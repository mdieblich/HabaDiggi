package com.dieblich.handball.materials;

import com.dieblich.handball.terms.FirstName;
import com.dieblich.handball.terms.LastName;

class Person {

    private FirstName firstName;
    private LastName lastName;

    Person(FirstName firstName, LastName lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    FirstName getFirstName() {
        return firstName;
    }

    LastName getLastName() {
        return lastName;
    }
}
