package es.vcarmen.fragment06;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fragment06 extends AppCompatActivity {
    Button boton1;
    FragmentManager FM = getFragmentManager();
    FragmentTransaction FT = FM.beginTransaction();
    Fragmento1 navegador = new Fragmento1();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment06);
        boton1 = (Button) findViewById(R.id.btn);
        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FT.replace(R.id.contenedor, navegador);
                FT.commit();
            }
        });
    }
}
