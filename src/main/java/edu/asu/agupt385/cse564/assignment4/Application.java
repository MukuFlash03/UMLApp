package edu.asu.agupt385.cse564.assignment4;

import edu.asu.agupt385.cse564.assignment4.util.GraphImporter;
import edu.asu.agupt385.cse564.assignment4.view.ApplicationGUI;

import javax.swing.SwingUtilities;

public class Application {
    public static void main(String[] args) {
        GraphImporter importer = new GraphImporter();
//        importer.importGraph(Application.class.getClassLoader().getResourceAsStream("graph.dot"));
        SwingUtilities.invokeLater(() -> {
            new ApplicationGUI("Assignment 4_5");
        });
//        GraphDataSource dataSource = GraphDataSource.getInstance();
//        dataSource.getAllVertices().stream().forEach(vertex -> {
//            System.out.println(vertex.getName());
//            System.out.println(vertex.getX() + ", " + vertex.getY());
//        });
//        dataSource.getAllEdges().stream().forEach(edge -> {
//            System.out.println(edge.getSource().getName() + " -- " + edge.getDestination().getName() + " " + edge.getRelationshipType());
//        });
    }
}
