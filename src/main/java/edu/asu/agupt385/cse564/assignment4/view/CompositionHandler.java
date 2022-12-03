package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.RelationshipType;
import edu.asu.agupt385.cse564.assignment4.model.Vertex;

import java.awt.Graphics;

/**
 * It represents a child Handler class in the Chain of Responsibility pattern 
 * which deals with handling any Edges with the relationship type 
 * set as Composition.
 * 
 * It also implements the Fluent-Builder pattern by utilizing method chaining 
 * to call methods to set various attributes of the parent Builder class - PlotDecorator
 * 
 * @author Mukul Mahadik
 * @version 1.0
 */
public class CompositionHandler extends ChainHandler {

    /**
     * Handler method to delegate the tasks to child Handler classes.
     * Or, handle the task itself if it is responsible for the corresponding task.
     * @param g Graphics object from paintComponent() from base UMLPanel
     * @param relation Relationship between source and destination vertices
     * @param a Source vertex
     * @param b Destination vertex
     */
    @Override
    public void handleRequest(Graphics g, RelationshipType relation, Vertex a, Vertex b) {
        PlotComponent line = new LineDecorator();
        if (relation == RelationshipType.COMPOSITION) {
            PlotDecorator compose = new CompositionDecorator().setComponent(line).setVertexA(a).setVertexB(b);

            compose.drawLineHead(g, a, b);
        } else {
            successor.handleRequest(g, relation, a, b);
        }
    }
}
