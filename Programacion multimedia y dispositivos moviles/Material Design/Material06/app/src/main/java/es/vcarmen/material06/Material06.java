package es.vcarmen.material06;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Material06 extends AppCompatActivity {
    private Button mButtonAddTab;
    private Button mButtonRemoveTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material06);
        final TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mButtonAddTab = (Button) findViewById(R.id.addTab);
        mButtonRemoveTab = (Button) findViewById(R.id.removeTab);

        //Primer Tab
        TabLayout.Tab primerTab = mTabLayout.newTab();
        primerTab.setText("TAB 01");
        primerTab.setIcon(R.mipmap.ic_launcher);
        mTabLayout.addTab(primerTab);

        //Segundo Tab
        TabLayout.Tab segundoTab = mTabLayout.newTab();
        segundoTab.setText("TAB 02");
        segundoTab.setIcon(R.drawable.icono1);
        mTabLayout.addTab(segundoTab);

        //Tercer Tab
        TabLayout.Tab tercerTab = mTabLayout.newTab();
        tercerTab.setText("TAB 03");
        tercerTab.setIcon(R.drawable.ic_action_name);

        //Trabajamos con la posición de los Tabs
        mTabLayout.addTab(tercerTab,1,true);

        //Trabajamos con la estética de los tabs
        mTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        //mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //El modo en el que la disponemos
        //mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

        //Para cambiar el color
        mTabLayout.setTabTextColors(Color.RED, Color.WHITE);
        //mTabLayout.setTabTextColors(Color.argb(255,50,50,50), Color.argb(255,0,200,200));
        //mTabLayout.setTabTextColors(Color.rgb(50,50,50), Color.rgb(0,200,200));

        //Color de linea de tabs seleccionada
        mTabLayout.setSelectedTabIndicatorColor(Color.GREEN);
        //La altura de este indicador
        mTabLayout.setSelectedTabIndicatorHeight(12);

        //Añadimos los escuchadores de los botones
        mButtonAddTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTabLayout.getTabCount() < 6) {
                    mTabLayout.addTab(mTabLayout.newTab().setText("Tab " + mTabLayout.getTabCount()));

                } else {
                    Toast.makeText(getApplicationContext(),"Ya has añadido 6 Tab", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mButtonRemoveTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTabLayout.getTabCount() > 2){
                    int position = mTabLayout.getTabCount();
                    position = position-1;
                    mTabLayout.removeTabAt(position);
                } else {
                    Toast.makeText(getApplicationContext(),"No se puede eliminar mas Tab", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Para saber que tab ha sido seleccionada
                int elegida = mTabLayout.getSelectedTabPosition();
                Toast.makeText(getApplicationContext(), "Tab tocado " + (elegida + 1), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
