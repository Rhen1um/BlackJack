import java.util.List;

/**
 * @author HavenTong
 * @date 2019-10-24 16:21
 */
public class PlayerHand extends Hand {
    private int bet;
    private int result;

    // win or lose or draw
    private enum Result{
        LOSE, WIN, DRAW
    }

    public PlayerHand(List<Card> cards, int bet) {
        super(cards);
        this.bet = bet;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
