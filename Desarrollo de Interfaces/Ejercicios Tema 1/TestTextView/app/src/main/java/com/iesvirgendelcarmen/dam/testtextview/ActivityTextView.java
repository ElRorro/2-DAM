package com.iesvirgendelcarmen.dam.testtextview;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityTextView extends AppCompatActivity {
    private Typeface fuente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        //Definimos que TextView debe realizar la animación
        TextView textView = (TextView) findViewById(R.id.miTextView);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.animaciones);
        //Que actitud tiene que tomar el modo de animación,es decir, en este caso reiniciarse
        anim.setRepeatMode(Animation.RESTART);
        //anim.setRepeatMode(Animation.INFINITE);//se repite de forma infitina entonces la siguiente linea nos la arroariamos
        //Cuantas veces se repite la animación
        anim.setRepeatCount(3);
        textView.startAnimation(anim);

        textView.append("\nSegunda Linea");

        LinearLayout ll = (LinearLayout) findViewById(R.id.miLinearLayout);

        //addTextView(ll, "Nuevo Text view");
        //addTextView(ll,"\nSegundo Text View");
        String[] animales = {"Perro", "Gato", "Zebra", "Conejo", "León", "Elefante", "Loro", "Pantera"};
        for (int i = 0; i < animales.length; i++){
            addTextView(ll, animales[i], 18 + i*2);
        }

        //cambiar la fuente a mitexto
        fuente = Typeface.createFromAsset(getAssets(), "fonts/FromCartoonBlocks.ttf");
        textView.setTypeface(fuente);
        textView.setTextSize(40);

        View widget = findViewById(R.id.miTextView);
        createAnimation(widget);
    }

    public void addTextView (LinearLayout ll, String texto, float size){
        TextView tv = new TextView(this);
        tv.setText(texto);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        ll.addView(tv);
    }

    public void createAnimation(View widget){
        //creamos el objeto animación
        AnimationSet animation = new AnimationSet(true);

        //Desplazamiento
        int rp = TranslateAnimation.RELATIVE_TO_PARENT;
        TranslateAnimation translacion = new TranslateAnimation(rp,0.0f,rp,1.0f,rp,0.0f,rp,1.0f);
        translacion.setDuration(3000);//dura 3 segundos
        translacion.setStartOffset(6000);//Desplazamiento en tiempo(empezaria cuando han pasado 6 segundos)

        //rotacion
        int rs = RotateAnimation.RELATIVE_TO_SELF;
        RotateAnimation rotacion = new RotateAnimation(0,45,rs,0.5f,rs,0.5f);
        rotacion.setDuration(3000);
        rotacion.setStartOffset(6000);

        //aparición
        AlphaAnimation aparicion = new AlphaAnimation(0,1);
        aparicion.setDuration(6000);
        aparicion.setStartOffset(1000);

        animation.addAnimation(translacion);
        animation.addAnimation(rotacion);
        animation.addAnimation(aparicion);

        widget.startAnimation(animation);
    }
}
