package edu.asu.agupt385.cse564.assignment4.controller;

import edu.asu.agupt385.cse564.assignment4.util.GraphDataSource;
import edu.asu.agupt385.cse564.assignment4.util.GraphExporter;
import edu.asu.agupt385.cse564.assignment4.util.GraphImporter;
import edu.asu.agupt385.cse564.assignment4.view.StatusLogger;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class acts as a controller for
 * {@link javax.swing.JMenuItem} in
 * {@link edu.asu.agupt385.cse564.assignment4.view.MenuBar}
 *
 * @author Anand Gupta
 * @version 1.0
 */
public class MenuBarController implements ActionListener {
    private final GraphImporter importer;
    private final GraphExporter exporter;
    private final GraphDataSource dataSource;

    /**
     * Constructs an object of MenuBarController with graph importer and
     * graph exporter services along with the data source
     *
     * @param importer graph importer service for loading dot files
     * @param exporter graph exporter service for saving graph as dot files
     */
    public MenuBarController(GraphImporter importer, GraphExporter exporter) {
        this.importer = importer;
        this.exporter = exporter;
        this.dataSource = GraphDataSource.getInstance();
    }

    /**
     * This method handles all the events associated with this listener.
     * The supported actions commands are: New, Load, Save and About
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "new":
                StatusLogger.getInstance().setMessage("Create new classes selected");
                this.handleNewDiagram();
                break;
            case "load":
                StatusLogger.getInstance().setMessage("Load the diagram selected");
                this.handleLoadDiagram();
                break;
            case "save":
                StatusLogger.getInstance().setMessage("Save the diagram selected");
                this.handleSaveDiagram();
                break;
            case "about":
                StatusLogger.getInstance().setMessage("View team details selected");
                this.handleTeamInfo();
                break;
            default:
                break;
        }
    }

    private void handleNewDiagram() {
        this.dataSource.deleteAll();
    }

    private void handleLoadDiagram() {
        String fileName;
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showDialog(null, "Open File") == 0) {
            fileName = fileChooser.getSelectedFile().toString();
            try (InputStream is = new FileInputStream(fileName)) {
                importer.importGraph(is);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Issue in parsing file", "Error", JOptionPane.ERROR_MESSAGE);
                System.err.println("Issue in parsing file: " + fileName);
                System.err.println(e.getMessage());
            }
        }
    }

    private void handleSaveDiagram() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String outputFile = System.getProperty("user.dir") + FileSystems.getDefault().getSeparator() + "graph_" + timestamp + ".dot";
        try {
            Path outputPath = Files.createFile(Paths.get(outputFile));
            exporter.exportGraph(Files.newOutputStream(outputPath));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Issue in saving file", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Issue in saving file: " + outputFile);
            System.err.println(e.getMessage());
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Issue in saving file: " + outputFile);
            System.err.println(e.getMessage());
        }
    }

    private void handleTeamInfo() {
        String[] teamInfo = {"Anand Gupta (agupt385@asu.edu)", "Mukul C. Mahadik (mmahadik@asu.edu)", "Shrinkhala Kayastha (skayast1@asu.edu)"};
        JOptionPane.showMessageDialog(new JFrame(), teamInfo, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
