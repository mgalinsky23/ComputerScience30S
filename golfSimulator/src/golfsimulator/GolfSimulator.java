/** Required package class namespace */
package golfsimulator;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * GolfSimulator - create a golf game application that uses a two-dimensional
 * array (matrix) representing 4 golfers playing 9 holes of golf (4 X 9 matrix)
 * to store 36 randomly generated golf scores (integer values 1 through 9), and
 * display the contents of the matrix. The golfer with the lowest number of
 * strokes on a hole wins the hole. Allow the user to enter (through an input
 * dialog) the hole number, and the application will display in a message dialog
 * which golfer won the hole (or show tie if the hole was tied).
 *
 * @author Michelle Galinsky
 * @since Nov 24, 2023
*/
public class GolfSimulator
{
    
    static final String TITLE      = "Golf Simulator";
    static final Font   FONT       = new Font("Consolas",Font.PLAIN,13);
    static final Color  BACKGROUND = new Color(238,238,238);
    static final Color  FOREGROUND = new Color(0,0,0);

    
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
        // Create graphical display area with formatted text to put in dialog
        JTextArea area = formatArea(text);
        // Store the user's response in a variable from what they clicked on
        // when the dialog appears only showing "yes" and "no" buttons for 
        // the user to choose from  
        int response = JOptionPane.showConfirmDialog(null,area,TITLE,
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (response == JOptionPane.YES_OPTION) return true;
        else                                    return false;
    }
    
    /**
     * Asks the user for a string input in a input dialog box
     * 
     * @param text the text for the dialog box
     * @return a valid string
     */
    private static String input(String text) {
        // Create graphical display area with formatted text to put in dialog
        JTextArea area = formatArea(text);
        // Store the user's response in a variable from what they typed into
        // a input dialog
        String    value = JOptionPane.showInputDialog(null, 
                area,TITLE,JOptionPane.PLAIN_MESSAGE);
        // Create an error message if they user did not enter a value correctly
        final String ERROR = "Error, please enter again\n\n";
        // Force a loop if the user left the dialog empty and clicked "ok" or
        // they clicked "cancel" or the "X"
        while (value == null || value.equals("")) {
            // Recreate the graphical display area
            area  = formatArea(ERROR + text);
            value = JOptionPane.showInputDialog(null,area,TITLE,
                    JOptionPane.PLAIN_MESSAGE);
        }
        return value;           // Once they have entered a value, return it
    }
    
    /**
     * Asks the user for a number (integer) in a input dialog box
     * 
     * @param text the text for the dialog box
     * @return a valid integer
     */
    private static int inputInteger(String text) {
        String value = input(text);     // Get user's response
        // Create an error message if they user did not enter a value correctly
        final String ERROR = "Error, please enter again\n\n";
        // Force a loop if the user did not enter a valid integer
        while (isInteger(value) == false) {
            value = input(ERROR + text);
        }
        int number = Integer.parseInt(value);       // Convert to integer
        return number;                              // Return number value
    }
    
    /**
     * Checks the value to see if it contains numerical characters or a "-"
     * 
     * @param value the string of characters to check
     * @return is a number (true) or not (false)
     */
    private static boolean isInteger(String value) {
        // Convert string into array of char values (built-in string method)
        char[] characters = value.toCharArray();
        // Loop (traverse) through this array from start to end
        for (int i = 0; i < characters.length; i++) {      
            // Read in the character at this index
            char character = characters[i];
            // Use built-in method to see if this character is a digit (0-9)
            if (Character.isDigit(character) == false) {
                // Character was not a digit, but is it the negative sign 
                if (characters[i] != '-') {
                    return false;       // Not a valid character for a integer
                }
            }
        }
        return true;                    // All characters valid for a integer
    }
    
    /**
     * Outputs text in a more visual graphical dialog 
     * 
     * @param text the text to display
     */
    private static void output(String text) {
        // Create graphical display area with formatted text to put in dialog
        JTextArea area = formatArea(text);
        // Add the display area to the dialog to show the user
        JOptionPane.showMessageDialog(null,area,TITLE,
                JOptionPane.PLAIN_MESSAGE);        
    }
    
