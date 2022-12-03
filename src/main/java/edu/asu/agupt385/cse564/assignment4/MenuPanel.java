package edu.asu.agupt385.cse564.assignment4;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import java.util.LinkedHashMap;

public class MenuPanel {

    JMenuBar menuBar;
    JMenuItem[] options = new JMenuItem[4];
    JMenu[] choices = new JMenu[2];
    
    LinkedHashMap<String, String[]> menuTitles = new LinkedHashMap<String, String[]>() {{
        put("File", new String[] {"New Diagram", "Save Diagram", "Load Diagram"});
        put("Help", new String[] {"View Team Details"});
    }};
    
    String[] teamInfo = {   "Anand Gupta (agupt385@asu.edu)", 
                            "Mukul C. Mahadik (mmahadik@asu.edu)", 
                            "Shrinkhala Kayastha (skayast1@asu.edu)"
                        };

    public MenuPanel() {

        menuBar = new JMenuBar();
        int i = 0, j = 0;
        for (String key : menuTitles.keySet()) {
            choices[j] = new JMenu(key);
            for (String value : menuTitles.get(key)) {
                options[i] = new JMenuItem(value);
                choices[j].add(options[i++]);
            }
            menuBar.add(choices[j++]);
        }
    }


    public JMenuItem[] getMenuOptions() {
        return options;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public String[] getTeamInfo() {
        return teamInfo;
    }
}
