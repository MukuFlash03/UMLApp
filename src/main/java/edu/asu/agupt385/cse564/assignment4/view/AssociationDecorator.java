package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.Vertex;

import java.awt.Graphics;

/**
 * This class is one of the concrete class for Plot Decorator. It plots the randomly generated
 * points in square shape in the GUI.
 *
 * @author Shrinkhala Kayastha
 * @author Mukul Mahadik
 * @version 1.0
 */
public class AssociationDecorator extends PlotDecorator {

    /**
     * Overrides the method operation in parent class. This function draws the plotted points in square shape.
     *
     * @param g           object for class Graphics
     * @param coordinates arraylist with coordinates of the plotted points
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
