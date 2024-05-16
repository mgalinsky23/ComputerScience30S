/** Required package class namespace */
package studentgradestatistics;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * StudentGradeStatistics - Create a program to track student score statistics.
 * The program should ask for the number of students in the class, then ask for
 * grades for each student. From this data, the program calculates four things:
 * 1. The maximum score entered 2. The minimum score entered 3. The average of
 * the scores entered (the mean) 4. The standard deviation
 *
 * @author Michelle Galinsky
 * @since Nov 27, 2023
 */
public class StudentGradeStatistics {

    static String title = "Standard Deviation";

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        output("Welcome to Standard Deviation");
        do {
            int num = inputInteger("Enter the number of students in the class:");
            double grades[] = new double[num];
            String grade = gradesDisplay(grades);
            output("Student Scores:\n\n"
                    + show(grades) + grade);
        } while (playAgain() == true);
        output("Thanks for using Standard Deviation");

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
     * Displays the minimum and maximum values
     *
     * @param array the student grades
     * @return the min and max values
     */
    private static String show(double[] array) {
        String text = "";
        double answersMin = 0;
        double answersMax = 0;
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            text += "Student " + count + " = " + array[i] + "\n";
            count++;
            answersMin = findMin(array);
            answersMax = findMax(array);
        }

        text = text + "\nMaximum score = " + answersMax + "\n";
        text = text + "Minimum score = " + answersMin + "\n";

        return text;
    }

    /**
     * Finds the minimum value in the array
     *
     * @param array the student grades
     * @return the minimum value
     */
    private static double findMin(double[] array) {
        double low = 100;
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
     * @param array the student grades
     * @return the maximum value
     */
    private static double findMax(double[] array) {
        final double HIGH = 0;
        double num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > HIGH) {
                num = array[i];
            }
        }
        return num;
    }

    /**
     * Asks the user for a string input in a input dialog box
     *
     * @param text the text for the dialog box
     * @return a valid string
     */
    private static String input(String text) {
        String value = JOptionPane.showInputDialog(null,text,
                title, JOptionPane.QUESTION_MESSAGE);
        final String ERROR = "Error, please enter again\n\n";
        while (value == null || value.equals("")) {
            value = JOptionPane.showInputDialog(null, text, title,
                    JOptionPane.PLAIN_MESSAGE);
        }
        return value;
    }

    /**
     * Asks the user for a number (integer) in a input dialog box
     *
     * @param text the text for the dialog box
     * @return a valid integer
     */
    private static int inputInteger(String text) {
        String value = input(text);
        final String ERROR = "Error, please enter again\n\n";
        while (isInteger(value) == false) {
            value = input(ERROR + text);
        }
        int num = Integer.parseInt(value);
        return num;
    }

    /**
     * Checks the value to see if it contains numerical characters or a "-"
     *
     * @param value the string of characters to check
     * @return is a number (true) or not (false)
     */
    private static boolean isInteger(String value) {
        char[] characters = value.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];
            if (Character.isDigit(character) == false) {
                if (characters[i] != '-') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks the value to see if it contains numerical characters or a "-" or a
     * "."
     *
     * @param value the string of characters to check
     * @return is a number (true) or not (false)
     */
    private static boolean isDouble(String value) {
        char[] characters = value.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];
            if (Character.isDigit(character) == false) {
                if (characters[i] != '.' &&
                    characters[i] != '-') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Displays the grades of the students, average score and standard deviation
     *
     * @param array the grades of the students
     * @return a string with the values from above
     */
    private static String gradesDisplay(double[] array) {
        String text = "";
        int count = 1;
        for (int i = 0; i < array.length; i++) {

            double grade = inputDouble("Enter the grade for student " + count);
            while (grade > 100 || grade <= 0) {
                output("Invalid grade!");
                grade = inputDouble("Enter the grade for student " + count);
            }

            array[i] = grade;
            count++;

        }
        double average = averageGrade(array);
        double deviation = standardDeviation(array, average);

        text = "Average score = " + average
                + "\nStandard Deviation = " + deviation;
        return text;
    }

    /**
     * Calculates the average
     *
     * @param array the values used for calculating the average
     * @return the average of all the students
     */
    private static double averageGrade(double[] array) {
        double average = 0;
        for (int i = 0; i < array.length; i++) {
            average += array[i];
        }
        average = average / array.length;

        return average;
    }

    /**
     * Calculates the standard deviation
     *
     * @param array the values used to calculate the standard deviation
     * @param average the value used to calculate the standard deviation
     * @return the standard deviation
     */
    private static double standardDeviation(double[] array, double average) {

        // the elements of the equation...
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + Math.pow(array[i], 2);
        }
        double numerator = sum;
        double denominator = array.length;
        double mean = average;
        double fraction = numerator / denominator;
        double value = fraction - Math.pow(mean, 2);
        double answer = Math.sqrt(value);

        return answer;
    }

    /**
     * Asks the user for a double in an input dialog box
     *
     * @param text the text for the dialog box
     * @return the number
     */
    private static double inputDouble(String text) {
        String value = input(text);
        final String ERROR = "Error, please enter again\n\n";
        while (isDouble(value) == false) {
            value = input(ERROR + text);
        }
        double num = Double.parseDouble(value);
        return num;
    }

}
