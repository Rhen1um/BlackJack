import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MufanTest {

    @Test
    void testDeck() {
        Deck deck = new Deck();
        System.out.println(deck.deal().toString());
        System.out.println(deck.deal().toString());
        System.out.println(deck.deal().toString());
        System.out.println(deck.deal().toString());
        System.out.println(deck.deal().toString());
        System.out.println(deck.deal().toString());
        System.out.println(deck.deal().toString());
        System.out.println(deck.deal().toString());
    }
}
