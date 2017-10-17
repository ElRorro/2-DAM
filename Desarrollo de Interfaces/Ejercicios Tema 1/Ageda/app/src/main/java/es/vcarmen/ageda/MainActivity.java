package es.vcarmen.ageda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText textName;
    private EditText textSurname;
    private EditText textPhone;
    private  EditText textSex;
    private Persona p;
    private Agenda agenda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textName = (EditText) findViewById(R.id.editNombre);
        textSurname = (EditText) findViewById(R.id.editApellidos);
        textPhone = (EditText) findViewById(R.id.editTelefono);
        textSex = (EditText) findViewById(R.id.editSexo);
    }

    public void addPerson(){
        String namePerson = textName.getText().toString();
        String surnamePerson = textSurname.getText().toString();
        int phonePerson = Integer.parseInt(textPhone.getText().toString());
        String sexPerson = textSex.getText().toString(

        p = new Persona(namePerson, surnamePerson, phonePerson, sexPerson);
        agenda.addPerson(p);
    }


    public void removePerson(){
        String namePerson = textName.getText().toString();
        String surnamePerson = textSurname.getText().toString();
        int phonePerson = Integer.parseInt(textPhone.getText().toString());
        String sexPerson = textSex.getText().toString();

        p = new Persona(namePerson, surnamePerson, phonePerson, sexPerson);
        agenda.removePerson(p);
    }
}
