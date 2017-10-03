package com.dieblich.handball.materials;

import com.dieblich.handball.terms.FirstName;
import com.dieblich.handball.terms.LastName;

import java.util.Objects;

class Person {

    private final FirstName firstName;
    private final LastName lastName;

    Person(FirstName firstName, LastName lastName) {
        Objects.requireNonNull(firstName, "firstName darf nicht null sein");
        Objects.requireNonNull(lastName, "lastName darf nicht null sein");
        this.firstName = firstName;
        this.lastName = lastName;
    }

    FirstName getFirstName() {
        return firstName;
    }

    LastName getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
