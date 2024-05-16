package larry.sburgers;

import javax.swing.JOptionPane;

/**
 * Description - The tremendously popular fast-food restaurant “Larry’s Burgers”
 * charges $1.49 for burgers, $0.89 for fries, and $0.99 for sodas. You have
 * been commissioned to write a cash program which allows an employee to enter
 * an order (the number of burgers, fries, and sodas), the amount of cash the
 * customer tendered, and then display a total, the tax (at 13%), and the final
 * cost, and the change.
 *
 * Date - 2023/09/22
 *
 * @author m.galinsky
 */
public class LarrySBurgers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Create initial variables
        final double burger = 1.49;
        final double fry = 0.89;
        final double soda = 0.99;

        // Create welcome screen for the user (message dialog box)
        JOptionPane.showMessageDialog(null, """
            Welcome to Larry's Burgers Program
                                            
            The tremendously popular fast-food
            restaurant "Larry's Burgers" charges
            $1.49 for burgers, $0. 88 for fries, 
            and $0.99 for sodas. You have been
            commissioned to write a cash program
            which allows an employee to enter an
            order (the number of burgers, fries,
            and sodas), the amount of cash the 
            customer tendered, and then display 
            a total, the tax (at 13%), and 
            the final cost, and the change.""",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Get user input (number of hamburgers) - dialog
        String inputBurger = JOptionPane.showInputDialog(
                null,
                "Enter the number of hamburgers ordered:",
                "Input",
                JOptionPane.QUESTION_MESSAGE
        );

        // Get user input (number of fries) - dialog
        String inputFries = JOptionPane.showInputDialog(
                null,
                "Enter the number of fries ordered:",
                "Input",
                JOptionPane.QUESTION_MESSAGE
        );

        // Get user input (number of sodas) - dialog
        String inputSodas = JOptionPane.showInputDialog(
                null,
                "Enter the number of sodas ordered:",
                "Input",
                JOptionPane.QUESTION_MESSAGE
        );

        // Get user input (cash amount) - dialog
        String inputCash = JOptionPane.showInputDialog(
                null,
                "Enter the cash tendered:",
                "Input",
                JOptionPane.QUESTION_MESSAGE
        );

        // Convert from string to int and double variables
        int burgers = Integer.parseInt(inputBurger);
        int fries = Integer.parseInt(inputFries);
        int sodas = Integer.parseInt(inputSodas);

        double cash = Double.parseDouble(inputCash);

        // Determine what the user will need to pay
        double totalBurg = burgers * burger;
        double totalFry = fries * fry;
        double totalSoda = sodas * soda;

        double sub = totalBurg + totalFry + totalSoda;
        double total = sub * 1.13;
        double change = cash - total;

        // Display the amount owed by the user
        JOptionPane.showMessageDialog(
                null,
                "Your order is: \n"
                + "Hamburgers: " + burgers + "\n"
                + "Fries: " + fries + "\n"
                + "Sodas: " + sodas + "\n"
                + "Cash tendered: $" + cash + "\n"
                + "Sub-Total: $" + sub + "\n"
                + "Total: $" + total + "\n"
                + "Change: $" + change + "\n",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Show ending message
        JOptionPane.showMessageDialog(
                null,
                "Thanks for using Larry's Burgers Program!",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );

    }

}
