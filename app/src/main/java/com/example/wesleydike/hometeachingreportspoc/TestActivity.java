package com.example.wesleydike.hometeachingreportspoc;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

public class TestActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    HashMap<String, User> userList = new HashMap<String, User>();
    //ArrayList<User> userList = new ArrayList<User>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        final ListView listView = (ListView)findViewById(R.id.listView);

        DatabaseReference usersRef = database.getReference().child("Users");
        usersRef.child("User").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                User user = (User)dataSnapshot.getValue();
                userList.put(user.getIdNum(), user);
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

        ArrayAdapter<User> arrayAdapter = new ArrayAdapter<User>
                (this, android.R.layout.simple_list_item_1, (ArrayList<User>)userList.values());
    }

    /**
     * actions performed on Familiesbutton click
     * @param view
     */
    public void addUserButtonPressed(View view) {
        DatabaseReference usersRef = database.getReference().child("Users");
        User user = new User();
        usersRef.child("Users").child(user.getIdNum()).setValue(user);
    }
    /**
     * acctions performed on Familiesbutton click
     * @param view
     */
    public void addFamilyButtonPressed(View view) {
        Intent intent = new Intent(this, FamiliesActivity.class);
        startActivity(intent);
    }
}

