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

public class StatuesFragment extends Fragment {
    private View fragment_view;
    private ListView listView;
    private StatuesAndParksListAdapter statuesListAdapter;
    private ArrayList<StatuePark> statues = new ArrayList<>();
    private final String[] STATUES_NAMES = {"Lupa Capitolina", "Matia Corvin", " Horea, Closca and Crisan Statuary Group", "The “Carolina” Obelisk", "Glory to the Romanian Soldier"};
    private final String[] STATUES_STREETS = {"Eroilor Boulevard, pedestrian area", "Unirii Square", "1st of December 1918 Boulevard", "The Museum Square", "Avram Iancu Square"};
    private final int[] STATUES_PICTURES = {R.drawable.statue_lupa_capitolina,R.drawable.statue_matia_corvin, R.drawable.statue_horia_closca, R.drawable.statue_obelisk, R.drawable.statue_glory};

    public StatuesFragment() {
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
        for (int i = 0; i < STATUES_NAMES.length; i++) {
            StatuePark currentStatue = new StatuePark();
            currentStatue.setName(STATUES_NAMES[i]);
            currentStatue.setStreet(STATUES_STREETS[i]);
            currentStatue.setImageResId(STATUES_PICTURES[i]);
            statues.add(currentStatue);
        }
    }

    private void setAdapterOnMuseumsList() {
        statuesListAdapter = new StatuesAndParksListAdapter(getActivity(), statues);
        listView.setAdapter(statuesListAdapter);
    }
}
