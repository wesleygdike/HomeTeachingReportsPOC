package com.example.wesleydike.hometeachingreportspoc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

public class TestActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    ListView listView;
    HashMap<String, User> userList = new HashMap<String, User>();
    SharedPreferences preferences;
    User user;
    //ArrayList<User> userList = new ArrayList<User>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        preferences = getSharedPreferences("HTRprefs",0);
        listView = (ListView) findViewById(R.id.lvUserIDs);
        final ListView listView = (ListView)findViewById(R.id.lvUserIDs);
        DatabaseReference usersRef = database.getReference().child("Users");
        usersRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                User user = dataSnapshot.getValue(User.class);
                userList.put(user.getIdNum(), user);
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
        user = userList.get(preferences.getString("USER", "TestUser"));
    }

    private void updateListView() {

        UserListAdapter arrayAdapter = new UserListAdapter
                (this, R.layout.families_view, new ArrayList<User>(userList.values()));
        listView.setAdapter(arrayAdapter);

    }

    /**
     * actions performed on Familiesbutton click
     * @param view
     */
    public void addUserButtonPressed(View view) {
        final Family mFamily = new Family();
        final ArrayList<Family> mFamilies = new ArrayList<>(user.getFamilies());
        DatabaseReference usersRef = database.getReference();
        //TO-DO Instead of adding a blank user we need to make it so a pop-up appears
        //and allows us to fill in as least a Name, at best it would also accept a number
        //for how many member of the familiy there will be. then one you hit OK another pop-up
        //would appear for each new member of the familiy prompting user for Name, age and
        //Birthday.
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.family_information_dialog, null);
        final EditText etFamilyName = (EditText) mView.findViewById(R.id.etFamliyName);
        final EditText etNumberOfMembers = (EditText) mView.findViewById(R.id.etNumberOfMembers);
        Button btnComplete = (Button) mView.findViewById(R.id.btnComplete);
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etFamilyName.getText() != null && etNumberOfMembers != null) {
                    mFamily.setName(etFamilyName.getText().toString());
                    for (int i = 0;
                         i < Integer.getInteger(etNumberOfMembers.getText().toString());
                         i++) {
                        final AlertDialog.Builder mPersonBuilder = new AlertDialog.Builder(TestActivity.this);
                        View mPersonView = getLayoutInflater().inflate(R.layout.family_information_dialog, null);
                        final EditText etPersonName = (EditText) mPersonView.findViewById(R.id.etPersonName);
                        final EditText etPersonAge = (EditText) mPersonView.findViewById(R.id.etPersonAge);
                        final EditText etPersonBirthday = (EditText) mPersonView.findViewById(R.id.etPersonBirthday);
                        Button btnPersonComplete = (Button) mPersonView.findViewById(R.id.btnPersonComplete);
                        btnPersonComplete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (etPersonName.getText() != null
                                        && etPersonAge.getText() != null
                                        && etPersonBirthday != null) {
                                    Person mCurrentPerson = new Person();
                                    mCurrentPerson.setName(etPersonName.getText().toString());
                                    mCurrentPerson.setAge(Integer.getInteger(etPersonAge.getText().toString()));
                                    mCurrentPerson.setBirthDate(etPersonBirthday.getText().toString());
                                    mFamily.addMember(mCurrentPerson);
                                } else {
                                    //make Toast propting for input
                                }
                            }
                        });
                        mPersonBuilder.setView(R.layout.person_information_dialog);
                        AlertDialog personDialog = mPersonBuilder.create();
                        personDialog.show();
                    }
                } else {
                    //make Toast propting for input
                }
            }

        });
        user.addFamily(mFamily);
        mBuilder.setView(R.layout.family_information_dialog);
        AlertDialog familyDialog = mBuilder.create();
        familyDialog.show();
        usersRef.child("Users").child(user.getIdNum()).setValue(user);
    }

    /**
     * acctions performed on Familiesbutton click
     * @param view
     */
    public void testDialog (View view) {

    }

    /**
     * acctions performed on Familiesbutton click
     * @param view
     */
    public void addFamilyButtonPressed(View view) {
        final Family mFamily = new Family();
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.family_information_dialog, null);
        final EditText etFamilyName = (EditText) mView.findViewById(R.id.etFamliyName);
        final EditText etNumberOfMembers = (EditText) mView.findViewById(R.id.etNumberOfMembers);
        Button btnComplete = (Button) mView.findViewById(R.id.btnComplete);
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etFamilyName.getText() != null && etNumberOfMembers != null) {
                    mFamily.setName(etFamilyName.getText().toString());
                    for (int i = 0;
                         i < Integer.getInteger(etNumberOfMembers.getText().toString());
                         i++) {
                        final AlertDialog.Builder mPersonBuilder = new AlertDialog.Builder(TestActivity.this);
                        View mPersonView = getLayoutInflater().inflate(R.layout.family_information_dialog, null);
                        final EditText etPersonName = (EditText) mPersonView.findViewById(R.id.etPersonName);
                        final EditText etPersonAge = (EditText) mPersonView.findViewById(R.id.etPersonAge);
                        final EditText etPersonBirthday = (EditText) mPersonView.findViewById(R.id.etPersonBirthday);
                        Button btnPersonComplete = (Button) mPersonView.findViewById(R.id.btnPersonComplete);
                        btnPersonComplete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (etPersonName.getText() != null
                                        && etPersonAge.getText() != null
                                        && etPersonBirthday != null) {
                                    Person mCurrentPerson = new Person();
                                    mCurrentPerson.setName(etPersonName.getText().toString());
                                    mCurrentPerson.setAge(Integer.getInteger(etPersonAge.getText().toString()));
                                    mCurrentPerson.setBirthDate(etPersonBirthday.getText().toString());
                                    mFamily.addMember(mCurrentPerson);
                                } else {
                                    //make Toast propting for input
                                }
                            }
                        });
                        mPersonBuilder.setView(R.layout.person_information_dialog);
                        AlertDialog personDialog = mPersonBuilder.create();
                        personDialog.show();
                    }
                } else {
                    //make Toast propting for input
                }
            }

        });
        user.addFamily(mFamily);
        mBuilder.setView(R.layout.family_information_dialog);
        AlertDialog familyDialog = mBuilder.create();
        familyDialog.show();
    }
}

