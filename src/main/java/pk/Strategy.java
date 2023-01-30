package pk;

import java.util.Random;

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
            player_obj.RandRoll_Hand();
            //System.out.print("After re-rolling, ");
            player_obj.Calculate_TurnScore();
            //DisplayStats(player_obj);
            //System.out.print("\n");
            round_factor = true;
        }

        else{

            // Player will choose to end their turn by choice if <3skulls
            if(!(player_obj.are3Skulls())){
                //System.out.println(player_obj.name + " has chosen to end their turn.");
                player_obj.total_score += player_obj.turn_score;
                //System.out.println(player_obj.name + "'s total Score: " + player_obj.total_score + " points");
                //System.out.println("\n");
                player_obj.turn_score = 0;
            }

            // Player is forced to end turn if >=3 skulls are present
            else{
                player_obj.turn_score = 0;
                //System.out.print(player_obj.name + " has rolled 3 or more skulls: ");
                //player_obj.displayCurrentHand();
                //System.out.println(player_obj.name + "'s total score did not increase: " + player_obj.total_score);
                //System.out.println("Therefore, " + player_obj.name + "'s turn ends!");
                //System.out.println("\n");
            }
            round_factor = false;
        }
        return round_factor;
        // always return decision of turn to method call
    }
}
