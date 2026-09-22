package br.edu.unicid.quiz_teste;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome;
    private Button btnIniciar;

    private ImageView ftIntegrantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mapeamento dos componentes
        ftIntegrantes = findViewById(R.id.ImageView1);
        edtNome = findViewById(R.id.edtNome);
        btnIniciar = findViewById(R.id.btnIniciar);

        // Define a imagem diretamente via código Java ao iniciar a tela
        ftIntegrantes.setImageResource(R.drawable.img);

        // Evento de clique para iniciar o quiz
        btnIniciar.setOnClickListener(v -> {
            String nome = edtNome.getText().toString().trim();

            Intent intent = new Intent(MainActivity.this, pergunta1.class);

            // Passa o nome digitado e a pontuação inicial
            intent.putExtra("NOME_USUARIO", nome);
            intent.putExtra("PONTUACAO", 0);

            startActivity(intent);
        });
    }
}