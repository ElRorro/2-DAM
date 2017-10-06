package es.vcarmen.fragment03;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by matinal on 06/10/2017.
 */

public class Fragmento1 extends ListFragment {
    private String[] artistas = {"Alberto Duero", "Miguel Ángel", "Rafael Sanzio", "Tiziano", "Donatello", "Paolo Uccelo",
            "Giotto", "Peter Breughel", "F.Brunelleschi", "Fra Angelico", "A.Mantegna", "Leonardo", "G.Bellini", "S.Botticelli", "cosimo Roseelli",
            "Masaccio", "Ghirlandaio", "Giorgione", "Filippino Lippi", "P.della Francesa"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Ahora cargamos la Lista
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, artistas));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento1, container, false);
    }


    //ME HE QUEDADO EN LA PARTE 6
}
