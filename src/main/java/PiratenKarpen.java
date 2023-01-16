import pk.Dice;
import pk.Player;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        
        Player p = new Player();
        p.setHand();
        p.displayHand();
        
        

    }
    
}
