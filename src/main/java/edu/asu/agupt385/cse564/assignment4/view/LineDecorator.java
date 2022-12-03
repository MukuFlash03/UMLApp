package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.Vertex;

import java.awt.Graphics;

/**
 * This class serves as the concrete component of the Decorator pattern.
 * It deals with drawing a simple line connecting two points.
 *
 * @author Shrinkhala Kayastha
 * @version 1.0
 */
public class LineDecorator implements PlotComponent {

    /**
     * Overrides the method drawLineHead() in parent class. 
     * This function draws a line segment connecting the centers of 
     * the given pair of vertices
     * @param g object for class Graphics
     * @param a Source vertex
     * @param b Destination vertex
     */
    @Override
    public void drawLineHead(Graphics g, Vertex a, Vertex b) {
        int x1 = (int) a.center().getX();
        int y1 = (int) a.center().getY();
        int x2 = (int) b.center().getX();
        int y2 = (int) b.center().getY();

        g.drawLine(x1, y1, x2, y2);
    }
}
