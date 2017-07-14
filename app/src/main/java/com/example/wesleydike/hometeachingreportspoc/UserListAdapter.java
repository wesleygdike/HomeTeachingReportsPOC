package com.example.wesleydike.hometeachingreportspoc;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Wesley Dike on 7/14/2017.
 */

public class UserListAdapter extends ArrayAdapter<User> {
    Context context;
    int resource;

    public UserListAdapter(
            @NonNull Context context,
            @LayoutRes int resource,
            @NonNull ArrayList<User> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resource, parent, false);

        TextView textView = (TextView) convertView.findViewById(R.id.nameTextView);

        User currentUser = getItem(position);
        if(currentUser.getIdNum() != null) {
            textView.setText(currentUser.getIdNum());
        } else {
            textView.setText("Null Pointer!");
        }
        return convertView;
    }
}

