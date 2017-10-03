package com.dieblich.handball.materials;

import com.dieblich.handball.terms.HandballException;
import com.dieblich.handball.terms.OfficialTag;
import com.dieblich.handball.terms.TeamName;

import java.util.*;

class Team {

    private static final int MINIMUM_PLAYERS = 5;
    private static final int MAXIMUM_PLAYERS = 14;
    private final SortedMap<OfficialTag, Person> officials = new TreeMap<>();
    private final TeamName name;
    private final List<Player> players = new ArrayList<>();
    private Person coach;

    Team(TeamName name) {
        this.name = name;
    }

    TeamName getName() {
        return name;
    }

    Person getCoach() {
        return coach;
    }

    void setCoach(Person coach) {
        this.coach = coach;
        officials.put(OfficialTag.A, coach);
    }

    void setOfficial(OfficialTag tag, Person official) throws HandballException {
        if (tag == OfficialTag.A) {
            coach = official;
        } else if (official instanceof Player && players.contains(official)) {
            throw new HandballException(official + " ist schon als Spieler eingetragen und darf daher nur Offizieller A sein, nicht aber Offizieller " + tag);
        }
        officials.put(tag, official);
    }

    SortedMap<OfficialTag, Person> getOfficials() {
        return officials;
    }

    void addPlayer(Player player) throws HandballException {
        if (players.size() >= MAXIMUM_PLAYERS) {
            throw new HandballException("Das Team hat schon 14 Spieler: " + players);
        }
        if (players.contains(player)) {
            throw new HandballException("Spieler " + player + " bereits vorhanden: " + players);
        }
        players.add(player);
    }

    boolean isComplete() {
        return players.size() >= MINIMUM_PLAYERS && coach != null;
    }

    List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
