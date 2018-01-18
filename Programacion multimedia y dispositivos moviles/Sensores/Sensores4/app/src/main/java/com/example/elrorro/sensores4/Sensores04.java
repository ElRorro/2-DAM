package com.example.elrorro.sensores4;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores04 extends AppCompatActivity implements SensorEventListener{
    private int contador;
    private boolean continuar = true;
    private double x = 0, y = 0, z = 0, a = 0, amax = 0;
    private double campoTierraMax = SensorManager.MAGNETIC_FIELD_EARTH_MAX;
    private double campoTierraMin = SensorManager.MAGNETIC_FIELD_EARTH_MIN;
    TextView tvax, tvay, tvaz, tva, tvaMax, tvG, cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores04);

        tvax = (TextView) findViewById(R.id.tvCampoX);
        tvay = (TextView) findViewById(R.id.tvCampoY);
        tvaz = (TextView) findViewById(R.id.tvCampoZ);
        tva = (TextView) findViewById(R.id.tvCampoMagnetico);
        tvaMax = (TextView) findViewById(R.id.tvCampoTerrestre);
        tvG = (TextView) findViewById(R.id.tvCampoTierra);
        cont = (TextView) findViewById(R.id.tvContador);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor campo = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        sensorManager.registerListener(this, campo, SensorManager.SENSOR_DELAY_NORMAL);
        new MyAsynTask().execute();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        x = sensorEvent.values[0];
        y = sensorEvent.values[0];
        z = sensorEvent.values[0];

        a = Math.sqrt(x*x + y*y + z*z);
        if (a > amax) amax = a;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    class MyAsynTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            while (true) {
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                contador++;
                publishProgress();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            tvax.setText("" + x);
            tvay.setText("" + y);
            tvaz.setText("" + z);
            tva.setText("" + a);
            tvaMax.setText("" + amax);
            tvG.setText("" + campoTierraMin + " . " + campoTierraMax);
            cont.setText("CONTADOR: " + contador);
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        continuar = true;
        new MyAsynTask().execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        continuar = false;
    }
}
