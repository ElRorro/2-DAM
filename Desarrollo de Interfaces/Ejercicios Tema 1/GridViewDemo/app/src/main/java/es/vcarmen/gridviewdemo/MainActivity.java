package es.vcarmen.gridviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int seleccionado = item.getItemId();

        switch (seleccionado){
            case R.id.opcion1:
                Toast.makeText(this, "Se ha pulsado opción 1", Toast.LENGTH_LONG).show();
                return true;
            case R.id.opcion2:
                Toast.makeText(this, "Se ha pulsado opción 2", Toast.LENGTH_LONG).show();
                return true;
            case R.id.opcion3:
                Toast.makeText(this, "Se ha pulsado opción 3", Toast.LENGTH_LONG).show();
                return true;
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }
}
