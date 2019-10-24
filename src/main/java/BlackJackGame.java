/**
 * @author HavenTong
 * @date 2019-10-24 17:34
 */
public class BlackJackGame {
    private Deck deck;
    private Dealer dealer;
    private Player player;

    public BlackJackGame(Deck deck, Dealer dealer, Player player) {
        this.deck = deck;
        this.dealer = dealer;
        this.player = player;
    }

    public Deck getDeck() {
        return deck;
    }

    public Dealer getDealer() {
        return dealer;
    }


    public Player getPlayer() {
        return player;
    }

    /**
     * compare playerHands with Dealer's hand and judge the result
     * @param playerHands
     * @return
     */
    public Result judgeResult(Hand[] playerHands){
        return Result.DRAW;
    }

    public Card getCard(){
        return new Card(1,Suit.Club);
    }


}
