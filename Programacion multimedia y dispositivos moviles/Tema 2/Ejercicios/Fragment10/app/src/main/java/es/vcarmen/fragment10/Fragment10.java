package es.vcarmen.fragment10;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Fragment10 extends FragmentActivity implements Fragmento1.Callbacks {
    private boolean dosFragmentos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment10);

        if (findViewById(R.id.frame_contenedor) != null){
            dosFragmentos = true;
        }
    }

    @Override
    public void onEntradaSeleccionada(String id) {


        if (dosFragmentos){
            Bundle arguments = new Bundle();
            arguments.putString(Fragmento3.ARG_ID_ENTRADA_SELECCIONADA, id);
            Fragmento3 fragment = new Fragmento3();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_contenedor,fragment).commit();
        } else {
            Intent detalleIntent = new Intent(this, Fragmento2.class);
            detalleIntent.putExtra(Fragmento3.ARG_ID_ENTRADA_SELECCIONADA, id);
            startActivity(detalleIntent);
        }
    }
}
