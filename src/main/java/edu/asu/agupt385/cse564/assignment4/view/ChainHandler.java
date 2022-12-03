package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.RelationshipType;
import edu.asu.agupt385.cse564.assignment4.model.Vertex;

import java.awt.Graphics;

/**
 * It represents the topmost hierarchical level of 
 * the Chain of Responsibility pattern.
 * 
 * @author Mukul Mahadik
 * @version 1.0
 */
public abstract class ChainHandler {

    protected ChainHandler successor;

    /**
     * Sets the successors objects as the corresponding child Handler class
     * @param successor Represents any of the child Handler class objects
     */
    public void setSuccessor(ChainHandler successor) {
        this.successor = successor;
    }

    /**
     * Handler method to delegate the tasks to child Handler classes.
     * Or, handle the task itself if it is responsible for the corresponding task.
     * @param g Graphics object from paintComponent() from base UMLPanel
     * @param relation Relationship between source and destination vertices
     * @param a Source vertex
     * @param b Destination vertex
     */
    public abstract void handleRequest(Graphics g, RelationshipType relation, Vertex a, Vertex b);

}
