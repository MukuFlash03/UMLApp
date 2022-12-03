package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.RelationshipType;
import edu.asu.agupt385.cse564.assignment4.model.Vertex;

import java.awt.Graphics;

public class CompositionHandler extends ChainHandler {

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
