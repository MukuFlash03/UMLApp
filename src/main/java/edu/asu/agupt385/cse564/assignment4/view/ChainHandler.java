package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.RelationshipType;
import edu.asu.agupt385.cse564.assignment4.model.Vertex;

import java.awt.Graphics;

public abstract class ChainHandler {

    protected ChainHandler successor;

    public void setSuccessor(ChainHandler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(Graphics g, RelationshipType relation, Vertex a, Vertex b);

}