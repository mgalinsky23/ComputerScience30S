package unitcircle;

import javax.swing.JOptionPane;

/**
 * Description - The unit circle - Mr. Wachs is preparing to teach the unit
 * ‘circle’ in grade 10 mathematics, and as usual, he has no idea what he is
 * doing! You need to help him out and write a program to calculate the
 * circumference of a circle, the area of a circle, and the volume of a
 * sphere based on the radius that is inputted
 *
 * Date - 2023/09/22
 *
 * @author m.galinsky
 */
public class UnitCircle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Create welcome screen for the user (message dialog box)
        JOptionPane.showMessageDialog(
                null,
                "Mr. Wachs is preparing to teach the unit ‘circle’ \n"
                + "in grade 10 mathematics, and as usual, he has no \n"
                + "idea what he is doing! You need to help him out and \n"
                + "write a program to calculate the circumference of \n"
                + "a circle, the area of a circle, and the volume of \n"
                + "a sphere based on the radius",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Get user input (radius) - dialog
        String input = JOptionPane.showInputDialog(
                null,
                "Enter the radius of the circle:",
                "Unit Circle Calculator",
                JOptionPane.QUESTION_MESSAGE
        );

        // Convert from string to double variables
        double radius = Double.parseDouble(input);

        // Calculate the circumference, area and volume based on the input
        double circum = Math.PI * 2 * radius;
        double area = Math.PI * radius * radius;
        double volume = (4 * Math.PI / 3) * radius * radius * radius;

        // Display the calculations to the user
        JOptionPane.showMessageDialog(
                null,
                "The circumference of the circle is: " + circum + "\n"
                + "The area of the circle is: " + area + "\n"
                + "The volume of the circle is: " + volume,
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Show ending message
        JOptionPane.showMessageDialog(
                null,
                "Thank you for using Unit Circle Calculator",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );

    }

}
