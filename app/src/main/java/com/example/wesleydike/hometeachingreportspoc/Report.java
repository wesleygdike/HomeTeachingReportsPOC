package com.example.wesleydike.hometeachingreportspoc;

import java.util.Map;

/**
 * Created by Wesley Dike on 6/6/2017.
 * <p>Represents a report data class</p>
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
    /**Returns the year of the Report as int*/
    public int getYear() {
        return year;
    }
    /**Sets the year of the Report*/
    public void setYear(int year) {
        this.year = year;
    }
    /**Returns the month of the Report as int*/
    public int getMonth() {
        return month;
    }
    /**Sets the month of the Report*/
    public void setMonth(int month) {
        this.month = month;
    }
    /**Returns the selected indicator of the Report as intended value*/
    public boolean getIndicator(String mapkey) {
        return false;
    }
    /**Sets the selected indicator of the Report*/
    public void setIndicator(String mapkey, Boolean value) {

    }
    /**Returns the family of the Report as a Family object*/
    public Family getFamily() {
        return family;
    }
    /**Sets the family of the Report*/
    public void setFamily(Family family) {
        this.family = family;
    }
}
