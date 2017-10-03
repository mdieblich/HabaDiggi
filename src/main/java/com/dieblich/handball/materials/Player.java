package com.dieblich.handball.materials;

import com.dieblich.handball.terms.BirthDate;
import com.dieblich.handball.terms.FirstName;
import com.dieblich.handball.terms.LastName;
import com.dieblich.handball.terms.PlayerNumber;

class Player extends Person {

    private BirthDate birthDate;
    private PlayerNumber playerNumber;
    private PlayerLicense playerLicense;

    Player(FirstName firstName, LastName lastName) {
        super(firstName, lastName);
    }

    BirthDate getBirthDate() {
        return birthDate;
    }

    void setBirthDate(BirthDate birthDate) {
        this.birthDate = birthDate;
    }

    PlayerNumber getPlayerNumber() {
        return playerNumber;
    }

    void setPlayerNumber(PlayerNumber playerNumber) {
        this.playerNumber = playerNumber;
    }

    PlayerLicense getPlayerLicense() {
        return playerLicense;
    }

    void setPlayerLicense(PlayerLicense playerLicense) {
        this.playerLicense = playerLicense;
    }
}
