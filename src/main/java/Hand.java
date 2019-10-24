import java.util.ArrayList;
import java.util.List;

/**
 * @author HavenTong
 * @date 2019-10-24 16:15
 */
public class Hand {

    private List<Card> cards;

    Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int calculateValue(){
        return 0;
    }

    public boolean isBlackJack(){
        return false;
    }

    public boolean isBurst(){
        return false;
    }
}
