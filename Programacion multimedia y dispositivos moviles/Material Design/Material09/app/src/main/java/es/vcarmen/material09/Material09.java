package es.vcarmen.material09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Material09 extends AppCompatActivity {
    private Toolbar mtoolbar1;
    private Toolbar mtoolbar2;
    private Menu mopcion1;
    private Menu mopcion2;
    private Menu mopcion3;
    private ImageView icono;
    private static final int DURACION = 250;
    private LinearLayout detalle;
    private boolean giro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material09);
        mtoolbar1 = (Toolbar) findViewById(R.id.barra1);
        mopcion1 = (Menu) findViewById(R.id.opcion1);
        mopcion2 = (Menu) findViewById(R.id.opcion2);
        mopcion3 = (Menu) findViewById(R.id.opcion3);
        giro = false;
        icono = (ImageView) findViewById(R.id.imagen2);
        detalle = (LinearLayout) findViewById(R.id.linear3);

        mtoolbar1.setTitle("EL RAPTO DE LAS SABINAS");
        mtoolbar1.setSubtitle("Jesús Rodríguez Jurado");

        mtoolbar1.inflateMenu(R.menu.menu);

        mtoolbar1.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.opcion1:
                        Toast.makeText(Material09.this, "PULSADA OPCION 1", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.opcion2:
                        Toast.makeText(Material09.this, "PULSADA OPCION 2", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.opcion3:
                        Toast.makeText(Material09.this, "PULSADA OPCION 3", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void rotate(float angulo){
        Animation animacion = new RotateAnimation(0.0f, angulo, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        animacion.setFillAfter(true);
        animacion.setDuration(DURACION);
        icono.startAnimation(animacion);
    }

    public void tocado(View view){

        if (giro == true){
            icono.setImageResource(R.mipmap.menos);
            rotate(-180.0f);
            giro = false;
            Dinamizador.contrae(detalle, DURACION);
        } else if (giro == false){
            icono.setImageResource(R.mipmap.menos);
            rotate(180.0f);
            giro = true;
            Dinamizador.expande(detalle,DURACION);
        }
    }
}
