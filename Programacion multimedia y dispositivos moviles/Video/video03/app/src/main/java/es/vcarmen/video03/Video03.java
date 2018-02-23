package es.vcarmen.video03;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Video03 extends AppCompatActivity implements SurfaceHolder.Callback{
    private SurfaceView mSurfaceView;
    private Button mBtnGrabar, mBtnPausa, mBtnPlay;

    private MediaRecorder grabador;
    private MediaPlayer reproductor;

    private String ruta;
    private boolean grabando = false;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video03);

        mSurfaceView = (SurfaceView) findViewById(R.id.surface);
        mBtnGrabar = (Button) findViewById(R.id.grabar);
        mBtnPausa = (Button) findViewById(R.id.pausar);
        mBtnPlay = (Button) findViewById(R.id.play);

        mSurfaceView.getHolder().addCallback(this);
        mSurfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        ruta = Environment.getExternalStorageDirectory() + "mivideo.mp4";

        mBtnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                grabando = true;
                mBtnGrabar.setEnabled(false);
                mBtnPausa.setEnabled(true);
                mBtnPlay.setEnabled(false);

                grabador.setAudioSource(MediaRecorder.AudioSource.MIC);
                grabador.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                grabador.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                grabador.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                grabador.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
                grabador.setOutputFile(ruta);

                try {
                    grabador.prepare();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //Iniciamos el grabador
                grabador.start();
            }
        });

        mBtnPausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (grabando) {
                    grabador.stop();
                    grabador.reset();
                    grabando = false;
                } else {
                    reproductor.stop();
                    reproductor.reset();
                    mBtnPlay.setText("PLAY");
                }
            }
        });

        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (!reproductor.isPlaying()) {
                   reproductor.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                       @Override
                       public void onCompletion(MediaPlayer mediaPlayer) {
                           mBtnGrabar.setEnabled(true);
                           mBtnPausa.setEnabled(false);
                           mBtnPlay.setEnabled(true);
                       }
                   });
                   if (reproductor.getCurrentPosition() == reproductor.getDuration()) {
                       try {
                           reproductor.setDataSource(ruta);
                           reproductor.prepare();
                       } catch (IllegalArgumentException e) {
                       } catch (IOException e) {
                       }
                   }
                   reproductor.start();
               } else {
                 reproductor.pause();
               }
            }
        });
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (grabador == null) {
            grabador = new MediaRecorder();
            grabador.setPreviewDisplay(surfaceHolder.getSurface());
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        if (reproductor == null) {
            reproductor = new MediaPlayer();
            reproductor.setDisplay(surfaceHolder);
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        grabador.release();
        reproductor.release();
    }
}
