package com.example.android.tourguideapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.tourguideapp.Adapters.ChurchesListAdapter;
import com.example.android.tourguideapp.Models.Church;
import com.example.android.tourguideapp.R;

import java.util.ArrayList;

public class ChurchesFragment extends Fragment {
    private View fragment_view;
    private ListView listView;
    private ChurchesListAdapter churchesListAdapter;
    private ArrayList<Church> churches = new ArrayList<>();
    private final String[] CHURCHES_NAMES = {"Calvaria Fortress Church", "Saints Peter and Paul Church", "The Bob Church", "The Calvin Church with Rooster", "The Calvin Reformed Church of the Lower Town", "The Church of the Piarists"};
    private final String[] CHURCHES_PHONES = {"+40 (0)264 - 511.205", "+40 (0)264 – 878.987", "+40 (0)264 – 420.120", "+40 (0)0264 - 540.210", "+40 (0)0264 - 144.110", "+40 (0)0264 - 149.841"};
    private final String[] CHURCHES_STREETS = {"Manastur 60 Street", "36, Boulevard December 21, 1989", "Narciselor 34", "84, Motilor Street", "41, December 21st 1918 Boulevard", "Grigorescu 23 Street"};

    public ChurchesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initializeUiComponents(inflater, container);
        initializeMuseumsList();
        setAdapterOnMuseumsList();
        return fragment_view;
    }

    private void initializeUiComponents(LayoutInflater inflater, ViewGroup container) {
        fragment_view = inflater.inflate(R.layout.fragment_view, container, false);
        listView = (ListView) fragment_view.findViewById(R.id.baseList);
    }

    private void initializeMuseumsList() {
        churches.clear();
        for (int i = 0; i < CHURCHES_NAMES.length; i++) {
            Church currentChurch = new Church();
            currentChurch.setName(CHURCHES_NAMES[i]);
            currentChurch.setPhone(CHURCHES_PHONES[i]);
            currentChurch.setStreet(CHURCHES_STREETS[i]);
            churches.add(currentChurch);
        }
    }

    private void setAdapterOnMuseumsList() {
        churchesListAdapter = new ChurchesListAdapter(getActivity(), churches);
        listView.setAdapter(churchesListAdapter);
    }
}
