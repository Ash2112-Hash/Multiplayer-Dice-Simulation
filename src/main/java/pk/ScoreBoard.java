package pk;


// The ScoreBoard class is used to log, manage and represent the wins of each player
public class ScoreBoard {

    private static double player1_WinCount;
    private static double player2_WinCount;
    //private double variables used to represent of each player respectively


    // Constructor for creating a Scoreboard object
    // Accepts two double values: default wins at beginning is 0
    protected ScoreBoard(double p1_InitialWins, double p2_InitialWins) {
        player1_WinCount = p1_InitialWins;
        player2_WinCount = p2_InitialWins;

    }

    // log_Wins is used to log the number of wins for each player respectively
    protected void log_Wins(double p1_wins, double p2_wins){
        player1_WinCount += p1_wins;
        player2_WinCount += p2_wins;
    }

    // DisplayBoard will display the current scoreboard to stdout
    public void DisplayBoard(Player p1_obj, Player p2_obj){
        double p1_winrate = (player1_WinCount/42)*100;
        double p2_winrate = (player2_WinCount/42)*100;

        System.out.println("####--- Players Win Rates ---####");
        System.out.printf(p1_obj.name + ": %.2f %s" + "\n", p1_winrate, "%");
        System.out.printf(p2_obj.name + ": %.2f %s" + "\n", p2_winrate, "%");
    }

}
