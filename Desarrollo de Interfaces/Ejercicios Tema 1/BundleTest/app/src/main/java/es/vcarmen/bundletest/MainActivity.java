package es.vcarmen.bundletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int contador = 0;
    private Button btnIncrementar;
    private TextView text;
    public final static String CONTADOR = "CONTADOR";
    public final static String PERSONA = "PERSONA";
    public final static String AGENDA = "AGENDA";
    private ArrayList<Persona> agenda;
    private Persona p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnIncrementar = (Button) findViewById(R.id.btnIncrementar);
        text = (TextView) findViewById(R.id.textView);
        btnIncrementar.setOnClickListener(this);

        //Para obtener lo que habiamos guardado
        if (savedInstanceState != null){
            p = (Persona)savedInstanceState.getSerializable(PERSONA);
            text.setText(p.toString());

            agenda = (ArrayList<Persona>) savedInstanceState.getSerializable(AGENDA);
        }

    }

    public void onClick(View view){
        contador++;
        text.setText(contador+"");
        p = new Persona("Jesus", "Rodriguez");
        agenda.add(p);
        p = new Persona("Ana", "Alvarez");
        agenda.add(p);
        p = new Persona("Jesus", "Lopez");
        agenda.add(p);
        p = new Persona("Juan Isaac", "Huertas");
        agenda.add(p);

        text.setText(p.toString());
        agenda.add(p);
    }

    //Para guardar valores en concreto cuando giramos la pantalla hacemos lo siguiente
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CONTADOR, contador);
        outState.putSerializable(PERSONA, p);
        outState.putSerializable(AGENDA, agenda);
    }

}
