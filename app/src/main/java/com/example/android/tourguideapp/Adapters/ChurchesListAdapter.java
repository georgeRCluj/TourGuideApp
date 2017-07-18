package com.example.android.tourguideapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.tourguideapp.Models.Church;
import com.example.android.tourguideapp.R;

import java.util.List;

public class ChurchesListAdapter extends ArrayAdapter<Church> {
    private TextView churchNameView;
    private TextView churchPhoneView;
    private TextView churchStreetView;
    private TextView churchWebsiteView;
    private View listItemView;
    private Church currentChurch;

    public ChurchesListAdapter(Context context, List<Church> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflateList(position, convertView, parent);
        initializeUiComponents();
        setTextsOnVariables();
        return listItemView;
    }

    private void initializeUiComponents() {
        churchNameView = (TextView) listItemView.findViewById(R.id.nameId);
        churchPhoneView = (TextView) listItemView.findViewById(R.id.phoneId);
        churchStreetView = (TextView) listItemView.findViewById(R.id.emailId);
        churchWebsiteView = (TextView) listItemView.findViewById(R.id.websiteId);
        churchWebsiteView.setVisibility(View.GONE);
    }

    private void inflateList(int position,  View convertView, ViewGroup parent) {
        currentChurch = getItem(position);
        // Check if the existing view is being reused, otherwise inflate the view
        listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
    }

    private void setTextsOnVariables(){
        churchNameView.setText(currentChurch.getName());
        churchPhoneView.setText(currentChurch.getPhone());
        churchStreetView.setText(currentChurch.getStreet());
    }
}
