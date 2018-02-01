package es.vcarmen.sonido03;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by matinal on 01/02/2018.
 */

public class Servicio extends Service {
    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        player = MediaPlayer.create(this, R.raw.badbunny);
        player.setLooping(true);
        Toast.makeText(this, "SERVICIO CREADO", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        player.stop();
        Toast.makeText(this, "SERVICIO STOP", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        player.start();
        Toast.makeText(this, "SERVICIO START", Toast.LENGTH_LONG).show();
    }
}
