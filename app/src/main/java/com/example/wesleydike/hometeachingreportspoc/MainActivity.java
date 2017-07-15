package com.example.wesleydike.hometeachingreportspoc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * <p>Landing page of the Application</p>
 */
public class MainActivity extends AppCompatActivity {
    public static final String USERID = "userID";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    Button familiesButton;
    TextView testText;
    EditText userIDInput;
    DatabaseReference userRef;
    String userID;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        familiesButton = (Button)findViewById(R.id.familiesButton);
        userIDInput = (EditText) findViewById(R.id.editText);
        userID = userIDInput.getText().toString();
        Log.i("MainAcitiviy","UserID Value:" + userID);
        userRef = database.getReference().child("Users").child(userID);
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
                Log.i("MainAcitiviy","UserID Value toString:" + dataSnapshot.getValue(User.class).toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * acctions performed on Familiesbutton click
     *
     */
    public void updateUserBtnPressed () {
    }

    /**
     * acctions performed on Familiesbutton click
     * @param view
     */
    public void familiesButtonPressed(View view) {
        updateUserBtnPressed();
                Intent intent = new Intent(this, FamilyAdderActivity.class);
                intent.putExtra(USERID, userID);
                startActivity(intent);
    }

    /**
     * actions preformed on Roportsbutton click
     * @param view
     */
    public void reportsButtonPressed(View view) {

        Intent intent = new Intent(this, ReportsActivity.class);
        startActivity(intent);
    }

    /**
     * actions preformed on Roportsbutton click
     * @param view
     */
    public void TestButtonPressed(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        intent.putExtra(USERID, userID);
        startActivity(intent);
    }
}
