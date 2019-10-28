import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author JJAYCHEN
 * @date 2019/10/24 5:29 下午
 */
public class GameView {
    Scanner s = new Scanner(System.in);

    /**
     * print the welcome information. Called when the game starts.
     */
    public void printWelcomeInformation() {
//        System.out.println("Welcome to BlackJack!");
//        System.out.println("===================================================");
        System.out.println(
                "    +------------------------------+ \n" +
                        "    | ╦ ╦┌─┐┬  ┌─┐┌─┐┌┬┐┌─┐  ┌┬┐┌─┐| \n" +
                        "    | ║║║├┤ │  │  │ ││││├┤    │ │ │| \n" +
                        "    | ╚╩╝└─┘┴─┘└─┘└─┘┴ ┴└─┘   ┴ └─┘| \n" +
                        "    | ╔╗ ┬  ┌─┐┌─┐┬┌─   ╦┌─┐┌─┐┬┌─ | \n" +
                        "    | ╠╩╗│  ├─┤│  ├┴┐   ║├─┤│  ├┴┐ | \n" +
                        "    | ╚═╝┴─┘┴ ┴└─┘┴ ┴  ╚╝┴ ┴└─┘┴ ┴ | \n" +
                        "    +------------------------------+ \n"
        );
    }

    /**
     * print the balance of player.
     *
     * @param balance
     */
    public void printTheBalanceOfPlayer(int balance) {
        System.out.println("You have $" + balance + " now.");
    }

    /**
     * tell play how much he/she wins.
     *
     * @param value how much player wins
     */
    private void printWinBet(int value) {
        System.out.println(" You win $" + value + ".");
    }

    /**
     * tell play how much he/she loses.
     *
     * @param value how much player loses
     */
    private void printLoseBet(int value) {
        value = -value;
        System.out.println(" You lose $" + value + ".");
    }

    /**
     * Called when the game starts, ask the plays how many hands
     * they want to hold. It returns a value between 1 and 5.
     *
     * @return the number of hands that the player wants to hold.
     */
    public int getNumberOfHands() {
        System.out.println("How many hands would you hold?");
        while (true) {
            try {
                System.out.println("Enter the number of hands(no more than 5):");
                int i = s.nextInt();
                if (i <= 0 || i > 5) {
                    System.out.println("Please input a value between 1 and 5.");
                    continue;
                }
                return i;
            } catch (InputMismatchException e) {
                System.out.println("Please input a correct value.");
                s.next(); // 缓冲区的数据还是没有被取出，所以要手动取一下
            }
        }
    }

    /**
     * get the bet value from console. No constrains whether
     * the values is out of range. Just make sure it returns
     * a non-negative int(0 or LARGER than 100).
     *
     * @param index use index to indicate user we are asking for which hand.
     * @return an int value represents the bet. 0 represents give up this hand.
     */
    public int getBetValue(int index) {
        while (true) {
            try {
                System.out.println("Enter bet for hand " + index + "(at least 100):");
                System.out.println("(You can input 0 to skip all left hands)");
                int i = s.nextInt();
                if (i < 0 || i != 0 && i < 100) {
                    System.out.println("Please input a non-negative value(at least 100).");
                    continue;
                }
                return i;
            } catch (InputMismatchException e) {
                System.out.println("Please input a correct value.");
                s.next();
            }
        }
    }

    /**
     * called when the bet value is bigger than the balance of the player.
     * It will tell the player how much they have now and ask for a new value.
     * It makes sure that the new bet is no more than current balance.
     *
     * @param currentBalance the current balance value that player holds.
     * @param index          use index to indicate user we are asking for which hand.
     * @return a new bet value.
     */
    public int printBetOutOfRangeAndGetANewBetValue(int currentBalance, int index) {
        System.out.println("You do not have enough money! Please enter a valid value again.");
        printTheBalanceOfPlayer(currentBalance);
        int result = getBetValue(index);
        while (result > currentBalance) {
            result = getBetValue(index);
        }
        return result;
    }

    // TODO: if user skip the first hand...?
//    public int printAtLeastOneBetRequired(int index) {
//
//    }

