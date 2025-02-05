/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author schwaba4441
 */
import javax.swing.JOptionPane;
public class SchwabAlta_Hello_Goodbye_250205 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String userName = getUserName(); // Get valid user input
        
        while (true) { // Main loop to allow repeated interaction
            displayWelcomeMessage(userName); // Show welcome message
            

            int continueChoice = JOptionPane.showConfirmDialog(null, "Would you like to continue?", "Continue?", JOptionPane.YES_NO_OPTION);
            if (continueChoice == JOptionPane.NO_OPTION) {
                break; // Exit the loop if user chooses "No"
            }
        }

        displayGoodbyeMessage(userName); // Show goodbye message before exiting
    }
    public static String getUserName() {
        String name;
        do {
            name = JOptionPane.showInputDialog("Please enter your name:");
            if (name == null) {
                int confirmExit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmExit == JOptionPane.YES_OPTION) {
                    System.exit(0); // Exit the program
                }
            }
        } while (name == null || name.trim().isEmpty()); // Keep asking until valid input
        return name;
    }

    // Method to display a welcome message
    public static void displayWelcomeMessage(String name) {
        JOptionPane.showMessageDialog(null, "Welcome, " + name + "! Glad to have you here. 😊");
    }
    
        // Method to display a goodbye message
    public static void displayGoodbyeMessage(String name) {
        JOptionPane.showMessageDialog(null, "Goodbye, " + name + "! Have a great day! 👋");
    }
}
