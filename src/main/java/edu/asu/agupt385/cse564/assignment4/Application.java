package edu.asu.agupt385.cse564.assignment4;

import edu.asu.agupt385.cse564.assignment4.view.ApplicationGUI;

import javax.swing.SwingUtilities;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ApplicationGUI("Assignment 4_5");
        });
    }
}
