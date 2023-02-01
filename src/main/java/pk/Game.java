package pk;
// Import random for implementing random functionality within players actions in the game

// The Game class is used to establish the main aspects and underlying functionality of the game
public class Game {
    //Important Note: All commented out print statements and code were used for debugging purposes to show the progress of the game in stdout

    private final Player player_1;
    private final Player player_2;
    // Associate two objects from the Player class (player 1 and 2) with the Game object


    // Two double variables associated with player 1 and player 2's number of wins
    private static ScoreBoard pk_ScoreChart;


    // Constructor for Game object
    // Accepts 2 player objects as parameters for the game
    public Game(Player p1, Player p2){
        player_1 = p1;
        player_2 = p2;
        pk_ScoreChart = new ScoreBoard(0, 0);
        //System.out.println("Player 1: " + player_1.name);
        //System.out.println("Player 2: " + player_2.name);
    }


    // Essential method of the Game class used to commence the game between both players
    // Utilizes the below methods in a specific manner to emulate the main aspects of the game: player score, draws, rerolls, wins
    public void startGame(){
        ProjectLog.insert_log_message(("Player 1: " + player_1.name), "trace");
        ProjectLog.insert_log_message(("Player 2: " + player_2.name), "trace");

        int game_count = 42;
        Strategy game_strat = new Strategy();
        boolean player1_continueFactor;
        boolean player2_continueFactor;


        // major loop used to create a specific number of games to be played: ie 42 games
        for(int actual_count = 0; actual_count < game_count; actual_count++) {

            //System.out.println("#####----- Starting Game: " + (actual_count+1) + " -----#####");
            ProjectLog.insert_log_message("Starting Game: " + (actual_count+1), "info");
            set_PlayerHand(player_1);
            

            // will continue the game for both players until either one of them have surpassed the score threshold
            while (player_1.total_score < 6000 && player_2.total_score < 6000) {
                do {
                    player1_continueFactor = game_strat.Random_DiceRolls(player_1);
                } while (player1_continueFactor);

                if(player_1.total_score < 6000){
                    set_PlayerHand(player_2);
                }
                else{
                    break;
                }

                do {
                    player2_continueFactor = game_strat.Random_DiceRolls(player_2);
                } while (player2_continueFactor);

                if(player_2.total_score < 6000){
                    set_PlayerHand(player_1);
                }

                else{
                    break;
                }
            }

            // Once a player surpasses score threshold (during a single game), the game is ended and all Player object statistics are reset
            End_Game();
            //System.out.println("#####----- End of Game: " + (actual_count+1) + " -----#####" + "\n");
            ProjectLog.insert_log_message("End of Game: " + (actual_count+1),  "info");

            player_1.Reset_Stats();
            player_2.Reset_Stats();
        }

        pk_ScoreChart.DisplayBoard(player_1, player_2);
        // After 42 games, percentage of wins are displayed
    }


    // set_PlayerHand method is used to set the hand of each player during the start of the game and the start of their new turn
    // If a player ends their turn (by choice or >=3 skulls), this method is responsible for rolling a new hand
    private void set_PlayerHand(Player player_obj){
        //System.out.println("Now, " + player_obj.name + " rolls a new hand!");
        ProjectLog.insert_log_message((player_obj.name + " rolls a new hand!"), "trace");
        player_obj.Roll8Dice();
        ProjectLog.insert_log_message((player_obj.name + "'s new hand: ") + player_obj.getCurrentHand(), "trace");
        player_obj.Calculate_TurnScore();
        ProjectLog.insert_log_message(player_obj.name + "'s Current Score from Hand: " + player_obj.turn_score + " points", "trace");

        //DisplayStats(player_obj);
        //System.out.println("\n");
    }


    //End_Game method used to determine which Player has won once game has ended
    private void End_Game(){
        //System.out.println("The game has ended!");
        if(player_1.total_score >= 6000 && player_2.total_score >= 6000){
            //System.out.println(player_1.name + " and " + player_2.name + " have both reached 6000 points!");
            //System.out.println("Therefore, the game is a tie!");
            ProjectLog.insert_log_message(player_1.name + " and " + player_2.name + " have both reached 6000 points!", "info");
            ProjectLog.insert_log_message("The game is a tie!", "warn");
        }

        else if(player_1.total_score >= 6000){
            //System.out.println(player_1.name + " has reached 6000 points!");
            //System.out.println("Therefore, Winner is " + player_1.name);
            ProjectLog.insert_log_message(player_1.name + " has reached 6000 points!", "info");
            ProjectLog.insert_log_message("Winner is " + player_1.name, "warn");
            pk_ScoreChart.log_Wins(1, 0);
        }

        else{
            ProjectLog.insert_log_message(player_2.name + " has reached 6000 points!", "info");
            ProjectLog.insert_log_message("Winner is " + player_2.name, "warn");
            pk_ScoreChart.log_Wins(0, 1);

            //System.out.println(player_2.name + " has reached 6000 points!");
            //System.out.println("Therefore, Winner is " + player_2.name);
        }
    }

    /* Used for debugging purposes!
    public void DisplayStats(Player player_obj){
        System.out.print(player_obj.name + "'s current hand: ");
        player_obj.displayCurrentHand();
        System.out.println(player_obj.name + "'s Current Score from Hand: " + player_obj.turn_score + " points");
    }
    */

}
