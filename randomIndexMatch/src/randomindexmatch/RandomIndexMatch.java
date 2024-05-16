/** Required package class namespace */
package randomindexmatch;

import javax.swing.JOptionPane;

/**
 * RandomIndexMatch - Create a matching index and element application that
 * allows the user to enter the size of an array, and then randomly fills each
 * element of the array with a number that has a 1 in 10 chance of being the
 * same value as the index itself. This means it will be a random number in a
 * range between five less than the index and five more than the index. The
 * program also counts how many times that the program generated an index value
 * that matched the index itself. Then the program displays the array and the
 * number of matches.
 *
 * @author Michelle Galinsky
 * @since Nov 21, 2023
 */
public class RandomIndexMatch {

    static String title = "Random Index Match";

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        output("Welcome to Random Index Match");
        do {
            int num = input("Please enter the size of the array to generate:");
            int l = -5;
            int h = num + 4;
            int[] nums = randomNumbers(l, h, num);
            display(nums, num);
        } while (playAgain() == true);
        output("Thanks for using Random Index Match");

    }

    /**
     * Displays a message
     *
     * @param text the text in the message
     * @param TITLE the title displayed in the message
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

    /**
     * Displays the array and the number of matches
     * 
     * @param array the random numbers displayed
     * @param number the number of indices
     */
    private static void display(int[] array, int number) {
        String text = "The array of size " + number + ":\n\n";
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            text = text + "Index " + i + " :    " + array[i] + "\n";
            if (i == array[i]) {
                count++;
            }
        }
        text = text + "\nIndex matches = " + count;

        output(text);
    }

    /**
     * Asks the user for a number (integer) in a input dialog box
     *
     * @param text the text for the dialog box
     * @return a valid integer
     */
    private static int input(String text) {
        // Store user's response from what they inputted in a dialog
        String value = JOptionPane.showInputDialog(null,
                text, title, JOptionPane.QUESTION_MESSAGE);;
        // Create an error message if they user did not enter a value correctly
        final String ERROR = "Error, please enter again\n\n";
        // Force a loop if the user left the dialog empty
        while (value.equals("")) {
            value = JOptionPane.showInputDialog(null,
                    ERROR + text, title, JOptionPane.QUESTION_MESSAGE);;
        }
        // Now convert what the user entered into an integer
        int number = Integer.parseInt(value);
        return number;        // Then return that number value      
    }

    /**
     * Generate an array of a set size filled with random integers in the range
     * between low and high
     *
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @param size the size to make the array
     * @return an array of random integers
     */
    private static int[] randomNumbers(int low, int high, int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = randomNumbers(low, high);
        }
        return numbers;
    }

    /**
     * Generates a random number in range between two numbers
     *
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return random number less than or equal to the low and greater than or
     * equal to the high
     */
    private static int randomNumbers(int low, int high) {
        double seed = Math.random();
        double L = (double) low;
        double H = (double) high;
        double number = (H - L + 1) * seed + L;
        return (int) number;
    }

}
