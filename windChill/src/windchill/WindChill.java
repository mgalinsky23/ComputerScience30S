package windchill;

import javax.swing.JOptionPane;

/**
 * Description - A wind chill of 10° F or above is not considered dangerous or
 * unpleasant; a wind chill of −10° F or higher but less than 10° F is
 * considered unpleasant; if it is −30° F or above but less than −10° F,
 * frostbite is possible; if it is −70° F or higher but below −30° F, frostbite
 * is likely and outdoor activities becomes dangerous; if the wind chill is less
 * than −70° F, exposed flesh will usually freeze within half a minute. Write a
 * program which accepts a temperature in CELCIUS and displays the appropriate
 * weather warning for a wind chill.
 *
 * Date - 2023/09/22
 * 
 * @author m.galinsky
 */
public class WindChill {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Create welcome screen for the user (message dialog box)
        JOptionPane.showMessageDialog(
                null,
                "A wind chill of 10° F or above is not considered\n"
                + "dangerous or unpleasant; a wind chill of −10° F or\n"
                + "higher but less than 10° F is considere unpleasant;d\n"
                + "if it is −30° F or above but less than −10° F,\n"
                + "frostbite is possible; if it is −70° F or higher but\n"
                + "below −30° F, frostbite is likely and outdoor\n"
                + "activities becomes dangerous; if the wind chill is\n"
                + "less than −70° F, exposed flesh will usually freeze\n"
                + "within half a minute.",
                "The Wind Chill Determiner",
                JOptionPane.PLAIN_MESSAGE
        );

        // Get user input (temperature in celcius) - dialog
        String celcius = JOptionPane.showInputDialog(
                null,
                "Enter the temperature in Celcius: ",
                "The Wind Chill Determiner",
                JOptionPane.PLAIN_MESSAGE
        );

        // Convert this to a number I can do math with
        double finalCelcius = Double.parseDouble(celcius);

        // Apply a formula (F = (C ∗ 1.8) + 32 )
        double fahr = (finalCelcius * 1.8) + 32;

        // Determine what wind chill warning to use
        if (fahr >= 10) {
            JOptionPane.showMessageDialog(
                    null,
                    "The wind chill is not considered dangerous or "
                    + "unpleasent for " + fahr + " degrees fahrenheit",
                    "The Wind Chill Determiner",
                    JOptionPane.PLAIN_MESSAGE);
        } else if (fahr >= -10 && fahr <= 10) {
            JOptionPane.showMessageDialog(
                    null,
                    "The wind chill is considered unpleasent for "
                    + fahr + " degrees fahrenheit",
                    "The Wind Chill Determiner",
                    JOptionPane.PLAIN_MESSAGE);
        } else if (fahr >= -30 && fahr <= -10) {

            JOptionPane.showMessageDialog(
                    null,
                    "Frostbite is possible for "
                    + fahr + " degrees fahrenheit",
                    "The Wind Chill Determiner",
                    JOptionPane.PLAIN_MESSAGE);
        } else if (fahr >= -70 && fahr <= -30) {
            JOptionPane.showMessageDialog(
                    null,
                    "Frostbite is likely and outdoor activities are now "
                    + "dangerous for " + fahr + " degrees fahrenheit",
                    "The Wind Chill Determiner",
                    JOptionPane.PLAIN_MESSAGE);
        } else if (fahr <= -70) {
            JOptionPane.showMessageDialog(
                    null,
                    "Exposed flesh will freeze within half a minute for "
                    + fahr + " degrees fahrenheit",
                    "The Wind Chill Determiner",
                    JOptionPane.PLAIN_MESSAGE);
        }

        // Show ending message
        JOptionPane.showMessageDialog(
                null,
                "Thanks for using The Wind Chill Determiner!",
                "The Wind Chill Determiner",
                JOptionPane.PLAIN_MESSAGE
        );

    }

}
