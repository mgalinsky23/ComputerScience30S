package leapyear;

import javax.swing.JOptionPane;

/**
 * Description - Mr. Wachs needs lots of holidays! As much as he loves teaching,
 * he also likes his days at home. Mr. Wachs loves leap years (because it is one
 * 8 * less day to teach). A year is a leap year if it is divisible by 4 but not
 * by 100 unless it is also divisible by 400. So 1996 and 2000 were leap years,
 * but 1999 and 1900 were not.
 *
 * Date - 05/10/2023
 *
 * @author m.galinsky
 */
public class LeapYear {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        final String TITLE = "The Leap Year Calculator";

        JOptionPane.showMessageDialog(null, """ 
            Mr. Wachs needs lots of holidays! As much as he loves
            teaching, he also likes his days at home. Mr. Wachs
            loves leap years (because it is one less day to
            teach). A year is a leap year if it is divisible by 4
            but not by 100 unless it is also divisible by 400.
            So 1996 and 2000 were leap years, but 1999 and 1900 
            were not.""",
                TITLE,
                JOptionPane.PLAIN_MESSAGE);

        String year = JOptionPane.showInputDialog(null,
                "Enter a year: ",
                TITLE,
                JOptionPane.PLAIN_MESSAGE);

        int input = Integer.parseInt(year);

        double dec4 = input % 4;
        double dec100 = input % 100;
        double dec400 = input % 400;

        String end = "";

        if (dec4 == 0 && dec100 != 0) {
            end = input + " is a leap year";
        } else if (dec4 == 0 && dec100 != 0 || dec400 == 0) {
            end = input + " is a leap year";
        } else {
            end = input + " is not a leap year";
        }

        JOptionPane.showMessageDialog(null,
                end,
                TITLE,
                JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "Thanks for using the Leap Year Calculator",
                TITLE,
                JOptionPane.PLAIN_MESSAGE);

    }

}
