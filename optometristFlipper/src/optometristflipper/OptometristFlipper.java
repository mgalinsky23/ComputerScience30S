/** Required package class namespace */
package optometristflipper;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

/**
 * Create a program that starts with the original grid (1, 2, "\n" ,3, 4,), then
 * gives the user the choice to flip vertically or horizontally and displays the
 * original and then the “flipped” grid. The program will then retain the new
 * grid.
 *
 * @author Michelle Galinsky
 * @since Nov 23, 2023
 */
public class OptometristFlipper {

    static String title = "Optometrist Flipper";
    static final Font FONT = new Font("Consolas", Font.PLAIN, 12);
    static final Color BACKGROUND = new Color(238, 238, 238);
    static final Color FOREGROUND = new Color(0, 0, 0);
    static int[][] nums = new int[2][2];
    static int[][] temp = new int[2][2];

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        nums[0][0] = 1;
        nums[0][1] = 2;
        nums[1][0] = 3;
        nums[1][1] = 4;

        // TODO code application logic here
        final String[] CHOICES = {
            "Vertical flip (across the vertical center line)",
            "Horizontal flip (across the horizontal center line",
            "Quit"};

        output("Welcome to Optometrist Flipper");
        String array = "";
        String choice = "";
        String flip = "\nPlease select which type of \"flip\" to make";
        
        do {
            choice = choices("The optometrist chart is:\n" + show(array) + flip, CHOICES);
            if (choice.equals(CHOICES[0])) {
                output(vertical(array));
            } else if (choice.equals(CHOICES[1])) {
                output(horizontal(array));
            }
        } while (!choice.equals(CHOICES[2]));

        output("Thanks for using Optometrist Flipper");
    }

    /**
     * Remembers the original chart
     *
     * @param array the chart
     * @return the chart
     */
    private static String show(String array) {
        
        String num = "";
        num += nums[0][0] + " " + nums[0][1] + "\n";
        num += nums[1][0] + " " + nums[1][1] + "\n";
        return num;
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
                formatArea(text),
                title,
                JOptionPane.PLAIN_MESSAGE
        );
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
        Object object = JOptionPane.showInputDialog(null, area, title,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (object == null) {
            return "";                 // User selects "X"
        } else {
            return object.toString();  // Return user's choice
        }
    }

    /**
     * Flips the original chart vertically
     *
     * @return the flipped chart
     */
    private static String vertical(String array) {
        String text = "The original chart is ...\n" + show(array);
        text += "\nYour new vertical flipped chart is...\n";
        temp[0][0] = nums[0][1];
        temp[0][1] = nums[0][0];
        temp[1][0] = nums[1][1];
        temp[1][1] = nums[1][0];

        nums[0][0] = temp[0][0];
        nums[0][1] = temp[0][1];
        nums[1][0] = temp[1][0];
        nums[1][1] = temp[1][1];

        text += "" + nums[0][0] + " " + nums[0][1] + "\n"
                + nums[1][0] + " " + nums[1][1];

        return text;
    }

    /**
     * Flips the original chart horizontally
     *
     * @return the flipped chart
     */
    private static String horizontal(String array) {
        String text = "The original chart is ...\n" + show(array);
        text += "\nYour new horizontal flipped chart is...\n";
        temp[0][0] = nums[1][0];
        temp[0][1] = nums[1][1];
        temp[1][0] = nums[0][0];
        temp[1][1] = nums[0][1];

        nums[0][0] = temp[0][0];
        nums[0][1] = temp[0][1];
        nums[1][0] = temp[1][0];
        nums[1][1] = temp[1][1];

        text += "" + nums[0][0] + " " + nums[0][1] + "\n"
                + nums[1][0] + " " + nums[1][1];

        return text;
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
}
