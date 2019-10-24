import java.util.Random;

public class Deck {
    private Card[] cards;
    // 此处修改了类图中的属性名
    private boolean[] isValid;

    /**
     * post: get a new Deck
     */
    Deck() {
        cards = new Card[52];
        isValid = new boolean[52];
        for(int i = 0; i < 52; i++) {
            isValid[i] = true;
        }
        int cnt = 0;
        for(int i = 0; i < 13; i++) {
            cards[cnt++] = new Card(i + 1, Suit.Club);
            cards[cnt++] = new Card(i + 1, Suit.Diamond);
            cards[cnt++] = new Card(i + 1, Suit.Spade);
            cards[cnt++] = new Card(i + 1, Suit.Heart);
        }
    }

    // set the all valid to true
    public void shuffle() {
        for (int i = 0; i < 52; i++) {
            isValid[i] = true;
        }
    }

    // return a card in random
    public Card deal() {
        Random random = new Random();
        int randomCard = random.nextInt(52);
        isValid[randomCard] = false;
        return cards[randomCard];
    }

    //
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck.deal().toString());
        System.out.println(deck.deal().toString());
    }

}
