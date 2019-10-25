/**
 * @author YueChen
 * @version 1.0
 * @date 2019/10/24 18:08
 */
public class GamblingHouse {
    private GameView gameView;
    private BlackJackGame blackJackGame;

    GamblingHouse() {
        gameView = new GameView();
        this.gameView = gameView;
    }

    public void createGame() {
        blackJackGame = new BlackJackGame();
    }


    public static void main(String[] args) {
        GamblingHouse gamblingHouse = new GamblingHouse();

    }
}
