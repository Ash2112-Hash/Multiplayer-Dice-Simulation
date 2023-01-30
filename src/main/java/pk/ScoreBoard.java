package pk;

public class ScoreBoard {

    private static double player1_WinCount;
    private static double player2_WinCount;


    protected ScoreBoard(double p1_InitialWins, double p2_InitialWins) {
        player1_WinCount = p1_InitialWins;
        player2_WinCount = p2_InitialWins;

    }

    protected void log_Wins(double p1_wins, double p2_wins){
        player1_WinCount += p1_wins;
        player2_WinCount += p2_wins;
    }

    public void DisplayBoard(Player p1_obj, Player p2_obj){
        double p1_winrate = (player1_WinCount/42)*100;
        double p2_winrate = (player2_WinCount/42)*100;

        System.out.println("####--- Players Win Rates ---####");
        System.out.printf(p1_obj.name + ": %.2f %s" + "\n", p1_winrate, "%");
        System.out.printf(p2_obj.name + ": %.2f %s" + "\n", p2_winrate, "%");
    }

}
