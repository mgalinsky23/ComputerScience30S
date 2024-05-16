package dicegame;

import javax.swing.JOptionPane;

/**
 * Description - A group of people is betting on the three throws of a die. A
 * person bets $1 on predicting the outcome of the three throws. Write a program
 * using random numbers (between 1 – 6) that simulates 3 throws of a die and
 * displays the winnings according to these rules: - All 3 throws are sixes: win
 * $20 - All 3 throws are the same (but not sixes): win $10 - Any 2 of the three
 * throws are the same: win $5 - Otherwise you lose your $1 bet
 *
 * Date - 2023/09/22
 *
 * @author m.galinsky
 */
public class DiceGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Create welcome screen for the user (message dialog box)
        JOptionPane.showMessageDialog(
                null,
                "This program allows betting on the three throws of a \n"
                + "die using random numbers (between 1 – 6). A person \n"
                + "bets $1 on predicting the outcome of the three throws. \n"
                + "The program simulates 3 throws of a die and displays \n"
                + "the winnings according to these rules:\n\n"
                + "1) All 3 throws are sixes: win $20\n"
                + "2) All 3 throws are the same (but not sixes): win $10\n"
                + "3) Any 2 of the three throws are the same: win $5\n"
                + "4) Otherwise you lose your $1 bet",
                "The Dice Game",
                JOptionPane.PLAIN_MESSAGE
        );

        // Create initial variables
        final int LOW = 1;
        final int HIGH = 6;

        // Create the random numbers that will be displayed later
        int one = (int) ((HIGH - LOW + 1) * Math.random() + LOW);
        int two = (int) ((HIGH - LOW + 1) * Math.random() + LOW);
        int three = (int) ((HIGH - LOW + 1) * Math.random() + LOW);

        String win = "You win ";

        // Determine what the user will win, and save that data to a variable
        if (one == 6 && two == 6 && three == 6) {
            win = "You win: $20";
        } else if (one == two && two == three && one == three) {
            win = "You win: $10";
        } else if (one == two || two == three || one == three) {
            win = "You win: $5";
        } else {
            win = "You lose: $1";
        }

        // Display the winnings to the user
        JOptionPane.showMessageDialog(
                null,
                "The dice were rolled...\n\n"
                + "First roll was " + one
                + "\nSecond roll was " + two
                + "\n Third roll was " + three
                + "\n " + win,
                "The Dice Game",
                JOptionPane.PLAIN_MESSAGE
        );

        // Show ending message
        JOptionPane.showMessageDialog(
                null,
                "Thanks for using The Dice Game!",
                "The Dice Game",
                JOptionPane.PLAIN_MESSAGE
        );

    }

}
