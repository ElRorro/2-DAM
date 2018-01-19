package es.vcarmen.dialogo08;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by matinal on 11/01/2018.
 */

public class Dialogo extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return dialogo();
    }

    public DatePickerDialog dialogo() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),
                (DatePickerDialog.OnDateSetListener) getActivity(),
                year,
                month,
                day);
    }
}
