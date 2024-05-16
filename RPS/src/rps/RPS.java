package rps;

import javax.swing.JOptionPane;

/**
 * Description - Create a Rock – Paper – Scissors game (using random numbers)
 * between yourself and the computer. You pick your choice with an input (either
 * R, P, or S – OR the actual words Rock, paper, or scissors – AND letter case
 * doesn’t matter) and the computer will randomly pick its choice. The computer
 * will then display the results of the game. Remember rock beats scissors,
 * paper beats rock, scissors beats rock, and if both are the same we have a
 * draw.
 *
 *
 * Date - 2023/09/26
 *
 * @author m.galinsky
 */
public class RPS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Create welcome screen for the user (message dialog box)
        JOptionPane.showMessageDialog(
                null,
                "This is a Rock – Paper – Scissors game (using random \n"
                + "numbers) between yourself and the computer. You pick \n"
                + "your choice with an input (either R, P, or S – OR the\n"
                + "actual words Rock, paper, or scissors – AND letter \n"
                + "case doesn’t matter) and the computer will randomly \n"
                + "pick its choice. The computer will then display the \n"
                + "results of the game. Remember rock beats scissors, \n"
                + "paper beats rock, scissors beats rock, and if both \n"
                + "are the same we have a draw.",
                "Rock - Paper - Scissors",
                JOptionPane.PLAIN_MESSAGE
        );

        // Get user input (R, P, or S) - dialog
        String input = JOptionPane.showInputDialog(
                null,
                "Please enter your choice(Rock 'R', Paper 'P', "
                + "or Scissors 'S')",
                "Rock - Paper - Scissors",
                JOptionPane.QUESTION_MESSAGE
        );

        // Create a constants to avoid "magic" numbers
        final int LOW = 1;
        final int HIGH = 3;

        // rock == 1, paper == 2, scissors == 3
        int number = (int) ((HIGH - LOW + 1) * Math.random() + LOW);

        String end = "";

        // Determine if the user wins, loses or ties with the computer
        if (input.equalsIgnoreCase("R") && number == 1) {
            end = "Tie! \n You chose ROCK \n Computer picked ROCK";
        } else if (input.equalsIgnoreCase("P") && number == 2) {
            end = "Tie! \n You chose PAPER \n Computer picked PAPER";
        } else if (input.equalsIgnoreCase("S") && number == 3) {
            end = "Tie! \n You chose SCISSORS \n Computer picked SCISSORS";
        } else if (input.equalsIgnoreCase("R") && number == 2) {
            end = """  
                You lose!
                (paper covers rock)
                You chose ROCK
                Computer picked PAPER """;
        } else if (input.equalsIgnoreCase("P") && number == 3) {
            end = """
                lose!
                (scissors cuts paper)
                You chose PAPER
                Computer picked SCISSORS """;
        } else if (input.equalsIgnoreCase("S") && number == 1) {
            end = """ 
               You lose!
                (rock breaks scissors)
                You chose SCISSORS
                Computer picked ROCK """;
        } else if (input.equalsIgnoreCase("R") && number == 3) {
            end = """ 
               You win!
                (rock breaks scissors)
                You chose ROCK
                Computer picked SCISSORS """;
        } else if (input.equalsIgnoreCase("P") && number == 1) {
            end = """ 
               You win!
                (paper covers rock)
                You chose PAPER
                Computer picked ROCK """;
        } else {
            end = """ 
                You win!
                (scissors cuts paper)
                You chose SCISSORS
                Computer picked PAPER """;
        }

        // Display if the user wins, loses or ties with the computer
        JOptionPane.showMessageDialog(
                null,
                end,
                "Rock - Paper - Scissors",
                JOptionPane.PLAIN_MESSAGE
        );

        // Show ending message
        JOptionPane.showMessageDialog(
                null,
                "Thanks for using Rock - Paper - Scissors!",
                "Rock - Paper - Scissors",
                JOptionPane.INFORMATION_MESSAGE
        );

    }

}
