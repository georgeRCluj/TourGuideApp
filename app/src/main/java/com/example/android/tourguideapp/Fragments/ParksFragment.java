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
    private final String[] PARKS_NAMES = {"„Alexandru Borza” Botanical Garden", "„Simion Barnutiu” Central Park", "The Cetatuia Park", "The Faget of Cluj", "The Hoia Forest and Hill"};
    private final String[] PARKS_STREETS = {"42 Republicii Street", "Motilor Center", "Cetatuia Street", "Calea Turzii Street", "Calea Baciului Street"};
    private final int[] PARKS_PICTURES = {R.drawable.park_botanical_garden,R.drawable.park_simion_barnutiu, R.drawable.park_cetatuia, R.drawable.park_faget, R.drawable.park_bhoia};

    public ParksFragment() {
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
        statues.clear();
        for (int i = 0; i < PARKS_NAMES.length; i++) {
            StatuePark currentStatue = new StatuePark();
            currentStatue.setName(PARKS_NAMES[i]);
            currentStatue.setStreet(PARKS_STREETS[i]);
            currentStatue.setImageResId(PARKS_PICTURES[i]);
            statues.add(currentStatue);
        }
    }

    private void setAdapterOnMuseumsList() {
        parksListAdapter = new StatuesAndParksListAdapter(getActivity(), statues);
        listView.setAdapter(parksListAdapter);
    }
}