package pk;
import java.util.Random;

public class Dice {

    public Faces dice_value;

    public void roll() {
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        this.dice_value = Faces.values()[bag.nextInt(howManyFaces)];

    }

    public Faces getDiceValue(){
        return this.dice_value;
    }

    
}
