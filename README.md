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
| x   | F01 | Roll a dice | D | 01/11/2023 | 01/13/2023 |
| x   | F02 | Roll eight dices  | D | 01/13/2023 | 01/14/2023 |
| x   | F03 | Player randomly chooses which dice to keep from their turn | D | 01/15/2023 | 01/20/2023 |
| x   | F04 | Player rerolls until 3 skulls are reached and turn ends | B (F03) | |
| x   | F05 | Score points: Diamond and Gold coins computed by multiplying by 100 | B (F04) | | 
| x   | F06 | Only two players are playing the game  |  B (F03, F04, F05) | | |
| x   | F07 | Only 42 games are to be played during simulation  |  P  |   |
| x   | F08 | Display win percentage of each player at the end of simulation | B (F05, F07) | | 
| ... | ... | ... |

