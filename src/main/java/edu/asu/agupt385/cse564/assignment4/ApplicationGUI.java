package edu.asu.agupt385.cse564.assignment4;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class ApplicationGUI extends JFrame {
    ApplicationGUI(String title) {
        super(title);
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) screenSize.getWidth() - ((int) (0.1 * screenSize.getWidth())), (int) screenSize.getHeight() - ((int) (0.1 * screenSize.getHeight())));
        int x = (int) ((screenSize.getWidth() - this.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    private void initialize() {

    }

}
