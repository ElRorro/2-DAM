package es.vcarmen.gridviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contacto> agenda;
    private ContactoAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agenda = new ArrayList<Contacto>();
        mockAgenda();

        GridView mGridView = (GridView) findViewById(R.id.agenda);
        adaptador = new ContactoAdapter(this, agenda);
        mGridView.setAdapter(adaptador);
    }

    public void mockAgenda(){
        Contacto c;

        c = new Contacto("Jesús", "Rodriguez", R.drawable.child);
        agenda.add(c);

        c = new Contacto("Ana", "Álvarez", R.drawable.child2);
        agenda.add(c);

        c = new Contacto("Pepe", "Camino", R.drawable.child);
        agenda.add(c);

        c = new Contacto("Esperanza", "Jurado", R.drawable.child2);
        agenda.add(c);

        c = new Contacto("Jesús", "Lopez", R.drawable.child);
        agenda.add(c);

        c = new Contacto("Daniel", "Rodriguez", R.drawable.child);
        agenda.add(c);
    }
}
