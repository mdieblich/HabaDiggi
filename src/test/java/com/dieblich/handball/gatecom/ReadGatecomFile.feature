Feature: Read Gatecom Files

  Scenario: LigaKey Extraction
    Given The File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When I extract a GateComGame
    Then The LigaKey should be "2001_024_TurnerkreisNippes2_HGVHuerth_Gleuelsim07102017165235"