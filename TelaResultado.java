package com.example.duastelasradiobuttons;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaResultado extends AppCompatActivity {

    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inicializaTelaResultado();
    }

    private void inicializaTelaResultado() {
        resultado = findViewById(R.id.TextView_Resultado);
        int notaFinal = calculaNota();
        if (notaFinal == 10){
            resultado.setText("Parabéns, você acertou tudo!");
        }
        else if (notaFinal==5) {
            resultado.setText("Você acertou metade da prova!.");
        }
        else {
            resultado.setText("Você não acertou nada!");
        }
    }

    private int calculaNota() {
        String resposta1 = getIntent().getStringExtra("resposta01");
        String resposta2 = getIntent().getStringExtra("resposta02");
        if (resposta1.equals("C - Washigton") && resposta2.equals("D- Jupiter")) {
            return 10;
        }else if (resposta2.equals("C - Washigton") || resposta2.equals("D- Jupiter")) {
            return 5;
        }else {
            return 0;
        }

    }
}