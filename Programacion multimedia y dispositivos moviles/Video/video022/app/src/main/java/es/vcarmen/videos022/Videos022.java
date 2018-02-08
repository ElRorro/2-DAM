package es.vcarmen.videos022;

import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class Videos022 extends AppCompatActivity implements SurfaceHolder.Callback {

    Uri pelicula;
    public TextView titulo;

    MediaPlayer reproductor;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    boolean pausa = false;

    String video =
            Environment.getExternalStorageDirectory().getAbsolutePath()+"/storage/emulated/0/Movies/Instagram/VID_215371221_054657_079.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos022);

        Button botonPlay = (Button) findViewById(R.id.reproduce);
        Button botonPausa = (Button) findViewById(R.id.pausa);
        titulo = (TextView) findViewById(R.id.video);
        getWindow().setFormat(PixelFormat.UNKNOWN);
        surfaceView = (SurfaceView) findViewById(R.id.surface);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFixedSize(176, 144);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        reproductor = new MediaPlayer();


        botonPlay.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                pausa = false;
                if (reproductor.isPlaying()) {
                    reproductor.reset();
                }
                reproductor.setAudioStreamType(AudioManager.STREAM_MUSIC);
                reproductor.setDisplay(surfaceHolder);
                try {
                    reproductor.setDataSource(video);
                    //reproductor.setDataSource(getApplication(),video);
                    reproductor.prepare();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                reproductor.start();
            }
        });

        botonPausa.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (pausa) {
                    pausa = false;
                    reproductor.start();
                } else {
                    pausa = true;
                    reproductor.pause();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        reproductor.release();
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
