package es.vcarmen.videomediastore;

import android.content.Context;
import android.database.Cursor;
import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.io.IOException;

public class videoMediaStore extends AppCompatActivity implements SurfaceHolder.Callback{
    private Button boton1, boton2;
    private Spinner mSpinner;
    private SurfaceView surfaceView;
    private CursorAdapter adaptador;
    private TextView texto1, texto2;
    private Uri pelicula;
    private SurfaceHolder surfaceHolder;
    private MediaPlayer reproductor;
    private boolean pausa = false;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_media_store);

        boton1 = (Button) findViewById(R.id.reproduce);
        boton2 = (Button) findViewById(R.id.pausa);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        texto1 = (TextView) findViewById(R.id.textView1);
        texto2 = (TextView) findViewById(R.id.textView2);
        surfaceView = (SurfaceView) findViewById(R.id.surface);

        final Uri mediaSrc = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        cursor = managedQuery(mediaSrc,null,null,null,MediaStore.Audio.Media.TITLE);

        String[] nombre = {MediaStore.MediaColumns.TITLE};
        int[] ids = {android.R.id.text1};
        adaptador = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, nombre, ids);
        mSpinner.setAdapter(adaptador);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> padre, View vista, int posicion, long id) {
                cursor = adaptador.getCursor();
                cursor.moveToPosition(posicion);
                String indice = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
                pelicula = Uri.withAppendedPath(mediaSrc, indice);
                texto1.setText(pelicula.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.setFixedSize(176,144);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        reproductor = new MediaPlayer();

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pausa = false;

                if (reproductor.isPlaying()) {
                    reproductor.reset();
                    reproductor.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    reproductor.setDisplay(surfaceHolder);
                }

                try {
                    reproductor.setDataSource(getApplicationContext(), pelicula);
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

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pausa == true) {
                    pausa = false;
                    reproductor.start();
                }

                if (pausa == false) {
                    pausa = true;
                    reproductor.pause();
                }
            }
        });

        getWindow().setFormat(PixelFormat.UNKNOWN);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        reproductor.release();
    }
}
