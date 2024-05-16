package sin;

import javax.swing.JOptionPane;

/**
 * Description - Canadian Social Insurance Numbers (SINs) have a built-in
 * redundancy code in the form of a check sum. To calculate whether a 9-digit
 * SIN is valid, a calculation is performed. If the calculation arrives at the
 * correct value, the SIN is valid, otherwise it is invalid. For the 9-digit SIN
 * numbers, the (slightly simplified) calculation is: 1. The digits in even
 * numbered positions are each multiplied by two, and the results are added
 * together. 2. The digits in odd numbered positions are added together. 3. The
 * two sums from steps 1 and 2 are then added together. If this result is evenly
 * divisible by ten, the SIN is valid. Otherwise, the SIN is invalid.
 *
 * Date - 2023/09/27
 *
 * @author m.galinsky
 */
public class SIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Create welcome screen for the user (message dialog box)
        JOptionPane.showMessageDialog(null,
                "Canadian Social Insurance Numbers (SINs) have a built-in\n"
                + " redundancy code in the form of a check sum. To calculate\n"
                + "whether a 9-digit SIN is valid, a calculation is performed.\n"
                + "If the calculation arrives at the correct value, the SIN is\n"
                + "valid, otherwise it is invalid. For the 9-digit SIN numbers,\n"
                + "the (slightly simplified) calculation is: (1) The digits in\n"
                + "even numbered positions are each multiplied by two, and the\n"
                + "results are added together. (2) The digits in odd numbered\n"
                + "positions are added together (3) The two sums from steps 1 and\n"
                + "2 are then added together. If this result is evenly divisible\n"
                + "by ten, the SIN is valid. Otherwise, the SIN is invalid.\n",
                "Canadian Social Insurance Numbers",
                JOptionPane.PLAIN_MESSAGE);

        // Get user input (SIN) - dialog
        String sin = JOptionPane.showInputDialog(
                null,
                "Enter SIN number for checking:",
                "Input",
                JOptionPane.PLAIN_MESSAGE
        );

        // Create a constant to avoid "magic" numbers
        final int NUM = 48;

        // Find all even and odd numbers to calculate if the SIN is valid
        char even1Char = sin.charAt(1);
        int even1 = (int) even1Char - NUM;
        int t = (even1 * 2);

        char even3Char = sin.charAt(3);
        int even3 = (int) even3Char - NUM;
        int f = even3 * 2;

        char even5Char = sin.charAt(5);
        int even5 = (int) even5Char - NUM;
        int s = even5 * 2;

        char even7Char = sin.charAt(7);
        int even7 = (int) even7Char - NUM;
        int e = even7 * 2;

        char odd0Char = sin.charAt(0);
        int odd0 = (int) odd0Char - NUM;

        char odd2Char = sin.charAt(2);
        int odd2 = (int) odd2Char - NUM;

        char odd4Char = sin.charAt(4);
        int odd4 = (int) odd4Char - NUM;

        char odd6Char = sin.charAt(6);
        int odd6 = (int) odd6Char - NUM;

        char odd8Char = sin.charAt(8);
        int odd8 = (int) odd8Char - NUM;

        int endOdd = odd0 + odd2 + odd4 + odd6 + odd8;
        int endEven = t + f + s + e;

        int end = endOdd + endEven;

        String v = "";

        // Determine whether the SIN in valid or invalid
        if (end % 10 == 0) {
            v = "Your SIN is valid";
        } else {
            v = "Your SIN is invalid";
        }

        // Display if the SIN is valid or invalid
        JOptionPane.showMessageDialog(
                null,
                v,
                "Canadian Social Insurance Numbers",
                JOptionPane.PLAIN_MESSAGE
        );

        // Show ending message
        JOptionPane.showMessageDialog(
                null,
                "Thanks for using Canadian Social Insurance Numbers!",
                "Message",
                JOptionPane.PLAIN_MESSAGE
        );

    }

}
