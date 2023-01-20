package pk;
import java.util.ArrayList;



public class Player {
    public Dice[] current_hand = new Dice[8];
    public ArrayList<Integer> reroll_handIndex = new ArrayList<Integer>();
    String name;
    

    public Player(String user_name){
        this.name = user_name;
    }


    public String getName(){
        return this.name;
    }

    
    public void setHand(){
        this.Roll8Dice();
    }
    

    public void Roll8Dice(){
        for(int i = 0; i<8; i++){
            Dice d = new Dice();
            d.roll();
            current_hand[i] = (d);
        }

        
    }

    public void RandRoll_Hand(){
        int max_count = current_hand.length;
        int min_count = 2;
        reroll_handIndex.clear();

        int RandDice_count = (int)(Math.random()*(max_count - min_count + 1)+min_count);

        for(int i = 0; i < RandDice_count; i++){
            int Random_index = (int)(Math.random() * current_hand.length);

            if((current_hand[Random_index].getDiceValue() != Faces.SKULL) && !(reroll_handIndex.contains(Random_index))){
                current_hand[Random_index].roll();
                reroll_handIndex.add(Random_index);

            }

            else{
                if(RandDice_count == 2 || reroll_handIndex.size() <= 1){
                    RandDice_count++;
                }
            }

        }

    }

    public void displayCurrentHand(){
        for(int i = 0; i < current_hand.length; i++){
            System.out.print(current_hand[i].getDiceValue());
            if(i < (current_hand.length - 1)){
                System.out.print(" ,");
            }
        }
        System.out.print("\n");

    }


    /*Testing purposes
    public void displayReRolledDices(){
        for(int i = 0; i < reroll_handIndex.size(); i++){
            System.out.print("Dice " + (reroll_handIndex.get(i)+1));
            if(i < (reroll_handIndex.size() - 1)){
                System.out.print(" ,");
            }
        }
        System.out.print("\n");
    }
    */
}
