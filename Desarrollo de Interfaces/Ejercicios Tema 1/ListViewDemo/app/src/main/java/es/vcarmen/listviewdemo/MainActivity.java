package es.vcarmen.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listNombres;
    ArrayList<Persona> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = mockLista();
        listNombres = (ListView) findViewById(R.id.listaNombres);

        PersonaAdapter adaptador = new PersonaAdapter(this, lista);

       /* ArrayAdapter<Persona> adaptador = new ArrayAdapter<Persona>(this, android.R.layout.simple_dropdown_item_1line, lista);
        listNombres.setAdapter(adaptador);*/
    }

    private ArrayList<Persona> mockLista(){
        ArrayList<Persona> lista = new ArrayList<>();
        Persona p1 = new Persona("Luis", "Molina Garzón");
        lista.add(p1);
        p1 = new Persona("Jesús", "Pérez Goon");
        lista.add(p1);
        p1 = new Persona("Alfonso", "Comino Olivo");
        lista.add(p1);
        p1 = new Persona("Juan", "Castillo Galdós");
        lista.add(p1);

        return lista;
    }
}
