package com.example.elrorro.socialtechfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainForm extends FragmentActivity {
    AdapterFragment paginador;
    ViewPager visor;
    List<Fragment> listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listFragment = new ArrayList<Fragment>();
        listFragment.add(new FragmentForm());
        listFragment.add(new FragmentListView());
        paginador = new AdapterFragment(getSupportFragmentManager(), listFragment);
        visor = (ViewPager) findViewById(R.id.ViewPager);
        visor.setAdapter(paginador);

    }
}
