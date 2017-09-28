package com.iesvirgendelcarmen.dam.primeraapp;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView mitexto = (TextView) findViewById(R.id.mitexto);
        //mitexto.setText("text changed");
        //mitexto.append("\n nuevo texto");

        TextView title = (TextView) findViewById(R.id.textViewTitle);
        title.setText(R.string.mitexto);

        title.setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorTittle, null));

        //Creamos un subtitulo para añadirlo al LinearLayout
        TextView subTitle = new TextView (this);
        subTitle.setText(R.string.subTitle);

        //Para añadir al layout el textView anterior
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.miLinearLayout);
        linearLayout.addView(subTitle);

    }
}