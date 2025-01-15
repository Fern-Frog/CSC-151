/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arearec_011525_schwab_01;
import javax.swing.JOptionPane;

/**
 *
 * @author schwaba4441
 */
public class Arearec_011525_Schwab_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Prompt user for the length of the rectangle
            String lengthInput = JOptionPane.showInputDialog(null, 
                    "Enter the length of the rectangle:", 
                    "Rectangle Area Calculator", 
                    JOptionPane.QUESTION_MESSAGE);
            
            // Convert the length input to a double
            double length = Double.parseDouble(lengthInput);

            // Prompt user for the width of the rectangle
            String widthInput = JOptionPane.showInputDialog(null, 
                    "Enter the width of the rectangle:", 
                    "Rectangle Area Calculator", 
                    JOptionPane.QUESTION_MESSAGE);
            
            // Convert the width input to a double
            double width = Double.parseDouble(widthInput);

            // Calculate the area of the rectangle
            double area = length * width;

            // Display the calculated area
            JOptionPane.showMessageDialog(null, 
                    "The area of the rectangle is: " + area, 
                    "Result", 
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            // Handle invalid number input
            JOptionPane.showMessageDialog(null, 
                    "Invalid input. Please enter numeric values only.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            JOptionPane.showMessageDialog(null, 
                    "An unexpected error occurred: " + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
