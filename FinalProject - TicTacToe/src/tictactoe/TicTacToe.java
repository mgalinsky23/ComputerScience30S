/** Required package class namespace */
package tictactoe;

import javax.swing.JOptionPane;


/**
 * TicTacToe - A game in which two players seek in alternate turns to complete a 
 * row, a column, or a diagonal with either three O's or three X's drawn in the 
 * spaces of a grid of nine squares.
 * 
 * @author Michelle Galinsky
 * @since Jan 8, 2024
*/
public class TicTacToe
{
    static String title = "Tic Tac Toe";
    
    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        final int[][] TIC_TAC_TOE = {{3}, {3}};
        output(TIC_TAC_TOE);
        read();
        
    }
    
    /**
     * Reads what the user entered
     */
    private static void read() {
        
    }
    
    /**
     * Displays the board
     * 
     * @param matrix the board
     */
    private static void output(int[][] matrix) {
        JOptionPane.showMessageDialog(
                null,
                matrix,
                title,
                JOptionPane.PLAIN_MESSAGE
        );
        
    }

}