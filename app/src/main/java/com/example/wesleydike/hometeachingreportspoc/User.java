package com.example.wesleydike.hometeachingreportspoc;

import java.util.List;

/**
 * Created by Wesley Dike on 6/6/2017.
 */

public class User {
    static private int id = 0;
    //These are the unseen bits of the User
    private List<Family> families;
    private String credentials;
    private String Name;
    private User companion;
    private String idNum;


    //Constructors
    User() {
        idNum = "User" + id++;
    }
    //Your non-Default constructors can home base right here <---

    //Encapsulating functions
    public void addFamily(Family newFamily) {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public void removeFamily(Family exFamily) {

    }

    public List<Family> getFamilies() {
        return families;
    }

    public Report getReport() {
        //STUBBED!!! Need to fix this with valid code
        return new Report();
    }

    public User getCompanion() {
        return companion;
    }

    public void setCompanion(User companion) {
        this.companion = companion;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }
}
