package com.example.elrorro.socialtechfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ElRorro on 23/10/2017.
 */

public class FragmentForm extends Fragment implements View.OnClickListener {
    private String[] TRAINING = {"SMR", "DAM", "DAW", "ASIR",
            "Ingeniería técnica informática", "Ingeniería Informática", "Grado", "Otros"};
    private String[] PROVINCE = {"Almería", "Cádiz", "Córdoba", "Granada", "Huelva", "Jaén", "Málaga", "Sevilla"};
    private ArrayList<Contact> listContact = new ArrayList<Contact>();
    //Definimos las variables para posteriormente
    private Button btnAddConctact;
    private EditText nameContact;
    private EditText surnameContact;
    private EditText telephoneContact;
    private EditText emailContact;
    //private Spinner trainingContact;
    private Spinner spinnerProvince;
    private TextView numberContact;
    private SeekBar age;
    private TextView textAge;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private ListView listViewContact;

    private MultiAutoCompleteTextView multiTitle;
    //creamos variables para almacenar el contenido de los EditText
    private String contactName;
    private String contactSurname;
    private int contactTelephone;
    private String contactEmail;
    private String contactTraining;
    private String contactProvince;
    private int contactAge;
    private String gender;

    //PARA GUARDAR EL ARRAY Y LOS DATOS NECESARIOS(SERIALIZABLE)
    public final static String AGENDA = "AGENDA";

    //creamos un objeto Contact
    private Contact contact;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnAddConctact = (Button) getActivity().findViewById(R.id.addContact);
        nameContact = (EditText) getActivity().findViewById(R.id.editName);
        surnameContact = (EditText) getActivity().findViewById(R.id.editSurname);
        telephoneContact = (EditText) getActivity().findViewById(R.id.editTelephone);
        emailContact = (EditText) getActivity().findViewById(R.id.editEmail);
        //trainingContact = (MultiAutoCompleteTextView) findViewById(R.id.multiTitle);
        //trainingContact = (Spinner) findViewById(R.id.spinner);
        numberContact = (TextView) getActivity().findViewById(R.id.numberContacs);
        spinnerProvince = (Spinner) getActivity().findViewById(R.id.spinnerProvince);
        age = (SeekBar) getActivity().findViewById(R.id.seekAge);
        textAge = (TextView) getActivity().findViewById(R.id.textSeekBar);
        radioGroup = (RadioGroup) getActivity().findViewById(R.id.radioGroup);
        multiTitle = (MultiAutoCompleteTextView) getActivity().findViewById(R.id.multiTitle);
        listViewContact = (ListView) getActivity().findViewById(R.id.listContact);

        btnAddConctact.setOnClickListener(this);

        /*Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, TRAINING);
        spinner.setAdapter(adapter3);*/

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, TRAINING);
        multiTitle.setAdapter(adapter);
        multiTitle.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


        Spinner spinner2 = (Spinner) getActivity().findViewById(R.id.spinnerProvince);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, PROVINCE);
        spinner2.setAdapter(adapter4);

        age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progreso, boolean paraUsuario) {
                textAge.setText(String.valueOf(progreso));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        if (savedInstanceState != null){
            listContact = (ArrayList<Contact>) savedInstanceState.getSerializable(AGENDA);
        }
        numberContact.setText(String.valueOf("Numero Total Contactos: " + listContact.size()));

        /*listViewContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });*/
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addContact:

                contactName = nameContact.getText().toString();
                contactSurname = surnameContact.getText().toString();
                contactTelephone = Integer.parseInt(telephoneContact.getText().toString());
                contactEmail = emailContact.getText().toString();
                contactTraining = multiTitle.getText().toString();
                contactProvince = (String) spinnerProvince.getSelectedItem();
                contactAge = age.getProgress();

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioButton = (RadioButton) getActivity().findViewById(selectedId);
                gender = radioButton.getText().toString();

                Contact c = new Contact(contactName, contactSurname, contactTelephone, contactEmail, contactTraining, contactProvince, contactAge, gender);
                listContact.add(c);

                numberContact.setText(String.valueOf("Numero Total Contactos: " + listContact.size()));

                AdapterContact adapter = new AdapterContact(this.getActivity(), listContact);
                listViewContact = (ListView) getActivity().findViewById(R.id.listContact);
                listViewContact.setAdapter(adapter);

        }
    }

    //Para guardar valores cuando giramos la pantalla hacemos lo siguiente
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(AGENDA, listContact);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form, container, false);
    }
}
