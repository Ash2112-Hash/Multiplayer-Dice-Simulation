// Imports the required libraries for the PiratenKarpen class
import pk.CLManager;
import pk.Game;
import pk.Player;


// The PiratenKarpen class is used to initiate the main game
public class PiratenKarpen {

    // main method of the class
    // Player class is used to create 2 player objects
    // Game object is created using the player objects as arguments and game is started using the startGame() method
    // Based on CLI argument, the class will activate trace mode for the game:
        // Argument: none, game procedes accordingly
        // Argument: trace_mode, ProjectLog class will write log messages to log file
    public static void main(String[] args) {
        Game PK_game = new Game(new Player("Joe"), new Player("Jeff"));
        CLManager commandLine_analyzer = new CLManager(args);
        commandLine_analyzer.Analyze_CLArgs(PK_game);



        // Important Note: See Build and Execution section of README for instructions on how to execute game in CLI
    }

}
