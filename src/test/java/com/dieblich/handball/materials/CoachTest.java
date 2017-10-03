package com.dieblich.handball.materials;

import com.dieblich.handball.terms.FirstName;
import com.dieblich.handball.terms.LastName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoachTest {

    @Test
    void isAPerson() {
        assertTrue(Person.class.isAssignableFrom(Coach.class));
    }

    @Test
    void hasAFirstName() {
        FirstName juergen = new FirstName("Jürgen");
        Coach juergenOtt = new Coach(juergen, new LastName("Ott"));
        assertEquals(juergen, juergenOtt.getFirstName());
    }

    @Test
    void hasALastName() {
        LastName ott = new LastName("Ott");
        Coach juergenOtt = new Coach(new FirstName("Jürgen"), ott);
        assertEquals(ott, juergenOtt.getLastName());
    }
}
