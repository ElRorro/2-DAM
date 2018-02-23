package es.vcarmen.dibujo05;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Grafico mVista = new Grafico(this);
        setContentView(mVista);
    }

    public class Grafico extends View {

        public Grafico(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.WHITE);
            Paint pincel = new Paint();
            pincel.setColor(Color.BLACK);
            canvas.drawLine(canvas.getWidth()/2, 0, canvas.getWidth()/2, canvas.getHeight(), pincel);

            pincel.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("ALINEAMIENTO DERECHA", canvas.getWidth()/2, canvas.getHeight()/8, pincel);
            pincel.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("ALINEAMIENTO CENTRO", canvas.getWidth()/2, canvas.getHeight()/6, pincel);
            pincel.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText("ALINEAMIENTO IZQUIERDA", canvas.getWidth()/2, canvas.getHeight()/4, pincel);
        }
    }
}
