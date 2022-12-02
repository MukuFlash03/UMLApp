package edu.asu.agupt385.cse564.assignment4;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class ApplicationGUI extends JFrame implements ActionListener {

    StatusLogger statusBar;
    MenuPanel menu;

    GraphDataSource blackboard;

    ApplicationGUI(String title) {
        super(title);
        // setLayout(new BorderLayout());
        // setResizable(false);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) screenSize.getWidth() - ((int) (0.1 * screenSize.getWidth())), (int) screenSize.getHeight() - ((int) (0.1 * screenSize.getHeight())));
        int x = (int) ((screenSize.getWidth() - this.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        initialize();
    }

    private void initialize() {

        SourceCodePanel leftPanel = new SourceCodePanel();
        UMLPanel rightPanel = new UMLPanel();
        statusBar = StatusLogger.getInstance();
        menu = new MenuPanel();
        setJMenuBar(menu.getMenuBar());
        addComponentsToPane(this.getContentPane(), leftPanel, rightPanel);

        //Observer implementation
        blackboard = GraphDataSource.getInstance();
        blackboard.addObserver(leftPanel);

        JMenuItem[] items = menu.getMenuOptions();
        for (JMenuItem item : items)
            item.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        statusBar.setMessage(choice + " tab selected");
        if(choice.equals("New Diagram")){
            this.blackboard.deleteAll();
            repaint();
        }
        if(choice.equals("Save Diagram")){
            this.blackboard.deleteAll();
            repaint();
        }
        if(choice.equals("Load Diagram")){
            this.blackboard.deleteAll();
            repaint();
        }
    }



    public void addComponentsToPane(Container pane, SourceCodePanel leftPanel, UMLPanel rightPanel) {
 
        pane.setLayout(new GridBagLayout());
        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 700;
        pane.add(leftPanel, c);
    
        
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.01;
        c.gridx = 1;
        c.gridy = 0;
        c.ipady = 700;
        pane.add(rightPanel, c);
    
        
//        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
//        c.insets = new Insets(0, 0, 0, 0);
        c.ipady = 20;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        pane.add(statusBar, c);
    }
}

