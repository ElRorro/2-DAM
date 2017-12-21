package com.example.elrorro.sensores5;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores5 extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor orienta;
    private int contador;
    private double azimut = 0, vertical = 0, lateral = 0;
    private String orientacion = "posicion";
    private TextView tvAzimut, tvVertical, tvOrientacion, tvContador, tvLateral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores5);

        tvAzimut = (TextView) findViewById(R.id.tvAzimut);
        tvVertical = (TextView) findViewById(R.id.tvVerticalidad);
        tvOrientacion = (TextView) findViewById(R.id.tvOrientacion);
        tvContador = (TextView) findViewById(R.id.tvNumeroLecturas);
        tvLateral = (TextView) findViewById(R.id.tvInclinacion);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        orienta = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        runOnUiThread(new CambiaTexto());
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        azimut = sensorEvent.values[0];
        vertical = sensorEvent.values[1];
        lateral = sensorEvent.values[2];
        contador++;

        if(azimut < 22) orientacion = "NORTE";
        else if (azimut < 67) orientacion = "NORESTE";
        else if (azimut < 112) orientacion = "ESTE";
        else if (azimut < 157) orientacion = "SURESTE";
        else if (azimut < 202) orientacion = "SUR";
        else if (azimut < 247) orientacion = "SUROESTE";
        else if (azimut < 292) orientacion = "OESTE";
        else if (azimut < 337) orientacion = "NOROESTE";
        else orientacion = "NORTE";

        if (vertical < 50) orientacion = "VERTICAL ARRIBA";
        if (vertical > 50) orientacion = "VERTICAL ABAJO";

        if (lateral < 50) orientacion = "LATERAL IZQUIERDA";
        if (lateral > 50) orientacion = "LATERAL DERECHA";


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    class CambiaTexto implements Runnable {
        @Override
        public void run() {
            tvAzimut.setText(""+azimut);
            tvVertical.setText(""+vertical);
            tvLateral.setText(""+lateral);
            tvOrientacion.setText(""+orientacion);
            tvContador.setText(""+contador);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        sensorManager.registerListener(this, orienta, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
