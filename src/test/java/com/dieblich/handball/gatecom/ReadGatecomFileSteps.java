package com.dieblich.handball.gatecom;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadGatecomFileSteps {

    private GatecomFile gatecomFile;
    private GatecomGame extractedGame;

    @Given("^The File \"([^\"]*)\"$")
    public void theFile(String filename) {
        gatecomFile = new GatecomFile(filename);
    }

    @When("^I extract a GateComGame$")
    public void iExtractAGateComGame() {
        extractedGame = gatecomFile.extractGame();
    }

    @Then("^The LigaKey should be \"([^\"]*)\"$")
    public void theLigaKeyShouldBe(String ligaKey) {
        assertEquals(ligaKey, extractedGame.getLigaKey());
    }
}
