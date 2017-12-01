package es.vcarmen.material10;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.AnimeViewHolder> implements View.OnClickListener  {
    private List<Encapsulador> items;

    @Override
    public void onClick(View view) {
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView titulo;
        public TextView texto;

        public AnimeViewHolder(View vista) {
            super(vista);
            imagen = (ImageView) vista.findViewById(R.id.imagen);
            titulo = (TextView) vista.findViewById(R.id.titulo);
            texto = (TextView) vista.findViewById(R.id.texto);
        }
    }


    public Adaptador(List<Encapsulador> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i)  {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.carta, viewGroup, false);
        //Comentamos este método ya que en el java principal tenemos implementado otro
        /*v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "TOCADO ELEMENTO: " + String.valueOf(i+1), Toast.LENGTH_SHORT).show();
            }
        });*/
        return new AnimeViewHolder(v);
    }


    @Override
    public void onBindViewHolder(AnimeViewHolder viewHolder, final int i) {

        viewHolder.imagen.setImageResource(items.get(i).getIdImagen());
        viewHolder.titulo.setText(items.get(i).getTextoTitulo());
        viewHolder.texto.setText(String.valueOf(items.get(i).getTextoContenido()));
        //Este metodo nos devuelve un toast cuando tocamos la imagen nos quedamos con el del java principal ya que es mas profesiona
        //Este lo comentamos.
        /*viewHolder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tocado = items.get(i).getTextoTitulo().toString();
                Toast.makeText(view.getContext(),"Tocado " + tocado, Toast.LENGTH_LONG).show();
            }
        });*/
    }

}