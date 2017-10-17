package com.iesvirgendelcarmen.dam.testtextview;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityTextView extends AppCompatActivity implements View.OnClickListener {
    private Typeface fuenteTitulo;
    private LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        ll = (LinearLayout) findViewById(R.id.miLinearLayout);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                addTextView(ll, "Prueba", 20);
            }
        });

        Button btnChangedTitle = (Button) findViewById(R.id.btnChangeTittle);
        Button btnChangedButton = (Button) findViewById(R.id.btnChangeButton);
        btnChangedTitle.setOnClickListener(this);
        btnChangedButton.setOnClickListener(this);

        //Text view del titulo
        TextView text = (TextView) findViewById(R.id.miTextView);

        //Crear tipo de letra
        fuenteTitulo = Typeface.createFromAsset(getAssets(),"fonts/Christmas in Finland.ttf");
        text.setTypeface(fuenteTitulo);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.animaciones);
        anim.setRepeatMode(Animation.INFINITE);
        anim.setRepeatCount(3);
       // text.startAnimation(anim);

        text.setText(R.string.miTextView);
        text.append("\nSegunda línea.");

       /* addTextView(ll, "Nuevo textView");
        addTextView(ll, " textView");
        addTextView(ll, " textView");
        addTextView(ll, " textView");
        addTextView(ll, "Nuevo textView");
        addTextView(ll, "Nuevo textView");
        addTextView(ll, "Nuevo textView");*/

        String[] animales = {"Perro", "Gato", "Pájaro", "León", "Elefante", "Tigre"};

        for (int i = 0; i < animales.length; i++){
            addTextView(ll, animales[i], 18 + i*2);
        }

        View widget = findViewById(R.id.miTextView);
        creaAnimacion(widget);

    }

    public void addTextView(LinearLayout ll,String text, float size){
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        ll.addView(tv);

    }

    public void creaAnimacion(View widget){

        AnimationSet anim = new AnimationSet(true);

        //Rotación
        int rs= RotateAnimation.RELATIVE_TO_SELF;
        RotateAnimation rotacion = new RotateAnimation(0,45f,rs,0.5f,rs,0.5f);
        rotacion.setDuration(3000);
        rotacion.setStartOffset(6000);

        //Desplazamineto
        int rp = TranslateAnimation.RELATIVE_TO_PARENT;
        TranslateAnimation traslacion = new TranslateAnimation(rp,0f,rp,0f,rp,0f,rp,0.25f);
        traslacion.setDuration(3000);
        traslacion.setStartOffset(9000);

        //Aparicion
        AlphaAnimation aparicion = new AlphaAnimation(0,1);
        aparicion.setDuration(3000);

        //Escalado
        int rss = ScaleAnimation.RELATIVE_TO_SELF;
        ScaleAnimation escala = new ScaleAnimation(1,2,1,5,rs,0.5f,rs,0.5f);
        escala.setDuration(3000);
        escala.setStartOffset(3000);

        anim.addAnimation(aparicion);
        anim.addAnimation(escala);
        anim.addAnimation(rotacion);
        anim.addAnimation(traslacion);
        widget.startAnimation(anim);

    }
    public void deleteAnimals(View views){
        LinearLayout ll = (LinearLayout) findViewById(R.id.miLinearLayout);
        int n = ll.getChildCount();
        for (int i = n-1; i > 4; i--){
            ll.removeViewAt(i);
        }
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        Log.d("Pulsación", (btn.getText().toString()));
    }
}
