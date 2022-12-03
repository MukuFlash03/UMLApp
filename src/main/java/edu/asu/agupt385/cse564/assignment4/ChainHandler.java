package edu.asu.agupt385.cse564.assignment4;

import java.awt.Graphics;

public abstract class ChainHandler {

    protected ChainHandler successor;
    
    public void setSuccessor(ChainHandler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(Graphics g, RelationshipType relation, Vertex a, Vertex b);

}