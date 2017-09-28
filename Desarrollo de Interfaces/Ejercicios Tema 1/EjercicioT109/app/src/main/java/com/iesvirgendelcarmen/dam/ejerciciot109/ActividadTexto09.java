package com.iesvirgendelcarmen.dam.ejerciciot109;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class ActividadTexto09 extends AppCompatActivity {
    private TextView mitexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_texto09);

        //DEFINIMOS QUE TEXT VIEW VA A REALIZAR LA ANIMACIÓN
        mitexto = (TextView) findViewById(R.id.mitexto);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        mitexto.startAnimation(anim);
    }
}
