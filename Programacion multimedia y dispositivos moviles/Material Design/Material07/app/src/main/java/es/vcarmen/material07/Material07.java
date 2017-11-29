package es.vcarmen.material07;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Material07 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material07);

        //Paginador de viewpager
        final ViewPager paginador;
        paginador = (ViewPager) findViewById(R.id.contenedor2);

        final TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        //Primer Tab
        mTabLayout.addTab(mTabLayout.newTab().setText("Primero").setIcon(R.drawable.ic_action_name));
        //Segundo Tab
        mTabLayout.addTab(mTabLayout.newTab().setText("Segundo").setIcon(R.drawable.ic_action_colgar));
        //Tercer Tab
        mTabLayout.addTab(mTabLayout.newTab().setText("Tercero").setIcon(R.drawable.ic_action_pausada));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragmento = null;

                switch (tab.getPosition()){
                    case 0:
                        fragmento = new Fragmento1();
                        break;
                    case 1:
                        fragmento = new Fragmento2();
                        break;
                    case 2:
                        fragmento = new Fragmento3();
                        break;
                }
                /*FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.contenedor, fragmento);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();*/
                paginador.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        Adaptador adaptador = new Adaptador(getSupportFragmentManager(), mTabLayout.getTabCount());
        paginador.setAdapter(adaptador);
        paginador.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }
}
