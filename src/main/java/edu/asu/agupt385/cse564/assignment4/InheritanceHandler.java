package edu.asu.agupt385.cse564.assignment4;

import java.awt.Graphics;

public class InheritanceHandler extends ChainHandler {

    @Override
    public void handleRequest(Graphics g, RelationshipType relation, Vertex a, Vertex b) {
        PlotComponent line = new LineDecorator();
        if (relation == RelationshipType.INHERITANCE) {
            PlotDecorator inherit = new InheritanceDecorator()
                                            .setComponent(line)
                                            .setVertexA(a)
                                            .setVertexB(b)
                                            ;

            inherit.drawLineHead(g, a, b);
        }
        else
            successor.handleRequest(g, relation, a, b);
    }    
}
