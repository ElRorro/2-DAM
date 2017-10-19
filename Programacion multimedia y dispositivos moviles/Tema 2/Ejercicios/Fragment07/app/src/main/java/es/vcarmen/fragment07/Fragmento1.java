package es.vcarmen.fragment07;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by matinal on 19/10/2017.
 */

public class Fragmento1 extends Fragment {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private LinearLayout mlayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento1, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        btn1 = (Button) getActivity().findViewById(R.id.importarTexto1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView lbl = (TextView) getActivity().findViewById(R.id.texto3);
                Toast.makeText(getActivity(), lbl.getText(), Toast.LENGTH_SHORT).show();
                mlayout = (LinearLayout) getActivity().findViewById(R.id.mlayout);
                mlayout.setBackgroundColor(Color.parseColor("#C80EDB"));
            }
        });

        btn2 = (Button) getActivity().findViewById(R.id.exportarTexto1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView texto = (TextView) getActivity().findViewById(R.id.texto4);
                texto.setText("TOCADO FRAG1");
                texto.setTextColor(Color.parseColor("#0B2AF2"));
            }
        });

        btn3 = (Button) getActivity().findViewById(R.id.importarTexto2);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView lbl = (TextView) getActivity().findViewById(R.id.texto1);
                Toast.makeText(getActivity(), lbl.getText(), Toast.LENGTH_SHORT).show();
                mlayout = (LinearLayout) getActivity().findViewById(R.id.mlayout);
                mlayout.setBackgroundColor(Color.parseColor("#FC154A"));
            }
        });

        btn4 = (Button) getActivity().findViewById(R.id.exportarTexto2);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView texto = (TextView) getActivity().findViewById(R.id.texto2);
                texto.setText("TOCADO FRAG2");
                texto.setTextColor(Color.parseColor("#16F20B"));
            }
        });
    }

}
