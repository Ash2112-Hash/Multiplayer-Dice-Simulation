# Pirate Dice Game Simulation

Pirates Dice is a Java-based multiplayer board game that allows players to roll dice and make bids about the total number of dice with a specific number that are being held by all players. The game involves bluffing, deception, and strategic decision-making, and can be played with friends or against computer opponents.



## Overview

- Each player rolls eight dice at each turn
- Score points by getting combinations of symbols on the dice
- Play against another player
- Use special event cards to gain an advantage or hinder the other player
- Specify player strategies using command line arguments
- Run the game in "trace mode" to log important events
- Display win percentage of each player at the end of the game
- Integrated log4j2 with pom.xml to log progression of game


## Getting Started

  ### Prerequisites

  - Java 11
  - Maven


## Usage

  ### Build and Execution

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

  ### Running Project using CLI commands
  * To run game by specifying player strategies, specify command for each player (seperated by a space)
    * `mvn exec:java -Dexec.args="combo random"` (run game with player 1 using combo strategy and player 2 using random strategy)
    * `mvn exec:java -Dexec.args="combo random trace_mode"` (run game with player 1 using combo strategy and player 2 using random strategy within trace mode)

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**


## Non-Development Tasks:
 * Integrated log4j2 with pom.xml to log progression of game
 * Enabled program to be run in "trace mode" and log important events to internal log file


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

| Feature  | Status  | 
|---       | :-:     |
Roll eight dices  | D | 
Player Strategy: randomly choose dice to roll and keep | D |
Player's turn ends with 3 skulls | D |
Score points: Diamond and Gold coins from roll | D |
Two players(only) can play the game  | D |
Regular 42 games can be played during simulation  | D |
Score Points: Dice Combinations | D |
Player Strategy: choose dice to Maximize Combos  | D |
| ... | ... | ... |


