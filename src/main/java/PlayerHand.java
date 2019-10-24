import java.util.List;

enum Result{
    LOSE, WIN, DRAW
}
/**
 * @author HavenTong
 * @date 2019-10-24 16:21
 */
public class PlayerHand extends Hand {
    private int bet;
    private Result result;

    public PlayerHand(List<Card> cards, int bet) {
        super(cards);
        this.bet = bet;
    }

    PlayerHand(int bet) {
        this.bet = bet;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
