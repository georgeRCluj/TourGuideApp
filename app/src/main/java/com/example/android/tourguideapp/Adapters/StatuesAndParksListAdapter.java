package com.example.android.tourguideapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideapp.Models.StatuePark;
import com.example.android.tourguideapp.R;

import java.util.List;

import static android.view.View.GONE;

public class StatuesAndParksListAdapter extends ArrayAdapter<StatuePark> {
    private TextView statueNameView;
    private TextView statuePhoneView;
    private TextView statueStreetView;
    private TextView statueWebsiteView;
    private ImageView statueImage;
    private View listItemView;
    private StatuePark currentStatue;
    private Context mContext;

    public StatuesAndParksListAdapter(Context context, List<StatuePark> objects) {
        super(context, 0, objects);
        mContext = context;
        // 0 in the middle stands for the resource ID [for a layout file containing a TextView to use when instantiating views].
        // since we use a custom view, not just a textView, then it will be 0
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflateList(position, convertView, parent);
        initializeUiComponents();
        setTextsAndImagesOnVariables();
        return listItemView;
    }

    private void initializeUiComponents() {
        statueNameView = (TextView) listItemView.findViewById(R.id.nameId);
        statuePhoneView = (TextView) listItemView.findViewById(R.id.phoneId);
        statuePhoneView.setVisibility(GONE);
        statueStreetView = (TextView) listItemView.findViewById(R.id.emailId);
        statueWebsiteView = (TextView) listItemView.findViewById(R.id.websiteId);
        statueWebsiteView.setVisibility(GONE);
        statueImage = (ImageView) listItemView.findViewById(R.id.imageResId);
        statueImage.setVisibility(View.VISIBLE);
    }

    private void inflateList(int position,  View convertView, ViewGroup parent) {
        currentStatue = getItem(position);
        // Check if the existing view is being reused, otherwise inflate the view
        listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
    }

    private void setTextsAndImagesOnVariables(){
        statueNameView.setText(currentStatue.getName());
        statueStreetView.setText(currentStatue.getStreet());
        statueImage.setImageDrawable(ContextCompat.getDrawable(mContext, currentStatue.getImageResId()));
    }
}
