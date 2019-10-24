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

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        // TODO: toString method.
        return "";
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getName() {
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
}
