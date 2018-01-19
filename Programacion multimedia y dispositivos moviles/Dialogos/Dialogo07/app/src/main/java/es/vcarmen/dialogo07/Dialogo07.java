package es.vcarmen.dialogo07;

import android.support.v4.app.FragmentManager;
import android.app.TimePickerDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class Dialogo07 extends FragmentActivity implements TimePickerDialog.OnTimeSetListener {

    FragmentManager fmanager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo07);

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
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        Toast.makeText(this, "Tiempo: " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
    }
}
