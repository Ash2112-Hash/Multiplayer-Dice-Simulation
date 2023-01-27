import pk.Player;
import pk.Game;

public class PiratenKarpen {

    public static void main(String[] args) {
        Player user_1 = new Player("Joe");
        Player user_2 = new Player("Jeff");
        Game PK_game = new Game(user_1, user_2);

        PK_game.startGame();

    }
    
}
