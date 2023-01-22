package pk;

public class Game {
    public Player player_1;

    public Game(Player p1){
        System.out.println("Welcome to Piraten Karpen Simulator!");
        this.player_1 = p1;
        System.out.println("Player 1: " + player_1.getName());
    }


    public void startGame(){
        set_PlayerHands();
        boolean player_continue = player_1.count_skulls();

        while(player_continue){
            make_turn(player_1);
            player_continue = player_1.count_skulls();

        }

        end_turn(player_1);

    }


    public void make_turn(Player player_obj){
        System.out.println("Now, " + player_obj.getName() + " randomly re-rolls their dice!");
        player_obj.RandRoll_Hand();
        System.out.print("After re-rolling, ");
        player_obj.Calculate_TurnScore();
        DisplayStats(player_obj);
        System.out.print("\n");


    }

    public void set_PlayerHands(){
        System.out.println("First, " + player_1.getName() + " rolls all eight dices. ");
        player_1.setHand();
        player_1.Calculate_TurnScore();
        System.out.print("After rolling all 8, ");
        DisplayStats(player_1);
        System.out.println("\n");

    }

    public void end_turn(Player player_obj){
        System.out.print(player_obj.getName() + " has rolled 3 or more skulls: ");
        player_obj.displayCurrentHand();
        player_obj.total_score += player_obj.getTurnScore();
        System.out.println(player_obj.getName() + "'s Final Score: " + player_obj.getTotalScore());
        System.out.println("Therefore, " + player_obj.getName() + "'s turn ends!");


    }

    public void DisplayStats(Player player_obj){
        System.out.print(player_obj.getName() + "'s current hand: ");
        player_obj.displayCurrentHand();
        System.out.println(player_obj.getName() + "'s Current Score: " + player_obj.getTurnScore());
    }


}
