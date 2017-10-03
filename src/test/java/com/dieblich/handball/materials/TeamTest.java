package com.dieblich.handball.materials;

import com.dieblich.handball.terms.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void shouldHaveAName() {
        TeamName tkNippes2Name = new TeamName("TK Nippes 2");
        Team tkNippes2 = new Team(tkNippes2Name);
        assertEquals(tkNippes2Name, tkNippes2.getName());
    }

    @Test
    void shouldHaveACoach() {
        Coach juergenOtt = new Coach(new FirstName("Jürgen"), new LastName("Ott"));
        Team tkNippes2 = new Team(new TeamName("TK Nippes 2"));
        tkNippes2.setCoach(juergenOtt);
        assertEquals(juergenOtt, tkNippes2.getCoach());
    }

    @Test
    void shouldHaveOfficials() throws HandballException {
        Team tkNippes2 = new Team(new TeamName("TK Nippes 2"));
        Person christianGernhardt = new Person(new FirstName("Christian"), new LastName("Gernhardt"));

        tkNippes2.setOfficial(OfficialTag.A, christianGernhardt);

        assertTrue(tkNippes2.getOfficials().size() > 0);
        assertEquals(christianGernhardt, tkNippes2.getOfficials().get(OfficialTag.A));
    }

    @Test
    void firstOfficialIsTheCoach() throws HandballException {
        Team tkNippes2 = new Team(new TeamName("TK Nippes 2"));
        Coach juergenOtt = new Coach(new FirstName("Jürgen"), new LastName("Ott"));

        tkNippes2.setOfficial(OfficialTag.A, juergenOtt);

        assertEquals(juergenOtt, tkNippes2.getCoach());
    }

    @Test
    void coachIsTheFirstOfficial() {
        Team tkNippes2 = new Team(new TeamName("TK Nippes 2"));
        Coach juergenOtt = new Coach(new FirstName("Jürgen"), new LastName("Ott"));
        tkNippes2.setCoach(juergenOtt);

        assertEquals(juergenOtt, tkNippes2.getOfficials().get(OfficialTag.A));
    }

    @Test
    void noOfficialIsDoubled() throws HandballException {
        Team tkNippes2 = new Team(new TeamName("TK Nippes 2"));
        Person juergenOtt = new Person(new FirstName("Jürgen"), new LastName("Ott"));

        tkNippes2.setOfficial(OfficialTag.A, juergenOtt);
        tkNippes2.setOfficial(OfficialTag.B, juergenOtt);

        assertTrue(tkNippes2.getOfficials().containsKey(OfficialTag.A));

    }


    @Test
    void hasPlayers() throws Exception {
        Team tkNippes2 = new Team(new TeamName("TK Nippes 2"));
        Player martinDieblich = new Player(new FirstName("Martin"), new LastName("Dieblich"));
        Player hartmutSchmitz = new Player(new FirstName("Hartmut"), new LastName("Schmitz"));

        tkNippes2.addPlayer(martinDieblich);
        tkNippes2.addPlayer(hartmutSchmitz);

        assertTrue(tkNippes2.getPlayers().contains(martinDieblich), "Martin fehlt");
        assertTrue(tkNippes2.getPlayers().contains(hartmutSchmitz), "Hartmut fehlt");
    }

    @Test
    void teamIsCompleteIfItHasAtLeastFivePlayers() throws HandballException {
        Team tkNippes2 = new Team(new TeamName("TK Nippes 2"));
        tkNippes2.setCoach(new Coach(new FirstName("Jürgen"), new LastName("Ott")));

        tkNippes2.addPlayer(new Player(new FirstName("Martin"), new LastName("Dieblich")));
        tkNippes2.addPlayer(new Player(new FirstName("Hartmut"), new LastName("Schmitz")));
        tkNippes2.addPlayer(new Player(new FirstName("Dennis"), new LastName("Mühlenholz")));
        tkNippes2.addPlayer(new Player(new FirstName("Phil"), new LastName("Bohlen")));
        assertFalse(tkNippes2.isComplete());
        tkNippes2.addPlayer(new Player(new FirstName("André"), new LastName("Kahlenbach")));
        assertTrue(tkNippes2.isComplete());

    }

    @Test
    void teamIsCompleteIfItHasAtLeastACoach() throws HandballException {
        Team tkNippes2 = new Team(new TeamName("TK Nippes 2"));

        tkNippes2.addPlayer(new Player(new FirstName("Martin"), new LastName("Dieblich")));
        tkNippes2.addPlayer(new Player(new FirstName("Hartmut"), new LastName("Schmitz")));
        tkNippes2.addPlayer(new Player(new FirstName("Dennis"), new LastName("Mühlenholz")));
        tkNippes2.addPlayer(new Player(new FirstName("Phil"), new LastName("Bohlen")));
        tkNippes2.addPlayer(new Player(new FirstName("André"), new LastName("Kahlenbach")));
        assertFalse(tkNippes2.isComplete());
        tkNippes2.setCoach(new Coach(new FirstName("Jürgen"), new LastName("Ott")));
        assertTrue(tkNippes2.isComplete());

    }


    @Test
    void hasNoMoreThan14Players() throws HandballException {
        Team tkNippes2 = new Team(new TeamName("TK Nippes 2"));
        for (int i = 1; i <= 14; i++) {
            tkNippes2.addPlayer(new Player(new FirstName("Martin" + i), new LastName("Dieblich" + i)));
        }
        try {
            tkNippes2.addPlayer(new Player(new FirstName("Martin15"), new LastName("Dieblich15")));

            fail("15. Person wurde zum Team hinzugefügt");
        } catch (Exception e) {/* erwartete Exception*/ }

    }


    @Test
    void noPlayerIsDoubled() throws HandballException {
        Team tkNippes2 = new Team(new TeamName("TK Nippes 2"));

        tkNippes2.addPlayer(new Player(new FirstName("Martin"), new LastName("Dieblich")));
        try {

            tkNippes2.addPlayer(new Player(new FirstName("Martin"), new LastName("Dieblich")));
            fail("Spieler konnte zweimal hinzugefügt werden:");
        } catch (Exception e) {/* erwartete Exception */ }

    }

    @Test
    void aPlayerMaybeTheFirstOfficial() throws HandballException {
        Team tkNippes2 = new Team(new TeamName("TK Nippes 2"));

        Player martinDieblich = new Player(new FirstName("Martin"), new LastName("Dieblich"));

        tkNippes2.addPlayer(martinDieblich);
        tkNippes2.setOfficial(OfficialTag.A, martinDieblich);

    }

    @Test
    void aPlayerMustNotBeAnOfficialOtherThanTheFirst() throws HandballException {
        Team tkNippes2 = new Team(new TeamName("TK Nippes 2"));

        Player martinDieblich = new Player(new FirstName("Martin"), new LastName("Dieblich"));

        tkNippes2.addPlayer(martinDieblich);
        try {
            tkNippes2.setOfficial(OfficialTag.B, martinDieblich);
            fail("Spieler wurde zu Offiziellem B!");
        } catch (Exception e) {/*expected*/}
        try {
            tkNippes2.setOfficial(OfficialTag.C, martinDieblich);
            fail("Spieler wurde zu Offiziellem C!");
        } catch (Exception e) {/*expected*/}
        try {
            tkNippes2.setOfficial(OfficialTag.D, martinDieblich);
            fail("Spieler wurde zu Offiziellem D!");
        } catch (Exception e) {/*expected*/}
    }
}
