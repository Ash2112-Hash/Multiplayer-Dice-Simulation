import pk.Player;
import pk.Game;

public class PiratenKarpen {

    public static void main(String[] args) {
        Player user_1 = new Player("Joe");
        Game PK_game = new Game(user_1);

        PK_game.startGame();


    }
    
}
