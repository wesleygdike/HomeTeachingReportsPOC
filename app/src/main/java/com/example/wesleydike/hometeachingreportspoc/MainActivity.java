package com.example.wesleydike.hometeachingreportspoc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    Button familiesButton;
    TextView testText;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        familiesButton = (Button)findViewById(R.id.familiesButton);
        testText = (TextView) findViewById(R.id.textView);
        ref = database.getReference("TestUser");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //this is called on intial value and when data is changed
                User user = dataSnapshot.getValue(User.class);
                testText.setText("64%");
                SharedPreferences prefs = getPreferences(0);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("USER", "TestUser");
                //add log
                Log.d("MainAcitiviy_Listener","Test on data change");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //failed to read value
                //add log
            }
        });

    }



    /**
     * acctions performed on Familiesbutton click
     * @param view
     */
    public void familiesButtonPressed(View view) {
        Intent intent = new Intent(this, FamiliesActivity.class);
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
}
