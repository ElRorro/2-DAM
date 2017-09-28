package com.iesvirgendelcarmen.dam.ejerciciot114;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class ActividadTexto14 extends AppCompatActivity {
    private TextView animacion;
    private int contador = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_texto14);

        repeticionAnimacion(animacion);

    }
    public void repeticionAnimacion(TextView overshoot){
        //Definimos que TextView debe realizar la animación
        animacion = (TextView) findViewById(R.id.overshoot);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.tranlacion);
        //Que actitud tiene que tomar el modo de animación,es decir, en este caso reiniciarse
        anim.setRepeatMode(Animation.RESTART);
        //anim.setRepeatMode(Animation.INFINITE);//se repite de forma infitina entonces la siguiente linea nos la arroariamos
        //Cuantas veces se repite la animación
        anim.setRepeatCount(20);
        animacion.startAnimation(anim);
        animacion.append("\n Repeat Mode: 1");
        animacion.append("\n Repeat Count:" + contador);
        contador++;
    }
}
