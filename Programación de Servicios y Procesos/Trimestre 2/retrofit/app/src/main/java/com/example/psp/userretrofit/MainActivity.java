package com.example.psp.userretrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static boolean conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //conexion = getConexion();
    }

    private boolean getConexion() {
        try {
            Process process = Runtime.getRuntime().exec("ping 192.168.16.124 -c 1");
            return process.waitFor() == 0;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void goToGET (View view) {
        if (getConexion()) {
            Intent intentGET = new Intent(this, GetEmailActivity.class);
            startActivity(intentGET);
        }
        else
            Toast.makeText(this, "ERROR EN LA CONEXION", Toast.LENGTH_SHORT).show();
    }

    public void gotToPOST (View view) {
        if (getConexion()) {
            Intent intentGET = new Intent(this, GetEmailActivity.class);
            startActivity(intentGET);
        }
        else
            Toast.makeText(this, "ERROR EN LA CONEXION", Toast.LENGTH_SHORT).show();
    }
}
