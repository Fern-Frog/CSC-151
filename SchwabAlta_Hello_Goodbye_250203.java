/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author schwaba4441
 */

import java.time.LocalTime;
import javax.swing.JOptionPane;
public class SchwabAlta_Hello_Goodbye_250203 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         String userName = getUserName();

        while (true) { // Main loop for interaction
            displayWelcomeMessage(userName);
            String mood = askUserMood(userName);

            suggestActivity(mood);
        

            int continueChoice = JOptionPane.showConfirmDialog(null, "Would you like to continue?", "Continue?", JOptionPane.YES_NO_OPTION);
            if (continueChoice == JOptionPane.NO_OPTION) {
                break;
            }
        }

        displayGoodbyeMessage(userName);

        
    }
    
     // Method to get the user's name (with retry option)
    public static String getUserName() {
        String name;
        do {
            name = JOptionPane.showInputDialog("Please enter your name:");
            if (name == null) {
                int confirmExit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmExit == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        } while (name == null || name.trim().isEmpty());
        return name.trim();
    }

    // Method to display a time-based welcome message
    public static void displayWelcomeMessage(String name) {
        LocalTime time = LocalTime.now();
        String greeting;

        if (time.isBefore(LocalTime.NOON)) {
            greeting = "Good morning, " + name + "!";
        } else if (time.isBefore(LocalTime.of(18, 0))) {
            greeting = "Good afternoon, " + name + "! ️";
        } else {
            greeting = "Good evening, " + name + "!";
        }

        JOptionPane.showMessageDialog(null, greeting + " Glad to have you here. 😊");
    }

    // Method to ask how the user is feeling using a dropdown
    public static String askUserMood(String name) {
        String[] moodOptions = { "Happy 😊", "Excited 🎉", "Okay 😐", "Sad 😢", "Tired 😴", "I'd rather not say 🤐" };

        int choice = JOptionPane.showOptionDialog(
            null,
            "How are you feeling today, " + name + "?",
            "Mood Check",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            moodOptions,
            moodOptions[0]
        );

        if (choice == -1 || choice == 5) { // User cancels or selects "I'd rather not say"
            JOptionPane.showMessageDialog(null, "No worries, " + name + "! Hope you have a great day. 😊");
            return "Not shared 🤐";
        } else {
            String response = switch (choice) {
                case 0 -> "That's wonderful to hear, " + name + "! Keep smiling! 😃";
                case 1 -> "Wow, " + name + "! Exciting times ahead! 🚀";
                case 2 -> "Hope your day gets even better, " + name + "! 😊";
                case 3 -> "I'm sorry to hear that, " + name + ". I hope things get better soon! 💙";
                case 4 -> "Get some rest, " + name + "! A nap might help. 😴";
                default -> "Thank you for sharing, " + name + "! 😊";
            };

            JOptionPane.showMessageDialog(null, response);
            return moodOptions[choice]; // Return the mood
        }
    }

    // Suggest an activity based on mood
    public static void suggestActivity(String mood) {
        String suggestion;
        switch (mood) {
            case "Happy 😊" -> suggestion = "That's great! Maybe share your happiness with a friend! 🎉";
            case "Excited 🎉" -> suggestion = "How about doing something adventurous today? 🚀";
            case "Okay 😐" -> suggestion = "Maybe watch a fun movie or listen to some music! 🎬🎵";
            case "Sad 😢" -> suggestion = "Try listening to your favorite song or talking to someone who makes you smile. 💙";
            case "Tired 😴" -> suggestion = "Some rest and a cup of tea might help! ☕😴";
            default -> suggestion = "Do whatever makes you happy! 😊";
        }
        JOptionPane.showMessageDialog(null, suggestion);
    }

   

    // Method to display a goodbye message
    public static void displayGoodbyeMessage(String name) {
        JOptionPane.showMessageDialog(null, "Goodbye, " + name + "! Have a great day! 👋");
    }

}
