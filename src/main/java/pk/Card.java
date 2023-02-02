package pk;

import java.util.*;


// The Card class is used to create and set the card deck of the game
public class Card {
    private Card_Faces card_suite;

    public static List<Card_Faces> card_Collection = new ArrayList<Card_Faces>();
    // card_collection to represent the deck of cards

    // Constructor for the card class
    public Card(Card_Faces card_val) {
        this.card_suite = card_val;

    }

    // SetCardDeck to create and set the game's card deck
    protected static List<Card_Faces> setCardDeck(){
        List<Card_Faces> deck = new ArrayList<Card_Faces>();

        for(int i = 0; i < 6; i++){
            deck.add(Card_Faces.SEA_BATTLE);
        }

        for(int y = 0; y < 25; y++){
            deck.add(Card_Faces.nop);
        }

        for(int z = 0; z < 4; z++){
            deck.add(Card_Faces.MONKEY_BUSINESS);
        }

        card_Collection = deck;
        return card_Collection;

    }

}
