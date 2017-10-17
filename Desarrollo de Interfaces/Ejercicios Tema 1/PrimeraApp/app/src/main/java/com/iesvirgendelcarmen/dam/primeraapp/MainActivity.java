package com.iesvirgendelcarmen.dam.primeraapp;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*TextView mitexto = (TextView) findViewById(R.id.mitexto);

        mitexto.setText("Text Changed");
        mitexto.append("\n Nueva Línea");*/

        TextView text = (TextView)findViewById(R.id.textViewTittle);
        text.setText(R.string.mitexto);

        text.setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorTitulo,null));

        TextView subTitle = new TextView(this);
        subTitle.setText(R.string.subTitulo);


        LinearLayout ll = (LinearLayout) findViewById(R.id.miLinearLayout);
        ll.addView(subTitle);


    }
}
