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
        blackJackGame = new BlackJackGame();
    }

    public void startGame() {
        while (true) {
            this.playGame();
        }
    }

    private void playGame() {
        gameView.printWelcomeInformation();
        gameView.printTheBalanceOfPlayer(blackJackGame.getPlayer().getMoney());
        int numberOfHands = gameView.getNumberOfHands();
        for(int i = 0; i < numberOfHands; i++) {
            int bet = gameView.getBetValue(i + 1);
            if(bet == 0) {
                break;
            }
            if(!blackJackGame.addHand(bet)) {
                bet = gameView.printBetOutOfRangeAndGetANewBetValue(blackJackGame.getPlayer().getMoney(), i + 1);
                if(bet == 0) break;
            }
        }
        blackJackGame.initDeal();
        numberOfHands = blackJackGame.getPlayer().getHandCount();
        PlayerHand[] playerHands = blackJackGame.getPlayer().getPlayerHands();
        if(blackJackGame.dealerIsBlackJack()) {
            gameView.printDealerGetsBlackJack();
            gameView.printDealerHand(blackJackGame.getDealer().getHand().getCardsString());
            for(int i = 0; i < numberOfHands; i++) {
                gameView.printPlayerHand(playerHands[i].getCardsString());
            }
            //TODO

        }
        else {
            for(int i = 0; i < numberOfHands; i++) {
                String[] dealHandCards = blackJackGame.getDealer().getHand().getCardsString();
                String[] playHandCards = playerHands[i].getCardsString();
                gameView.printNewHand(dealHandCards, playHandCards, i + 1);
                //TODO
                boolean hit = true;
                while (hit) {
                    hit = gameView.getHitOrStay();
                    blackJackGame.hitOrStay(hit);
                    playHandCards = playerHands[i].getCardsString();
                    gameView.printPlayerHand(playHandCards);
                }
            }
            //TODO
        }
    }


    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
