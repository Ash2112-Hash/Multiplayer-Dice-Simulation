package pk;
import java.util.Random;
// Import random for implementing random functionality for dice values

// The Dice class is used to construct and manipulate all Dice object as a part of the game
public class Dice {

    private Faces dice_value;
    // represents the Face value of the Dice object

    // roll() method generates a random dice value for the Dice object
    protected void roll() {
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        this.dice_value = Faces.values()[bag.nextInt(howManyFaces)];


    }

    // getDiceValue() used to return the Dice's value to method call
    // Primarily used within the Player class
    public Faces getDiceValue(){
        Faces diceval_copy = this.dice_value;
        return diceval_copy;
    }

    
}
