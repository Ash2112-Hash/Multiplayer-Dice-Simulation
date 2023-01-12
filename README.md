# A1 - Piraten Karpen

  * Author: < Ashwin Unnithan >
  * Email: < unnithaa@mcmaster.ca >

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < 
      * Accepts the correct group of input/parameters/arguments (if any)
      * Correctly processes and returns the assoicated output relevant to the progress of the game
      * Clear of unnecessary bugs, errors and exceptions interfering with application or usage (gameplay)
    >

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  S | 01/01/23 |  |
| x   | F02 | Roll eight dices  |  B (F01) |   |
| x   | F03 | Only 42 games are to be played during simulation  |  P  |   |
| x   | F04 | Player keeps the random dice value from their turn | B (F02) | | 
| x   | F05 | Player rerolls until 3 skulls are reached and turn ends | B (F04) | |
| x   | F06 | Only two players are playing the game  |  B (F02, F04) |   |
| x   | F07 | Score points: Diamond and Gold coins | B (F05) | | 
| x   | F08 | Display win percentage of each player at the end of simulation | B (F07) | | 
| ... | ... | ... |

