package nitpickie.sovernightdelivery;

import javax.swing.JOptionPane;

/**
 * Description - Nitpickie’s overnight delivery service accepts no package
 * heavier than 27 kilograms, or larger than 0. 1 cubic meters. Write a program
 * that asks for the weight of a package and its dimensions, and displays an
 * appropriate message if the package does not meet the requirements (e.g. too
 * large, too heavy or both).
 *
 * Date - 2023/09/22
 *
 * @author m.galinsky
 */
public class NitpickieSOvernightDelivery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Create welcome screen for the user (message dialog box)
        JOptionPane.showMessageDialog(
                null,
                "Nitpickie’s overnight delivery service accepts no\n"
                + "package heavier than 27 kilograms, or larger than\n"
                + "0.1 cubic meters. Write a program that asks for the\n"
                + "weight of a package and its dimensions, and displays\n"
                + "an appropriate message if the package does not meet\n"
                + "the requirements (e.g. too large, too heavy or both).",
                "Nitpickie's overnight delivery",
                JOptionPane.PLAIN_MESSAGE
        );

        // Get user input (weight in kg) - dialog
        String weight = JOptionPane.showInputDialog(
                null,
                "Enter the wieght of the package in kilograms: ",
                "Nitpickie's overnight delivery",
                JOptionPane.PLAIN_MESSAGE
        );

        // Get user input (length in m) - dialog
        String length = JOptionPane.showInputDialog(
                null,
                "Enter the length of the package in meters: ",
                "Nitpickie's overnight delivery",
                JOptionPane.PLAIN_MESSAGE
        );

        // Get user input (width in m) - dialog
        String width = JOptionPane.showInputDialog(
                null,
                "Enter the width of the package in meters: ",
                "Nitpickie's overnight delivery",
                JOptionPane.PLAIN_MESSAGE
        );

        // Get user input (height in m) - dialog
        String height = JOptionPane.showInputDialog(
                null,
                "Enter the height of the package in meters: ",
                "Nitpickie's overnight delivery",
                JOptionPane.PLAIN_MESSAGE
        );

        // Convert from string to int and double variables
        int finalWeight = Integer.parseInt(weight);
        double finalLength = Double.parseDouble(length);
        double finalWidth = Double.parseDouble(width);
        double finalHeight = Double.parseDouble(height);

        double size = finalLength * finalWidth * finalHeight;
        
        final int WEIGHT = 27;
        final double SIZE = 0.1;
        
        // Determine if the package meets the requirements
        if (finalWeight > WEIGHT && size > SIZE) {
            JOptionPane.showMessageDialog(
                    null,
                    "Package rejected!\nToo heavy and too large",
                    "Nitpickie's overnight delivery",
                    JOptionPane.PLAIN_MESSAGE);
        } else if (finalWeight > WEIGHT) {
            JOptionPane.showMessageDialog(
                    null,
                    "Package rejected!\nToo heavy",
                    "Nitpickie's overnight delivery",
                    JOptionPane.PLAIN_MESSAGE
            );

        } else if (size > SIZE) {
            JOptionPane.showMessageDialog(
                    null,
                    "Package rejected!\nToo large",
                    "Nitpickie's overnight delivery",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Package Accepted!",
                    "Nitpickie's overnight delivery",
                    JOptionPane.PLAIN_MESSAGE);
        }

        // Show ending message
        JOptionPane.showMessageDialog(
                null,
                "Thanks for using Nitpickie's overnight delivery!",
                "Nitpickie's overnight delivery",
                JOptionPane.PLAIN_MESSAGE
        );

    }

}
