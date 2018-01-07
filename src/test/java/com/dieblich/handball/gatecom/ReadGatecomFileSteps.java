package com.dieblich.handball.gatecom;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReadGatecomFileSteps {

    /*
    assertEquals(, extractedGame.);
    */

    private String gatecomFileName;
    private GatecomFile gatecomFile;
    private GatecomGame extractedGame;

    @Given("^the File \"([^\"]*)\"$")
    public void theFile(String filename) {
        gatecomFileName = filename;
    }

    @When("^I extract a GateComGame$")
    public void iExtractAGateComGame() throws GatecomException {
        extractedGame = gatecomFile.extractGame();
    }

    @Given("^a non-existing file$")
    public void aNonExistingFile() {
        gatecomFileName = "C:\\idontexists.sim";
    }

    @When("^a GatecomFile is created$")
    public void aGatecomFileIsCreated() throws GatecomException {
        gatecomFile = new GatecomFile(gatecomFileName);
    }

    @Then("^an exception is thrown$")
    public void anExceptionIsThrown() {
    }

    @Then("^an exception is thrown when a GatecomFile is created$")
    public void anExceptionIsThrownWhenAGatecomFileIsCreated() {
        try {
            aGatecomFileIsCreated();
            fail("File is not present and gatecomfile should not be created");
        } catch (GatecomException e) {
            // everything is fine
        }
    }

    @Then("^the LigaKey should be \"([^\"]*)\"$")
    public void theLigaKeyShouldBe(String ligaKey) {
        assertEquals(ligaKey, extractedGame.getLigaKey());
    }

    @Then("^the LigaName should be \"([^\"]*)\"$")
    public void theLiganameShouldBe(String ligaName) {
        assertEquals(ligaName, extractedGame.getLigaName());
    }

    @And("^the SpielNummer should be \"([^\"]*)\"$")
    public void theSpielNummerShouldBe(String spielnummer){
        assertEquals(spielnummer, extractedGame.getSpielNummer());
    }

    @And("^the LigaNummer should be \"([^\"]*)\"$")
    public void theLigaNummerShouldBe(String ligaNummer) {
        assertEquals(ligaNummer, extractedGame.getLigaNummer());
    }

    @And("^the Status should be \"([^\"]*)\"$")
    public void theStatusShouldBe(String status) {
        assertEquals(status, extractedGame.getStatus());
    }

    @And("^the Datum should be \"([^\"]*)\"$")
    public void theDatumShouldBe(String datum) {
        assertEquals(datum, extractedGame.getDatum());
    }

    @And("^the Uhrzeit should be \"([^\"]*)\"$")
    public void theUhrzeitShouldBe(String uhrzeit) {
        assertEquals(uhrzeit, extractedGame.getUhrzeit());
    }

    @And("^the HalbzeitDauer should be \"([^\"]*)\"$")
    public void theHalbzeitDauerShouldBe(String halbzeitDauer) {
        assertEquals(halbzeitDauer, extractedGame.getHalbzeitDauer());
    }

    @And("^the Halle should be \"([^\"]*)\"$")
    public void theHalleShouldBe(String halle) {
        assertEquals(halle, extractedGame.getHalle());
    }

    @And("^mitVerlaengerung should be \"([^\"]*)\"$")
    public void mitverlaengerungShouldBe(String mitVerlaengerung) {
        assertEquals(mitVerlaengerung, extractedGame.getMitVerlaengerung());
    }

    @Then("^the Spielleitung should be \"([^\"]*)\"$")
    public void theSpielleitungShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the SpielleitungKosten should be \"([^\"]*)\"$")
    public void theSpielleitungKostenShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Zeitnehmer should be \"([^\"]*)\"$")
    public void theZeitnehmerShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the ZeitnehmerKosten should be \"([^\"]*)\"$")
    public void theZeitnehmerKostenShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Sekretaer should be \"([^\"]*)\"$")
    public void theSekretaerShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the SekretaerKosten should be \"([^\"]*)\"$")
    public void theSekretaerKostenShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the SchiriBeobachter should be \"([^\"]*)\"$")
    public void theSchiriBeobachterShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the SchiriBeobachterKosten should be \"([^\"]*)\"$")
    public void theSchiriBeobachterKostenShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the Schiri(\\d+)Text(\\d+) should be \"([^\"]*)\"$")
    public void theSchiriTextShouldBe(int arg0, int arg1, String arg2) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Schiri(\\d+)KM should be \"([^\"]*)\"$")
    public void theSchiriKMShouldBe(int arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Schiri(\\d+)FahrtKosten should be \"([^\"]*)\"$")
    public void theSchiriFahrtKostenShouldBe(int arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Schiri(\\d+)Auslagen should be \"([^\"]*)\"$")
    public void theSchiriAuslagenShouldBe(int arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Schiri(\\d+)Abfahrt should be \"([^\"]*)\"$")
    public void theSchiriAbfahrtShouldBe(int arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Schiri(\\d+)Heimkehr should be \"([^\"]*)\"$")
    public void theSchiriHeimkehrShouldBe(int arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Schiri(\\d+)Txt(\\d+) should be \"([^\"]*)\"$")
    public void theSchiriTxtShouldBe(int arg0, int arg1, String arg2) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the Spielfeldaufbau should be \"([^\"]*)\"$")
    public void theSpielfeldaufbauShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the AnzahlOrdner should be \"([^\"]*)\"$")
    public void theAnzahlOrdnerShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Spielkleidung should be \"([^\"]*)\"$")
    public void theSpielkleidungShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Baelle should be \"([^\"]*)\"$")
    public void theBaelleShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Zuschauer should be \"([^\"]*)\"$")
    public void theZuschauerShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Spielausweiskontrolle should be \"([^\"]*)\"$")
    public void theSpielausweiskontrolleShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the HexEncodedHeimUnterschrift should be \"([^\"]*)\"$")
    public void theHexEncodedHeimUnterschriftShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the HexEncodedGastUnterschrift should be \"([^\"]*)\"$")
    public void theHexEncodedGastUnterschriftShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the HexEncodedSchiri(\\d+)Unterschrift should be \"([^\"]*)\"$")
    public void theHexEncodedSchiriUnterschriftShouldBe(int arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the HexEncodedHeimMVUnterschrift should be \"([^\"]*)\"$")
    public void theHexEncodedHeimMVUnterschriftShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the HexEncodedGastMVUnterschrift should be \"([^\"]*)\"$")
    public void theHexEncodedGastMVUnterschriftShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the HexEncodedDelegierterUnterschrift should be \"([^\"]*)\"$")
    public void theHexEncodedDelegierterUnterschriftShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the game should be notversiegelt$")
    public void theGameShouldBeNotversiegelt() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Md5EncodedHeimUnterschrift should be \"([^\"]*)\"$")
    public void theMd5EncodedHeimUnterschriftShouldBe(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Md5EncodedGastUnterschrift should be \"([^\"]*)\"$")
    public void theMd5EncodedGastUnterschriftShouldBe(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the Md5EncodedSchiri(\\d+)Unterschrift should be \"([^\"]*)\"$")
    public void theMd5EncodedSchiriUnterschriftShouldBe(int arg1, String arg2) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the players from the team \"([^\"]*)\" should be:$")
    public void thePlayersFromTheTeamShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the goals of the \"([^\"]*)\"-team should be \"([^\"]*)\"$")
    public void theGoalsOfTheTeamShouldBe(String arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the score at the first break should be \"([^\"]*)\"$")
    public void theScoreAtTheFirstBreakShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the final score should be \"([^\"]*)\"$")
    public void theFinalScoreShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the break \"([^\"]*)\" of the \"([^\"]*)\"-team should be at \"([^\"]*)\"$")
    public void theBreakOfTheTeamShouldBeAt(String arg0, String arg1, String arg2) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the \"([^\"]*)\" team should have only taken \"([^\"]*)\" break$")
    public void theTeamShouldHaveOnlyTakenBreak(String arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the \"([^\"]*)\" team should have only taken \"([^\"]*)\" breaks$")
    public void theTeamShouldHaveOnlyTakenBreaks(String arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the game should be from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void theGameShouldBeFromTo(String arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the main break should be from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void theMainBreakShouldBeFromTo(String arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the goal scoring of the first half-time should be:$")
    public void theGoalScoringOfTheFirstHalfTimeShouldBe() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the goal scoring of the second half-time should be:$")
    public void theGoalScoringOfTheSecondHalfTimeShouldBe() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the game should have (\\d+) events$")
    public void theGameShouldHaveEvents(int arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the events are:$")
    public void theEventsAre() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the game report should be empty$")
    public void theGameReportShouldBeEmpty() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^no team should have made a protest$")
    public void noTeamShouldHaveMadeAProtest() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^the protest should be empty$")
    public void theProtestShouldBeEmpty() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the file version should be \"([^\"]*)\"$")
    public void theFileVersionShouldBe(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
