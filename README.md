# A1 - Piraten Karpen

  * Author: < Ashwin Unnithan >
  * Email: < unnithaa@mcmaster.ca >

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode (without trace mode):
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_) or `mvn exec:java`
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar`
  * To run project using trace mode with log4j2:
    * `mvn exec:java -Dexec.args="trace_mode"`

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < 
      * Accepts the correct group of input/parameters/arguments (if any)
      * Correctly processes and returns the assoicated output relevant to the progress of the game
      * Clear of unnecessary bugs, errors and exceptions interfering with application or usage (gameplay)
   * <

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice | D | 01/11/2023 | 01/13/2023 |
| x   | F02 | Roll eight dices  | D | 01/13/2023 | 01/14/2023 |
| x   | F03 | Player Strategy: randomly choose dice to roll and keep | D | 01/15/2023 | 01/20/2023 |
| x   | F04 | Player's turn ends with 3 skulls | D | 01/20/2023 | 01/21/2023 |
| x   | F05 | Score points: Diamond and Gold coins from roll | D | 01/21/2023 | 01/21/2023 |
| x   | F06 | Two players(only) can play the game  | D | 01/21/2023 | 01/25/2023 |
| x   | F07 | 42 games can be played during simulation  | D | 01/25/2023 | 01/25/2023 |
| x   | F08 | Display win percentage of each player at end | D | 01/25/2023 | 01/27/2023 |
| x   | F09 | Score Points: Dice Combinations | D | 01/31/2023 | 01/31/2023 |
| x   | F10 | Player Strategy: choose dice to Maximize Combos  | D | 01/31/2023 | 02/01/2023 |
| x   | F11 | Choose Strategy: command line arguments | B(F09, F10) | |  |
| ... | ... | ... |

