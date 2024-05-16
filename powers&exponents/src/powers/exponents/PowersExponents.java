/** Required package class namespace */
package powers.exponents;

import javax.swing.JOptionPane;

/**
 * PowersExponents - Write a method power(base,exponent) which calculates the
 * power of a base to an exponent.
 *
 * @author Michelle Galinsky
 * @since Oct 17, 2023
 */
public class PowersExponents {

    static String TITLE = "Powers and Exponents";

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        start(TITLE);
        do {
            int numB = input("Enter a base: ", TITLE);
            int numE = input("Enter an exponent: ", TITLE);
            int answer = power(numB, numE);
            output("The base " + numB + " to the exponent of "
                    + numE + " = " + answer, TITLE);
        } while (playAgain() == true);
        end(TITLE);

    }

    /**
     * Displays the starting message
     *
     * @param TITLE the title displayed in the message
     */
    private static void start(String TITLE) {
        output("Welcome to Powers and Exponents", TITLE);
    }

    /**
     * Displays an input dialog box for the user to enter the base and exponent
     *
     * @param text the base and exponent
     * @param TITLE the title displayed in the message
     * @return the answer
     */
    private static int input(String text, String TITLE) {
        String inputUser = JOptionPane.showInputDialog(null, text, TITLE,
                JOptionPane.PLAIN_MESSAGE);
        int num = Integer.parseInt(inputUser);
        return num;
    }

    private static int power(int base, int exponent) {
        int answer = 1;
        for (int i = 1; i <= exponent; i++) {
            answer = answer * base;
        }
        return answer;
    }

    /**
     * Displays the answer
     *
     * @param text the answer
     * @param TITLE the title displayed in the message
     */
    private static void output(String text, String TITLE) {
        JOptionPane.showMessageDialog(
                null,
                text,
                TITLE,
                JOptionPane.PLAIN_MESSAGE
        );
    }

    /**
     * Displays the ending message
     *
     * @param TITLE the title displayed in the message
     */
    private static void end(String TITLE) {
        JOptionPane.showMessageDialog(
                null,
                "Thanks for using Powers and Exponents",
                TITLE,
                JOptionPane.PLAIN_MESSAGE
        );
    }

    /**
     * Displays a message to the user to see if they want to continue playing
     *
     * @param text the question displayed
     * @param TITLE the title displayed in the message
     */
    private static boolean playAgain() {
        // Send the yesNo method the play again message
        return yesNo("Do you want to play again?");
    }

    /**
     * Ask the user a yes and no question, in a confirm dialog box
     *
     * @param text the yes no question to ask in the dialog
     * @return true (yes), false (no)
     */
    private static boolean yesNo(String text) {
        // Store the user's response in a variable from what they clicked on
        // when the dialog appears only showing "yes" and "no" buttons for 
        // the user to choose from         
        int response = JOptionPane.showConfirmDialog(null, text, TITLE,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            return true;            // The user's response picked yes
        } else {
            return false;           // The user's response picked no
        }
    }
}
