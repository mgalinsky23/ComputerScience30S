package wachssong;

import javax.swing.JOptionPane;

/**
 * Description - Mr. Sereda often ‘entertains’ his students with his songs in
 * class. Mr. Wachs has written his own song, but I need you to help write it.
 * Write a program that takes an integer input from the user, then users this
 * number as the countdown value in this song.
 *
 * Date - 2023/09/29
 *
 * @author m.galinsky
 */
public class WachsSong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        final String TITLE = "The Wachs Song";

        // Create welcome screen for the user (message dialog box)
        JOptionPane.showMessageDialog(null, """  
            Mr. Sereda often entertains his students with his songs
            in class. Mr. Wachs has written his own song, but I need
            you to help write it. Write a program that takes an integer
            input from the user, then users this number as the countdown
            value in this song. """,
                TITLE,
                JOptionPane.PLAIN_MESSAGE
        );

        // Get user input (countdown number) - dialog
        String input = JOptionPane.showInputDialog(
                null,
                "Enter a number for countdown:",
                TITLE,
                JOptionPane.PLAIN_MESSAGE
        );

        // Convert from string to int variable
        int num = Integer.parseInt(input);

        // Display the song with the amount the user inputted
        for (int i = num; i >= 1; i--) {
            System.out.println(i + " students in Wachs' class,\n"
                    + i + " students in class,\n"
                    + "Wachs tells a joke, turns his back,");
            i--;
            System.out.println(i + " students in Wachs' class!");
        }

        // Show ending message
        JOptionPane.showMessageDialog(
                null,
                "Thanks for using The Wachs Song!",
                TITLE,
                JOptionPane.PLAIN_MESSAGE
        );

    }

}
