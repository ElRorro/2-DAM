package com.iesvirgendelcarmen.dam.actividad09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Actividad09 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad09);

        TextView textView = (TextView) findViewById(R.id.miTextView);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        textView.startAnimation(anim);
    }
}
