package es.vcarmen.fragment10;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by matinal on 25/10/2017.
 */

public class Fragmento1 extends ListFragment {
    private Callbacks mCallbacks;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        Toast.makeText(getActivity(), "Fragmento1", Toast.LENGTH_SHORT).show();
        setListAdapter(new Adaptador(getActivity(), R.layout.layout_listado, Contenido.ENT_LISTA) {
            @Override
            public void onEntrada(Object entrada, View view) {
                Toast.makeText(getActivity(), "Cargando", Toast.LENGTH_SHORT).show();

                TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textotitulo);
                texto_superior_entrada.setText(((Contenido.Lista_entrada)entrada).textoEncima);
                ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imagenLista);
                imagen_entrada.setImageResource(((Contenido.Lista_entrada)entrada).idImagen);
            }
        });
    }

    public Fragmento1(){};

    public interface Callbacks{
        public void onEntradaSeleccionada(String id);
    }

    private static Callbacks CallbacksVacios = new Callbacks() {
        @Override
        public void onEntradaSeleccionada(String id) {
        }
    };

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = CallbacksVacios;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallbacks.onEntradaSeleccionada(Contenido.ENT_LISTA.get(position).id);
    }
}
