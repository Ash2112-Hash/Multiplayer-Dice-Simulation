package pk;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    ArrayList<Dice> current_hand = new ArrayList<Dice>();

    
    public void setHand(){
        this.Roll8Dice();
    }
    

    public void Roll8Dice(){
        for(int i = 0; i<8; i++){
            Dice d = new Dice();
            d.roll();
            current_hand.add(d);
        }
    }


    public void displayHand(){
        for(Dice singleDice : current_hand){
            System.out.println(singleDice.dice_value + "");
        }
        
        
    }
    
}
