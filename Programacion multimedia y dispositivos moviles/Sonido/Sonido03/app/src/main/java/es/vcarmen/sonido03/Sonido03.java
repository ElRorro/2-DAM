package es.vcarmen.sonido03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sonido03 extends AppCompatActivity {
    private TextView mtvTitulo;
    private Button mbtnIniciar, mbtnParar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido03);

        mtvTitulo = (TextView) findViewById(R.id.tvTitulo);
        mbtnIniciar = (Button) findViewById(R.id.btnIniciar);
        mbtnParar = (Button) findViewById(R.id.btnParar);

        mbtnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getApplicationContext(), Servicio.class));
            }
        });

        mbtnParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(getApplicationContext(), Servicio.class));
            }
        });
    }
}
