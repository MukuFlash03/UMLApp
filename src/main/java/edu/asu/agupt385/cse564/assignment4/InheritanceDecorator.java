package edu.asu.agupt385.cse564.assignment4;

import java.awt.*;

/**
 * This class is one of the concrete class for Plot Decorator. It adds bar to the
 * already plotted square points in the GUI.
 *
 * @author Shrinkhala Kayastha
 * @author Mukul Mahadik
 * @version 1.0
* */
public class InheritanceDecorator extends PlotDecorator {

    /**
     * Overrides the method operation in parent class. This function draws the bar for the already plotted points.
     * @param g object for class Graphics
     * @param coordinates arraylist with coordinates of the plotted points
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
