import javax.swing.JOptionPane;

public class Arearec_021725_Schwab_02 {

    public static void main(String[] args) {
        String userName = getUserName(); // Get valid user input
        
        while (true) { // Main loop to allow repeated interaction
            displayWelcomeMessage(userName); // Show welcome message

            boolean keepGoing = true;
            while (keepGoing) {
                int choice = showMenu(); // Display menu

                switch (choice) {
                    case 1 -> calculateRectangleArea();
                    case 2 -> calculateBoxSurfaceArea();
                    case 3 -> keepGoing = false; // Exit calculation loop
                    default -> showError("Invalid option. Please select again.");
                }
            }
 
            int continueChoice = JOptionPane.showConfirmDialog(null, "Would you like to continue?", "Continue?", JOptionPane.YES_NO_OPTION);
            if (continueChoice == JOptionPane.NO_OPTION) {
                displayGoodbyeMessage(userName); // Show goodbye message before exiting
                break; // Exit the loop if user chooses "No"
            }
             
        }
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

    // Displays menu and returns user choice
    private static int showMenu() {
        String[] options = {"2D Rectangle Area", "3D Box Surface Area", "Exit to Main Menu"};
        return JOptionPane.showOptionDialog(null, 
                "Choose an option:", 
                "Shape Calculator Menu", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, options, options[0]) + 1; // Adjust index to match switch cases
    }

    // Handles input and calculation for a 2D rectangle's area
    private static void calculateRectangleArea() {
        try {
            double length = getPositiveDouble("Enter the length of the rectangle:");
            double width = getPositiveDouble("Enter the width of the rectangle:");
            double area = length * width;

            showResult("The area of the rectangle is: " + area);
        } catch (NumberFormatException e) {
            showError("Invalid input. Please enter numeric values only.");
        }
    }

    // Handles input and calculation for a 3D rectangular prism's surface area
    private static void calculateBoxSurfaceArea() {
        try {
            double length = getPositiveDouble("Enter the length of the box:");
            double width = getPositiveDouble("Enter the width of the box:");
            double height = getPositiveDouble("Enter the height of the box:");

            // Surface Area = 2(lw + lh + wh)
            double surfaceArea = 2 * (length * width + length * height + width * height);
            showResult("The surface area of the box is: " + surfaceArea);
        } catch (NumberFormatException e) {
            showError("Invalid input. Please enter numeric values only.");
        }
    }

    // Prompts user for a positive double input
    private static double getPositiveDouble(String message) throws NumberFormatException {
        double value;
        do {
            String input = JOptionPane.showInputDialog(null, message, "Input", JOptionPane.QUESTION_MESSAGE);
            if (input == null) exitProgram(); // User pressed cancel
            value = Double.parseDouble(input);
            if (value <= 0) showError("Please enter a positive number.");
        } while (value <= 0);
        return value;
    }

    // Displays result message
    private static void showResult(String message) {
        JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.INFORMATION_MESSAGE);
    }

    // Displays error message
    private static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Exits the program
    private static void exitProgram() {
        displayGoodbyeMessage("User"); // Default to "User" if name is unavailable
        System.exit(0);
    }
}