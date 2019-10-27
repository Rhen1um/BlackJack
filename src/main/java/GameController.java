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
        while (this.playGame());
    }

    private boolean playGame() {
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
        //庄家是bj
        if(blackJackGame.dealerIsBlackJack()) {
            gameView.printDealerGetsBlackJack();
        }
        //庄家不是bj
        else {
            for(int i = 0; i < numberOfHands; i++) {
                String[] dealHandCards = blackJackGame.getDealer().getHand().getCardsString();
                String[] playHandCards = playerHands[i].getCardsString();
                gameView.printNewHand(dealHandCards, playHandCards, i + 1);
                //玩家是bj
                if(playerHands[i].isBlackJack()) {
                    gameView.printPlayerGetsBlackJack();
                    continue;
                }

                //玩家不是bj
                boolean hit = true;
                while (hit) {
                    hit = gameView.getHitOrStay();
                    blackJackGame.hitOrStay(hit);
                    playHandCards = playerHands[i].getCardsString();
                    gameView.printPlayerHand(playHandCards);
                    if(playerHands[i].isBurst()) {
                        gameView.printPlayerBurst(playerHands[i].calculateValue());
                        blackJackGame.getPlayer().stay();
                        break;
                    }
                }
            }
            blackJackGame.getDealer().autoHit(blackJackGame);
        }


        gameView.printDealerHand(blackJackGame.getDealer().getHand().getCardsString());
        for(int i = 0; i < numberOfHands; i++) {
            gameView.printPlayerHand(playerHands[i].getCardsString(),i+1);
        }

        int[] results = blackJackGame.getPlayerMoneyResults();
        gameView.printTheResultOfGame(results, blackJackGame.getPlayer().getMoney());

        blackJackGame.clear();

        // 问一下是否继续
        boolean isContinue = gameView.getWhetherStartNextGame(blackJackGame.getPlayer().getMoney());
        return isContinue;
    }


    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
