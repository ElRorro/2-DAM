package es.vcarmen.sonido04;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

public class Sonido04 extends AppCompatActivity {

    ImageButton mbtnRecord, mbtnPause, mbtnPlay;
    private MediaRecorder miGrabadora;
    private String salida = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido04);

        mbtnRecord = (ImageButton)findViewById(R.id.imRecord);
        mbtnPause = (ImageButton)findViewById(R.id.imPause);
        mbtnPlay = (ImageButton)findViewById(R.id.imPlay);

        mbtnRecord.setEnabled(true);
        mbtnPause.setEnabled(false);
        mbtnPlay.setEnabled(false);

        salida = Environment.getExternalStorageDirectory().getAbsolutePath()+"/grabado.3gp";
        miGrabadora = new MediaRecorder();
        miGrabadora.setAudioSource(MediaRecorder.AudioSource.MIC);
        miGrabadora.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        miGrabadora.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        miGrabadora.setOutputFile(salida);

        mbtnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    miGrabadora.prepare();
                    miGrabadora.start();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "GRABACIÓN", Toast.LENGTH_SHORT).show();

                mbtnRecord.setEnabled(false);
                mbtnPause.setEnabled(true);
            }
        });

        mbtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miGrabadora.stop();
                miGrabadora.release();
                miGrabadora = null;

                Toast.makeText(getApplicationContext(), "FIN GRABACIÓN", Toast.LENGTH_SHORT).show();
                mbtnPlay.setEnabled(true);
                mbtnPause.setEnabled(false);
            }
        });

        mbtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) throws IllegalArgumentException,SecurityException,IllegalStateException{
                    MediaPlayer repro = new MediaPlayer();

                    try {
                        repro.setDataSource(salida);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        repro.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    repro.start();

                    mbtnRecord.setEnabled(true);
                    mbtnPause.setEnabled(false);
                    mbtnPlay.setEnabled(false);
                    Toast.makeText(getApplicationContext(), "REPRODUCIENDO", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
