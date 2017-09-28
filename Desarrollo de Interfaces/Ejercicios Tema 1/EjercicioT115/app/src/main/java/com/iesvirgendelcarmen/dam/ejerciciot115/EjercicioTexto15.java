package com.iesvirgendelcarmen.dam.ejerciciot115;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class EjercicioTexto15 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_texto15);

        //Definimos que TextView debe realizar la animación
        TextView textView = (TextView) findViewById(R.id.textoGirando);
        textView = Typeface.createFromAsset(getAssets(), "FromCartoonBlocks.ttf");
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        textView.startAnimation(anim);

    }
}
