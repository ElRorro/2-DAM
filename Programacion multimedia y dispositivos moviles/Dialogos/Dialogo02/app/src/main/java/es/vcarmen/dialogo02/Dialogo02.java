package es.vcarmen.dialogo02;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Dialogo02 extends AppCompatActivity {

    private Button mbtn;
    private EditText editext1;
    private EditText editext2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo02);

        mbtn = (Button) findViewById(R.id.btn);
        editext1 = (EditText) findViewById(R.id.editext1);
        editext2 = (EditText) findViewById(R.id.editext2);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(0);
            }
        });

        class Aceptar implements View.OnClickListener {
            @Override
            public void onClick(View view) {
                String username = editext1.getText().toString().trim();
                String password = editext2.getText().toString().trim();

                if (username.matches("Leonardo") && password.matches("Davinci")){
                    dismissDialog(id);
                } else {
                    tvd.setText("Datos Incorrectos");
                }
            }
        }
    }

    protected Dialog onCreateDialog (int id) {
        Dialog dialogo = new Dialog(this);
        Window w = dialogo.getWindow();
        int flag = WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
        w.setFlags(flag, flag);
        dialogo.setTitle("DIÁLOGO PERSONAL");
        dialogo.setContentView(R.layout.dialogo);
        mbtn.setOnClickListener(new Dialogo02.Aceptar());
        return dialogo;
    }

}
