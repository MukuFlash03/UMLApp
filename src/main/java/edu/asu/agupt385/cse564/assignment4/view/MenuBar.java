package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.controller.MenuBarController;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * This class defines a custom {@link JMenuBar} to be used in the application
 *
 * @author Anand Gupta
 * @version 1.0
 */
public class MenuBar extends JMenuBar {

    /**
     * Constructs an object of MenuBar which has the following menu items:
     * File - New, Load, and Save; Help - About Team
     *
     * @param controller to handle the events associated with JMenuItem
     */
    public MenuBar(MenuBarController controller) {
        JMenu fileMenu = new JMenu("File");
        JMenuItem newDiagram = new JMenuItem("New");
        newDiagram.setActionCommand("new");
        newDiagram.addActionListener(controller);
        JMenuItem loadDiagram = new JMenuItem("Load");
        loadDiagram.setActionCommand("load");
        loadDiagram.addActionListener(controller);
        JMenuItem saveDiagram = new JMenuItem("Save");
        saveDiagram.setActionCommand("save");
        saveDiagram.addActionListener(controller);
        fileMenu.add(newDiagram);
        fileMenu.add(loadDiagram);
        fileMenu.add(saveDiagram);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem teamDetails = new JMenuItem("About Team");
        teamDetails.setActionCommand("about");
        teamDetails.addActionListener(controller);
        helpMenu.add(teamDetails);

        this.add(fileMenu);
        this.add(helpMenu);
    }
}
