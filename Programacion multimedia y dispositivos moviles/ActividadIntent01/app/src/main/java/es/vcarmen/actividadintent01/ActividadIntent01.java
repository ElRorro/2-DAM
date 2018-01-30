package es.vcarmen.actividadintent01;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class ActividadIntent01 extends AppCompatActivity {

    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_intent01);
        mBtn = (Button) findViewById(R.id.button1);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), Intent02.class);
                /*intent.putExtra("fecha", Calendar.getInstance().get(Calendar.YEAR));
                intent.putExtra("Almeria", "almeria");
                intent.putExtra("Jaen", "jaen");
                intent.putExtra("Cordoba", "cordoba");
                intent.putExtra("Huelva", "huelva");*/

                /*Intent implicito = new Intent(Intent.ACTION_VIEW);
                implicito.setData(Uri.parse("https://www.iesvirgendelcarmen.com/"));
                startActivity(implicito);*/

                /*Intent implicito2 = new Intent(Intent.ACTION_WEB_SEARCH);
                String cadena = "JAÉN";
                implicito2.putExtra(SearchManager.QUERY, cadena);
                startActivity(implicito2);*/

                /*Intent telefono = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:1234567890"));
                startActivity(telefono);*/

                /*Intent telefono2 = new Intent(Intent.ACTION_CALL);
                telefono2.setData(Uri.parse("tel:1234567890"));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(telefono2);*/

                /*Intent mapa = new Intent(Intent.ACTION_VIEW);
                mapa.setData(Uri.parse("geo:0,0?z=30&q=cines"));
                startActivity(mapa);*/

                /*Intent camara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(camara);*/

                /*Intent contactos = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("content://contacts/people/"));
                startActivity(contactos);*/
            }
        });
    }
}
