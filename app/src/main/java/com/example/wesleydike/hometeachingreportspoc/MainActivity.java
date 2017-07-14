package com.example.wesleydike.hometeachingreportspoc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    public final String HTR_PREFS = "HTRprefs";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    Button familiesButton;
    TextView testText;
    DatabaseReference ref;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        familiesButton = (Button)findViewById(R.id.familiesButton);
        EditText userIDInput = (EditText) findViewById(R.id.editText);
        String userID = userIDInput.getText().toString();
        ref = database.getReference().child("USERS").child(userID);
    }

    /**
     * acctions performed on Familiesbutton click
     * @param view
     */
    public void familiesButtonPressed(View view) {
        SharedPreferences preferences = getSharedPreferences(HTR_PREFS, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userID", userID);
        Intent intent = new Intent(this, FamiliesActivity.class);
        startActivity(intent);
    }

    /**
     * actions preformed on Roportsbutton click
     * @param view
     */
    public void reportsButtonPressed(View view) {
        SharedPreferences preferences = getSharedPreferences(HTR_PREFS, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userID", userID);
        Intent intent = new Intent(this, ReportsActivity.class);
        startActivity(intent);
    }

    /**
     * actions preformed on Roportsbutton click
     * @param view
     */
    public void TestButtonPressed(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }
}
