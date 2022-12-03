package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.controller.MenuBarController;
import edu.asu.agupt385.cse564.assignment4.util.GraphExporter;
import edu.asu.agupt385.cse564.assignment4.util.GraphImporter;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * This class defines the GUI of the application
 *
 * @author Mukul Mahadik
 * @author Shrinkhala Kayastha
 * @version 1.0
 */
public class ApplicationGUI extends JFrame {
    protected JMenuBar menuBar;
    protected JPanel sourceCodePanel;
    protected JPanel umlPanel;
    protected JPanel statusBar;

    /**
     * Constructs an object of Application GUI which has the following
     * components:
     * {@link MenuBar} at the top
     * {@link SourceCodePanel} on the left for displaying source code
     * {@link UMLPanel} on the right for displaying the UML
     * {@link StatusLogger} at the bottom to display the textual messages
     *
     * @param title title of the application window
     */
    public ApplicationGUI(String title) {
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
        initialize();

        setVisible(true);
    }

    /**
     * Initializes the major GUI components of the application including:
     * Menubar, SourceCodePanel, UMLPanel, StatusBar
     */
    private void initialize() {
        this.menuBar = new MenuBar(new MenuBarController(new GraphImporter(),
                new GraphExporter()));
        this.sourceCodePanel = new SourceCodePanel();
        this.umlPanel = new UMLPanel();
        this.statusBar = StatusLogger.getInstance();
        this.setJMenuBar(this.menuBar);
        this.add(this.sourceCodePanel, BorderLayout.WEST);
        this.add(this.umlPanel, BorderLayout.EAST);
        this.add(this.statusBar, BorderLayout.SOUTH);
    }
}

