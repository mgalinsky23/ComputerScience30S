package driverz;

import javax.swing.JOptionPane;

/**
 * Description - The Sturgeon Heights advanced drivers Education class does time
 * trial out in the parking lot. However, they use an old stop watch that
 * records the time in seconds. Write program which inputs the number of seconds
 * as a whole number, then converts that value to hours, minutes and seconds.
 *
 * Date - 06/10/2023
 *
 * @author m.galinsky
 */
public class DriverZ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        final String TITLE = "Strugeon Heights Advanced Drivers Education";

        JOptionPane.showMessageDialog(null, """
                 The Sturgeon Heights advanced drivers Education 
                 class does time trial out in the parking lot. 
                 However, they use an old stop watch that records 
                 the time in seconds. Write program which 
                 inputs the number of seconds as a whole number, 
                 then converts that value to hours, minutes and 
                 seconds.""",
                TITLE,
                JOptionPane.PLAIN_MESSAGE);

        String input = JOptionPane.showInputDialog(null,
                "Please enter the total time (in seconds)",
                TITLE,
                JOptionPane.QUESTION_MESSAGE);

        int sec = Integer.parseInt(input);
        
        final int thrsix = 3600;
        final int six = 60;
        
        int hour = sec / thrsix;
        int min = (sec - (hour * thrsix)) / six;
        int seconds = sec - (hour * thrsix + min * six);

        JOptionPane.showMessageDialog(null,
                "For the total time of: " + sec + " seconds, the breakdown is:"
                + "\nHours: " + hour
                + "\nMinutes: " + min
                + "\nSeconds: " + seconds,
                TITLE,
                JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "Thanks for using Strugeon Heights Advanced Drivers Education",
                TITLE,
                JOptionPane.INFORMATION_MESSAGE);

    }

}
