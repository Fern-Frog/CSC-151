import javax.swing.JOptionPane;

public class SchwabAlta_Hello_Goodbye_250205 {

    public static void main(String[] args) {
        String userName = getUserName(); // Get valid user input
        
        while (true) { // Main loop to allow repeated interaction
            displayWelcomeMessage(userName); // Show welcome message

            // Ask for section number and interpret it
            String sectionNumber = getSectionNumber();
            if (sectionNumber != null) {
                String meaning = interpretSectionNumber(sectionNumber);
                JOptionPane.showMessageDialog(null, meaning, "Section Number Meaning", JOptionPane.INFORMATION_MESSAGE);
            }

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

    public static void displayWelcomeMessage(String name) {
        JOptionPane.showMessageDialog(null, "Welcome, " + name + "! Glad to have you here. 😊");
    }

    public static void displayGoodbyeMessage(String name) {
        JOptionPane.showMessageDialog(null, "Goodbye, " + name + "! Have a great day! 👋");
    }

    public static String getSectionNumber() {
        String section;
        do {
            section = JOptionPane.showInputDialog("Please enter your 4-digit section number (e.g., 0123):");
            if (section == null) {
                int confirmExit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmExit == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        } while (section == null || section.length() != 4 || !section.matches("\\d{4}"));
        
        return section;
    }

    public static String interpretSectionNumber(String sectionNumber) {
        char sessionDigit = sectionNumber.charAt(0);
        char locationDigit = sectionNumber.charAt(1);
        String courseNumber = sectionNumber.substring(2); // Last two digits

        String session = switch (sessionDigit) {
            case '0' -> "16 Week";
            case '1' -> "1st Eight Week";
            case '2' -> "2nd Eight Week";
            case '3' -> "12 Week Session";
            case '5' -> "Off Cycle";
            case '6' -> "1st Four Week Session";
            case '7' -> "2nd Four Week Session";
            case '8' -> "3rd Four Week Session";
            case '9' -> "4th Four Week Session";
            default -> "Unknown Session";
        };

        String location = switch (locationDigit) {
            case '0' -> "Main Campus";
            case '1' -> "Fort Bragg";
            case '3' -> "Spring Lake Center";
            case '4' -> "Botanical Garden Center";
            case '9' -> "Online";
            case 'B' -> "Blended (Hybrid) (50%+ Online/F2F)";
            case 'C' -> "Collision";
            case 'D' -> "Developmental/Support Co-requisite";
            case 'F' -> "Flex";
            case 'H' -> "High School - County";
            case 'L' -> "Learning Communities";
            case 'P' -> "High School - Polytech";
            case 'R' -> "Ford";
            case 'V' -> "Virtual Classroom";
            case 'X' -> "Off Campus";
            case 'Y' -> "HyFlex";
            default -> "Unknown Location/Type";
        };

        String timeType = "";
        int courseNum = Integer.parseInt(courseNumber);
        if (courseNum >= 1 && courseNum <= 49) {
            timeType = "Day Class";
        } else if (courseNum >= 51 && courseNum <= 59) {
            timeType = "Night Class";
        } else if (courseNum >= 61 && courseNum <= 69) {
            timeType = "Weekend Class";
        } else {
            timeType = "Unknown Time Type";
        }

        return "Your section number " + sectionNumber + " means:\n"
                + "📅 Session: " + session + "\n"
                + "📍 Location/Type: " + location + "\n"
                + "📖 Course Number: " + courseNumber + " (" + timeType + ")";
    }
}
