package com.example.wesleydike.hometeachingreportspoc;

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
        ref = database.getReference("test");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //this is called on intial value and when data is changed
                String value = dataSnapshot.getValue(String.class);
                testText.setText(value);
                //add log
                Log.d("MainAcitiviy_Listener","Test on data change");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //failed to read value
                //add log
            }
        });
        //test Jefferson
        //test Spencer
        //test conflict!!
        //test conflict!!Jefferson
        //Merge Jefferson!
        //Merge Me!
    }

    public void familiesButtonPressed(View view) {

        if(ref.toString() == "hello world") {
            ref.setValue("toggled");
        } else {
            ref.setValue("hello world");
        }
    }
}
