import java.util.ArrayList;
import java.util.List;

/**
 * @author JJAYCHEN
 * @date 2019/10/24 5:32 下午
 */
public class Dealer {
    /**
     * the hand that dealer holds.
     */
    Hand hand;

    /**
     * Provide two initial cards, and create a new
     * hand based on them.
     *
     * @param firstCard  first initial card
     * @param secondCard second initial card
     */
    public void createHand(Card firstCard, Card secondCard) {
        List<Card> cardList = new ArrayList<Card>();
        cardList.add(firstCard);
        cardList.add(secondCard);
        hand = new Hand(cardList);
    }

    public void autoHit() {
        while (hand.calculateValue() < 17) {
            // TODO: get a card from the Deck through BlackJackGame
            Card card = BlackJackGame.getCard;
            hand.addCard(card);
        }
    }

    public void clearHand() {
        hand = null;
    }
}
