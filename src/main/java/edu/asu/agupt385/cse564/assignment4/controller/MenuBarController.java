package edu.asu.agupt385.cse564.assignment4.controller;

import edu.asu.agupt385.cse564.assignment4.GraphDataSource;
import edu.asu.agupt385.cse564.assignment4.GraphExporter;
import edu.asu.agupt385.cse564.assignment4.GraphImporter;

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

public class MenuBarController implements ActionListener {
    private final GraphImporter importer;
    private final GraphExporter exporter;
    private final GraphDataSource dataSource;

    public MenuBarController(GraphImporter importer, GraphExporter exporter) {
        this.importer = importer;
        this.exporter = exporter;
        this.dataSource = GraphDataSource.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "new":
                this.handleNewDiagram();
                break;
            case "load":
                this.handleLoadDiagram();
                break;
            case "save":
                this.handleSaveDiagram();
                break;
            case "about":
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
