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
    private String[] churches_names, churches_phones, churches_streets;

    public ChurchesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initializeUiComponents(inflater, container);
        initializeChurchesList();
        setAdapterOnChurchesList();
        return fragment_view;
    }

    private void initializeUiComponents(LayoutInflater inflater, ViewGroup container) {
        fragment_view = inflater.inflate(R.layout.fragment_view, container, false);
        listView = (ListView) fragment_view.findViewById(R.id.baseList);
    }

    private void initializeChurchesList() {
        churches_names = getActivity().getResources().getStringArray(R.array.church_names);
        churches_phones = getActivity().getResources().getStringArray(R.array.church_phones);
        churches_streets = getActivity().getResources().getStringArray(R.array.church_streets);
        churches.clear();
        for (int i = 0; i < churches_names.length; i++) {
            Church currentChurch = new Church();
            currentChurch.setName(churches_names[i]);
            currentChurch.setPhone(churches_phones[i]);
            currentChurch.setStreet(churches_streets[i]);
            churches.add(currentChurch);
        }
    }

    private void setAdapterOnChurchesList() {
        churchesListAdapter = new ChurchesListAdapter(getActivity(), churches);
        listView.setAdapter(churchesListAdapter);
    }
}
