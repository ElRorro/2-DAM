package es.vcarmen.dialogo08;

import android.app.DatePickerDialog;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class Dialogo08 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    FragmentManager fmanager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo08);

        Button boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialogo fragment = new Dialogo();
                fragment.show(fmanager, "PERSONALIZADO");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Toast.makeText(this, "FECHA ELEGIDA: " + day + "/" + (month+1) + "/" + year, Toast.LENGTH_LONG).show();
    }
}
