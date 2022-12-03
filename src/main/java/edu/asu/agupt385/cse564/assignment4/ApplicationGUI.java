package edu.asu.agupt385.cse564.assignment4;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationGUI extends JFrame implements ActionListener {

    StatusLogger statusBar;
    MenuPanel menu;
    GraphDataSource blackboard;

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
        initialize();

        setVisible(true);
    }

    private void initialize() {
        setJMenuBar(new MenuPanel().getMenuBar());
        this.add(new SourceCodePanel(), BorderLayout.WEST);
        this.add(new UMLPanel(), BorderLayout.EAST);
        this.add(StatusLogger.getInstance(), BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        statusBar.setMessage(choice + " tab selected");

        if (choice.equals("New Diagram")) {
            handleNewDiagram();
        }
        if (choice.equals("Save Diagram")) {
            handleSaveDiagram();
            repaint();
        }
        if (choice.equals("Load Diagram")) {
            handleLoadDiagram();
            repaint();
        }
        // TODO show dialog of team info
        // handleTeamInfo();

    }

    public void handleNewDiagram() {
        this.blackboard.deleteAll();
        repaint();
    }

    public void handleSaveDiagram() {

    }

    public void handleLoadDiagram() {

    }

    public void handleTeamInfo() {
        JPanel dPane = new JPanel();
        dPane.setLayout(new GridLayout(0, 1));
        JDialog d = new JDialog(this, "Project Team");

        for (String person : menu.getTeamInfo()) {
            JLabel label = new JLabel(person);
            dPane.add(label);
        }
        d.add(dPane);
        d.setSize(500, 500);
        d.setVisible(true);
    }
}

