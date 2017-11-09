package es.vcarmen.material04;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_material04 extends AppCompatActivity implements View.OnClickListener{
    private CoordinatorLayout mCoordinatorLayout;
    private FloatingActionButton mFloatingActionButton;
    private Button mButtonSimple;
    private Button mButtonInteractivo;
    private Button mButtonPersonalizado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material04);

        //Definidos anteriormente y ahora enlzamos con la vista
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        mButtonSimple = (Button) findViewById(R.id.btnSimple);
        mButtonInteractivo = (Button) findViewById(R.id.btnInteractivo);
        mButtonPersonalizado = (Button) findViewById(R.id.btnPersonalizado);

        mFloatingActionButton.setOnClickListener(this);
        mButtonSimple.setOnClickListener(this);
        mButtonInteractivo.setOnClickListener(this);
        mButtonPersonalizado.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab:
                Snackbar snackbarFab = Snackbar.make(mCoordinatorLayout, "Jesús Rodríguez", Snackbar.LENGTH_LONG);
                snackbarFab.show();
                break;
            case R.id.btnSimple:
                Snackbar snackbar = Snackbar.make(mCoordinatorLayout, "EJEMPLO DE SNACKBAR", Snackbar.LENGTH_LONG);
                snackbar.show();
                break;
            case R.id.btnInteractivo:
                Snackbar snackbar2 = Snackbar.make(mCoordinatorLayout, "EJEMPLO DE SNACKBAR", Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(mCoordinatorLayout, "MENSAJE RESTAURADO", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
                snackbar2.show();
                break;
            case R.id.btnPersonalizado:
                Snackbar snackbar3 = Snackbar.make(mCoordinatorLayout, "EJEMPLO DE SNACKBAR", Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(mCoordinatorLayout, "MENSAJE RESTAURADO", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
                snackbar3.setActionTextColor(Color.CYAN);
                View sbView = snackbar3.getView();
                TextView texto = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                texto.setTextColor(Color.YELLOW);
                snackbar3.show();
                break;

        }
    }
}
