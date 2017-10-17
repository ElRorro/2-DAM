package com.iesvirgendelcarmen.dam.actividad07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Actividad07 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad07);

        //Text view
        TextView textView = (TextView) findViewById(R.id.texto07);
        textView.setText("TEXTO DESDE JAVA");


    }
}
