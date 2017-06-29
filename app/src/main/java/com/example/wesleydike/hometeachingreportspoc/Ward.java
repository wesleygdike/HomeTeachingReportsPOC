package com.example.wesleydike.hometeachingreportspoc;

import java.util.List;

/**
 * Created by Wesley Dike on 6/6/2017.
 * <p>Represents the Ward Data class</p>
 */

public class Ward {
    //The under-the-hood of the ward
    private String name;
    private List<Family> families;
    private List<User> homeTeachers;
    private String idNum;


    //Constructors
        //Your non-Default constructors can home base right here <---

    //Encapsulating functions
    /**Sets the Ward name*/
    public void setName(String name) {
        this.name = name;
    }
    /**Returns the Ward name as a String*/
    public String getName() {

        return name;
    }
    /**Adds the passed Family object to the families List*/
    public void addFamily(Family newFamily) {

    }
    /**Removes the passed family from the families List*/
    public void removeFamily(Family exFamily) {

    }
    /**Returns the families List*/
    public List<Family> getFamilies() {

        return families;
    }
    /**Adds the passed User to the homeTeachers List*/
    public void addHomeTeacher(User newUser) {

    }
    /**Removes the passed User from the homeTeachers List*/
    public void removeHomeTeacher(User exUser) {

    }
    /**Returns the homeTeachers List*/
    public List<User> getHomeTeachers() {

        return homeTeachers;
    }
}
