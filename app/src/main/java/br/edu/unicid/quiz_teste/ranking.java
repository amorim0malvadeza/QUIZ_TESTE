package br.edu.unicid.quiz_teste;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ranking extends AppCompatActivity {

    private TextView tituloRanking;
    private TextView nomeUser;
    private TextView txtAcerto;
    private TextView txtPontuacao;
    private Button btnRespoderNovamente;
    private Button btnTelaPrincipal;

    private String nomeUsuarioStr;
    private int pontuacaoInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ranking);

        // Mapeamento dos componentes com os seus novos IDs
        tituloRanking = findViewById(R.id.tituloRanking);
        nomeUser = findViewById(R.id.nomeUser);
        txtAcerto = findViewById(R.id.txtAcerto);
        txtPontuacao = findViewById(R.id.txtPontuacao);
        btnRespoderNovamente = findViewById(R.id.btnRespoderNovamente);
        btnTelaPrincipal = findViewById(R.id.btnTelaPrincipal);

        // Recebe os dados passados da última pergunta
        Intent intent = getIntent();
        nomeUsuarioStr = intent.getStringExtra("NOME_USUARIO");
        pontuacaoInt = intent.getIntExtra("PONTUACAO", 0);

        // Exibe o nome do usuário e a pontuação na interface
        if (nomeUsuarioStr != null && !nomeUsuarioStr.isEmpty()) {
            nomeUser.setText(nomeUsuarioStr);
        } else {
            nomeUser.setText("Visitante");
        }

        txtPontuacao.setText(String.valueOf(pontuacaoInt));

        // Botão para reiniciar o Quiz voltando para a pergunta1
        btnRespoderNovamente.setOnClickListener(v -> {
            Intent intentPergunta1 = new Intent(ranking.this, pergunta1.class);
            intentPergunta1.putExtra("NOME_USUARIO", nomeUsuarioStr);
            intentPergunta1.putExtra("PONTUACAO", 0); // Reinicia o placar
            startActivity(intentPergunta1);
            finish();
        });

        // Botão para retornar à Tela Principal (MainActivity)
        btnTelaPrincipal.setOnClickListener(v -> {
            Intent intentMain = new Intent(ranking.this, MainActivity.class);
            intentMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intentMain);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}