/** Required package class namespace */
package housebuilder;

import javax.swing.JOptionPane;

/**
 * HouseBuilder - Write a program to draw a house from characters. The program
 * will get input from the user to determine the width of the base and adjust
 * the roof and walk accordingly. For example, if the user entered a house width
 * of 6, the house would have a base width of 6 and a base height of 1⁄2 the
 * width or 3. The roof will similarly have a width of 6 and a height of 3. The
 * walk will also have a length of 6.
 *
 * @author Michelle Galinsky
 * @since Oct 24, 2023
 */
public class HouseBuilder {
    // REUSABLE VARIABLES and METHODS (below this line)........................

    static final String TITLE = "House Builder";

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        start();
        program();
        end();
    }

    /**
     * Starts the application and welcomes user with a dialog
     */
    private static void start() {
        // Call output to generate a dialog and attach the title global variable
        output("Welcome to " + TITLE);
    }

    /**
     * Ends the application with a dialog and terminates the application
     */
    private static void end() {
        // Call output dialog and attach global title then terminate the app
        output("Thanks for using " + TITLE);
        System.exit(0);                                 // Terminates the app
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

    /**
     * Asks the user for a string input in a input dialog box
     *
     * @param text the text for the dialog box
     * @return a valid string
     */
    private static String input(String text) {
        // Store the user's response in a variable from what they typed into
        // a input dialog
        String value = JOptionPane.showInputDialog(null,
                text, TITLE, JOptionPane.QUESTION_MESSAGE);
        // Create an error message if they user did not enter a value correctly
        final String ERROR = "Error, please enter again\n\n";
        // Force a loop if the user left the dialog empty and clicked "ok" or
        // they clicked "cancel" or the "X"
        while (value == null || value.equals("")) {
            // Have the user enter again (with error message attached)
            value = JOptionPane.showInputDialog(null, ERROR + text, TITLE,
                    JOptionPane.QUESTION_MESSAGE);
        }
        // Once they have entered a value, return it
        return value;
    }

    /**
     * Asks the user for a number (integer) in a input dialog box
     *
     * @param text the text for the dialog box
     * @return a valid integer
     */
    private static int inputInteger(String text) {
        // Store user's response from what they inputted in a dialog
        String value = input(text);
        // Create an error message if they user did not enter a value correctly
        final String ERROR = "Error, please enter again\n\n";
        // Force a loop if the user left the dialog empty
        while (value.equals("")) {
            value = input(ERROR + text);
        }
        // Now convert what the user entered into an integer
        int number = Integer.parseInt(value);
        return number;        // Then return that number value      
    }

    /**
     * Outputs text in a more visual graphical dialog
     *
     * @param text the text to display
     */
    private static void output(String text) {
        JOptionPane.showMessageDialog(null, text, TITLE,
                JOptionPane.PLAIN_MESSAGE);
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
     * Determines if a number if odd or even
     *
     * @param number the number to check
     * @return true (if even), false (if odd)
     */
    private static boolean isEven(int number) {
        if (number % 2 == 0) {      // Number divides evenly by zero
            return true;
        } else {                      // Number does not divide evenly by zero
            return false;
        }
    }

    // PROBLEM SPECIFIC VARIABLES and METHODS (below this line)................
    static final String BLOCK = "*";
    static final String SPACE = " ";
    static final String WALL = "|";
    static final String FLOOR = "_";
    static final String ROOF_LEFT = "/";
    static final String ROOF_RIGHT = "\\";

    /**
     * The logic to draw a house and ask the user if they want to play again
     */
    private static void program() {
        //House builder

        do {
            // Get the base(width) from the user
            int base = inputInteger("Enter a base:");
            //Only accepts even numbers
            if (isEven(base) == false) {
                output("Please enter a proper number");
            } else {
                //Draw the house
                int height = base / 2;
                roof(base, height);
                house(base, height);
                sidewalk(base);
            }
        } while (playAgain() == true);

    }

    /**
     * Draws (using sout) the roof certain height and width using "/" for the
     * left side of the roof, and a "\" for the right, and a "_" for the bottom
     *
     * @param width the width of the roof
     * @param height the height of the roof
     */
    private static void roof(int width, int height) {
        // Draw the top of the roof...
        int spaces = width / 2 - 1;                 // Used for leading spaces
        // continually draw levels of the roof
        for (int level = 0; level < height - 1; level++) {
            for (int i = 0; i < spaces; i++) {      // The leading spaces first
                System.out.print(SPACE);
            }
            spaces--;                               // Advanced the spaces
            // Now the roof level
            System.out.print(ROOF_LEFT);            // Draw a wall
            for (int i = 0; i < level * 2; i++) {   // Draw the floor
                System.out.print(SPACE);
            }
            System.out.println(ROOF_RIGHT);         // Draw a wall
        }
        // Drawing the bottom of the roof...
        System.out.print(ROOF_LEFT);                // Draw a wall
        for (int i = 0; i < width - 2; i++) {       // Draw the floor
            System.out.print(FLOOR);
        }
        System.out.println(ROOF_RIGHT);             // Draw a wall
    }

    /**
     * Draws (using sout) the roof certain height and width using "/" for the
     * left side of the roof, and a "\" for the right, and a "_" for the bottom
     * -with the spaces in between
     *
     * @param width the width of the house
     * @param height the height of the house
     */
    private static void house(int width, int height) {
        // Draw all other walls
        for (int wall = 0; wall < height - 1; wall++) {
            System.out.print(WALL);                 // Draw a wall
            for (int i = 0; i < width - 2; i++) {   // Draw the floor
                System.out.print(SPACE);
            }
            System.out.println(WALL);               // Draw a wall
        }
        // Drawing the bottom walls and floor...
        System.out.print(WALL);                     // Draw a wall
        for (int i = 0; i < width - 2; i++) {       // Draw the floor
            System.out.print(FLOOR);
        }
        System.out.println(WALL);                   // Draw a wall
    }

    /**
     * Draws the sidewalk with a step first (with two "*") of "*" of a certain
     * width
     *
     * @param width the width of the walk
     */
    private static void sidewalk(int width) {
        int numberOfSpaces = width / 2;
        // Draw some leading spaces first...
        for (int i = 0; i < numberOfSpaces - 1; i++) {
            System.out.print(SPACE);
        }
        System.out.println(BLOCK + BLOCK);          // Draw the "step"
        // Draw some leading steps first...
        for (int i = 0; i < numberOfSpaces - 1; i++) {
            System.out.print(SPACE);
        }
        for (int i = 0; i < width; i++) {           // Draw the sidewalk
            System.out.print(BLOCK);
        }
        System.out.println("");                     // And a line break
    }
}
