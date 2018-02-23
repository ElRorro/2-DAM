package es.vcarmen.dibujo01;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Grafico grafico = new Grafico(this);
        setContentView(grafico);

    }

    private class Grafico extends View {

        public Grafico(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
        }
    }
}




