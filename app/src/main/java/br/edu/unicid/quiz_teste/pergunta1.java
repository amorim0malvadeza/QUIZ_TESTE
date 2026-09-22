package br.edu.unicid.quiz_teste;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class pergunta1 extends AppCompatActivity {

    private ImageView fotoPais;
    private RadioGroup radioGroupAlternativas;
    private RadioButton opcao1, opcao2, opcao3, opcao4;
    private Button btnResponder;

    private String nomeUsuario;
    private int pontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pergunta1);

        // Recebe os dados da Intent vindos da MainActivity
        Intent intent = getIntent();
        nomeUsuario = intent.getStringExtra("NOME_USUARIO");
        pontuacao = intent.getIntExtra("PONTUACAO", 0);

        // Mapeamento dos componentes
        fotoPais = findViewById(R.id.fotoPaís);
        opcao1 = findViewById(R.id.opcao1);
        opcao2 = findViewById(R.id.opcao2);
        opcao3 = findViewById(R.id.opcao3);
        opcao4 = findViewById(R.id.opcao4);
        btnResponder = findViewById(R.id.btnResponder);

        // Imagem da bandeira
        fotoPais.setImageResource(R.drawable.brasil);

        // Desabilita o botão até que alguma opção seja marcada
        btnResponder.setEnabled(false);

        // Identifica qual RadioButton foi selecionado para habilitar o botão
        // Nota: Assumindo que no seu XML as opçoes estão dentro de um RadioGroup
        opcao1.setOnClickListener(v -> btnResponder.setEnabled(true));
        opcao2.setOnClickListener(v -> btnResponder.setEnabled(true));
        opcao3.setOnClickListener(v -> btnResponder.setEnabled(true));
        opcao4.setOnClickListener(v -> btnResponder.setEnabled(true));

        // Lógica ao clicar no botão RESPONDER
        btnResponder.setOnClickListener(v -> {

            if (opcao4.isChecked()) {
                pontuacao++;
            }

            // Abre a próxima pergunta (pergunta2.java)
            Intent proxIntent = new Intent(pergunta1.this, pergunta2.class);
            proxIntent.putExtra("NOME_USUARIO", nomeUsuario);
            proxIntent.putExtra("PONTUACAO", pontuacao);
            startActivity(proxIntent);
            finish(); // Fecha a Pergunta 1 para não acumular no botão voltar
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}