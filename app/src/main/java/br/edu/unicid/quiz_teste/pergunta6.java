package br.edu.unicid.quiz_teste;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class pergunta6 extends AppCompatActivity {

    private ImageView fotoPais;
    private RadioButton opcao1, opcao2, opcao3, opcao4;
    private Button btnResponder;

    private String nomeUsuario;
    private int pontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pergunta6);

        Intent intent = getIntent();
        nomeUsuario = intent.getStringExtra("NOME_USUARIO");
        pontuacao = intent.getIntExtra("PONTUACAO", 0);

        fotoPais = findViewById(R.id.fotoPaís);
        opcao1 = findViewById(R.id.opcao1);
        opcao2 = findViewById(R.id.opcao2);
        opcao3 = findViewById(R.id.opcao3);
        opcao4 = findViewById(R.id.opcao4);
        btnResponder = findViewById(R.id.btnResponder);

        fotoPais.setImageResource(R.drawable.gabao);
        btnResponder.setEnabled(false);

        opcao1.setOnClickListener(v -> btnResponder.setEnabled(true));
        opcao2.setOnClickListener(v -> btnResponder.setEnabled(true));
        opcao3.setOnClickListener(v -> btnResponder.setEnabled(true));
        opcao4.setOnClickListener(v -> btnResponder.setEnabled(true));

        btnResponder.setOnClickListener(v -> {

            if (opcao2.isChecked()) {
                pontuacao++;
            }

            Intent proxIntent = new Intent(pergunta6.this, pergunta7.class);
            proxIntent.putExtra("NOME_USUARIO", nomeUsuario);
            proxIntent.putExtra("PONTUACAO", pontuacao);
            startActivity(proxIntent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}