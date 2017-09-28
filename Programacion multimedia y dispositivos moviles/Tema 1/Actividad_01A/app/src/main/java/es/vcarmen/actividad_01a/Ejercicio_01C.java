package es.vcarmen.actividad_01a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by matinal on 28/09/17.
 */

public class Ejercicio_01C extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_01c);
    }

    public void boton3(View view){
        Intent intent = new Intent(this, Ejercicio_01F.class);
        startActivity(intent);
    }

    public void onPause(){
        super.onPause();
        finish();
    }
}
