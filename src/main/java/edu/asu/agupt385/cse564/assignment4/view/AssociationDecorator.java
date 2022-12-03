package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.Vertex;

import java.awt.Graphics;

/**
 * This class is one of the child concrete decorators for PlotDecorator. 
 * It adds simple arrow head to the already plotted 
 * simple line between two sets of vertices.
 *
 * @author Shrinkhala Kayastha
 * @version 1.0
* */
public class AssociationDecorator extends PlotDecorator {

    /**
     * Overrides the method drawLineHead() in parent class. 
     * This function draws simple arrow heads for the line between the given pair of vertices
     * @param g object for class Graphics
     * @param a Source vertex
     * @param b Destination vertex
     */
    @Override
    public void drawLineHead(Graphics g, Vertex a, Vertex b) {
        super.drawLineHead(g, a, b);

        int x2 = (int) b.center().getX();
        int y2 = (int) b.center().getY();

        g.drawLine(x2, y2, x2 - 10, y2 - 10);
        g.drawLine(x2, y2, x2 + 10, y2 - 10);
    }
}
