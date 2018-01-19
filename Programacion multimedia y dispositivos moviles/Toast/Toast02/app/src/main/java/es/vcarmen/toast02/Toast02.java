package es.vcarmen.toast02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Toast02 extends AppCompatActivity {
    private Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast02);
        mBtn = (Button) findViewById(R.id.btn);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(getApplicationContext());
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.layoutToast));
                toast.setView(layout);
                toast.setGravity(Gravity.CENTER |Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                TextView mensaje = (TextView) layout.findViewById(R.id.texto2);
                mensaje.setText("TOAST PERSONALIZADO");
                toast.show();
            }
        });
    }
}
