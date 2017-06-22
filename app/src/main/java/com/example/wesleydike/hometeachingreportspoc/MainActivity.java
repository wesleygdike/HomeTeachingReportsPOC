package com.example.wesleydike.hometeachingreportspoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button familiesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        familiesButton = (Button)findViewById(R.id.familiesButton);

        //test Jefferson
        //test Spencer
        //test conflict!!
        //test conflict!!Jefferson
        //Merge Jefferson!
        //Merge Me!
    }

    public void familiesButtonPressed() {
        Person temp = new  Person();
    }
}
