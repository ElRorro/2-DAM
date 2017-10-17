package es.vcarmen.proyectobotones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int numero = 0;
    private TextView tn;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Para hacer un manejador de eventos hay que realizar los siguiente
         */
        //Capturamos el texto de numero para cambiar su texto por la cifra
        tn = (TextView) findViewById(R.id.numero);
        tn.setText(numero+"");

        Button btnIn = (Button) findViewById(R.id.inc);
        Button btnDec = (Button) findViewById(R.id.dec);
        ToggleButton tBtn = (ToggleButton) findViewById(R.id.tBtn);
        ll = (LinearLayout) findViewById(R.id.mainLayout);
        /*
        Segunda forma de hacer una manejador de eventos al realizar el this habra que implementar
        implements View.OnClickListener e implementar sus métodos posteriormente
         */
        btnIn.setOnClickListener(this);
        btnDec.setOnClickListener(this);

        btnIn.setOnLongClickListener(this);
        btnDec.setOnLongClickListener(this);

        tBtn.setOnCheckedChangeListener(this);

        /*
        Primera forma de hacer un manejador de eventos
         */
        /*
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero++;
                tn.setText(numero+"");
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numero > 0) {
                    numero--;
                    tn.setText(numero + "");
                }
            }
        });*/
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.inc:
                numero++;
                tn.setText(numero+"");
                break;
            case R.id.dec:
                if(numero > 0) {
                    numero--;
                    tn.setText(numero + "");
                }
                break;
        }
    }

    @Override
    public boolean onLongClick(View view) {
        /*if (view.getId() == R.id.inc){
            numero = numero + 10;
            tn.setText(numero+"");
            return true;
        } else {
            return false;
        }*/

        switch (view.getId()){
            case R.id.inc:
                numero = numero + 10;
                tn.setText(numero+"");
                return true;
            case R.id.dec:
                if(numero > 9) {
                    numero = numero - 10;
                    tn.setText(numero+"");
                }
                return true;
        }
        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b){
            ll.setBackgroundColor(getResources().getColor(R.color.colorMainLayoutOn));
        } else {
            ll.setBackgroundColor(getResources().getColor(R.color.colorMainLayoutOff));
        }
    }
}
