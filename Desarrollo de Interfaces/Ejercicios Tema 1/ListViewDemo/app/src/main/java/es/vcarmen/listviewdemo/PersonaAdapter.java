package es.vcarmen.listviewdemo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matinal on 16/10/2017.
 */

public class PersonaAdapter extends ArrayAdapter<Persona> {
    public PersonaAdapter(@NonNull Context context, @NonNull ArrayList<Persona> lista) {
        super(context, 0 , lista);
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Persona p = getItem(position);

        if(convertView == null){
            LayoutInflater.from(getContext()).inflate(R.layout.persona_item,parent, false);
        }
        TextView persona = convertView.findViewById(R.id.personaNombre);
        TextView apellidos = convertView.findViewById(R.id.personaApellidos);

        persona.setText(p.getNombre());
        apellidos.setText(p.getApellidos());

        return convertView;
    }
}
