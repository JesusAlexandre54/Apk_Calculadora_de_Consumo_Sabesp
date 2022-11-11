package com.example.calculadoradeconsumo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    TextView tv_resultado,tv_consumo;
    Intent i;
    Button voltar, sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        voltar = findViewById(R.id.bt_voltar);
        sair = findViewById(R.id.bt_sair);
        i = getIntent();//pega os valores passados pelo intent
        tv_resultado=findViewById(R.id.tv_resultado);
        tv_resultado.setText(i.getExtras().getString("resultado"));
        tv_consumo = findViewById(R.id.tv_consumo);
        tv_consumo.setText(i.getExtras().getString("consumo"));


        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Resultado.this, MainActivity.class);
                startActivity(i);
            }
        });
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}