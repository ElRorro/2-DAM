package com.iesvirgendelcarmen.dam.ejerciciot108;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class actividadTexto08 extends AppCompatActivity {
    private TextView mitexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_texto08);

        mitexto = (TextView) findViewById(R.id.mitexto);
        mitexto.setText("NUEVO TEXTO");
        mitexto.append("\n OTRA LINEA 1 CON APPEND");
        mitexto.append("\n OTRA LINEA 2 CON APPEND");
    }
}
