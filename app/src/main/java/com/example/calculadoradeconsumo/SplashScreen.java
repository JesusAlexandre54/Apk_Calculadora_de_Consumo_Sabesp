package com.example.calculadoradeconsumo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    Intent i;
    String resultado,consumo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        i = getIntent();
        resultado = i.getExtras().getString("resultado");
        consumo = i.getExtras().getString("consumo");



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                i = new Intent(SplashScreen.this,Resultado.class);
                i.putExtra("resultado",resultado);
                i.putExtra("consumo",consumo);
                startActivity(i);

            }
        }, 2000);
    }
}