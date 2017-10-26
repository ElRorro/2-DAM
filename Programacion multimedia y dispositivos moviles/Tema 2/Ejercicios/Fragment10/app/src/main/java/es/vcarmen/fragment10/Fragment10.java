package es.vcarmen.fragment10;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Fragment10 extends FragmentActivity implements Fragmento1.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment10);
    }

    @Override
    public void onEntradaSeleccionada(String id) {
        Toast.makeText(getBaseContext(), "TOCADO EL " + id, Toast.LENGTH_SHORT).show();
        Intent detalleIntent = new Intent(this, Fragmento2.class);
        detalleIntent.putExtra(Fragmento3.ARG_ID_ENTRADA_SELECCIONADA, id);
        startActivity(detalleIntent);
    }
}
