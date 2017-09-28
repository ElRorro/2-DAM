package com.iesvirgendelcarmen.dam.ejercicitot113;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class ActividadTexto13 extends AppCompatActivity {
    private TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_texto13);

        //DEFINIMOS EL TEXTO QUE HARÁ LA ANIMACIÓN
        myText = (TextView) findViewById(R.id.textoAnimado);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translacion);
        myText.startAnimation(anim);
        //Que actitud tiene que tomar el modo de animación,es decir, en este caso reiniciarse
        anim.setRepeatMode(Animation.RESTART);
    }
}
