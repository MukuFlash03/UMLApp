package edu.asu.agupt385.cse564.assignment4;

import javax.swing.JLabel;

public class StatusLogger extends JLabel {

    private static volatile StatusLogger INSTANCE;

    private StatusLogger() {
    }

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

    public void setMessage(String message) {
        super.setText(message);
    }
}
