package com.example.wesleydike.hometeachingreportspoc;

import java.util.Date;

/**
 * Created by Wesley Dike on 6/6/2017.
 */

public class Person {
    //Private Personal informations
    private String name;
    private int age;
    private Date birthDate;

    //Constructors
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
