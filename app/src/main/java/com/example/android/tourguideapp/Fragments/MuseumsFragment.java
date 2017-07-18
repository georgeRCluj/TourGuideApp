package com.example.android.tourguideapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.tourguideapp.Adapters.MuseumsListAdapter;
import com.example.android.tourguideapp.Models.Museum;
import com.example.android.tourguideapp.R;

import java.util.ArrayList;

public class MuseumsFragment extends Fragment {
    private View fragment_view;
    private ListView listView;
    private MuseumsListAdapter museumsListAdapter;
    private ArrayList<Museum> museums = new ArrayList<>();
    private final String[] MUSEUM_NAMES = {"Art Museum", "National Ethnographic Museum", "Botanical Museum", "Emil Racovita Museum"};
    private final String[] MUSEUM_PHONES = {"+40 (0)264 - 596.953", "+40 (0)264 – 586.776", "+40 (0)264 – 592.152", "+40 (0)0264 - 430.601"};
    private final String[] MUSEUM_EMAILS = {"macn@cluj.astral.ro", "contact@muzeul-etnografic.rom", "gradina.botanica@ubbcluj.ro", "info-tourism@primariaclujnapoca.ro"};
    private final String[] MUSEUM_WEBSITES = {"http://www.macluj.ro", "http://www.muzeul-etnografic.ro", "http://www.ubbcluj.ro/ro/structura/sport/botanica.html", " "};

    public MuseumsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
        museums.clear();
        for (int i = 0; i < MUSEUM_NAMES.length; i++) {
            Museum currentMuseum = new Museum();
            currentMuseum.setName(MUSEUM_NAMES[i]);
            currentMuseum.setPhone(MUSEUM_PHONES[i]);
            currentMuseum.setEmail(MUSEUM_EMAILS[i]);
            currentMuseum.setWebsite(MUSEUM_WEBSITES[i]);
            museums.add(currentMuseum);
        }
    }

    private void setAdapterOnMuseumsList() {
        museumsListAdapter = new MuseumsListAdapter(getActivity(), museums);
        listView.setAdapter(museumsListAdapter);
    }
}
