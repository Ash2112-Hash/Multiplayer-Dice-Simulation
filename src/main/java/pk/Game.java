package pk;

public class Game {
    public Player player_1;
    
    public Game(Player p1){
        System.out.println("Welcome to Piraten Karpen Simulator!");
        this.player_1 = p1;
        System.out.println("Player 1: " + player_1.getName());
    }


}
