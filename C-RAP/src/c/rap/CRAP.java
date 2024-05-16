package c.rap;

import javax.swing.JOptionPane;

/**
 * Description - You are an intern at radio station, C-RAP, the disk jockeys
 * announce the current temperature in both Fahrenheit and Celsius every
 * half-hour. They would like an easy way to display both the Fahrenheit and
 * Celsius temperatures quickly and at the same time. The local airport phones
 * in the temperature (but only in Celsius). They have requested that you
 * develop an application that will display both temperatures after the Celsius
 * temperature is inputted. Note: Use this conversion formula: F = (C ∗ 1.8) + 32
 *
 *Date - 2023/09/22
 *
 * @author m.galinsky
 */
public class CRAP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Create welcome screen for the user (message dialog box)
        JOptionPane.showMessageDialog(null, """
                Welcome to the C-RAP number 2 radio station 
                                      
                You are an intern at radio station, C-RAP, The 
                the disk jockeys announce the current temperature 
                in both Fahrenheit and Celsius every half-hour. 
                They would like an easy way to display both the 
                Fahrenheit and Celsius temperatures quickly and 
                at the same time. The local airport phones in 
                the temperature (but only in Celsius). They 
                have requested that you develop an application 
                that will display both temperatures after the 
                Celsius temperature is inputted. Note: Use 
                this conversion formula: F = (C * 1.8) + 32""",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Get user input (temperature in celcius) - dialog
        String text = JOptionPane.showInputDialog(
                null,
                "Enter temperature in celsius",
                "Input",
                JOptionPane.QUESTION_MESSAGE
        );

        // Convert this to a number I can do math with
        double celsius = Double.parseDouble(text);

        // Apply a formula (F = (C ∗ 1.8) + 32 )
        double fahr = (celsius * 1.8) + 32;

        // Show the user the results (fahrenheit) in a dialog
        JOptionPane.showMessageDialog(
                null,
                "Your temperature in Fahrenheit is " + fahr,
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Show ending message
        JOptionPane.showMessageDialog(
                null,
                "Thank you!",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );

    }

}
