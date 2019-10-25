/**
 * @author HavenTong
 * @date 2019-10-24 17:34
 */
public class BlackJackGame {
    private Deck deck;
    private Dealer dealer;
    private Player player;

    public BlackJackGame() {
        this.deck = new Deck();
        this.dealer = new Dealer();
        this.player = new Player();
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
     * @author HavenTong
     * compare playerHands with Dealer's hand and judge the result
     * @return
     */
    public void judgeResult(){
        Hand dealerHand = dealer.getHand();
        PlayerHand[] playerHands = player.getPlayerHands();
        Result result;
        if (!dealerHand.isBlackJack()){
            for (int i = 0 ; i < playerHands.length; i++){
                /* player BlackJack */
                if (playerHands[i].isBlackJack()){
                    result = Result.WIN;
                } else {
                    int playerValue = playerHands[i].calculateValue();
                    int dealerValue = dealerHand.calculateValue();
                    if (playerValue > dealerValue){
                        result = Result.WIN;
                    } else if (playerValue < dealerValue){
                        result = Result.LOSE;
                    } else {
                        result = Result.DRAW;
                    }
                }
                playerHands[i].setResult(result);
            }
        } else {
            for (int i = 0; i < playerHands.length; i++){
                if (playerHands[i].isBlackJack()){
                    result = Result.DRAW;
                } else {
                    result = Result.LOSE;
                }
                playerHands[i].setResult(result);
            }
        }
    }

    /**
     * @author HavenTong
     * get card from the deck
     */
    public Card getCard(){
        return deck.deal();
    }


}
