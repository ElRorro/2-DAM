package es.vcarmen.actividadintent01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by matinal on 19/01/2018.
 */

public class Intent02 extends AppCompatActivity {
    private TextView mTv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent02);

        mTv = (TextView) findViewById(R.id.texto2);

        Bundle extras = getIntent().getExtras();

        /*mTv.setText(extras.get("fecha").toString() + "\n");
        mTv.append(extras.get("Almeria").toString() + "\n");
        mTv.append(extras.get("Jaen").toString() + "\n");
        mTv.append(extras.get("Cordoba").toString() + "\n");
        mTv.append(extras.get("Huelva").toString() + "\n");*/

    }
}
