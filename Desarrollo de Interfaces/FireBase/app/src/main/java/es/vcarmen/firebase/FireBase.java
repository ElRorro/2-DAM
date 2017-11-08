package es.vcarmen.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FireBase extends AppCompatActivity {

    @BindView(R.id.historial)
    TextView historial;

    @BindView(R.id.btnEnviar)
    Button enviar;

    @BindView(R.id.entrada)
    EditText entrada;

    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base);
        //Para que funcione ButterKnife introducimos la siguiente linea
        ButterKnife.bind(this);
        //método para conectar a firebase
        conectarFirebase();
        //Leer datos de firebase
        leerFireBase();

    }

    @OnClick(R.id.btnEnviar)
    public void enviarMensaje(){
        String cadena = entrada.getText().toString();
        limpiarEntrada();
        Mensaje msg = new Mensaje(cadena);
        guardarMensaje(msg);
    }

    public void guardarMensaje(Mensaje msg){
        myRef.push().setValue(msg);
    }

    public void leerFireBase(){
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot != null && dataSnapshot.getValue() != null) {
                    try {
                        Mensaje msg = dataSnapshot.getValue(Mensaje.class);
                        insertarMensaje(msg);
                    } catch (Exception ex) {

                    }
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void insertarMensaje(Mensaje msg){
        if(msg.getMensaje() != null) {
            historial.append("\n");
            historial.append(msg.getMensaje());
        }
    }

    public void limpiarEntrada(){
        entrada.setText("");
    }

    public void conectarFirebase(){
        // Write a message to the database
        //Estable la conexión
        database = FirebaseDatabase.getInstance();
        //Crea una referencia a una colección dentro de la base de datos, la etiqueta mensaje podemos cambiar por lo que queramos
        myRef = database.getReference("message");
    }
}
