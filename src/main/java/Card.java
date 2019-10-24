/**
 * Spade: ♠, Heart: ♥, Diamond: ♦, Club: ♣
 */
enum Suit {
    Spade, Heart, Diamond, Club
}

public class Card {
    /**
     * value in [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13].
     */
    private int value;

    /**
     * suit in [Spade, Heart, Diamond, Club].
     */
    private Suit suit;

    /**
     * Constructor
     *
     * @param value value of the card.
     * @param suit  suit of the card.
     */
    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * example: "♠ Spade Jack", "♠ Spade 10".
     * @return a complete string represents the card.
     */
    @Override
    public String toString() {
        // TODO: toString method.
        return getCardSuitAsCharacter() + " " + getCardSuitName() + " " + getCardName();
    }

    /**
     * Get the raw vale of a card.
     *
     * @return the raw value of the card as int.
     */
    public int getValue() {
        return value;
    }

    /**
     * Get the suit as enum type.
     *
     * @return the suit as enum type.
     */
    public Suit getSuit() {
        return suit;
    }


    /**
     * Get the name of the card, based on its value.
     * if 1 <= value <= 10, it returns its value as name.
     * if value equals 11, 12, 13, it returns "Jack",
     * "Queen", "King" respectively.
     *
     * @return name of the card, based of its value.
     */
    public String getCardName() {
        switch (value) {
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return Integer.toString(value);
        }
    }

    /**
     * get the name of the suit of card by using suit.toString.
     * @return the name of the suit of a card.
     */
    public String getCardSuitName(){
        return suit.toString();
    }

    /**
     * Spade: ♠, Heart: ♥, Diamond: ♦, Club: ♣
     * @return a character represents the suit.
     */
    public String getCardSuitAsCharacter(){
        switch(suit){
            //Spade: ♠, Heart: ♥, Diamond: ♦, Club: ♣
            case Spade:
                return "♠";
            case Heart:
                return "♥";
            case Diamond:
                return "♦";
            case Club:
                return "♣";
            default:
                return "";
        }
    }
}