    /**
     * Sets up a fancy display area for the text to display
     * 
     * @param text the string of text to format
     * @return the formatted text area for display
     */
    private static JTextArea formatArea(String text) {
        // Create a graphics object to display the graphical things
        JTextArea area = new JTextArea();
        // Assign the global variable font, colors, and passed text to the area
        area.setFont(FONT);
        area.setBackground(BACKGROUND);
        area.setForeground(FOREGROUND);
        area.setText(text);
        return area;
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
     * Checks to make sure the number is in the range
     * 
     * @param number the number to check
     * @param low lowest in the range
     * @param high highest in the range
     * @return in range (true) or not (false)
     */
    private static boolean inRange(int number, int low, int high) {
        if (number >= low && number <= high) return true;
        return false;
    }
        
    /**
     * Generate a random number (a double) in a range
     * 
     * @param low the lowest double in the range
     * @param high the highest double in the range
     * @return random double in the range
     */
    private static double random(double low, double high) {
        return (high - low + 1d) * Math.random() + low;
    }
    
    /**
     * Generate a random number (an integer) in a range
     * 
     * @param low the lowest integer in the range
     * @param high the highest integer in the range
     * @return random integer in the range
     */
    private static int random(int low, int high) {
        return (int)(random((double)low, (double)high));
    }
    
    /**
     * Presents an input dialog with a drop down selection of options
     * 
     * @param text the text to show in the dialog
     * @param options the array of option to have in the drop down
     * @return the option they choose
     */
    private static String choices(String text, String[] options) {
        // Create graphical display area with formatted text to put in dialog
        JTextArea area = formatArea(text);
        // Add display area to dialog to show user which gives a drop-down
        // in the dialog and returns an "object"
        Object object = JOptionPane.showInputDialog(null, area, TITLE, 
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (object == null)  return "";                 // User selects "X"
        else                 return object.toString();  // Return user's choice
    }
    
    /**
     * Generates a matrix of random integers in the range between low and high
     * 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @param rows the number of rows (down) to make the matrix 
     * @param columns the number of columns (across) to make the matrix
     * @return an array of random integers
     */
    private static int[][] random(int low, int high, int rows, int columns) {
        int[][] matrix = new int[rows][columns];    // Create empty matrix
        for (int row = 0; row < rows; row++) {                  // Travel rows
            for (int column = 0; column < columns; column++) {  // and columns
                matrix[row][column] = random(low, high);        // Assign value
            }
        }
        return matrix;                              // Return completed matrix
    }
    
    /**
     * Formats the matrix into a string that could be outputted
     * 
     * @param matrix the array to format
     * @return a string of formatted text
     */
    private static String toString(int[][] matrix) {
        String text = "";                          // Variable to store array
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                text += matrix[row][column] + " \t";
            }
            text += "\n";
        }
        return text;
    }
    
    static final int HOLES = 9;
    static final int PLAYERS = 4;
    
    static int[][] scores = new int [PLAYERS][HOLES];    // Matrix stores score
    
    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        start();                                            // Welcome screen
        do {
            String message = createScoreCard();             // Adding the scores
            message += "\nPlease make a selection from the options below...";
            final String[] OPTIONS = {
                "Play a round of golf",
                "Find the winner of a hole",
                "Quit"
            };                                              // User options
            String selection = choices(message, OPTIONS);   // User menu
            
            if (selection.equals(OPTIONS[0])){
                playRound();
            }
            else if(selection.equals(OPTIONS[1])){
                findWinner();
            }
            else if(selection.equals(OPTIONS[2])){
                end();
            }
        } while(true);                               // Intentional endless loop    
    }
    
    /**
     * Creates the score card
     * 
     * @return the finishes score card
     */
    private static String createScoreCard() {
        // Drawing the header for the scorecard
        String text = "\t\t";
        for (int hole = 1; hole <= HOLES; hole++) {
            text += "Hole " + hole + "\t";
        }
        
        // Now draw all the scores for all the players...
        for (int player = 0; player < PLAYERS; player++) {
            text += "\nPlayer " + (player+1) + ":\t";
            for (int hole = 0; hole < HOLES; hole++) {
                text += scores[player][hole] + "\t";
            }
        }
        text += "\n\n";
        // Return the completed score card
        return text;
    }
    
    /**
     * Simulates a round of golf with random cores between 1 and 9
     */
    private static void playRound() {
        scores = random(1, 9, PLAYERS, HOLES);
        output("Scores have been simulated!");
    }
    
    /**
     * Asks the user for a hole number, it error checks that number to make
     * sure it is between 1 and the total number of holes. Then it looks at all
     * the players for that hole and determines which player has the lowest 
     * score. If two or more players have that low score, then the hole is a 
     * tie. Then the result will be displayed to the user
     */
    private static void findWinner() {
        int hole = inputInteger("Enter the hole number:");  // Store hole to examine
        if (inRange(hole, 1, HOLES) == false){              // Check the hole number
            output("Hole " + hole + " is invalid!");        // Error message
        }
        else{                                               // Hole is valid
            hole--;                         // Adjust the variable for array indexing
            int lowest = scores[0][hole];   // Remembers the lowest score
            int winner = 0;                 // Track the winning player
            boolean tie = false;            // Tracks a tie or not (flag)
            // Travel through all the players and examine the hole 
            // that the user provided
            for (int player = 0; player < PLAYERS; player++) {
                // Check if a new low score is in the score card
                if(scores[player][hole] < lowest){
                    lowest = scores[player][hole];
                    winner = player;
                    tie = false;            // Flag that tie no longer occurs
                }
                else if(scores[player][hole] == lowest){
                    tie = true;             // Flag that a tie is happening
                }
            }
            // Adjust the variables again for zero indexing
            winner++;
            hole++;
            // Show the user the results
            if(tie){
                output("Tie score of " + lowest + " on hole " + hole);
            }
            else{
            output("Player " + winner + " has won hole " + hole 
                    + " with a score of " + lowest);
            }
        }
    }
}