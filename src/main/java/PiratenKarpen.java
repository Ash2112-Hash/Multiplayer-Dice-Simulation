// Import the required Player and Game class from pk package
import pk.Player;
import pk.Game;

// The PiratenKarpen class is used to initiate the main game
public class PiratenKarpen {

    // main method of the class
    // Player class is used to create 2 player objects
    // Game object is created using the player objects as arguments and game is started using the startGame() method
    public static void main(String[] args) {
        Game PK_game = new Game(new Player("Joe"), new Player("Jeff"));
        PK_game.startGame();

    }


    
}
