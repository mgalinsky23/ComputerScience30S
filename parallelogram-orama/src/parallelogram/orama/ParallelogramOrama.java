/** Required package class namespace */
package parallelogram.orama;

import javax.swing.JOptionPane;

/**
 * ParallelogramOrama - You must write a Java application that asks the user for
 * a height, width, and character to use. The program will them create a hollow,
 * parallelogram with those dimensions and character.
 *
 * @author Michelle Galinsky
 * @since Nov 2, 2023
 */
public class ParallelogramOrama {

    static String title = "Parallelogram-orama";

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        output("Welcome to Parallelogram-orama");
        do {
            int width = input("Enter width: ", title);
            int height = input("Enter height: ", title);
            String symbol = JOptionPane.showInputDialog(null, "Enter character: ", title,
                    JOptionPane.PLAIN_MESSAGE);
            int line = height;
            drawParallelogram(width, height, symbol);
        } while (playAgain() == true);
        output("Thanks for using Parallelogram-orama");
    }

    /**
     * Asks the user for a number (integer) in a input dialog box
     *
     * @param text the text for the dialog box
     * @param TITLE the title displayed in the dialog box
     * @return
     */
    private static int input(String text, String title) {
        String inputUser = JOptionPane.showInputDialog(null, text, title,
                JOptionPane.PLAIN_MESSAGE);
        int num = Integer.parseInt(inputUser);
        return num;
    }
    
    /**
     * Draws the parallelogram
     * 
     * @param width the width of the parallelogram
     * @param height the height of the parallelogram
     * @param symbol the character used to draw the parallelogram
     */
    private static void drawParallelogram(int width, int height, String symbol) {
        int spaces = height + 1;
        drawLeadingSpaces(spaces);
        drawFilledLine(width, symbol);
        for (int i = 0; i < height; i++) {
            spaces--;
            drawLeadingSpaces(spaces);
            drawHollowLine(width, symbol);
        }
        drawFilledLine(width, symbol);

    }
    
    /**
     * The blank spaces drawn before the parallelogram
     * 
     * @param spaces the blank spaces before the parallelogram
     */
    private static void drawLeadingSpaces(int spaces) {
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
    }
    
    /**
     * The top and bottom parts of the parallelogram
     * 
     * @param width the width of the parallelogram
     * @param symbol the character used to draw the parallelogram
     */
    private static void drawFilledLine(int width, String symbol) {
        for (int i = 0; i < width; i++) {
            System.out.print(symbol);
        }
        System.out.println("");
    }
    
    /**
     * The blank spaces inside of the parallelogram
     * 
     * @param width the width of the parallelogram
     * @param symbol the character used to draw the parallelogram
     */
    private static void drawHollowLine(int width, String symbol) {
        System.out.print(symbol);
        for (int i = 0; i < width - 2; i++) {
            System.out.print(" ");
        }
        System.out.println(symbol);
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
                title,
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
        int response = JOptionPane.showConfirmDialog(null, text, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            return true;            // The user's response picked yes
        } else {
            return false;           // The user's response picked no
        }
    }
}
