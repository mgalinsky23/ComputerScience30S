/** Required package class namespace */
package min.max;

import javax.swing.JOptionPane;

/**
 * MinMax - Create a max and min numbers application that generates an array of
 * 10 random numbers between 1 and 99 and then displays the array elements. The
 * application should then display the highest number in the array, and the
 * lowest number in the array.
 *
 * @author Michelle Galinsky
 * @since Nov 9, 2023
 */
public class MinMax {

    static String title = "Min/Max";

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        output("Welcome to Min/Max");
        do {
            // Creating the array:            
            int[] answers = randomNumbers(1, 99, 10);
            // Displaying the created array:
            show(answers);
        } while (playAgain() == true);
        output("Thanks for using Min/Max");

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
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            return true;            // The user's response picked yes
        } else {
            return false;           // The user's response picked no
        }
    }

    /**
     * Displays an array of random numbers and min and max values
     *
     * @param array the random numbers displayed
     */
    private static void show(int[] array) {
        String text = "Here is your random array...\n\n";
        int answersMin = 0;
        int answersMax = 0;
        for (int i = 0; i < array.length; i++) {
            text = text + "Index " + i + " = " + array[i] + "\n";
            answersMin = findMin(array);
            answersMax = findMax(array);
        }

        text = text + "\nThe minimum value in the array is = " + answersMin + "\n";
        text = text + "The maximum value in the array is = " + answersMax + "\n";

        output(text);
    }

    /**
     * Finds the minimum value in the array
     *
     * @param array random numbers
     * @param num the random numbers at each index
     * @return the min value in the array
     */
    private static int findMin(int[] array) {
        int low = 100;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < low) {
                low = array[i];
            }
        }
        return low;
    }

    /**
     * Finds the maximum value in the array
     *
     * @param array random numbers
     * @param num the random numbers at each index
     * @return the max value in the array
     */
    private static int findMax(int[] array) {
        int high = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > high) {
                high = array[i];
            }
        }
        return high;
    }
}
