package com.example.wesleydike.hometeachingreportspoc;

import android.util.Log;

import java.util.Date;

/**
 * Created by Wesley Dike on 6/6/2017.
 */

public class Person {
    static int ID_COUNT;
    private String idNum;
    //Private Personal informations
    private String name = "Enter Name";
    private int age = 0;
    private Date birthDate;

    //Constructors
    Person() {
        //load default person information
        //Log information
        idNum = name + ID_COUNT++;
        Log.i("Person ID: " + idNum, "New Person: " + idNum + "created successfully.");
    }
    //Your non-Default constructors can home base right here <---

    //Encapsulating functions
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


}
