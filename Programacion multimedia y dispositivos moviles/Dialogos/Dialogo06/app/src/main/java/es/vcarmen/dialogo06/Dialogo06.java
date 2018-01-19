package es.vcarmen.dialogo06;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dialogo06 extends AppCompatActivity {
    TextView texto;
    ProgressDialog progressDialog;
    int progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo06);
        texto = (TextView) findViewById(R.id.texto);
        Button boton = (Button) findViewById(R.id.button1);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(0);
                new MyAsyncTask().execute();
            }
        });
    }

    protected Dialog onCreateDialog (int id) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setTitle("Progeso...");
        return progressDialog;
    }

    class MyAsyncTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i=0; i<100;i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                progreso = i+1;
                publishProgress();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            progressDialog.setProgress(progreso);
            if(progreso == 100)
                texto.setText("PROGRESO TERMINADO");
            progressDialog.dismiss();
        }
    }
}
