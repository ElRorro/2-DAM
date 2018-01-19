package es.vcarmen.notificaciones05;

/**
 * Created by matinal on 19/01/2018.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class Notificacion05 extends AppCompatActivity{
    private NotificationManager notificador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification05);
        Button boton= (Button) findViewById(R.id.button1);
        notificador = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                notification(
                        1,
                        android.R.drawable.stat_sys_warning,
                        "NOTIFICACIÓN",
                        "NUEVA NOTIFICACIÓN"
                );
            }
        });
    }
    public void notification(int id, int iconId, String titulo, String
            contenido) {
        Intent intent = new Intent(this, Actividad.class);
        intent.setAction(Intent.ACTION_VIEW);
        PendingIntent actividad = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new
                        NotificationCompat.Builder(this)
                        .setSmallIcon(iconId)
                        .setLargeIcon(BitmapFactory.decodeResource(
                                getResources(),
                                R.mipmap.ic_launcher))
                        .setContentTitle(titulo)
                        .setContentText(contenido)

                        .setColor(getResources().getColor(R.color.colorAccent))
                        .setStyle(
                                new NotificationCompat.BigTextStyle()
                                        .bigText(contenido + ", pulsa para ver la nueva ctividad"))
                                                        .addAction(android.R.drawable.ic_menu_edit,
                                                                "VERLA", actividad)
                                                        .addAction(android.R.drawable.stat_sys_warning,
                                                                "IGNORAR", null)
                                                        .setAutoCancel(true);
        Notification notification = mBuilder.build();
        notificador.notify(id, notification);
    }
}

