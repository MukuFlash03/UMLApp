package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.Vertex;

import java.awt.Graphics;

/**
 * This class plots the randomly generated points in the GUI and connects them with the line
 * forming line graph for the points.
 *
 * @author Shrinkhala Kayastha
 * @author Mukul Mahadik
 * @version 1.0
 */
public class LineDecorator implements PlotComponent {

    /**
     * Overrides the method operation in parent class. This function draws the plotted points
     * and connects them with a line graph.
     *
     * @param g           object for class Graphics
     * @param coordinates arraylist with coordinates of the plotted points
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
