package com.example.android.tourguideapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.tourguideapp.Adapters.StatuesAndParksListAdapter;
import com.example.android.tourguideapp.Models.StatuePark;
import com.example.android.tourguideapp.R;

import java.util.ArrayList;

public class ParksFragment extends Fragment {
    private View fragment_view;
    private ListView listView;
    private StatuesAndParksListAdapter parksListAdapter;
    private ArrayList<StatuePark> statues = new ArrayList<>();
    private String[] parks_names, parks_streets;
    private final int[] PARKS_PICTURES = {R.drawable.park_botanical_garden,R.drawable.park_simion_barnutiu, R.drawable.park_cetatuia, R.drawable.park_faget, R.drawable.park_bhoia};

    public ParksFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initializeUiComponents(inflater, container);
        initializeParksList();
        setAdapterOnParksList();
        return fragment_view;
    }

    private void initializeUiComponents(LayoutInflater inflater, ViewGroup container) {
        fragment_view = inflater.inflate(R.layout.fragment_view, container, false);
        listView = (ListView) fragment_view.findViewById(R.id.baseList);
    }

    private void initializeParksList() {
        parks_names = getActivity().getResources().getStringArray(R.array.park_names);
        parks_streets = getActivity().getResources().getStringArray(R.array.park_streets);
        statues.clear();
        for (int i = 0; i < parks_names.length; i++) {
            StatuePark currentStatue = new StatuePark();
            currentStatue.setName(parks_names[i]);
            currentStatue.setStreet(parks_streets[i]);
            currentStatue.setImageResId(PARKS_PICTURES[i]);
            statues.add(currentStatue);
        }
    }

    private void setAdapterOnParksList() {
        parksListAdapter = new StatuesAndParksListAdapter(getActivity(), statues);
        listView.setAdapter(parksListAdapter);
    }
}