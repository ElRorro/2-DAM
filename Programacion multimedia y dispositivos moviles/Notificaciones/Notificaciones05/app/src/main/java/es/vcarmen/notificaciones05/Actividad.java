package es.vcarmen.notificaciones05;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Actividad extends AppCompatActivity {

    private NotificationManager notificador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad);

        Button boton = (Button) findViewById(R.id.button1);

        notificador = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notification(1, android.R.drawable.stat_sys_warning, "NOTIFICACIÓN", "PULSA LA NOTIFICACIÓN");
            }
        });
    }

    public void notification(int id, int iconId, String titulo, String contenido) {
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(iconId)
                .setLargeIcon(BitmapFactory.decodeResource(
                        getResources(),
                        R.mipmap.ic_launcher
                        )
                )
                .setContentTitle(titulo)
                .setContentText(contenido)
                .setColor(getResources().getColor(R.color.colorAccent));

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(resultPendingIntent);

        builder.setAutoCancel(true);

        notificador.notify(id, builder.build());
    }
}

