package com.example.wesleydike.hometeachingreportspoc;

import java.util.List;

/**
 * Created by Wesley Dike on 6/6/2017.
 * <p>Data object representing a family</p>
 */

public class Family {
    //Private information of which is in regard to the designated family
    private List<Person> members;
    private List<Report> reports;
    private String idNum;


    //Constructors
    Family() {

    }
    //Your non-Default constructors can home base right here <---

    //Encapsulating functions
    /**Returns Familiy members as a list of Persons*/
    public List<Person> getMembers () {
        return members;
    }
    /**Adds a new Person object to members list*/
    public void addMember(Person newMember) {
        members.add(newMember);
    }
    /**Removes the passed member if found from the members list*/
    public void removeMember (Person exMember) {

    }
    /**Returns a list of this familys Report objects*/
    public List<Report> getReports() {
        return reports;
    }
    /**Adds a report to reports*/
    public void addReport(Report newReport) {

    }
    /**Removes the passed Report if found from the reports list*/
    public  void removeReport(Report exReport) {

    }
 }
