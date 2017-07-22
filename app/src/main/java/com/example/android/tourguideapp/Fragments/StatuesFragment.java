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
    private String[] statues_names, statues_streets;
    private final int[] STATUES_PICTURES = {R.drawable.statue_lupa_capitolina,R.drawable.statue_matia_corvin, R.drawable.statue_horia_closca, R.drawable.statue_obelisk, R.drawable.statue_glory};

    public StatuesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initializeUiComponents(inflater, container);
        initializeStatuesList();
        setAdapterOnStatuesList();
        return fragment_view;
    }

    private void initializeUiComponents(LayoutInflater inflater, ViewGroup container) {
        fragment_view = inflater.inflate(R.layout.fragment_view, container, false);
        listView = (ListView) fragment_view.findViewById(R.id.baseList);
    }

    private void initializeStatuesList() {
        statues_names = getActivity().getResources().getStringArray(R.array.statue_names);
        statues_streets = getActivity().getResources().getStringArray(R.array.statue_streets);
        statues.clear();
        for (int i = 0; i < statues_names.length; i++) {
            StatuePark currentStatue = new StatuePark();
            currentStatue.setName(statues_names[i]);
            currentStatue.setStreet(statues_streets[i]);
            currentStatue.setImageResId(STATUES_PICTURES[i]);
            statues.add(currentStatue);
        }
    }

    private void setAdapterOnStatuesList() {
        statuesListAdapter = new StatuesAndParksListAdapter(getActivity(), statues);
        listView.setAdapter(statuesListAdapter);
    }
}
