import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author JJAYCHEN
 * @date 2019/10/24 5:29 下午
 */
public class GameView {
    Scanner s = new Scanner(System.in);

    /**
     * print the welcome information. called when the game stars.
     */
    public void printWelcomeInformation() {
        System.out.println("Welcome to BlackJack!");
    }


    public void printTheBalanceOfPlayer(int balance) {
        System.out.println("You have $" + balance + "now.");
    }

    /**
     * Called when the game stars, ask the plays how many hands
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
     * a non-negative int.
     *
     * @return an int value represents the bet.
     */
    public int getBetValue() {
        while (true) {
            try {
                System.out.println("Enter bet:");
                System.out.println("(You can input 0 to skip all left hands)");
                int i = s.nextInt();
                if (i < 0) {
                    System.out.println("Please input a non-negative value.");
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
     * @return a new bet value.
     */
    public int printBetOutOfRangeAndGetANewBetValue(int currentBalance) {
        System.out.println("You do not have enough money! Please enter a valid value again.");
        printTheBalanceOfPlayer(currentBalance);
        return getBetValue();
    }
}
