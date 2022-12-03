package edu.asu.agupt385.cse564.assignment4;

import edu.asu.agupt385.cse564.assignment4.view.ApplicationGUI;

import javax.swing.SwingUtilities;

/**
 * This class is the entry point of the application
 *
 * @author Anand Gupta
 * @author Mukul C. Mahadik
 * @author Shrinkhala Kayastha
 * @version 1.0
 */
public class Application {

    /**
     * This main method is used to invoke the application GUI in a separate
     * thread.
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ApplicationGUI("Assignment 4_5");
        });
    }
}
