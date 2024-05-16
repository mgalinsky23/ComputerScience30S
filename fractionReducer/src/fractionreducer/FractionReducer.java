/** Required package class namespace */
package fractionreducer;

import javax.swing.JOptionPane;

/**
 * FractionReducer - Write a method to manipulate fractions. Write a method
 * reduce(numerator,denominator) which reduces the fraction. The function should
 * return a string which is the reduced fraction in the form
 * “numerator/denominator”.
 *
 * @author Michelle Galinsky
 * @since Oct 25, 2023
 */
public class FractionReducer {

    static String title = "Fraction Reducer";

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String numN = null;
        String numD = null;
        output("Welcome to Fraction Reducer", title);
        do {
            String fraction = input("Enter the fraction: ", title);
            
            int numerator = getNumerator(fraction);
            int denominator = getDenominator(fraction);
            
            
            //int reduced = reduce(fraction);

            output("The numerator is: " + numerator
                    + "The denominator is: " + denominator
                    + "The reduced fraction is: " + fraction, title);
        } while (playAgain() == true);
        output("Thanks for using Fraction Reducer", title);

    }
    
    /**
     * Displays the answer
     *
     * @param text the answer
     * @param TITLE the title displayed in the message
     */
    private static void output(String text, String title) {
        JOptionPane.showMessageDialog(
                null,
                text,
                title,
                JOptionPane.PLAIN_MESSAGE
        );
    }

    private static String input(String text, String title) {
        String inputUser = JOptionPane.showInputDialog(null, text, title,
                JOptionPane.PLAIN_MESSAGE);
        return inputUser;
    }

    private static int getNumerator(String fraction) {
        System.out.println("numerator... of ---> " + fraction + " is ....");
        for (int i = 0; i < fraction.length(); i++) {
            char character = 0;
            if(character != '/')
            {
                character = fraction.charAt(i);
                String text = character + "";
                int numerator = Integer.parseInt(text);
                System.out.print(text);
            }
        }
        return 0;
    }

    private static int getDenominator(String fraction) {
        System.out.println("Denominator... of ---> " + fraction + " is ....");
        for (int i = 0; i < fraction.length(); i++) {
            char character = 0;
            if(character == '/')
            {
                character = fraction.charAt(i);
                String text = character + "";
                int denominator = Integer.parseInt(text);
                System.out.print(text);
            }
        }
        return 0;
    }
    
    private static int reduce(String numN, String numD) {
        
        return 1;
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
        int response = JOptionPane.showConfirmDialog(null, text, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response == JOptionPane.YES_OPTION) {
            return true;            // The user's response picked yes
        } else {
            return false;           // The user's response picked no
        }
    }

    

}
