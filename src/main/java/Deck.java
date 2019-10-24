import java.util.Random;

public class Deck {
    private Card[] cards;
    // 此处修改了类图中的属性名
    private boolean[] isValid;

    // Deck
    Deck() {
        cards = new Card[52];
        isValid = new boolean[52];
        for(int i = 0; i < 52; i++) {
            isValid[i] = true;
        }
    }

    // set the all valid to true
    public void shuffle() {
        for (int i = 0; i < 52; i++) {
            isValid[i] = true;
        }
    }

    public Card deal() {
        Random random = new Random();
        int randomCard = random.nextInt(52);
        isValid[randomCard] = false;
        return cards[randomCard];
    }

}
