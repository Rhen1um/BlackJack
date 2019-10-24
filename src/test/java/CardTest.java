import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void testToString() {
        Card card1 = new Card(5, Suit.Club);
        Card card2 = new Card(10, Suit.Spade);
        Card card3 = new Card(11, Suit.Diamond);
        Card card4 = new Card(13, Suit.Heart);
        System.out.println(card1.toString());
        System.out.println(card2.toString());
        System.out.println(card3.toString());
        System.out.println(card4.toString());

    }
}