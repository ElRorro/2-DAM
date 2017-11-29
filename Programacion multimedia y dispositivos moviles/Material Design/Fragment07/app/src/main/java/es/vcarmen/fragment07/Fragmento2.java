package es.vcarmen.fragment07;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by matinal on 19/10/2017.
 */

public class Fragmento2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento2, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

}
