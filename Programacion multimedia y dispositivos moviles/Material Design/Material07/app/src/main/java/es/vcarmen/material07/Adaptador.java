package es.vcarmen.material07;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by matinal on 23/11/2017.
 */

public class Adaptador extends FragmentPagerAdapter {
    int numTab;

    public Adaptador(FragmentManager fm, int numTab){
        super(fm);
        this.numTab = numTab;
    };


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragmento1 fragmento1 = new Fragmento1();
                return fragmento1;
            case 1:
                Fragmento2 fragmento2 = new Fragmento2();
                return fragmento2;
            case 2:
                Fragmento3 fragmento3 = new Fragmento3();
                return fragmento3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTab;
    }
}
