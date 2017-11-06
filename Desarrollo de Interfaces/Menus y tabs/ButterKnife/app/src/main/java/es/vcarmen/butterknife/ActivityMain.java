package es.vcarmen.butterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityMain extends AppCompatActivity {

    @BindView(R.id.titulo)
    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        ButterKnife.bind(this);

        titulo.setText("Texto cambiado con ButterKnife");
    }

    @OnClick(R.id.titulo)
    public void cambiarNombre(){
        titulo.setText("Se ha hecho click");
    }
}
