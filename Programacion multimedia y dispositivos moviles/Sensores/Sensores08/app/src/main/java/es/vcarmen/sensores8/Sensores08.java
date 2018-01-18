package es.vcarmen.sensores8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Sensores08 extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    private Sensor sensor;
    private Sensor acelerometro;
    public static int x, y, centrox = 250, centroy = 250;
    private LinearLayout mainLayout;
    ShapeDrawable mDibujo;
    MiVistaPersonal miVista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores8);

        mainLayout = (LinearLayout) findViewById(R.id.mLayout);
        mDibujo = new ShapeDrawable();

        miVista = new MiVistaPersonal(this);
        mainLayout.addView(miVista);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        x = centrox + (int) Math.pow(sensorEvent.values[1],2);
        y = centroy + (int) Math.pow(sensorEvent.values[2], 2);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    public class MiVistaPersonal extends View {
        private static final int ancho = 100, alto = 100;

        public MiVistaPersonal(Context context) {
            super(context);
            mDibujo = new ShapeDrawable(new OvalShape());
            mDibujo.getPaint().setColor(0xff74AC23);
            mDibujo.setBounds(x,y,x+ancho, y+alto);
        }

        protected void onDraw(Canvas canvas) {
            RectF oval = new RectF(Sensores08.x, Sensores08.y, Sensores08.x + ancho, Sensores08.y + alto);
            Paint pincel = new Paint();
            pincel.setColor(Color.RED);
            canvas.drawRect(oval, pincel);
            invalidate();
        }
    }

}



