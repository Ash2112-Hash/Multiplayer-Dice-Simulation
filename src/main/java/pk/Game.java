package pk;
import java.util.Random;
// Import random for implementing random functionality within players actions in the game

// The Game class is used to establish the main aspects and underlying functionality of the game
public class Game {
    //Important Note: All commented out print statements and code were used for debugging purposes to show the progress of the game in stdout

    public Player player_1;
    public Player player_2;
    // Associate two objects from the Player class (player 1 and 2) with the Game object

    private double player1_WinCount;
    private double player2_WinCount;
    // Two double variables associated with player 1 and player 2's number of wins



    // Constructor for Game object
    // Accepts 2 player objects as parameters for the game
    public Game(Player p1, Player p2){
        player_1 = p1;
        player_2 = p2;
        //System.out.println("Player 1: " + player_1.name);
        //System.out.println("Player 2: " + player_2.name);
    }


    // Essential method of the Game class used to commence the game between both players
    // Utilizes the below methods in a specific manner to emulate the main aspects of the game: player score, draws, rerolls, wins
    public void startGame(){
        int game_count = 42;

        // major loop used to create a specific number of games to be played: ie 42 games
        for(int actual_count = 0; actual_count < game_count; actual_count++) {
            //System.out.println("#####----- Starting Game: " + (actual_count+1) + " -----#####");
            set_PlayerHand(player_1);
            boolean player1_continueFactor;
            boolean player2_continueFactor;

            // will continue the game for both players until either one of them have surpassed the score threshold
            while (player_1.total_score < 6000 && player_2.total_score < 6000) {
                do {
                    player1_continueFactor = DecideTurn(player_1);
                } while (player1_continueFactor);

                if(player_1.total_score < 6000){
                    set_PlayerHand(player_2);
                }
                else{
                    break;
                }

                do {
                    player2_continueFactor = DecideTurn(player_2);
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
            player_1.Reset_Stats();
            player_2.Reset_Stats();
        }

        ScoreBoard();
        // After 42 games, percentage of wins are displayed
    }


    // set_PlayerHand method is used to set the hand of each player during the start of the game and the start of their new turn
    // If a player ends their turn (by choice or >=3 skulls), this method is responsible for rolling a new hand
    public void set_PlayerHand(Player player_obj){
        //System.out.println("Now, " + player_obj.name + " rolls a new hand!");
        player_obj.Roll8Dice();
        player_obj.Calculate_TurnScore();
        //System.out.print("After rolling all 8, ");
        //DisplayStats(player_obj);
        //System.out.println("\n");
    }


    //End_Game method used to determine which Player has won once game has ended
    public void End_Game(){
        //System.out.println("The game has ended!");
        if(player_1.total_score >= 6000 && player_2.total_score >= 6000){
            //System.out.println(player_1.name + " and " + player_2.name + " have both reached 6000 points!");
            //System.out.println("Therefore, the game is a tie!");
            player1_WinCount += 0;
            player2_WinCount += 0;
        }

        else if(player_1.total_score >= 6000){
            //System.out.println(player_1.name + " has reached 6000 points!");
            //System.out.println("Therefore, Winner is " + player_1.name);
            player1_WinCount++;
        }

        else{
            //System.out.println(player_2.name + " has reached 6000 points!");
            //System.out.println("Therefore, Winner is " + player_2.name);
            player2_WinCount++;
        }
    }

    // DecideTurn is a major method responsible for deciding the turn of each player
    // Based on a coin toss random logic, each player would either reroll or decide to end their turn by choice. In the case of 3 skulls, player will automatically end their turn
    // The decision of the turn will be returned as boolean value (used in the start_Game method)
    public boolean DecideTurn(Player player_obj) {
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

    //ScoreBoard method will calculate and display percentage of wins of each player at the end of 42 games
    public void ScoreBoard(){
        double p1_winrate = (player1_WinCount/42)*100;
        double p2_winrate = (player2_WinCount/42)*100;
        System.out.println("####--- Players Win Rates ---####");
        System.out.printf(player_1.name + ": %.2f %s" + "\n", p1_winrate, "%");
        System.out.printf(player_2.name + ": %.2f %s" + "\n", p2_winrate, "%");
    }


    /* Used for debugging purposes!
    public void DisplayStats(Player player_obj){
        System.out.print(player_obj.name + "'s current hand: ");
        player_obj.displayCurrentHand();
        System.out.println(player_obj.name + "'s Current Score from Hand: " + player_obj.turn_score + " points");
    }
    */

}
