/**
 * @author YueChen
 * @version 1.0
 * @date 2019/10/24 17:34
 */
public class Player {
    private int money;
    private PlayerHand[] playerHands;
    private int handCount;
    private int currentHand;

    /**
     * Player's init money is 1000
     */
    Player() {
        money = 1000;
        handCount = 0;
        playerHands = new PlayerHand[5];
        currentHand = 0;
    }

    public PlayerHand[] getPlayerHands() {
        return playerHands;
    }

    public void addHand(int bet) {
        playerHands[handCount++] = new PlayerHand(bet);
    }

    public void stay() {
        currentHand++;
    }

    public void hit(Card card) {
        playerHands[currentHand].addCard(card);
    }


    public void clearHands() {
        playerHands = null;
        currentHand = 0;
        handCount = 0;
    }
}
