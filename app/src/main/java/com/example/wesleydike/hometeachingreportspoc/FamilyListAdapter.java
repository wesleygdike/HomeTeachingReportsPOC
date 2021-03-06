package com.example.wesleydike.hometeachingreportspoc;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wesley Dike on 7/12/2017.
 */

public class FamilyListAdapter extends ArrayAdapter<Family> {
    Context context;
    int resource;

    public FamilyListAdapter(
            @NonNull Context context,
            @LayoutRes int resource,
            @NonNull ArrayList<Family> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resource, parent, false);

        TextView textView = (TextView) convertView.findViewById(R.id.nameTextView);

        Family currentFamily = getItem(position);
        if(currentFamily.getIdNum() != null) {
            textView.setText(currentFamily.getIdNum());
        } else {
            textView.setText("Null Pointer!");
        }
        return convertView;
    }
}
