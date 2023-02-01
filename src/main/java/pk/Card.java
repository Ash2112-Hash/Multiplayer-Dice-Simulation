package pk;

import java.util.*;

public class Card {

    public Card_Faces card_suite;

    public static List<Card_Faces> card_Collection = new ArrayList<Card_Faces>();

    public Card(Card_Faces card_val) {
        this.card_suite = card_val;

    }

    public Card_Faces getSuite(){
        Card_Faces Cardval_copy = this.card_suite;
        return Cardval_copy;

    }

    public static List<Card_Faces> setCardDeck(){
        List<Card_Faces> deck = new ArrayList<Card_Faces>();

        for(int i = 0; i < 6; i++){
            deck.add(Card_Faces.SEA_BATTLE);
        }

        for(int y = 0; y < 29; y++){
            deck.add(Card_Faces.nop);
        }

        card_Collection = deck;
        return card_Collection;

    }

}
