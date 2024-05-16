/** Required package class namespace */
package simpleprogram;

import javax.swing.JOptionPane;

/**
 * SimpleProgram - This program performs the ‘simplest’ of computer operations,
 * being: INPUT → PROCESS → OUTPUT. This means that input will just input
 * something from the user, and then output will output the something.
 *
 * @author Michelle Galinsky
 * @since Oct 16, 2023
 */
public class SimpleProgram {

    static String TITLE = "The Simple Program";

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        start(TITLE);
        String something = input("Enter Something: ", TITLE);
        output("You entered " + something, TITLE);
        end(TITLE);
    }

    /**
     * Display the starting message
     *
     * @param TITLE the title displayed in the message
     */
    private static void start(String title) {

        output("Welcome to The Simple Program", TITLE);
    }

    /**
     * Displays an input dialog box for the user to enter something
     *
     * @param something the text entered by the user
     * @param TITLE the title displayed in the message
     * @return the text entered by the user
     */
    private static String input(String text, String title) {
        String something = JOptionPane.showInputDialog(null, text, TITLE,
                JOptionPane.PLAIN_MESSAGE);
        return something;
    }

    /**
     * Displays a message with the text inputted by the user
     *
     * @param thing the text inputted by the user
     * @param TITLE the title displayed in the message
     */
    private static void output(String thing, String title) {
        JOptionPane.showMessageDialog(null,
                thing,
                TITLE,
                JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Displays the ending message
     *
     * @param TITLE the title displayed in the message
     */
    private static void end(String title) {

        output("Thanks for using The Simple Program", TITLE);
    }

}
