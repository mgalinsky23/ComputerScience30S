/** Required package class namespace */
package formattingnumbers;

import javax.swing.JOptionPane;

/**
 * FormattingNumbers - Write a method called formatWithCommas() which takes an
 * integer as a parameter (up to 10 digits) and returns a string which is the
 * number with commas properly placed into the value.
 *
 * @author Michelle Galinsky
 * @since Oct 18, 2023
 */
public class FormattingNumbers {

    static String TITLE = "Formatting Numbers";

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        output("Welcome to Formatting Numbers");
        do {
            int num = input("Enter an integer: ", TITLE);
            String answer = formatWithCommas(num);
            output("Your number is " + answer);
        } while (playAgain() == true);
        output("Thanks for using Formatting Numbers");
    }
    
    /**
     * Asks the user for a number (integer) in a input dialog box
     *
     * @param text the text for the dialog box
     * @param TITLE the title displayed in the dialog box
     * @return 
     */
    private static int input(String text, String TITLE) {
        String inputUser = JOptionPane.showInputDialog(null, text, TITLE,
                JOptionPane.PLAIN_MESSAGE);
        int num = Integer.parseInt(inputUser);
        return num;
    }
    
    /**
     * Takes an integer and returns it as a string with commas 
     * 
     * @param num the integer that will be changed
     * @return the string with commas
     */
    private static String formatWithCommas(int num) {

        String number = "" + num;
        int threeCount = -1;
        String answer = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            threeCount++;
            if (threeCount == 3) {
                answer = answer + ",";
                threeCount = 0;
            }

            // Pulling out each character as a I loop
            char character = number.charAt(i);

            answer = answer + character;
        }

        String finalAnswer = "";
        // reverse the string
        for (int i = answer.length() - 1; i >= 0; i--) {
            finalAnswer = finalAnswer + answer.charAt(i);
        }

        return finalAnswer;
    }
    
    /**
     * Displays any messages
     *
     * @param text the message displayed
     */
    private static void output(String text) {
        JOptionPane.showMessageDialog(
                null,
                text,
                TITLE,
                JOptionPane.PLAIN_MESSAGE
        );
    }
    
    /**
     * Ask the user if they want to play again, in a dialog box
     *
     * @return true (yes, play again), false (no)
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
