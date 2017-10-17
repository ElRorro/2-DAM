package es.vcarmen.fragment05;

import android.preference.PreferenceFragment;
import android.support.annotation.XmlRes;

/**
 * Created by matinal on 17/10/17.
 */

public class Fragmento1 extends PreferenceFragment {
    @Override
    public void addPreferencesFromResource(@XmlRes int preferencesResId) {
        super.addPreferencesFromResource(R.xml.preferencias);
    }
}
