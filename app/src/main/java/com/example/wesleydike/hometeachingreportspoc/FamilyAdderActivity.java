package com.example.wesleydike.hometeachingreportspoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FamilyAdderActivity extends AppCompatActivity {

    User user;
    String userID;
    EditText etFamilyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_adder);

        EditText etFamilyName = (EditText) findViewById(R.id.etAdderFamilyName);

        userID = getIntent().getStringExtra(MainActivity.USERID);
        Log.i("TestAcitiviy_SetUser", "USER String value is: " + userID);
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users").child(userID);
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    /**
     * actions performed on Familiesbutton click
     *
     * @param view
     */
    public void addFamilyBtnPressed (View view) {
        Family mFamily = new Family();
        mFamily.setName(etFamilyName.getText().toString());
        user.addFamily(mFamily);
        Intent intent = new Intent(this, FamiliesActivity.class);
        intent.putExtra(MainActivity.USERID, userID);
        startActivity(intent);
    }
}
