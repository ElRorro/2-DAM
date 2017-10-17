package es.vcarmen.ageda;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.util.List;

/**
 * Created by matinal on 03/10/2017.
 */

public class Agenda extends AppCompatActivity {
    private List<Persona> listaPersonas;
    final EditText textName = (EditText) findViewById(R.id.editNombre);
    final EditText textSurname = (EditText) findViewById(R.id.editApellidos);
    final EditText textPhone = (EditText) findViewById(R.id.editTelefono);
    final EditText textSex = (EditText) findViewById(R.id.editSexo);
    private Persona p;
    private Agenda agenda;

    public void addPerson(Persona p){
        listaPersonas.add(p);
    }

    public void removePerson(Persona p){
        listaPersonas.remove(p);
    }

}
