package com.example.wesleydike.hometeachingreportspoc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    String userID;
    User user;

    //Family Dialog Variables
    Family mFamily;
    AlertDialog.Builder mBuilder;
    View mView;
    EditText etFamilyName;
    EditText etNumberOfMembers;
    Button btnComplete;
    //Person Dialog Variables
    AlertDialog.Builder mPersonBuilder;
    View mPersonView;
    EditText etPersonName;
    EditText etPersonAge;
    EditText etPersonBirthday;
    Button btnPersonComplete;
    //ArrayList<User> userList = new ArrayList<User>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        userID = getIntent().getStringExtra(MainActivity.USERID);
        listView = (ListView) findViewById(R.id.lvUserIDs);
        final ListView listView = (ListView) findViewById(R.id.lvUserIDs);
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
        Log.i("TestAcitiviy_SetUser", "Preferences USER String value is: " + userID);
        user = userList.get(userID);
        Log.i("TestAcitiviy_CurUser", "User value set to: ");
    }

    private void updateListView() {

        UserListAdapter arrayAdapter = new UserListAdapter
                (this, R.layout.families_view, new ArrayList<User>(userList.values()));
        listView.setAdapter(arrayAdapter);

    }

    /**
     * actions performed on Familiesbutton click
     *
     * @param view
     */
    public void addUserButtonPressed(View view) {
        User newUser = new User();
        user = newUser;
        DatabaseReference usersRef = database.getReference().child("Users");
        usersRef.child(newUser.getIdNum()).setValue(newUser);
    }

    /**
     * acctions performed on Familiesbutton click
     *
     * @param view
     */
    public void testDialog(View view) {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.family_information_dialog, null);
        mBuilder.setView(R.layout.family_information_dialog);
        AlertDialog familyDialog = mBuilder.create();
        familyDialog.show();
    }

    /**
     * acctions performed on Familiesbutton click
     *
     * @param view
     */
    public void addFamilyButtonPressed(View view) {
        Log.i("TestAcitiviy_adfam", "Addfamily btn Pressed");
        mFamily = new Family();
        mBuilder = new AlertDialog.Builder(this);
        mView = getLayoutInflater().inflate(R.layout.family_information_dialog, null);
        etFamilyName = (EditText) mView.findViewById(R.id.etFamliyName);
        etNumberOfMembers = (EditText) mView.findViewById(R.id.etNumberOfMembers);
        btnComplete = (Button) mView.findViewById(R.id.btnComplete);
        user.addFamily(mFamily);
        Log.i("TestAcitiviy_adFam", "Family creation/addition complete");
        mBuilder.setView(R.layout.family_information_dialog);
        AlertDialog familyDialog = mBuilder.create();
        familyDialog.show();
        Log.i("TestAcitiviy_adFam", "Family Dialog creation complete");
    }

    /**
     * acctions performed on Familiesbutton click
     *
     * @param view
     */
    public void familyCompleteBtnPressed(View view) {
        Log.i("TestAcitiviy_adfam", "Family Complete btn Pressed");
        if (etFamilyName.getText() != null && etNumberOfMembers != null) {
            mFamily.setName(etFamilyName.getText().toString());
            for (int i = 0;
                 i < Integer.getInteger(etNumberOfMembers.getText().toString());
                 i++) {
                Log.i("TestAcitiviy_adPer", "Add Person Loop iteration: " + i);
                mPersonBuilder = new AlertDialog.Builder(TestActivity.this);
                mPersonView = getLayoutInflater().inflate(R.layout.family_information_dialog, null);
                etPersonName = (EditText) mPersonView.findViewById(R.id.etPersonName);
                etPersonAge = (EditText) mPersonView.findViewById(R.id.etPersonAge);
                etPersonBirthday = (EditText) mPersonView.findViewById(R.id.etPersonBirthday);
                btnPersonComplete = (Button) mPersonView.findViewById(R.id.btnPersonComplete);
                mPersonBuilder.setView(R.layout.person_information_dialog);
                AlertDialog personDialog = mPersonBuilder.create();
                personDialog.show();
                Log.i("TestAcitiviy_adPer", "Person Dialog creation complete");
            }
        } else {
            Log.i("TestAcitiviy_adFam", "Family Info fields not populated");
            //make Toast propting for input
        }
    }

    /**
     * acctions performed on Familiesbutton click
     *
     * @param view
     */
    public void personCompleteBtnPressed(View view) {

        etPersonName = (EditText) mPersonView.findViewById(R.id.etPersonName);
        etPersonAge = (EditText) mPersonView.findViewById(R.id.etPersonAge);
        etPersonBirthday = (EditText) mPersonView.findViewById(R.id.etPersonBirthday);
        btnPersonComplete = (Button) mPersonView.findViewById(R.id.btnPersonComplete);
        Log.i("TestAcitiviy_adPer", "Person Complete btn Pressed");
        if (etPersonName.getText() != null
                && etPersonAge.getText() != null
                && etPersonBirthday != null) {
            Person mCurrentPerson = new Person();
            mCurrentPerson.setName(etPersonName.getText().toString());
            mCurrentPerson.setAge(Integer.getInteger(etPersonAge.getText().toString()));
            mCurrentPerson.setBirthDate(etPersonBirthday.getText().toString());
            mFamily.addMember(mCurrentPerson);
            Log.i("TestAcitiviy_adPer", "Person creation/addition complete");
        } else {
            Log.i("TestAcitiviy_adPer", "Person Info fields not populated");
            //make Toast propting for input
        }
    }
}