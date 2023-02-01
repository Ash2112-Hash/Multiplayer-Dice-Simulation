// Import the required libraries for the Strategy class
package pk;
import java.util.*;

//Important Note: All commented out print statements and code were used for debugging purposes to show the progress of the game in stdout


// The Strategy class is used to set and determine the playable strategy of the player within the game
public class Strategy {

    // Random_DiceRolls() is a major method responsible for the Random Roll player strategy
    // Based on a random coin toss logic, each player would either reroll or decide to end their turn by choice. In the case of 3 skulls, player will automatically end their turn
    // The decision of the turn will be returned as boolean value (used in the start_Game method)
    public boolean Random_DiceRolls(Player player_obj){
        Random random_generator = new Random();
        int random_number = random_generator.nextInt(2) + 1;
        // generates a random integer from 1 to 2

        boolean round_factor;

        // Player chooses to continue their turn (if random number is 2 and <3 skulls)
        if(random_number==2 && !(player_obj.are3Skulls())){
            //System.out.println("Now, " + player_obj.name + " randomly re-rolls their dice!");
            //System.out.print("After re-rolling, ");
            ProjectLog.insert_log_message(player_obj.name + " re-rolls their dice!", "trace");
            player_obj.RandRoll_Hand();
            ProjectLog.insert_log_message((player_obj.name + " after re-rolling: ") + player_obj.getCurrentHand(), "trace");
            player_obj.Calculate_TurnScore();
            ProjectLog.insert_log_message(player_obj.name + "'s Current Hand Score: " + player_obj.turn_score + " points", "info");
            round_factor = true;
        }

        else{

            // Player will choose to end their turn by choice if <3skulls
            if(!(player_obj.are3Skulls())){
                //System.out.println(player_obj.name + " has chosen to end their turn.");
                ProjectLog.insert_log_message(player_obj.name + " ends turn!", "info");
                player_obj.total_score += player_obj.turn_score;

                if(player_obj.total_score < 6000){
                    ProjectLog.insert_log_message(player_obj.name + "'s total Score: " + player_obj.total_score + " points", "warn");
                }

                //System.out.println(player_obj.name + "'s total Score: " + player_obj.total_score + " points");
                //System.out.println("\n");
                player_obj.turn_score = 0;
            }

            // Player is forced to end turn if >=3 skulls are present
            else{
                player_obj.turn_score = 0;
                ProjectLog.insert_log_message(player_obj.name + " has rolled 3 or more skulls: " + player_obj.getCurrentHand(), "warn");
                ProjectLog.insert_log_message(player_obj.name + "'s total score did not increase: " + player_obj.total_score + " points", "info");
                ProjectLog.insert_log_message(player_obj.name + "'s turn is ended", "info");

            }
            round_factor = false;
        }
        return round_factor;
        // always return decision of turn to method call
    }


    public boolean Maximize_Combos(Player player_obj){
        Random random_generator = new Random();
        int random_number = random_generator.nextInt(2) + 1;
        // generates a random integer from 1 to 2

        boolean round_factor;
        boolean enough_dice = Check_RemainingDice(player_obj);;

        // Player chooses to continue their turn (if random number is 2 and <3 skulls)
        if(random_number==2 && !(player_obj.are3Skulls()) && enough_dice){
            //System.out.println("Now, " + player_obj.name + " randomly re-rolls their dice!");
            //System.out.print("After re-rolling, ");
            ProjectLog.insert_log_message(player_obj.name + " re-rolls their dice!", "trace");
            player_obj.ComboRoll();
            ProjectLog.insert_log_message((player_obj.name + " after re-rolling: ") + player_obj.getCurrentHand(), "trace");
            player_obj.Calculate_TurnScore();
            ProjectLog.insert_log_message(player_obj.name + "'s Current Hand Score: " + player_obj.turn_score + " points", "info");
            round_factor = true;

        }

        else{

            // Player will choose to end their turn by choice if <3skulls
            if(!(player_obj.are3Skulls())){
                //System.out.println(player_obj.name + " has chosen to end their turn.");
                ProjectLog.insert_log_message(player_obj.name + " ends turn!", "info");
                player_obj.total_score += player_obj.turn_score;


                if(player_obj.total_score < 6000){
                    ProjectLog.insert_log_message(player_obj.name + "'s total Score: " + player_obj.total_score + " points", "warn");
                }
                player_obj.turn_score = 0;
            }


            // Player is forced to end turn if >=3 skulls are present
            else{
                player_obj.turn_score = 0;
                ProjectLog.insert_log_message(player_obj.name + " has rolled 3 or more skulls: " + player_obj.getCurrentHand(), "warn");
                ProjectLog.insert_log_message(player_obj.name + "'s total score did not increase: " + player_obj.total_score + " points", "info");
                ProjectLog.insert_log_message(player_obj.name + "'s turn is ended", "info");

            }
            round_factor = false;
        }
        return round_factor;
        // always return decision of turn to method call
    }



    public boolean Check_RemainingDice(Player single_player){
        List<String> test_hand = new ArrayList(Arrays.asList(single_player.getCurrentHand().split(" ,")));
        int skull_frequency = Collections.frequency(test_hand, "SKULL");
        System.out.println("Skull: " + skull_frequency);
        boolean result = true;

        for(String dice_face: test_hand){
            if(!Objects.equals(dice_face, "SKULL")) {
                int dice_frequency = Collections.frequency(test_hand, dice_face);
                System.out.println(dice_face + ": " + dice_frequency);

                if ((dice_frequency >= 7)){
                    result = false;
                    System.out.println(dice_face + ": " + dice_frequency);
                    break;
                }

                else{
                    if ((dice_frequency == 6) && (skull_frequency >= 1)){
                        result = false;
                        System.out.println(dice_face + ": " + dice_frequency);
                        break;
                    }
                }
            }
        }

        return result;

    }
}
