package com.iesvirgendelcarmen.dam.testtextview;

import android.view.View;
import android.widget.Button;

/**
 * Created by matinal on 02/10/2017.
 */

public class ManejadorEventos implements View.OnClickListener{
    @Override
    public void onClick(View view){
        Button btn = (Button) view;
        btn.setText("Boton pulsado");
    }
}
