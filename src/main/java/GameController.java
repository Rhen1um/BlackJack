/**
 * @author YueChen
 * @version 1.0
 * @date 2019/10/24 18:08
 */
public class GameController {
    private GameView gameView;
    private BlackJackGame blackJackGame;

    GameController() {
        gameView = new GameView();
        this.gameView = gameView;
    }

    public void createGame() {
        blackJackGame = new BlackJackGame();
    }

    public void startGame() {
        gameView.printWelcomeInformation();

    }


    public static void main(String[] args) {
        GameController gamblingHouse = new GameController();
        
    }
}
