package pk;
import java.util.ArrayList;
import java.util.List;


public class Player {
    public Dice[] current_hand = new Dice[8];
    public List<Integer> reroll_handIndex = new ArrayList<Integer>();
    String name;
    int turn_score = 0;
    int total_score = 0;
    boolean continue_roll = true;


    public Player(String user_name){
        this.name = user_name;
    }


    public void setHand(){
        Roll8Dice();
    }


    public void Roll8Dice(){
        for(int i = 0; i<8; i++){
            Dice individual_dice = new Dice();
            individual_dice.roll();
            this.current_hand[i] = (individual_dice);
        }
    }

    public void RandRoll_Hand(){
        int max_count = this.current_hand.length;
        int min_count = 2;
        this.reroll_handIndex.clear();

        int RandDice_count = (int)(Math.random()*(max_count - min_count + 1)+min_count);

        for(int i = 0; i < RandDice_count; i++){
            int Random_index = (int)(Math.random() * current_hand.length);

            if((this.current_hand[Random_index].getDiceValue() != Faces.SKULL) && !(this.reroll_handIndex.contains(Random_index))){
                this.current_hand[Random_index].roll();
                this.reroll_handIndex.add(Random_index);

            }

            else{
                if(RandDice_count == 2 || this.reroll_handIndex.size() <= 1){
                    RandDice_count++;
                }
            }

        }


    }

    public boolean are3Skulls(){
        int skull_count = 0;
        for(Dice single_dice: this.current_hand){
            if(single_dice.getDiceValue() == Faces.SKULL){
                skull_count++;
            }
        }
        this.continue_roll = skull_count < 3;
        return this.continue_roll;
    }

    public void Calculate_TurnScore(){
        int current_score = 0;
        for(Dice single_dice: this.current_hand){
            if(single_dice.getDiceValue() == Faces.DIAMOND || single_dice.getDiceValue() == Faces.GOLD){
                current_score += 100;
            }
        }
        this.turn_score = current_score;

    }

    public void Reset_Stats(){
        this.turn_score = 0;
        this.total_score = 0;
        this.continue_roll = true;
    }

    /* Used for debugging purposes!
    public void displayCurrentHand(){
        for(int i = 0; i < this.current_hand.length; i++){
            System.out.print(this.current_hand[i].getDiceValue());
            if(i < (this.current_hand.length - 1)){
                System.out.print(" ,");
            }
        }
        System.out.print("\n");

    }

     */

}
