package com.example.calculadoradeconsumo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText atual;
    EditText ultimo;
    Button calcular,sair;
    TextView consumoTotal;
    TextView total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        atual = findViewById(R.id.atual);
        ultimo = findViewById(R.id.ultimo);
        calcular = findViewById(R.id.button);
        sair = findViewById(R.id.bt_sair);

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teste1 = atual.getText().toString();
                String teste2= ultimo.getText().toString();
                Double valor1 = teste1.isEmpty()? 0.0:Double.parseDouble(atual.getText().toString());
                Double valor2 = teste2.isEmpty()?0.0:Double.parseDouble(ultimo.getText().toString());
                Double consumo = valor1-valor2;
                Double tarifa1 = 3.27;
                Double tarifa2 = 5.13;
                Double tarifa3 = 12.29;
                Double res1 = (consumo <= 10)?consumo*tarifa1:0.0;
                Double res2 = (consumo > 10 && consumo <= 20)?((consumo-10)*tarifa2+(10*3)):0.0;
                Double res3 = (consumo > 20)?(consumo-20)*tarifa3:0.0;
                Double calculoFinal = res1+res2+res3;
                Double totalGeral = calculoFinal*2;
                if (consumo == 0.0){
                    Toast.makeText(MainActivity.this, "É necessário inserir um valor!", Toast.LENGTH_SHORT).show();
                }else  if (valor1 < valor2){
                    Toast.makeText(MainActivity.this, "O ultimo registro não pode ser maior que o atual!", Toast.LENGTH_SHORT).show();


                }else {
                    /*MainActivy.this == > active atual , Resultado.class ==> active a qual sera direcionada após
                    acionar o click do button, i.putExtra leva os dados para a active chamada, name:"resultado" é
                    o nome da variável e "value: são os valores carregados na variavel resultado"*/
                    Intent i = new Intent(MainActivity.this, Resultado.class);
                i.putExtra("resultado","Valor Total: R$ "+ String.valueOf(totalGeral));
                i.putExtra("consumo","Consumo Total: "+ String.valueOf(consumo)+"m3");
                    startActivity(i); }

            }
        });

    }

}