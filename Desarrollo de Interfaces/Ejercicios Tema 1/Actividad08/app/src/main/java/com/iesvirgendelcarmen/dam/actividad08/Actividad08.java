package com.iesvirgendelcarmen.dam.actividad08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Actividad08 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad08);

        TextView textView = (TextView) findViewById(R.id.actividad08);
        textView.append("\nOTRA LÍNEA 1 CON APPEND");
        textView.append("\nOTRA LÍNEA 2 CON APPEND");

    }
}
