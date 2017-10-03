package com.dieblich.handball.materials;

import com.dieblich.handball.terms.BirthDate;
import com.dieblich.handball.terms.FirstName;
import com.dieblich.handball.terms.LastName;
import com.dieblich.handball.terms.PlayerNumber;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    @Test
    void isAPerson() {
        assertTrue(Person.class.isAssignableFrom(Coach.class));
    }

    @Test
    void hasAFirstName() {
        FirstName martin = new FirstName("Martin");
        Player martinDieblich = new Player(martin, new LastName("Dieblich"));
        assertEquals(martin, martinDieblich.getFirstName());
    }

    @Test
    void hasALastName() {
        LastName dieblich = new LastName("Dieblich");
        Player martinDieblich = new Player(new FirstName("Martin"), dieblich);
        assertEquals(dieblich, martinDieblich.getLastName());
    }

    @Test
    void hasAPlayerNumber() {
        Player martinDieblich = new Player(new FirstName("Martin"), new LastName("Dieblich"));
        PlayerNumber sixteen = new PlayerNumber(16);
        martinDieblich.setPlayerNumber(sixteen);
        assertEquals(sixteen, martinDieblich.getPlayerNumber());
    }

    @Test
    void hasABirthDate() {
        Player martinDieblich = new Player(new FirstName("Martin"), new LastName("Dieblich"));
        BirthDate birthDate = new BirthDate(LocalDate.of(1988, 3, 8));
        martinDieblich.setBirthDate(birthDate);
        assertEquals(birthDate, martinDieblich.getBirthDate());
    }

    @Test
    void hasAPlayerLicense() {
        Player martinDieblich = new Player(new FirstName("Martin"), new LastName("Dieblich"));
        PlayerLicense license = new PlayerLicense(543210);
        martinDieblich.setPlayerLicense(license);
        assertEquals(license, martinDieblich.getPlayerLicense());
    }

}
