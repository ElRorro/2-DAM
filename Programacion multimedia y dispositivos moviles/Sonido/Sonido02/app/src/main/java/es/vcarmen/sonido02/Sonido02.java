package es.vcarmen.sonido02;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Sonido02 extends AppCompatActivity {
    SeekBar mSeekBar;
    TextView mtvTitulo, mtvDuracion;
    ImageButton mBtnPrevious, mBtnPause, mBtnPlay, mBtnNext;
    MediaPlayer mMediaPlayer;
    private double tiempoFinal, tiempoPasado, timeRestante;
    private int avance = 2000, retroceso = 2000;
    private Handler controladorTiempo = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido02);

        mSeekBar = (SeekBar) findViewById(R.id.seekbar);
        mtvTitulo = (TextView) findViewById(R.id.titulo);
        mtvDuracion = (TextView) findViewById(R.id.tvDuracion);
        mBtnPrevious = (ImageButton) findViewById(R.id.btnPrevious);
        mBtnPause = (ImageButton) findViewById(R.id.btnPause);
        mBtnPlay = (ImageButton) findViewById(R.id.btnPlay);
        mBtnNext = (ImageButton) findViewById(R.id.btnNext);

        mSeekBar.setClickable(false);
        mMediaPlayer = MediaPlayer.create(this, R.raw.codigo_davinci);
        tiempoFinal = mMediaPlayer.getDuration();
        mSeekBar.setMax((int) tiempoFinal);
        mtvTitulo.setText("codigo_davinci.mp3");

        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.start();
                tiempoPasado = mMediaPlayer.getCurrentPosition();
                mSeekBar.setProgress((int) tiempoPasado);
                controladorTiempo.postDelayed(actualizarBarra, 100);
            }
        });

        mBtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.pause();
            }
        });

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((tiempoPasado + avance) <= tiempoFinal) {
                    tiempoPasado = tiempoPasado + avance;
                    mMediaPlayer.seekTo((int) tiempoPasado);
                }
            }
        });

        mBtnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((tiempoPasado - retroceso) > 0) {
                    tiempoPasado = tiempoPasado - retroceso;
                    mMediaPlayer.seekTo((int) tiempoPasado);
                }
            }
        });
    }

    private Runnable actualizarBarra = new Runnable() {
        @Override
        public void run() {
            tiempoPasado = mMediaPlayer.getCurrentPosition();
            mSeekBar.setProgress((int) tiempoPasado);
            timeRestante = tiempoFinal - tiempoPasado;
            mtvDuracion.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long)timeRestante),
                    TimeUnit.MILLISECONDS.toSeconds((long)timeRestante) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                            timeRestante))));
            controladorTiempo.postDelayed(this,100);
        }
    };
}
