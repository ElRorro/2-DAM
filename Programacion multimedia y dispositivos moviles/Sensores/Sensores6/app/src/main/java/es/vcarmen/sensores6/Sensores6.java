package es.vcarmen.sensores6;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores6 extends AppCompatActivity implements SensorEventListener{

    SensorManager sensorManager;
    Sensor sensorProximo;
    int contador = 0;
    double distancia = 0;
    String proximidad = "LEJOS";
    TextView tvProximidad, tvDistancia, tvContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores6);

        tvProximidad = (TextView) findViewById(R.id.proximidad);
        tvDistancia = (TextView) findViewById(R.id.orientacion);
        tvContador = (TextView) findViewById(R.id.lecturas);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorProximo = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(this, sensorProximo, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        distancia = sensorEvent.values[0];
        contador++;
        if(distancia < 1) proximidad = "CERCA";
        else proximidad = "LEJOS";

        tvDistancia.setText(""+distancia);
        tvProximidad.setText(""+proximidad);
        tvContador.setText(""+contador);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    /*class CambiaTexto implements Runnable{

        @Override
        public void run() {
            tvDistancia.setText(""+distancia);
            tvProximidad.setText(""+proximidad);
            tvContador.setText(""+contador);
            runOnUiThread(new CambiaTexto());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }*/
}
