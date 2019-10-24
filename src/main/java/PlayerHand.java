import java.util.List;

/**
 * The result of a hand (win or lose or draw)
 */
enum Result{
    LOSE, WIN, DRAW
}
/**
 * @author HavenTong
 * The hand of Player
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
