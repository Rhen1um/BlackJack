/**
 * @author YueChen
 * @version 1.0
 * @date 2019/10/24 18:08
 */
public class GamblingHouse {
    private GameView gameView;

    GamblingHouse(GameView gameView) {
        this.gameView = gameView;
    }

    public static void main(String[] args) {
        GameView gameView = new GameView();
        GamblingHouse gamblingHouse = new GamblingHouse(gameView);
        
    }
}
