package com.example.android.tourguideapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.tourguideapp.Models.Museum;
import com.example.android.tourguideapp.R;

import java.util.List;

public class MuseumsListAdapter extends ArrayAdapter<Museum> {
    private TextView museumNameView;
    private TextView museumPhoneView;
    private TextView museumEmailView;
    private TextView museumWebsiteView;
    private View listItemView;
    private Museum currentMuseum;

    public MuseumsListAdapter(Context context, List<Museum> objects) {
        super(context, 0, objects);
        // 0 in the middle stands for the resource ID [for a layout file containing a TextView to use when instantiating views].
        // since we use a custom view, not just a textView, then it will be 0
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
        museumNameView = (TextView) listItemView.findViewById(R.id.nameId);
        museumPhoneView = (TextView) listItemView.findViewById(R.id.phoneId);
        museumEmailView = (TextView) listItemView.findViewById(R.id.emailId);
        museumWebsiteView = (TextView) listItemView.findViewById(R.id.websiteId);
    }

    private void inflateList(int position,  View convertView, ViewGroup parent) {
        currentMuseum = getItem(position);
        // Check if the existing view is being reused, otherwise inflate the view
        listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
    }

    private void setTextsOnVariables(){
        museumNameView.setText(currentMuseum.getName());
        museumPhoneView.setText(currentMuseum.getPhone());
        museumEmailView.setText(currentMuseum.getEmail());
        museumWebsiteView.setText(currentMuseum.getWebsite());
    }
}
