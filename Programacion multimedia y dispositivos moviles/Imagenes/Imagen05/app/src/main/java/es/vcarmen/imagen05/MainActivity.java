package es.vcarmen.imagen05;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mText2;
    Button mBtnReescalar;
    ImageView mImageView;
    private static int escala = 350;
    private Bitmap imagen, bm;
    private float factorEscala;
    private Long tiempoInicio, tiempoFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText2 = (TextView) findViewById(R.id.tvSubtitulo);
        mBtnReescalar = (Button) findViewById(R.id.btnReescalar);
        mImageView = (ImageView) findViewById(R.id.imageView);



        mBtnReescalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tiempoInicio = System.currentTimeMillis();

                imagen = BitmapFactory.decodeResource(getResources(), R.drawable.leonardo);

                factorEscala = escala/(float)imagen.getHeight();

                int imageWidth = (int) ((Integer)imagen.getWidth()*factorEscala);
                int imageHeigth = (int) ((Integer)imagen.getHeight()*factorEscala);
                bm = Bitmap.createScaledBitmap(imagen, imageWidth, imageHeigth, false);

                mImageView.setImageBitmap(bm);

                Matrix mat = new Matrix();
                mat.postRotate(90);
                Bitmap bMpRt = Bitmap.createBitmap(bm,0,0,imageWidth, imageHeigth,mat,true);
                mImageView.setImageBitmap(bMpRt);



                tiempoFinal = System.currentTimeMillis();

                Long timeTotal = tiempoInicio - tiempoFinal;

                mText2.setText(String.valueOf(timeTotal));
            }
        });




    }
}
