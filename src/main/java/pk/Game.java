package pk;

import java.util.Random;

public class Game {
    public Player player_1;
    public Player player_2;

    public Game(Player p1, Player p2){
        System.out.println("Welcome to Piraten Karpen Simulator!");
        this.player_1 = p1;
        this.player_2 = p2;
        System.out.println("Player 1: " + player_1.getName());
        System.out.println("Player 2: " + player_2.getName());
    }


    public void startGame(){
        set_PlayerHands(player_1);
        boolean cont; boolean cont2;

        while(player_1.total_score < 6000 && player_2.total_score < 6000){
            do {
                cont = DecideTurn(player_1);
            }while(cont);


            set_PlayerHands(player_2);
            do {
                cont2 = DecideTurn(player_2);
            }while(cont2);

            set_PlayerHands(player_1);


        }
        End_Game();


    }

    public void make_turn(Player player_obj){
        System.out.println("Now, " + player_obj.getName() + " randomly re-rolls their dice!");
        player_obj.RandRoll_Hand();
        System.out.print("After re-rolling, ");
        player_obj.Calculate_TurnScore();
        DisplayStats(player_obj);
        System.out.print("\n");
    }

    public void set_PlayerHands(Player player_obj){
        System.out.println("Now, " + player_obj.getName() + " rolls all eight dices. ");
        player_obj.setHand();
        player_obj.Calculate_TurnScore();
        System.out.print("After rolling all 8, ");
        DisplayStats(player_obj);
        System.out.println("\n");
    }

    public void EndTurn_Skulls(Player player_obj){
        player_obj.turn_score = 0;
        System.out.print(player_obj.getName() + " has rolled 3 or more skulls: ");
        player_obj.displayCurrentHand();
        System.out.println(player_obj.getName() + "'s total score did not increase: " + player_obj.getTotalScore());
        System.out.println("Therefore, " + player_obj.getName() + "'s turn ends!");
        System.out.println("\n");
    }

    public void EndTurn_noSkulls(Player player_obj){
        System.out.println(player_obj.getName() + " has chosen to end their turn.");
        player_obj.total_score += player_obj.turn_score;
        System.out.println(player_obj.getName() + "'s total Score: " + player_obj.getTotalScore() + " points");
        System.out.println("\n");
        player_obj.turn_score = 0;
    }

    public void DisplayStats(Player player_obj){
        System.out.print(player_obj.getName() + "'s current hand: ");
        player_obj.displayCurrentHand();
        System.out.println(player_obj.getName() + "'s Current Score from Hand: " + player_obj.getTurnScore() + " points");
    }

    public void End_Game(){
        System.out.println("The game has ended!");
        if(player_1.total_score >= 6000 && player_2.total_score >= 6000){
            System.out.println(player_1.name + " and " + player_2.name + " have both reached 6000 points!");
            System.out.println("Therefore, the game is a tie!");
        }

        else if(player_1.total_score >= 6000){
            System.out.println(player_1.name + " has reached 6000 points!");
            System.out.println("Therefore, Winner is " + player_1.name);
        }

        else{
            System.out.println(player_2.name + " has reached 6000 points!");
            System.out.println("Therefore, Winner is " + player_2.name);
        }
    }

    public boolean DecideTurn(Player player_obj) {
        Random random_generator = new Random();
        int random_number = random_generator.nextInt(2) + 1;
        boolean round_factor;

        if(random_number==2 && player_obj.count_skulls()){
            make_turn(player_obj);
            round_factor = true;
        }

        else{
            if(player_obj.count_skulls()){
                EndTurn_noSkulls(player_obj);
            }
            else{
                EndTurn_Skulls(player_obj);
            }
            round_factor = false;
        }
        return round_factor;
    }

}
