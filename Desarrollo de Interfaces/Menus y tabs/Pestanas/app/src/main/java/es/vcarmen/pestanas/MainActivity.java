package es.vcarmen.pestanas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(android.R.id.tabhost)
    TabHost tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        findViewById(android.R.id.tabhost);

        //Instanciamos las pestañas
        tabs.setup();

        //Creamos la pestaña 1 y la añadimos a tabs
        TabHost.TabSpec spec;
        spec = tabs.newTabSpec("tab1");
        spec.setIndicator("Pestaña 1");
        //Le ponemos el contenido de un layout pero podemos pasarle una actividad a traves de un Intent
        spec.setContent(R.id.tabs1);
        tabs.addTab(spec);

        //Creamos la pestaña 2 y la añadimos a tabs
        spec = tabs.newTabSpec("tab2");
        spec.setIndicator("Pestaña 2");
        //Le ponemos el contenido de un layout pero podemos pasarle una actividad a traves de un Intent
        spec.setContent(R.id.tabs2);
        tabs.addTab(spec);

        tabs.setCurrentTab(0);
    }
}
