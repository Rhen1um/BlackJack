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

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    // if the money is not enough, then return false.
    private boolean cutMoney(int money) {
        if(this.money - money < 0) {
            return false;
        }
        this.money -= money;
        return true;
    }

    public PlayerHand[] getPlayerHands() {
        return playerHands;
    }

    // if the money is not enough, return false and don's add hand.
    public boolean addHand(int bet) {
        if(cutMoney(bet)) {
            playerHands[handCount++] = new PlayerHand(bet);
            return true;
        }
        return false;
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
