package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.Vertex;

import java.awt.*;

/**
 * This class is one of the child concrete decorators for PlotDecorator. 
 * It adds triangular arrow head to the already plotted 
 * simple line between two sets of vertices.
 *
 * @author Shrinkhala Kayastha
 * @version 1.0
* */
public class InheritanceDecorator extends PlotDecorator {

    /**
     * Overrides the method drawLineHead() in parent class. 
     * This function draws triangular arrow heads for the line between the given pair of vertices
     * @param g object for class Graphics
     * @param a Source vertex
     * @param b Destination vertex
     */
    @Override
    public void drawLineHead(Graphics g, Vertex a, Vertex b) {
        super.drawLineHead(g, a, b);

        int x2 = (int) b.center().getX();
        int y2 = (int) b.center().getY();

        double side = 15;
        int ax = x2;
        int ay = (int) (y2 + side / Math.sqrt(3));
        int bx = (int) (x2 - side / 2);
        int by = (int) (y2 - side / (2 * Math.sqrt(3)));
        int cx = (int) (x2 + side / 2);
        int cy = (int) (y2 - side / (2 * Math.sqrt(3)));

        int[] xCoords = {ax, bx, cx};
        int[] yCoords = {ay, by, cy};

        g.setColor(Color.WHITE);
        g.fillPolygon(xCoords, yCoords, 3);
        g.setColor(Color.BLACK);
    }
}
