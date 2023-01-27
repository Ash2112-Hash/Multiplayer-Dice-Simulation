package pk;

import java.util.Random;

public class Game {
    public Player player_1;
    public Player player_2;
    private double player1_WinCount;
    private double player2_WinCount;

    //Note: All commented code was used for debugging purposes to show the progress of the game in stdout

    public Game(Player p1, Player p2){
        this.player_1 = p1;
        this.player_2 = p2;
        //System.out.println("Player 1: " + player_1.name);
        //System.out.println("Player 2: " + player_2.name);
    }


    public void startGame(){
        int game_count = 42;

        for(int actual_count = 0; actual_count < game_count; actual_count++) {
            //System.out.println("#####----- Starting Game: " + (actual_count+1) + " -----#####");
            set_PlayerHands(player_1);
            boolean player1_continueFactor;
            boolean player2_continueFactor;

            while (player_1.total_score < 6000 && player_2.total_score < 6000) {
                do {
                    player1_continueFactor = DecideTurn(player_1);
                } while (player1_continueFactor);

                if(player_1.total_score < 6000){
                    set_PlayerHands(player_2);
                }
                else{
                    break;
                }

                do {
                    player2_continueFactor = DecideTurn(player_2);
                } while (player2_continueFactor);

                if(player_2.total_score < 6000){
                    set_PlayerHands(player_1);
                }

                else{
                    break;
                }
            }
            End_Game();
            //System.out.println("#####----- End of Game: " + (actual_count+1) + " -----#####" + "\n");
            player_1.Reset_Stats();
            player_2.Reset_Stats();
        }

        ScoreBoard();
    }

    public void make_turn(Player player_obj){
        //System.out.println("Now, " + player_obj.name + " randomly re-rolls their dice!");
        player_obj.RandRoll_Hand();
        //System.out.print("After re-rolling, ");
        player_obj.Calculate_TurnScore();
        //DisplayStats(player_obj);
        //System.out.print("\n");
    }

    public void set_PlayerHands(Player player_obj){
        //System.out.println("Now, " + player_obj.name + " rolls a new hand!");
        player_obj.setHand();
        player_obj.Calculate_TurnScore();
        //System.out.print("After rolling all 8, ");
        //DisplayStats(player_obj);
        //System.out.println("\n");
    }


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

    public boolean DecideTurn(Player player_obj) {
        Random random_generator = new Random();
        int random_number = random_generator.nextInt(2) + 1;
        boolean round_factor;

        if(random_number==2 && player_obj.are3Skulls()){
            make_turn(player_obj);
            round_factor = true;
        }

        else{
            if(player_obj.are3Skulls()){
                //System.out.println(player_obj.name + " has chosen to end their turn.");
                player_obj.total_score += player_obj.turn_score;
                //System.out.println(player_obj.name + "'s total Score: " + player_obj.total_score + " points");
                //System.out.println("\n");
                player_obj.turn_score = 0;
            }

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
    }

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
