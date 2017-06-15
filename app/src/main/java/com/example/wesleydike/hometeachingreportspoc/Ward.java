package com.example.wesleydike.hometeachingreportspoc;

import java.util.List;

/**
 * Created by Wesley Dike on 6/6/2017.
 */

public class Ward {
    //The under-the-hood of the ward
    private String name;
    private List<Family> families;
    private List<User> homeTeachers;

    //Constructors
        //Your non-Default constructors can home base right here <---

    //Encapsulating functions
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void addFamily(Family newFamily) {

    }

    public void removeFamily(Family exFamily) {

    }

    public List<Family> getFamilies() {

        return families;
    }

    public void addHomeTeacher(User newUser) {

    }

    public void removeHomeTeacher(User exUser) {

    }

    public List<User> getHomeTeachers() {

        return homeTeachers;
    }
}
