package com.example.elrorro.socialtechfragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterContact extends ArrayAdapter<Contact> {
    public AdapterContact(@NonNull Context context, @NonNull ArrayList<Contact> listContact) {
        super(context, 0, listContact);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Lo ponemos a null para que cada vez que añada un usuario me lo pinte en el TextView
        convertView = null;
        Contact c = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.textName);
        TextView surname = (TextView) convertView.findViewById(R.id.textSurname);
        TextView email = (TextView) convertView.findViewById(R.id.textEmail);

        name.setText(c.getNameContact());
        surname.setText(c.getSurnameContact());
        email.setText(c.getEmailContact());

        return convertView;
    }
}
