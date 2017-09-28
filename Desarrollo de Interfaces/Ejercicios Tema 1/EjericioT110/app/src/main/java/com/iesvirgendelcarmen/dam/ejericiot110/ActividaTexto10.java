package com.iesvirgendelcarmen.dam.ejericiot110;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActividaTexto10 extends AppCompatActivity {
    private TextView myText;
    private int contador = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activida_texto10);

        createText(myText);
        changeColorText();
        createText(myText);
        changeColorText();
    }

    public void createText(TextView myText){
        myText = (TextView) findViewById(R.id.myText);
        myText.setText("NUEVO MÉTODO DE TEXTO");
        myText.append("\n NUEVO MÉTODO DE TEXTO " + contador);
    }

    public void changeColorText(){
        myText = (TextView) findViewById(R.id.myText);
        myText.setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorTexto, null));
    }
}
