package pk;

// Import the required libraries for the PiratenKarpen class
import java.util.Arrays;
import java.util.List;
import java.util.Random;


// The CLManager class is used to analyze and manage input commands from the CLI to dictate players strategy and optional trace mode for game execution
public class CLManager {

    private final String[] CL_args;
    // A string array representing the CLI args of the object of the class

    // Constructor method for creating a CLManager object by accepting command_args array as argument
    public CLManager(String[] command_args) {
        this.CL_args = command_args;
    }


    // Analyze_CLArgs method will combine both the Check_TraceMode and SetGameStrategy method to commence the game based on inputs from CLI
    public void Analyze_CLArgs(Game PKgame){
        Check_TraceMode(Arrays.asList(this.CL_args));
        SetGameStrategy(Arrays.asList(this.CL_args), PKgame);
    }


    // Check_TraceMode method will determine if trace mode has been activated within CLI
    public static void Check_TraceMode(List<String> CL_args){
        if(CL_args.contains("trace_mode")){
            ProjectLog.log_factor = true;
        }

    }


    // SetGameStrategy method will set the game's strategy based on input in CLI
    // random: random strategy, combo: maximize combos strategy
    // If the user does not specify, it will randomly choose one from the choices available
    public static void SetGameStrategy(List<String> CL_args, Game game_obj){
        if(CL_args.contains("random") || CL_args.contains("combo")){
            game_obj.startGame(CL_args.get(0), CL_args.get(1));
        }

        else{
            String[] choices = new String[]{"combo", "random"};
            int random_choice = new Random().nextInt(choices.length);
            game_obj.startGame(choices[random_choice], choices[random_choice]);
        }

    }


}
