package com.example.wesleydike.hometeachingreportspoc;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

/**
 * Created by Wesley Dike on 7/12/2017.
 */

public class FamilyListAdapter extends ArrayAdapter<Family> {

    public FamilyListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }
}
