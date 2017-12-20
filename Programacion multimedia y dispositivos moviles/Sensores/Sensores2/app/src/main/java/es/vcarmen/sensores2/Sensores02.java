package es.vcarmen.sensores2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores02 extends AppCompatActivity implements SensorEventListener {
    private int contador = 0;
    private double x = 0, y = 0, z = 0, amax = 0, a = 0;
    private double gravedad = SensorManager.STANDARD_GRAVITY;
    private TextView tvax, tvay, tvaz, tvaMax, tvG, tva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores02);

        tvax = (TextView) findViewById(R.id.tvEjeX);
        tvay = (TextView) findViewById(R.id.tvEjeY);
        tvaz = (TextView) findViewById(R.id.tvEjeZ);
        tvaMax = (TextView) findViewById(R.id.tvAc_Max);
        tvG = (TextView) findViewById(R.id.tvGr);
        tva = (TextView) findViewById(R.id.tvAc);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_FASTEST);
        new MyAsynTask().execute();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        x = sensorEvent.values[0];
        y = sensorEvent.values[1];
        z = sensorEvent.values[2];

        a = Math.sqrt(x*x + y*y + z*z);

        if (a > amax) amax = a;


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    class MyAsynTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            while(true) {
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
            tvaMax.setText("" + amax);
            tva.setText("" + a);
            tvG.setText("" + gravedad);
            tvG.append("\n" + "CONTADOR: " + contador);
        }
    }
}
