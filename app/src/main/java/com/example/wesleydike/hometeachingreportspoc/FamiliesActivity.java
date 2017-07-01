package com.example.wesleydike.hometeachingreportspoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * <p>Families information Page</p>
 */
public class FamiliesActivity extends AppCompatActivity {
    FirebaseDatabase data;
    DatabaseReference families;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_families);
        data = FirebaseDatabase.getInstance();
        families = data.getReference("families");
        families.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                populateListview();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void populateListview() {

    }

    public void addFamily(View view) {
        Family temp = new Family();
        families.child(temp.getIdNum()).setValue(temp);
    }
}
