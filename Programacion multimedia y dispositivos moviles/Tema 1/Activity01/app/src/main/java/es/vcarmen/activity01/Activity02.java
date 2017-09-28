package es.vcarmen.activity01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Activity02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);
    }

    public void boton2(View view){
        Intent intent = new Intent(this, Activity01.class);
        startActivity(intent);
    }

    public void onPause(){
        super.onPause();
        finish();
    }
}
