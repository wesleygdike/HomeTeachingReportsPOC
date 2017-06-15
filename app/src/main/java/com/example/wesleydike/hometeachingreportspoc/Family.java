package com.example.wesleydike.hometeachingreportspoc;

import java.util.List;

/**
 * Created by Wesley Dike on 6/6/2017.
 */

public class Family {
    //Private information of which is in regard to the designated family
    private List<Person> members;
    private List<Report> reports;

    //Constructors
    //Your non-Default constructors can home base right here <---

    //Encapsulating functions
    public List<Person> getMembers () {
        return members;
    }

    public void addMember(Person newMember) {
        members.add(newMember);
    }

    public void removeMember (Person exMember) {

    }

    public List<Report> getReports() {
        return reports;
    }

    public void addReport(Report newReport) {

    }

    public  void removeReport(Report exReport) {

    }
 }
