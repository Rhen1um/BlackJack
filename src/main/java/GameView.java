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
        System.out.println("Welcome to BlackJack!");
        System.out.println("===================================================");
    }

    /**
     * print the balance of player.
     *
     * @param balance
     */
    public void printTheBalanceOfPlayer(int balance) {
        System.out.println("You have $" + balance + "now.");
    }

    /**
     * tell play how much he/she wins.
     *
     * @param value how much player wins
     */
    public void printWinBet(int value) {
        System.out.println("You win $" + value + ".");
    }

    /**
     * tell play how much he/she loses.
     *
     * @param value how much player loses
     */
    public void printLoseBet(int value) {
        System.out.println("You lose $" + value + ".");
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
                System.out.println("Enter bet for hand" + index + "(at least 100):");
                System.out.println("(You can input 0 to skip all left hands)");
                int i = s.nextInt();
                if (i < 0 || i != 0 && i < 100) {
                    System.out.println("Please input a non-negative value(at least 100).");
                    System.out.println("(You can input 0 to skip all left hands)");
                    continue;
                }
                return i;
            } catch (InputMismatchException e) {
                System.out.println("Please input a correct value.");
            }
        }
    }

    /**
     * called when the bet value is bigger than the balance of the player.
     * It will tell the player how much they have now and ask for a new value.
     *
     * @param currentBalance the current balance value that player holds.
     * @param index          use index to indicate user we are asking for which hand.
     * @return a new bet value.
     */
    public int printBetOutOfRangeAndGetANewBetValue(int currentBalance, int index) {
        System.out.println("You do not have enough money! Please enter a valid value again.");
        printTheBalanceOfPlayer(currentBalance);
        return getBetValue(index);
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
        System.out.println("Hand" + handIndex + "...");
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

    /**
     * Called ONLY WHEN dealer finished. Because it won't hidden thr first card.
     *
     * @param dealerCards a String array that contains the descriptions of cards of dealer.
     */
    public void printFinalDealerHand(String[] dealerCards) {
        System.out.println("Dealer:");
        for (String card : dealerCards
        ) {
            System.out.println(" " + card);
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
        System.out.println("Boom! You got " + totalValueOfCards + "points(larger than 21.)");
    }

    /**
     * Called when player gets BlackJack.
     */
    public void printPlayerGetsBlackJack() {
        System.out.println("☻Congratulations! You got a BlackJack!");
    }
}
