package es.vcarmen.formulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

public class Formulario extends AppCompatActivity {
    private final String[] ARTISTAS = {"Miguel Angel", "Leonardo", "Boticelli", "Donatello", "Rafael", "Perugino"};
    private final String[] PAISYCIUDADES = {"España", "Francia", "Alemania", "Belgica", "Italida", "Jaén", "Sevilla", "Códoba", "París", "Montpellier", "Málaga"};
    private final String[] PROVINCIAS = {"Jaén", "Málaga", "Sevilla", "Córdoba", "Granada", "Cádiz", "Almeria", "Huelva"};
    private EditText editNombre = (EditText) findViewById(R.id.editNombre);
    private EditText editEdad = (EditText) findViewById(R.id.editEdad);
    private EditText editEmail = (EditText) findViewById(R.id.editEmail);
    private String textoNombre;
    private String textoEdad;
    private String textoEmail;
    private String textoAuto;
    private String textoMulti;
    private String textoSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, ARTISTAS);
        AutoCompleteTextView texto = (AutoCompleteTextView) findViewById(R.id.textoAuto);
        texto.setAdapter(adaptador);

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, PAISYCIUDADES);
        MultiAutoCompleteTextView texto2 = (MultiAutoCompleteTextView) findViewById(R.id.textoMultiAuto);
        texto2.setAdapter(adaptador2);
        texto2.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adaptador3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, PROVINCIAS);
        spinner.setAdapter(adaptador3);

        textoNombre = editNombre.getText().toString();
        textoEdad = editEdad.getText().toString();
        textoEmail = editEmail.getText().toString();
        textoAuto = texto.getText().toString();
        textoMulti = texto2.getText().toString();
        textoSpinner = spinner.getSelectedItem().toString();
    }
}
