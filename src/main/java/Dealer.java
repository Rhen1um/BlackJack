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
    DealerHand hand;

    public Dealer(){

    }

    public DealerHand getHand() {
        return hand;
    }

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
        hand = new DealerHand(cardList);
    }

    /**
     * The dealer is operated by computer. We need autoHit
     * to automatically choose whether hit or not.
     * This should be called by BlackJackGame class.
     */
    public void autoHit(BlackJackGame blackJackGame) {
        while (hand.calculateValue() < 17) {
            // TODO: get a card from the Deck through BlackJackGame
            Card card = blackJackGame.getCard();
            hand.addCard(card);
        }
    }

    /**
     * After a round of game, we should clear the hand.
     */
    public void clearHand() {
        hand = null;
    }
}
