package edu.asu.agupt385.cse564.assignment4.view;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * This class represents the status bar present at the bottom of the GUI. 
 * It notifies users about the actions going on in the tool.
 * 
 * This class is a Singleton as it maintains a single copy of the class 
 * to update the user with the latest actions performed by 
 * the application or the user.
 *
 * @author Shrinkhala Kayastha
 * @version 1.0
 */
public class StatusLogger extends JPanel {

    private static volatile StatusLogger INSTANCE;

    private final JLabel statusLabel;

    private StatusLogger() {
        setLayout(new BorderLayout(1, 1));

        statusLabel = new JLabel("Ready");
        statusLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        statusLabel.setForeground(Color.BLACK);
        add(BorderLayout.CENTER, statusLabel);
    }

        
    /** 
     * Returns instantiated object of this class
     */
    public static StatusLogger getInstance() {
        if (INSTANCE == null) {
            synchronized (StatusLogger.class) {
                if (INSTANCE == null) {
                    INSTANCE = new StatusLogger();
                }
            }
        }
        return INSTANCE;
    }

    /** 
     * Sets the status message to be displayed
     * @param message Status message to be updated
     */
    public void setMessage(String message) {
        if (message.equals(""))
            statusLabel.setText("Ready");
        else
            statusLabel.setText(message);
    }
}
