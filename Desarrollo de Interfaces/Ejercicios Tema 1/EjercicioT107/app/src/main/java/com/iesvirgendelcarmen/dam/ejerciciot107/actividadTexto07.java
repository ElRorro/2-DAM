package com.iesvirgendelcarmen.dam.ejerciciot107;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class actividadTexto07 extends AppCompatActivity {
    private TextView miTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_texto07);

        miTexto = (TextView) findViewById(R.id.mitexto);
        miTexto.setText("TEXTO DESDE JAVA");
    }
}
