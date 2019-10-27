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
            for (int i = 0 ; i < player.getHandCount(); i++){
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
                    if (playerValue > 21){
                        result = Result.LOSE;
                    }
                }
                playerHands[i].setResult(result);
            }
        } else {
            for (int i = 0; i < player.getHandCount(); i++){
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

    /**
     * @author HavenTong
     * @param bet The bet of the current hand
     * @return
     */
    public boolean addHand(int bet){
        return player.addHand(bet);
    }

    /**
     * @author HavenTong
     * initialize the Hands of player and dealer
     */
    public void initDeal(){
        Card dealerFirstCard = deck.deal();
        Card dealerSecondCard = deck.deal();
        dealer.createHand(dealerFirstCard, dealerSecondCard);
        PlayerHand[] playerHands = player.getPlayerHands();
        for (int i = 0; i < player.getHandCount(); i++){
            Card playerFirstCard = deck.deal();
            Card playerSecondCard = deck.deal();
            playerHands[i].addCard(playerFirstCard);
            playerHands[i].addCard(playerSecondCard);
        }
    }

    /**
     * proceed hit or stay
     * @param hit
     */
    public void hitOrStay(boolean hit){
        if (hit){
            Card nextCard = deck.deal();
            player.hit(nextCard);
        } else {
            player.stay();
        }

    }

    /**
     * judge dealer is BlackJack
     * @return
     */
    public boolean dealerIsBlackJack(){
        return dealer.getHand().isBlackJack();
    }


    /**
     * get the results of money in an array
     * @return
     */
    public int[] getPlayerMoneyResults(){
        int handCount = player.getHandCount();
        DealerHand dealerHand = (DealerHand) dealer.getHand();
        PlayerHand[] playerHands = player.getPlayerHands();
        int[] moneyResults = new int[handCount];
        judgeResult();
        for (int i = 0; i < player.getHandCount(); i++){
            Result result = playerHands[i].getResult();
            int previousResult = playerHands[i].getBet();
            int betResult = playerHands[i].getBet();
            switch (result){
                case WIN:
                    if (playerHands[i].isBlackJack()){
                        betResult += betResult;
                    } else {
                        betResult = 0;
                    }
                    break;
                case LOSE:
                    betResult = -betResult;
                    break;
                default:
                    break;
            }
            player.addMoney(previousResult + betResult);
            moneyResults[i] = betResult;
        }
        return moneyResults;
    }

    /**
     * clear dealer and player and shuffle the deck for next game
     */
    public void clear(){
        deck.shuffle();
        player.clearHands();
        dealer.clearHand();
    }

}