    /**
     * @param dealerCards a String array that contains the descriptions of initial cards of dealer.
     * @param playerCards a String array that contains the descriptions of initial cards of player.
     * @param handIndex   the index of handler
     */
    public void printNewHand(String[] dealerCards, String[] playerCards, int handIndex) {
        System.out.println("=========================================");
        System.out.println("Hand " + handIndex + "...");
        System.out.println("Dealer:");
        System.out.println(" Hidden\n " + dealerCards[1]);
        printPlayerHand(playerCards);
    }

    /**
     * @param playerCards a String array that contains the descriptions of cards of player.
     */
    public void printPlayerHand(String[] playerCards) {
        System.out.println("Player:");
        for (String card : playerCards
        ) {
            System.out.println(" " + card);
        }
    }

    public void printPlayerHand(String[] playerCards, int handIndex) {
        System.out.println("Player(Hand " + handIndex + "):");
        for (String card : playerCards
        ) {
            System.out.println(" " + card);
        }
    }

    public void printPlayerHand(String[] playerCards, int handIndex, String result) {
        printPlayerHand(playerCards, handIndex);
        if (result.equals("BlackJack")) {
            System.out.println("☻ You got Black Jack!");
        } else if (result.equals("Burst")) {
            System.out.println("☹ Burst!");
        } else {
            System.out.println("Sum: " + result);
        }
    }

    /**
     * Called ONLY WHEN dealer finished. Because it won't hidden thr first card.
     *
     * @param dealerCards a String array that contains the descriptions of cards of dealer.
     */
    public void printDealerHand(String[] dealerCards) {
        System.out.println("-----------------------------------------");
        System.out.println("Dealer:");
        for (String card : dealerCards
        ) {
            System.out.println(" " + card);
        }
    }

    public void printDealerHand(String[] dealerCards, String result) {
        printDealerHand(dealerCards);
        if (result.equals("BlackJack")) {
            System.out.println("Dealer got Black Jack!");
        } else if (result.equals("Burst")) {
            System.out.println("Burst!");
        } else {
            System.out.println("Sum: " + result);
        }
    }

    /**
     * ask the user whether hit or stay.
     *
     * @return a bool value, true represents "Hit", false represents "Stay"
     */
    public boolean getHitOrStay() {
        while (true) {
            System.out.println("Hit or stay:");
            String answer = s.next();
            if (answer.toLowerCase().equals("hit")) {
                return true;
            } else if (answer.toLowerCase().equals("stay")) {
                return false;
            } else {
                System.out.println("Please input hit or stay:");
            }
        }
    }

    /**
     * Called when player's hand bursts.
     *
     * @param totalValueOfCards the total value of user's hand.
     */
    public void printPlayerBurst(int totalValueOfCards) {
        System.out.println("Boom! You got " + totalValueOfCards + " points(larger than 21)");
    }

    /**
     * Called when player gets BlackJack.
     */
    public void printPlayerGetsBlackJack() {
        System.out.println("☻ Congratulations! You got a BlackJack!");
    }

    /**
     * Called when dealer gets BlackJack.
     */
    public void printDealerGetsBlackJack() {
        System.out.println("Dealer gets BlackJack!");
    }

    /**
     * print the result of each hand and print the current balance.
     *
     * @param result
     * @param currentBalance
     */
    public void printTheResultOfGame(int[] result, int currentBalance) {
        for (int i = 0; i < result.length; i++) {
            System.out.println("Hand " + (i + 1) + ":");
            if (result[i] < 0) printLoseBet(result[i]);
            else printWinBet(result[i]);
        }
        printTheBalanceOfPlayer(currentBalance);
    }

    public boolean getWhetherStartNextGame(int currentBalance) {
        System.out.println("Do you want another round?(y/n)");
        while (true) {
            String answer = s.next();
            if (answer.toLowerCase().equals("y") || answer.toLowerCase().equals("yes")) {
                if (currentBalance < 100) {
                    System.out.println("☹︎ Sorry, you do not have enough money.");
                    return false;
                }
                return true;
            } else if (answer.toLowerCase().equals("n") || answer.toLowerCase().equals("no")) {
                System.out.println("Game Over.");
                return false;
            } else {
                System.out.println("Please input yes or no:");
            }
        }
    }
}
