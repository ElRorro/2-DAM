package com.iesvirgendelcarmen.dam.actividad10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Actividad10 extends AppCompatActivity {
    private TextView text,text1,text2;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad10);

        addTextView1(text, text1, text2);
        changeBackgroundColor(ll);

    }

    public void addTextView1(TextView text, TextView text1, TextView text2) {
        text = (TextView) findViewById(R.id.miTexto);
        text.setText("NUEVO MÉTODO DE TEXTO\n AÑADIENTO TEXTO CON PRINT\n AÑADIENDO TEXTO CON PRINT ");

        text1 = (TextView) findViewById(R.id.miTexto2);
        text1.setText("PRIMER TEXTO");
        text1.setTextColor(text1.getContext().getResources().getColor(R.color.colorTexto));
        text1.setTextSize(23);

        text2 = (TextView) findViewById(R.id.miTexto3);
        text2.setText("SEGUNDO TEXTO");
        text2.setTextColor(text2.getContext().getResources().getColor(R.color.colorTexto2));
        text2.setTextSize(26);
    }

    public void changeBackgroundColor(LinearLayout ll){
        ll = (LinearLayout) findViewById(R.id.miLinearLayout);
        ll.setBackgroundColor(ll.getContext().getResources().getColor(R.color.colorFondo));
    }
}
