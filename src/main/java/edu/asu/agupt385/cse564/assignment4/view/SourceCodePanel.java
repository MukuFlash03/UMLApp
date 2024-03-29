package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.Edge;
import edu.asu.agupt385.cse564.assignment4.model.RelationshipType;
import edu.asu.agupt385.cse564.assignment4.model.Vertex;
import edu.asu.agupt385.cse564.assignment4.util.GraphDataSource;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * This class represents the panel on the left side of the GUI 
 * It is an Observer class which displays the code according 
 * to the classes created by the user.
 *
 * @author Mukul Mahadik
 * @version 1.0
 */
public class SourceCodePanel extends JPanel implements Observer {

    private final JTextArea sourceCodeTextArea;

    SourceCodePanel() {
        GraphDataSource.getInstance().addObserver(this);
        this.sourceCodeTextArea = new JTextArea(50, 50);
        this.add(new JScrollPane(this.sourceCodeTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
    }

    /**
     * This function updates the GUI panels 
     * with relationships and vertices data present in the GraphDataSource
     * @param o object of Observable class
     * @param arg additional object with update function
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof GraphDataSource) {
            StringBuilder sourceCode = new StringBuilder();
            Set<Vertex> vertices = ((GraphDataSource) o).getAllVertices();
            vertices.forEach(vertex -> {
                Set<Edge> edges = ((GraphDataSource) o).getEdges(vertex);
                sourceCode.append(this.getFormattedVertex(vertex, edges)).append(System.lineSeparator());
            });
            this.sourceCodeTextArea.setText(sourceCode.toString());
        }
    }

    /**
     * Returns the string built as per the relationship type 
     * existing between each pair of vertices.
     */
    private StringBuilder getFormattedVertex(Vertex vertex, Set<Edge> edges) {
        List<String> classDeclarationRelations = new ArrayList<>();
        List<String> instanceScopeRelations = new ArrayList<>();
        List<String> localScopeRelations = new ArrayList<>();
        StringBuilder classSourceCode = new StringBuilder();

        edges.forEach(edge -> {
            if (edge.getRelationshipType() == RelationshipType.ASSOCIATION) {
                localScopeRelations.add(edge.getDestination().getName());
            } else if (edge.getRelationshipType() == RelationshipType.COMPOSITION) {
                instanceScopeRelations.add(edge.getDestination().getName());
            } else if (edge.getRelationshipType() == RelationshipType.INHERITANCE) {
                classDeclarationRelations.add(edge.getDestination().getName());
            }
        });

        classSourceCode.append("class " + vertex.getName());
        if (classDeclarationRelations.size() > 0) {
            classSourceCode.append(" extends ");
            classSourceCode.append(classDeclarationRelations.stream().collect(Collectors.joining(",")));
        }
        classSourceCode.append(" {").append(System.lineSeparator());
        if (instanceScopeRelations.size() > 0) {
            for (String s : instanceScopeRelations) {
                classSourceCode.append(s + " " + s + " = new " + s + "();");
                classSourceCode.append(System.lineSeparator());
            }
        }
        classSourceCode.append(System.lineSeparator());
        classSourceCode.append("method() {").append(System.lineSeparator());
        if (localScopeRelations.size() > 0) {
            for (String s : localScopeRelations) {
                classSourceCode.append(s + " " + s + " = new " + s + "();");
                classSourceCode.append(System.lineSeparator());
            }
        }
        classSourceCode.append("}").append(System.lineSeparator());
        classSourceCode.append("}").append(System.lineSeparator());

        return classSourceCode;
    }
}
