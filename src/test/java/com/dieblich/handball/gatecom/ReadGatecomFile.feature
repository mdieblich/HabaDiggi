Feature: Read Gatecom Files

  Scenario: Non-Existing File
    Given a non-existing file
    Then an exception is thrown when a GatecomFile is created

  Scenario: Extraction of static game attributes
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And I extract a GateComGame
    Then the LigaKey should be "2001_024_TurnerkreisNippes2_HGVHuerth_Gleuelsim07102017165235"
    And the LigaName should be "1. Kreisklasse"
    And the SpielNummer should be "024"
    And the LigaNummer should be "001518505503504501000000000000000002024"
    And the Status should be "VSG"
    And the Datum should be "07.10.2017"
    And the Uhrzeit should be "18:00"
    And the HalbzeitDauer should be "30"
    And the Halle should be "Joseph-Dumont-Schule, Escherstraße 217, 50739 Köln"
    And mitVerlaengerung should be "False"

  Scenario: Extraction of referees assisstants
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And I extract a GateComGame
    Then the Spielleitung should be ""
    And the SpielleitungKosten should be "0"
    And the Zeitnehmer should be "Hanna Schrey 300301"
    And the ZeitnehmerKosten should be "0"
    And the Sekretaer should be "Christine Hedfeld  7630"
    And the SekretaerKosten should be "0"
    And the SchiriBeobachter should be ""
    And the SchiriBeobachterKosten should be "0"

  Scenario: Extraction of referees
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And I extract a GateComGame
    Then the Schiri1Text1 should be "Birger Gierke, Kölner Str 15, 50226 Frechen"
    And the Schiri1Text2 should be ""
    And the Schiri1KM should be "60"
    And the Schiri1FahrtKosten should be "18"
    And the Schiri1Auslagen should be "18"
    And the Schiri1Abfahrt should be "16:30"
    And the Schiri1Heimkehr should be "20:30"
    And the Schiri2Txt1 should be "Knut Steinhausen, Rochusstr.31, 50129 Bergheim"
    And the Schiri2Txt2 should be ""
    And the Schiri2KM should be "40"
    And the Schiri2FahrtKosten should be "0,8"
    And the Schiri2Auslagen should be "18"
    And the Schiri2Abfahrt should be "16:50"
    And the Schiri2Heimkehr should be "20:10"

  Scenario: Extraction of referees checks
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And I extract a GateComGame
    Then the Spielfeldaufbau should be "OK"
    And the AnzahlOrdner should be "0"
    And the Spielkleidung should be "OK"
    And the Baelle should be "OK"
    And the Zuschauer should be "50"
    And the Spielausweiskontrolle should be "Kontrolle durch Schiedsrichter - ohne Anmerkung"

  Scenario: Extraction of signatures
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And I extract a GateComGame
    Then the HexEncodedHeimUnterschrift should be "313436333938"
    And the HexEncodedGastUnterschrift should be "373031393131"
    And the HexEncodedSchiri1Unterschrift should be ""
    And the HexEncodedSchiri2Unterschrift should be ""
    And the HexEncodedHeimMVUnterschrift should be ""
    And the HexEncodedGastMVUnterschrift should be ""
    And the HexEncodedDelegierterUnterschrift should be ""
    And the game should be notversiegelt
    And the Md5EncodedHeimUnterschrift should be "A16A859EA37EBE64C50E22D756747A4C"
    And the Md5EncodedGastUnterschrift should be "312DE10BBCA0AC30888CC9C566B61673"
    And the Md5EncodedSchiri1Unterschrift should be "54E0CB120643D6BBECE4DCC91A14ACA9"
    And the Md5EncodedSchiri2Unterschrift should be "A58C211A2406AB3C4CDCE1317436083A"


  Scenario: Extraction of players of the home team
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And I extract a GateComGame
    Then the players from the team "home" should be:
      | index | Name                  | Nr | BirthDate | Passnummer | active | Scored7m | Thrown7m | Goals | Torwart |
      | 0     | Turnerkreis Nippes    | H  |           | 1320103129 | False  | 0        | 0        | 0     | False   |
      | 1     | KINZEL, DAVID         | 1  | 10.04.87  | 259256 E   | True   | 0        | 0        | 0     | True    |
      | 2     | DIEBLICH, MARTIN      | 12 | 08.03.88  | 339056 E   | True   | 0        | 0        | 0     | True    |
      | 3     | SCHMITZ, GERNOT       | 3  | 11.12.72  | 375121 E   | True   | 0        | 0        | 1     | False   |
      | 4     | BAUMBACH, NIKLAS      | 6  | 27.12.91  | 417485 E   | True   | 3        | 3        | 4     | False   |
      | 5     | RANNERSBERGER, JULIUS | 7  | 23.01.99  | 454304 D   | True   | 0        | 0        | 5     | False   |
      | 6     | BALDAUF, MARC         | 8  | 07.04.95  | 394496 E   | True   | 0        | 0        | 0     | False   |
      | 7     | BOHLEN, PHIL          | 10 | 28.07.92  | 375725 E   | True   | 0        | 0        | 3     | False   |
      | 8     | WOJTKE, THILO         | 13 | 29.10.91  | 518587 E   | True   | 0        | 0        | 2     | False   |
      | 9     | SCHLENKER, JULIUS     | 14 | 15.09.82  | 489115 E   | True   | 0        | 0        | 1     | False   |
      | 10    | SCHMITZ, HARTMUT      | 15 | 17.05.77  | 360849 E   | True   | 0        | 0        | 5     | False   |
      | 11    | MUELLENHOLZ, DENNIS   | 17 | 12.08.92  | 359843 E   | True   | 0        | 0        | 3     | False   |
      | 12    | JANSSEN, MAX          | 18 | 03.07.83  | 176700 E   | True   | 0        | 0        | 1     | False   |
      | 13    | NIEWERTH, DOMINIK     | 19 | 08.12.82  | 383448 E   | True   | 0        | 0        | 1     | False   |
      | 14    | KNAFLA, AARON         | 24 | 21.11.97  | 433060 E   | True   | 0        | 0        | 1     | False   |
      | 15    | BOJKO, PETER          |    | 29.11.77  | 441691 E   | False  | 0        | 0        | 0     | False   |
      | 16    | BRETTHAUER, JANNIS    |    | 21.10.94  | 518446 E   | False  | 0        | 0        | 0     | False   |
      | 17    | KALENBACH, ANDRE      |    | 10.06.93  | 514141 E   | False  | 0        | 0        | 0     | False   |
      | 18    | HERBEL, JULIAN        |    | 06.05.88  | 525795 E   | False  | 0        | 0        | 0     | False   |
      | 19    | SIMONE, GERO          |    | 18.07.89  | 437112 E   | False  | 0        | 0        | 0     | False   |
      | 20    | SIMONE, GERO          |    | 18.07.89  | 437112 E   | False  | 0        | 0        | 0     | False   |
      | 21    | Ott, Jürgen           | OA |           |            | False  | 0        | 0        | 0     | False   |

  Scenario: Extraction of players of the visitors team
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And I extract a GateComGame
    Then the players from the team "visitors" should be:
      | index | Name                            | Nr | BirthDate | Passnummer | active | Scored7m | Thrown7m | Goals | Torwart |
      | 0     | HGV Hürth-Gleuel                | G  |           | 1320103114 | False  | 0        | 0        | 0     | False   |
      | 1     | KOEP, ALEXANDER                 | 1  | 27.12.98  | 490962 E   | True   | 0        | 0        | 0     | True    |
      | 2     | DEJOUI, FARES                   | 12 | 13.09.95  | 546859 E   | True   | 0        | 0        | 0     | True    |
      | 3     | WICHTERICH, LUKAS               | 2  | 04.01.96  | 412624 E   | True   | 0        | 0        | 2     | False   |
      | 4     | FRAENZEL, ROBIN                 | 3  | 18.06.98  | 464018 E   | True   | 0        | 0        | 0     | False   |
      | 5     | ZINGSHEIM, FELIX                | 4  | 29.11.98  | 436053 E   | True   | 0        | 0        | 3     | False   |
      | 6     | BEYFUSS, MARTIN                 | 7  | 28.08.90  | 323064 E   | True   | 0        | 0        | 1     | False   |
      | 7     | REINHARDT, MARC                 | 8  | 02.02.90  | 308907 E   | True   | 0        | 0        | 6     | False   |
      | 8     | DERAKHSHANI, LEON SINA          | 10 | 03.08.98  | 513860 E   | True   | 0        | 0        | 0     | False   |
      | 9     | BONSTEIN, SIMON VINCENT RICHARD | 22 | 15.05.99  | 436059 E   | True   | 0        | 0        | 11    | False   |
      | 10    | SENTER, ANDREAS                 | 23 | 19.11.84  | 276819 E   | True   | 0        | 0        | 3     | False   |
      | 11    | INGENERF, DAVID                 | 49 | 15.10.96  | 480116 E   | True   | 3        | 4        | 4     | False   |
      | 12    | FOERST, TIM                     | 66 | 28.01.99  | 464565 E   | True   | 0        | 0        | 0     | False   |
      | 13    | DUNKEL, JONAS                   | 5  | 13.01.98  | 480097 D   | False  | 0        | 0        | 0     | False   |
      | 14    | FLECKENSTEIN, ERIC              | 6  | 22.02.98  | 464564 E   | False  | 0        | 0        | 0     | False   |
      | 15    | ANDREE, MARKUS                  | 9  | 12.01.87  | 285463 E   | False  | 0        | 0        | 0     | False   |
      | 16    | SCHMITZ, LEONARD ONNO           | 11 | 26.05.98  | 480554 E   | False  | 0        | 0        | 0     | False   |
      | 17    | SCHREUER, JOCHEN                | 13 | 15.11.75  | 180458 E   | False  | 0        | 0        | 0     | False   |
      | 18    | MAUS, JONATHAN JULIUS           | 14 | 26.07.98  | 462120 E   | False  | 0        | 0        | 0     | False   |
      | 21    | Wassong, Stefan                 | OA |           |            | False  | 0        | 0        | 0     | False   |
      | 22    | Ingenerf, Karl                  | OB |           |            | False  | 0        | 0        | 0     | False   |

  Scenario: Extraction of the game summary
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And I extract a GateComGame
    Then the goals of the "home"-team should be "27"
    And the goals of the "visitors"-team should be "30"
    And the score at the first break should be "16:15"
    And the final score should be "27:30"
    And the break "1" of the "home"-team should be at "50:08"
    And the break "1" of the "visitors"-team should be at "26:04"
    And the "home" team should have only taken "1" break
    And the break "2" of the "visitors"-team should be at "53:22"
    And the "visitors" team should have only taken "2" breaks
    And the game should be from "18:02:46" to "19:23:07"
    And the main break should be from "18:35:04" to "18:45:18"

  Scenario: Extraction of goal scoring
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And I extract a GateComGame
    Then the goal scoring of the first half-time should be:
      | Home | Visitors |
      | 0    | 1        |
      | 1    | 1        |
      | 1    | 2        |
      | 2    | 2        |
      | 2    | 3        |
      | 3    | 3        |
      | 3    | 4        |
      | 3    | 5        |
      | 3    | 6        |
      | 4    | 6        |
      | 5    | 6        |
      | 5    | 7        |
      | 6    | 7        |
      | 7    | 7        |
      | 8    | 7        |
      | 9    | 7        |
      | 9    | 8        |
      | 9    | 9        |
      | 9    | 10       |
      | 10   | 10       |
      | 10   | 11       |
      | 11   | 11       |
      | 11   | 12       |
      | 12   | 12       |
      | 13   | 12       |
      | 14   | 12       |
      | 15   | 12       |
      | 15   | 13       |
      | 16   | 13       |
      | 16   | 14       |
      | 16   | 15       |
    And the goal scoring of the second half-time should be:
      | Home | Visitors |
      | 16   | 16       |
      | 17   | 16       |
      | 17   | 17       |
      | 18   | 17       |
      | 19   | 17       |
      | 20   | 17       |
      | 20   | 18       |
      | 21   | 18       |
      | 21   | 19       |
      | 21   | 20       |
      | 22   | 20       |
      | 22   | 21       |
      | 23   | 21       |
      | 23   | 22       |
      | 24   | 22       |
      | 24   | 23       |
      | 24   | 24       |
      | 24   | 25       |
      | 24   | 26       |
      | 25   | 26       |
      | 25   | 27       |
      | 25   | 28       |
      | 25   | 29       |
      | 26   | 29       |
      | 26   | 30       |
      | 27   | 30       |

  Scenario: Extraction of game events
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And I extract a GateComGame
    Then the game should have 74 events
    And the events are:
      | EreignisNr | Uhrzeit  | Spielzeit | Was  | Wer |
      | 0          |          |           |      |     |
      | 0          | 18:02:46 | 0:00      | 0    | 1H  |
      | 1          | 18:02:46 | 0:00      | H 1  | TW  |
      | 1          | 18:02:46 | 0:00      | G 1  | TW  |
      | 10         | 18:03:08 | 0:22      | G 23 | T   |
      | 5          | 18:03:25 | 0:39      | H 7  | T   |
      | 9          | 18:04:13 | 1:03      | G 22 | T   |
      | 5          | 18:04:43 | 1:33      | H 7  | T   |
      | 9          | 18:05:08 | 1:58      | G 22 | T   |
      | 7          | 18:05:21 | 2:12      | H 10 | T   |
      | 11         | 18:06:19 | 3:09      | G 49 | T7  |
      | 7          | 18:06:55 | 3:45      | G 8  | T   |
      | 11         | 18:08:33 | 5:07      | G 49 | T7  |
      | 12         | 18:09:00 | 5:34      | H 18 | T   |
      | 7          | 18:10:41 | 7:15      | G 8  | V   |
      | 5          | 18:11:15 | 7:48      | H 7  | T   |
      | 9          | 18:11:42 | 8:17      | G 22 | T   |
      | 8          | 18:11:51 | 8:26      | H 13 | T   |
      | 10         | 18:12:27 | 9:01      | H 15 | T   |
      | 10         | 18:13:32 | 10:06     | H 15 | T   |
      | 3          | 18:14:45 | 11:19     | H 3  | T   |
      | 7          | 18:18:28 | 15:02     | G 8  | T   |
      | 9          | 18:19:25 | 15:59     | G 22 | T   |
      | 5          | 18:20:09 | 16:43     | G 4  | T   |
      | 4          | 18:20:21 | 16:55     | H 6  | T   |
      | 11         | 18:21:06 | 17:41     | G 49 | 7   |
      | 9          | 18:21:28 | 18:02     | G 22 | T   |
      | 11         | 18:22:25 | 19:00     | H 17 | T   |
      | 9          | 18:23:04 | 19:38     | G 22 | T   |
      | 10         | 18:23:17 | 19:51     | H 15 | T   |
      | 10         | 18:23:47 | 20:21     | H 15 | V   |
      | 4          | 18:24:38 | 21:13     | H 6  | T7  |
      | 14         | 18:25:57 | 22:31     | H 24 | T   |
      | 0          | 18:29:36 | 26:04     | G    | TO  |
      | 11         | 18:31:37 | 26:32     | H 17 | T   |
      | 9          | 18:32:05 | 27:00     | G 22 | T   |
      | 9          | 18:32:18 | 27:13     | H 14 | T   |
      | 10         | 18:32:53 | 27:47     | G 23 | T   |
      | 7          | 18:34:53 | 29:48     | G 8  | T   |
      | 0          | 18:45:18 | 30:00     | 0    | H2  |
      | 5          | 18:46:44 | 31:25     | G 4  | T   |
      | 11         | 18:47:03 | 31:44     | G 49 | V   |
      | 4          | 18:47:22 | 32:04     | H 6  | T7  |
      | 10         | 18:48:25 | 33:06     | G 23 | T   |
      | 5          | 18:48:37 | 33:18     | H 7  | T   |
      | 8          | 18:50:16 | 34:38     | H 13 | T   |
      | 10         | 18:52:03 | 36:26     | H 15 | T   |
      | 9          | 18:52:20 | 36:43     | G 22 | T   |
      | 5          | 18:53:33 | 37:55     | H 7  | T   |
      | 9          | 18:53:52 | 37:58     | G 22 | V   |
      | 9          | 18:54:14 | 38:17     | G 22 | T   |
      | 14         | 18:57:19 | 41:22     | H 24 | V   |
      | 11         | 18:57:25 | 41:28     | G 49 | T   |
      | 7          | 18:57:45 | 41:48     | H 10 | T   |
      | 3          | 18:58:03 | 42:06     | G 2  | T   |
      | 11         | 18:58:40 | 42:43     | H 17 | T   |
      | 12         | 18:59:01 | 42:52     | H 18 | V   |
      | 11         | 19:01:45 | 44:45     | G 49 | T7  |
      | 7          | 19:02:32 | 45:32     | H 10 | T   |
      | 7          | 19:03:31 | 46:31     | G 8  | T   |
      | 7          | 19:06:43 | 48:05     | G 8  | T   |
      | 7          | 19:08:22 | 49:44     | G 8  | T   |
      | 0          | 19:08:49 | 50:08     | H    | TO  |
      | 0          | 19:13:36 | 53:22     | G    | TO  |
      | 5          | 19:15:27 | 53:46     | H 7  | Z2  |
      | 5          | 19:18:56 | 56:13     | G 4  | T   |
      | 13         | 19:19:05 | 56:21     | H 19 | T   |
      | 9          | 19:19:35 | 56:51     | G 22 | T   |
      | 9          | 19:20:22 | 57:39     | G 22 | T   |
      | 3          | 19:21:25 | 58:41     | G 2  | T   |
      | 10         | 19:21:38 | 58:54     | H 15 | T   |
      | 3          | 19:22:20 | 59:27     | G 2  | Z2  |
      | 6          | 19:22:50 | 59:42     | G 7  | T   |
      | 4          | 19:25:02 | 60:00     | H 6  | T7  |


  Scenario: Extraction of game events
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And I extract a GateComGame
    Then the game report should be empty
    And no team should have made a protest
    And the protest should be empty

  Scenario: Extraction of file version
    Given the File "E:\Handball\Zeitnehmer\ESB Reverse Engineering\Spielberichte\2001_024_Turnerkreis Nippes 2_HGV Hürth-Gleuel.sim"
    When a GatecomFile is created
    And I extract a GateComGame
    Then the file version should be "2.07"