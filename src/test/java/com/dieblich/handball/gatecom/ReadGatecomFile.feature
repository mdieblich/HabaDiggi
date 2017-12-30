Feature: Read Gatecom Files

  Scenario: Non-Existing File
    Given a non-existing file
    Then an exception is thrown when a GatecomFile is created

  Scenario: LigaKey Extraction
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And i extract a GateComGame
    Then the LigaKey should be "2001_024_TurnerkreisNippes2_HGVHuerth_Gleuelsim07102017165235"

  Scenario: Liganame Extraction
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And i extract a GateComGame
    Then the Liganame should be "1. Kreisklasse"