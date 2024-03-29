import java.util.ArrayList;
import java.util.List;

/**
 * @author HavenTong
 * @date 2019-10-24 16:15
 */
public class Hand {

    private List<Card> cards;

    /**
     * constructor with no parameters.
     */
    public Hand(){
        cards = new ArrayList<Card>();
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * @author JJAYCHEN
     * Add a new card to the hand.
     * @param card the new card to be added.
     */
    public void addCard(Card card){
        cards.add(card);
    }

    /**
     * @author HavenTong
     * Calculate the sum value of Hand
     * @return
     */
    public int calculateValue(){
        int sum = 0;
        int aceNum = 0;
        for (Card card : cards){
            int value = card.getValue();
            if (value > 10){
                value = 10;
            } else if (value == 1){
                aceNum++;
                value = 11;
            }
            sum += value;
        }
        while (aceNum > 0){
            if (sum > 21){
                sum -= 10;
                aceNum--;
             } else
                 break;
        }
        return sum;
    }

    /**
     * @author HavenTong
     * judge whether the hand is BlackJack
     * @return
     */
    public boolean isBlackJack(){
        if (cards.size() != 2) return false;
        int sum = calculateValue();
        return sum == 21;
    }

    /**
     * @author HavenTong
     * judge whether it is burst
     * @return
     */
    public boolean isBurst(){
        return calculateValue() > 21;
    }


    public String[] getCardsString() {
        int size = cards.size();
        String[] cardString = new String[size];
        for (int i = 0; i < cardString.length; i++){
            cardString[i] = cards.get(i).toString();
        }
        return cardString;
    }

    /**
     * get the Condition of the Hand
     * @return
     */
    public String getCondition(){
        boolean isBlackJack = isBlackJack();
        String result = "";
        if (isBlackJack){
            result = "BlackJack";
        } else {
            int value = calculateValue();
            if (value > 21){
                result = "Burst";
            } else {
                result = String.valueOf(value);
            }
        }
        return result;
    }
}
