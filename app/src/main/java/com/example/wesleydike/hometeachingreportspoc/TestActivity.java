package com.example.wesleydike.hometeachingreportspoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class TestActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


    }

    /**
     * acctions performed on Familiesbutton click
     * @param view
     */
    public void addUserButtonPressed(View view) {
        DatabaseReference usersRef = database.getReference().child("Users");
        usersRef.setValue(new User());
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
