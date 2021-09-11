package com.example.quakereport;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public  class earthAdapter extends ArrayAdapter<earthword> {


    public earthAdapter(MainActivity contest, ArrayList<earthword> earthquakes) {
        super(contest,0, earthquakes);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        earthword currentword = getItem(position);

        TextView nameTextView1 = (TextView) listItemView.findViewById(R.id.magnitude);
        GradientDrawable magnitudeCircle = (GradientDrawable) nameTextView1.getBackground();
        int magnitudeColor = getMagnitudeColor(currentword.getMmagtitude());
       // int magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
        magnitudeCircle.setColor(magnitudeColor);
        String formated = formatMagnitude(currentword.getMmagtitude());
        nameTextView1.setText(formated);

        TextView numberTextView2 = (TextView) listItemView.findViewById(R.id.textView2);
        numberTextView2.setText(currentword.getMplace());

        TextView numberTextView3 = (TextView) listItemView.findViewById(R.id.textView3);
        numberTextView3.setText(currentword.getMtime());

        return listItemView;
    }

    private int getMagnitudeColor(double mmagtitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(mmagtitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    private String formatMagnitude(double mmagtitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(mmagtitude);
    }


}
