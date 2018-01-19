package es.vcarmen.dialogos01;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dialogos01 extends AppCompatActivity {

    private Button mbtn , mbtn2, mbtn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos01);

        mbtn = (Button) findViewById(R.id.btn);
        mbtn2 = (Button) findViewById(R.id.btn2);
        mbtn3 = (Button) findViewById(R.id.btn3);

        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(0);
            }
        });

        mbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(1);
            }
        });

        mbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(2);
            }
        });
    }

    protected Dialog onCreateDialog(int id) {
        Dialog dialogo = null;
        if (id == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder = builder.setIcon(R.mipmap.ic_launcher);
            builder = builder.setTitle("EJEMPLO DE DIÁLOGO");
            dialogo = builder.create();
        } else if (id == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder = builder.setIcon(R.mipmap.ic_launcher);
            builder = builder.setTitle("EJEMPLO DE DIÁLOGO 2");
            dialogo = builder.create();
        } else if (id == 2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder = builder.setIcon(R.mipmap.ic_launcher);
            builder = builder.setTitle("EJEMPLO DE DIÁLOGO 3");
            dialogo = builder.create();
        }
        return dialogo;
    }
}
