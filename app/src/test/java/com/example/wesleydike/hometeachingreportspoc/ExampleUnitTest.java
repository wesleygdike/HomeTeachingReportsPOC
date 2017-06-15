package com.example.wesleydike.hometeachingreportspoc;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void keyIndicatorReturn_isCorrect() throws Exception {
        assertEquals(false, new Report().getIndicator("READ"));
    }

    @Test
    public void nullOnWardConstruction_isCorrect() throws Exception {
        assertEquals(null, new Ward().getFamilies());
    }

    @Test
    public void _isCorrect() throws Exception {
        Family family = new Family();
        Person newPerson = new Person();
        family.addMember(newPerson);
        assertEquals(newPerson, family.getMembers().get(0));
    }
}

