package pk;

// Imports Imports the required libraries/classes for Player
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


// The Player class is used to construct, manage and manipulate Player objects within the game
// Consists of the major properties and actions the Player object can take
public class Player {
    private final List<Dice> current_hand = new ArrayList<Dice>();
    // current_hand array represents the Dice objects in the Player object's possession
    // Array has a maximum size of 8 (8 dices)


    protected Card_Faces drawn_card;
    // represents the card of the player

    private final List<Integer> reroll_handIndex = new ArrayList<Integer>();
    // reroll_handIndex arrays is used to verify and store indices of rerolls

    protected String name;
    // name of the Player object

    protected int turn_score = 0;
    protected int total_score = 0;
    // integer variables to store the current turn_score and total score of player

    private boolean continue_roll = true;
    // a boolean factor used to determine if the player should continue rolling


    // Constructor for the Player class
    // Accepts a String as a name for the player object
    public Player(String user_name){
        this.name = user_name;
    }


    // Roll8Dice method rolls 8 dice and adds them to the player's current hand
    protected void Roll8Dice(){
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
    protected void RandRoll_Hand(){
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


    protected void ComboRoll(){
        int old_frequency = 0;
        int new_frequency = 0;
        List<Faces> faces_Hand = new ArrayList<Faces>();
        for (Dice each_dice : this.current_hand) {
            faces_Hand.add(each_dice.getDiceValue());
        }

        Faces target_val = null;

        for (Faces dice_val : faces_Hand) {
            if (dice_val != Faces.SKULL) {
                new_frequency = Collections.frequency(faces_Hand, dice_val);

                if (old_frequency < new_frequency) {
                    old_frequency = new_frequency;
                    target_val = dice_val;

                    if(old_frequency == 6 || old_frequency == 7){
                        ProjectLog.insert_log_message("Check hand", "debug");
                    }

                }


            }
        }
        //System.out.println(target_val + " " + old_frequency);

        for(Dice single_dice: this.current_hand){
            if((single_dice.getDiceValue() != target_val) && (single_dice.getDiceValue() != Faces.SKULL)){
                single_dice.roll();
            }
        }

    }


    // are3Skulls method will verify if 3 or more skulls are present within Player's current hand
    // If there are less than 3 skulls, continue_roll factor is returned as false
    // else, continue_roll factor is returned as true
    protected boolean are3Skulls(){
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
    // Utilizes both Find_DiamondGoldDice and Find_ComboDice() to calculate score
    protected void Calculate_TurnScore(){
        int riches_score = Find_DiamondGoldDice();
        int combo_score = Find_ComboDice();
        this.turn_score = (combo_score + riches_score);
    }


    // Find_DiamondGoldDice method will iterate through current hand to detect presence of Diamond and Gold dice
    // Each Gold and Diamond dice are worth 100 points
    private int Find_DiamondGoldDice(){
        int score = 0;
        for(Dice single_dice: this.current_hand){
            if(single_dice.getDiceValue() == Faces.DIAMOND || single_dice.getDiceValue() == Faces.GOLD){
                score += 100;
            }
        }

        return score;
    }


    // Find_ComboDice method will iterate through current hand to detect presence of dice combinations: 3, 4, 5, 6, 7, 8
    private int Find_ComboDice() {
        int score = 0;
        List<Faces> face_hand = new ArrayList<Faces>();
        for (Dice single_dice : this.current_hand) {
            face_hand.add(single_dice.getDiceValue());
        }
        List<Faces> new_face_hand = new ArrayList<>(face_hand.stream().distinct().toList());
        new_face_hand.remove(Faces.SKULL);

        for (Faces dice_val : new_face_hand) {

            int combos_num = Collections.frequency(face_hand, dice_val);
            //System.out.println(dice_val + " :" + combos_num);

            switch (combos_num) {
                case 3 -> score += 100;
                case 4 -> score += 200;
                case 5 -> score += 500;
                case 6 -> score += 1000;
                case 7 -> score += 2000;
                case 8 -> score += 4000;
            }

        }
        return score;
    }


    // Reset_Stats is used to reset all the player's stats to its original values
    // Primarily used to regulate the Player's actions within the Game class
    protected void Reset_Stats(){
        this.turn_score = 0;
        this.total_score = 0;
        this.continue_roll = true;
    }


    // getCurrentHand will allow for the player's current dice hand to be returned as a String (respecting encapsulation)
    protected String getCurrentHand() {
        StringBuilder player_hand = new StringBuilder();

        for (int i = 0; i < this.current_hand.size(); i++) {
            player_hand.append(this.current_hand.get(i).getDiceValue());

            if (i < (this.current_hand.size() - 1)) {
                player_hand.append(" ,");
            }
        }

        return String.valueOf(player_hand);

    }

    protected void DrawCard(List<Card_Faces> deck){
        int random_index = new Random().nextInt(deck.size());


        this.drawn_card = deck.get(random_index);

    }

}
