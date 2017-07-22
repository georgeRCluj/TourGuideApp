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
    private String[] museum_names, museum_phones, museum_emails, museum_websites;

    public MuseumsFragment() {
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
        museum_names = getActivity().getResources().getStringArray(R.array.museum_names);
        museum_phones = getActivity().getResources().getStringArray(R.array.museum_phones);
        museum_emails = getActivity().getResources().getStringArray(R.array.museum_emails);
        museum_websites = getActivity().getResources().getStringArray(R.array.museum_websites);
        museums.clear();
        for (int i = 0; i < museum_names.length; i++) {
            Museum currentMuseum = new Museum();
            currentMuseum.setName(museum_names[i]);
            currentMuseum.setPhone(museum_phones[i]);
            currentMuseum.setEmail(museum_emails[i]);
            currentMuseum.setWebsite(museum_websites[i]);
            museums.add(currentMuseum);
        }
    }

    private void setAdapterOnMuseumsList() {
        museumsListAdapter = new MuseumsListAdapter(getActivity(), museums);
        listView.setAdapter(museumsListAdapter);
    }
}
