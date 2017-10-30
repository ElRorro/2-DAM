package com.example.elrorro.socialtechfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ElRorro on 23/10/2017.
 */

public class AdapterFragment extends FragmentPagerAdapter {
    private List<Fragment> fragmentos;
    public AdapterFragment(FragmentManager fm, List<Fragment> fragmentos) {
        super(fm);
        this.fragmentos = fragmentos;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentos.get(position);
    }


    @Override
    public int getCount() {
        return fragmentos.size();
    }
}
