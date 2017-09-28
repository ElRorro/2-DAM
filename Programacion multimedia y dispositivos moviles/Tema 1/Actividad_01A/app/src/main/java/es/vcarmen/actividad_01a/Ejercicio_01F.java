package es.vcarmen.actividad_01a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by matinal on 28/09/17.
 */

public class Ejercicio_01F extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_01d);
    }

    public void boton4(View view){
        Intent intent = new Intent(this, Ejercicio_01A.class);
        startActivity(intent);
    }

    public void onPause(){
        super.onPause();
        finish();
    }
}
