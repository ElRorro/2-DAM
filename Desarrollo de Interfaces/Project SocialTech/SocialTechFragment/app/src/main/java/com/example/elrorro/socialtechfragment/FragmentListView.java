package com.example.elrorro.socialtechfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by ElRorro on 23/10/2017.
 */


public class FragmentListView extends Fragment implements View.OnClickListener {
    private static final String LIST_INSTANCE_STATE = "listView" ;
    private Button addNewContact;
    private ListView mListView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listview, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mListView = (ListView) getActivity().findViewById(R.id.listContact);
        addNewContact = (Button) getActivity().findViewById(R.id.addNewContact);
        addNewContact.setOnClickListener(this);

        if(savedInstanceState!=null) {
            mListView = savedInstanceState.getParcelable(LIST_INSTANCE_STATE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(LIST_INSTANCE_STATE, mListView.onSaveInstanceState());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addNewContact:
                Intent intent = new Intent(getActivity(), MainForm.class);
                startActivity(intent);
                break;
        }
    }
}
