package com.example.wesleydike.hometeachingreportspoc;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * <p>Families information Page</p>
 */
public class FamiliesActivity extends AppCompatActivity {
    FirebaseDatabase data;
    DatabaseReference userRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_families);
        final ListView listView = (ListView) findViewById(R.id.listView);
        SharedPreferences prefs = getPreferences(0);
        String userId = prefs.getString("USER", "TestUser");
        data = FirebaseDatabase.getInstance();
        userRef = data.getReference(userId);
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("FamiliesAcitiviy_Lstnr","Test on Families data change.");

                User user = dataSnapshot.getValue(User.class);
                if (user.getFamilies() != null) {
                    listView.setAdapter(
                            new ArrayAdapter<Family>(getBaseContext(),
                                    R.layout.families_view,
                                    R.id.textView,
                                    user.getFamilies()
                            ));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("FamiliesAcitiviy_Error","Test on Families data change Failed!");

            }
        });
    }

    private void populateListview() {

    }

    public void addFamily(View view) {
        Log.d("FamiliesAcitiviy_adfam","Adding a family to the User");
        Family temp = new Family();
        temp.setName("TestFamily");
        userRef.setValue("test");
    }
}
