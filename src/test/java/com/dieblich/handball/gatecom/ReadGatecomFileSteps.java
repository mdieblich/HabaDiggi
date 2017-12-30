package com.dieblich.handball.gatecom;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReadGatecomFileSteps {

    private String gatecomFileName;
    private GatecomFile gatecomFile;
    private GatecomGame extractedGame;

    @Given("^the File \"([^\"]*)\"$")
    public void theFile(String filename) {
        gatecomFileName = filename;
    }

    @When("^i extract a GateComGame$")
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

    @Then("^the Liganame should be \"([^\"]*)\"$")
    public void theLiganameShouldBe(String ligaName) {
        assertEquals(ligaName, extractedGame.getLigaName());
    }
}
