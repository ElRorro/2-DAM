package es.vcarmen.dialogo07;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;
import java.text.DateFormat;

/**
 * Created by matinal on 11/01/2018.
 */

public class Dialogo extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return dialogo();
    }

    public TimePickerDialog dialogo() {
        final Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int minutos = c.get(Calendar.MINUTE);

        return new TimePickerDialog(
                getActivity(),
                (TimePickerDialog.OnTimeSetListener) getActivity(),
                hora,minutos, android.text.format.DateFormat.is24HourFormat(getActivity()));
    }
}
