/**
 * @author YueChen
 * @version 1.0
 * @date 2019/10/24 18:08
 */
public class GameController {
    private GameView gameView;
    private BlackJackGame blackJackGame;


    /**
     * Constructor of the class GameController.
     * Make relation with gameView and blackJackGame.
     */
    GameController() {
        gameView = new GameView();
        blackJackGame = new BlackJackGame();
    }


    /**
     * Process the whole game.
     */
    public void startGame() {
        boolean isContinue = true;
        while (isContinue) {
            this.playGame();
            isContinue = askIfContinue();
        }
    }

    /**
     * Process the single game.
     */
    private void playGame() {
        initGame();

        int numberOfHands = blackJackGame.getPlayer().getHandCount();
        PlayerHand[] playerHands = blackJackGame.getPlayer().getPlayerHands();

        bodyGameHandler(numberOfHands, playerHands);
        getResultOfGame(numberOfHands, playerHands);
    }


    /**
     * Initialize the game: show welcome, get the number of hands and set every hand's bet.E
     */
    private void initGame() {
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
    }


    /**
     * Handle the body of the single game.(hit for dealer and player.)
     * @param numberOfHands: Number of player's hands.
     * @param playerHands: The objects of player's hands.
     */
    private void bodyGameHandler(int numberOfHands, PlayerHand[] playerHands) {
        // When the dealer is BlackJack.
        if(blackJackGame.dealerIsBlackJack()) {
            gameView.printDealerGetsBlackJack();
        }

        // When the dealer is not BlackJack.
        else {
            for(int i = 0; i < numberOfHands; i++) {
                String[] dealHandCards = blackJackGame.getDealer().getHand().getCardsString();
                String[] playHandCards = playerHands[i].getCardsString();
                gameView.printNewHand(dealHandCards, playHandCards, i + 1);

                // When the player in this hand is BlackJack.
                if(playerHands[i].isBlackJack()) {
                    gameView.printPlayerGetsBlackJack();
                    blackJackGame.getPlayer().stay();
                    continue;
                }

                //When the player in this hand is not BlackJack.
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
                    if(playerHands[i].getCards().size() >= 5) {
                        break;
                    }
                }
            }

            blackJackGame.getDealer().autoHit(blackJackGame);
        }
    }

    /**
     * Use blackJackGame to get the game result and use gameView to print the result of the game.
     * @param numberOfHands: Number of player's hands.
     * @param playerHands: The objects of player's hands.
     */
    private void getResultOfGame(int numberOfHands, PlayerHand[] playerHands) {
        gameView.printDealerHand(blackJackGame.getDealer().getHand().getCardsString());
        for(int i = 0; i < numberOfHands; i++) {
            gameView.printPlayerHand(playerHands[i].getCardsString(),i+1);
        }
        int[] results = blackJackGame.getPlayerMoneyResults();
        gameView.printTheResultOfGame(results, blackJackGame.getPlayer().getMoney());
        blackJackGame.clear();
    }

    /**
     * Use gameView to ask user if continue.
     * @return : If user choose continue.
     */
    private boolean askIfContinue() {
        return gameView.getWhetherStartNextGame(blackJackGame.getPlayer().getMoney());
    }


    /**
     * Main function of the whole Program. Create gameController and start the game.
     */
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
