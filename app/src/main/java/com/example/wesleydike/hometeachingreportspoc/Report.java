package com.example.wesleydike.hometeachingreportspoc;

import java.util.Map;

/**
 * Created by Wesley Dike on 6/6/2017.
 */

public class Report {
    //Private data of the report
    private int year;
    private int month;
    private Map keyIndicators;
    private Family family;
    private String idNum;


    //Constructors
    //Your non-Default constructors can home base right here <---

    //Encapsulating functions
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public boolean getIndicator(String mapkey) {
        return false;
    }

    public void setIndicator(String mapkey, Boolean value) {

    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
