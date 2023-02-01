// Imports respective List and ArrayList classes for below class
package pk;
import java.util.ArrayList;
import java.util.List;



// The Player class is used to construct, manage and manipulate Player objects within the game
// Consists of the major properties and actions the Player object can take
public class Player {
    private final List<Dice> current_hand = new ArrayList<Dice>();
    // current_hand array represents the Dice objects in the Player object's possession
    // Array has a maximum size of 8 (8 dices)

    private final List<Integer> reroll_handIndex = new ArrayList<Integer>();
    // reroll_handIndex arrays is used to verify and store indices of rerolls

    public String name;
    // name of the Player object

    int turn_score = 0;
    int total_score = 0;
    // integer variables to store the current turn_score and total score of player

    boolean continue_roll = true;
    // a boolean factor used to determine if the player should continue rolling


    // Constructor for the Player class
    // Accepts a String as a name for the player object
    public Player(String user_name){
        this.name = user_name;
    }


    // Roll8Dice method rolls 8 dice and adds them to the player's current hand
    public void Roll8Dice(){
        this.current_hand.clear();
                
        for(int i = 0; i<8; i++){
            Dice individual_dice = new Dice();
            individual_dice.roll();
            this.current_hand.add(individual_dice);
        }
    }

    // RandRoll_Hand method is used to randomly select a number of dice to reroll
    // First, a random number (within the range of the hand) is generated and used to roll a random number of dice
    // Then, Random_index is generated to pick a random dice to reroll from hand
    // reroll_handIndex array is used to verify and prevent the same dice from being rolled more than once
    public void RandRoll_Hand(){
        int max_count = this.current_hand.size();
        int min_count = 2;
        this.reroll_handIndex.clear();

        int RandDice_count = (int)(Math.random()*(max_count - min_count + 1)+min_count);
        // generates a random number from 2 to current size of the hand

        // picks a random dice based on how many dices to reroll (from RandDice_count)
        for(int i = 0; i < RandDice_count; i++){
            int Random_index = (int)(Math.random() * current_hand.size());
            // generates a Random_index for the array

            // verifies the Dice is not a skull and is not already rolled (ie. within reroll_handIndex)
            if((this.current_hand.get(Random_index).getDiceValue() != Faces.SKULL) && !(this.reroll_handIndex.contains(Random_index))){
                this.current_hand.get(Random_index).roll();
                this.reroll_handIndex.add(Random_index);

            }

            // if Dice is a skull or has already been rolled
            else{
                // if the RandDice_count is 2 or at most only 1 dice has been re-rolled so far (ie. this.reroll_handIndex.size() <= 1)
                if(RandDice_count == 2 || this.reroll_handIndex.size() <= 1){
                    RandDice_count++;

                    // increment RandDice_count to select another dice within the hand
                }
            }

        }


    }

    // are3Skulls method will verify if 3 or more skulls are present within Player's current hand
    // If there are less than 3 skulls, continue_roll factor is returned as false
    // else, continue_roll factor is returned as true
    public boolean are3Skulls(){
        int skull_count = 0;
        for(Dice single_dice: this.current_hand){
            if(single_dice.getDiceValue() == Faces.SKULL){
                skull_count++;
            }
        }
        this.continue_roll = skull_count >= 3;
        return this.continue_roll;
    }

    // Calculate_TurnScore method will calculate the turn score of Player based on dices in current hand
    // Gold and Diamond are worth 100 points each
    public void Calculate_TurnScore(){
        int current_score = 0;
        for(Dice single_dice: this.current_hand){
            if(single_dice.getDiceValue() == Faces.DIAMOND || single_dice.getDiceValue() == Faces.GOLD){
                current_score += 100;
            }
        }
        this.turn_score = current_score;

    }

    // Reset_Stats is used to reset all the player's stats to its original values
    // Primarily used to regulate the Player's actions within the Game class
    public void Reset_Stats(){
        this.turn_score = 0;
        this.total_score = 0;
        this.continue_roll = true;
    }


    // getCurrentHand will allow for the player's current dice hand to be returned as a String (respecting encapsulation)
    public String getCurrentHand() {
        StringBuilder player_hand = new StringBuilder();
        for (int i = 0; i < this.current_hand.size(); i++) {
            player_hand.append(this.current_hand.get(i).getDiceValue());

            if (i < (this.current_hand.size() - 1)) {
                player_hand.append(" ,");
            }
        }

        return String.valueOf(player_hand);
    }

}
