package com.example.elrorro.sensores3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores03 extends AppCompatActivity implements SensorEventListener{

    private int contador;
    private double x = 0, y = 0, z = 0;
    private TextView tvax, tvay, tvaz, cont;
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores03);

        tvax = (TextView) findViewById(R.id.tvEjeX);
        tvay = (TextView) findViewById(R.id.tvEjeY);
        tvaz = (TextView) findViewById(R.id.tvEjeZ);
        cont = (TextView) findViewById(R.id.tvContador);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        sensorManager.registerListener(this, gyro, SensorManager.SENSOR_DELAY_FASTEST);
        new MyAsynTask().execute();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        x = sensorEvent.values[0];
        y = sensorEvent.values[0];
        z = sensorEvent.values[0];
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
            cont.setText("CONTADOR: " + contador);
        }
    }
}
