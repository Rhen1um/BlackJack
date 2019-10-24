/**
 * @author YueChen
 * @version 1.0
 * @date 2019/10/24 17:34
 */
public class Player {
    private int money;
    private PlayerHand[] playerHands;
    private int handCount;

    /**
     * Player's init money is 1000
     */
    Player() {
        money = 1000;
        handCount = 0;
        playerHands = new PlayerHand[5];
    }

    public PlayerHand[] getPlayerHands() {
        return playerHands;
    }

    public void addHand() {
        PlayerHand[handCount++] = new PlayerHand();
    }

    public void hit() {

    }

    public void clearHands() {

    }
}
