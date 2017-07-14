package com.example.wesleydike.hometeachingreportspoc;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <p>Families information Page</p>
 */
public class FamiliesActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference userRef;
    DatabaseReference familiesRef;
    String userID;

    HashMap<String, Family> familiesMap = new HashMap<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_families);
        listView = (ListView) findViewById(R.id.lvFamilies);
        userID = getSharedPreferences("HTRprefs",0).getString("userID", "TestUser");
        userRef = database.getReference().child("Users").child(userID);
        familiesRef = userRef.child("Families");
        userRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Family family = dataSnapshot.getValue(Family.class);
                familiesMap.put(family.getIdNum(), family);
                updateListView();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void updateListView() {

        FamilyListAdapter arrayAdapter = new FamilyListAdapter
                (this, R.layout.families_view, new ArrayList<Family>(familiesMap.values()));
        listView.setAdapter(arrayAdapter);

    }

    public void addFamily(View view) {
        Log.d("FamiliesAcitiviy_adfam","Adding a family to the User");
        Family temp = new Family();
        temp.setName("TestFamily");
        userRef.setValue("test");
    }
}
