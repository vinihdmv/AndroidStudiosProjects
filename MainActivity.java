package com.example.duastelasradiobuttons;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup pergunta1;
    private RadioGroup pergunta2;
    private Button botaoEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inicializaTela();
    }


    private  void inicializaTela(){
        pergunta1 = findViewById(R.id.ActivityMain_pergunta1);
        pergunta2 = findViewById(R.id.ActivityMain_pergunta2);
        botaoEnviar = findViewById(R.id.activityMain_button);

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviaProva();
            }
        });
    }

    private void enviaProva() {
        String resposta01 =  verificaResposta(pergunta1);
        String resposta02 =  verificaResposta(pergunta2);

        Intent telaResultado = new Intent(this, TelaResultado.class); //tela de origem e tela de destino
        telaResultado.putExtra("resposta01", resposta01);
        telaResultado.putExtra("resposta02", resposta02);


        startActivity(telaResultado);
    }

    private String verificaResposta(RadioGroup RespostaMarcada) {

        int idOpcaoselecionada = RespostaMarcada.getCheckedRadioButtonId();
        RadioButton radioButtonSelecionado = findViewById(idOpcaoselecionada);

        return   radioButtonSelecionado.getText().toString();

    }
}