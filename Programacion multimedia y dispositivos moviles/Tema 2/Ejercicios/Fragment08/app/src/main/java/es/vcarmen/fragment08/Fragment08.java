package es.vcarmen.fragment08;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Fragment08 extends FragmentActivity implements Cabecera.CabeceraListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            return;
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment08);
        Cabecera primerFragmento = new Cabecera();
        primerFragmento.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, primerFragmento).commit();

    }

    public void tocado (int position) {
        //Toast.makeText(getBaseContext(),"TOCADO EL " + String.valueOf(position + 1), Toast.LENGTH_SHORT).show();
        Contenido detalle = new Contenido();
        Bundle args = new Bundle();
        args.putInt(Contenido.ARG_POSITION, position);
        detalle.setArguments(args);
        FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
        FT.replace(R.id.contenedor, detalle);
        FT.addToBackStack(null);
        FT.commit();
    }
}
