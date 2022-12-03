package edu.asu.agupt385.cse564.assignment4;

import java.awt.*;

/**
 * This class is one of the concrete class for Plot Decorator. It plots the randomly generated
 * points in square shape in the GUI.
 *
 * @author Shrinkhala Kayastha
 * @author Mukul Mahadik
 * @version 1.0
 * */
public class CompositionDecorator extends PlotDecorator {

    /**
     * Overrides the method operation in parent class. This function draws the plotted points in square shape.
     * @param g object for class Graphics
     * @param coordinates arraylist with coordinates of the plotted points
     */
    @Override
    public void drawLineHead(Graphics g, Vertex a, Vertex b) {
        super.drawLineHead(g, a, b);

        int x1 = (int) a.center().getX();
        int y1 = (int) a.center().getY();

        double side = 5;
        int ax = x1;
        int ay = (int) (y1 - side * Math.sqrt(2));
        int bx = (int) (x1 + side * Math.sqrt(2));
        int by = y1;
        int cx = x1;
        int cy = (int) (y1 + side * Math.sqrt(2));
        int dx = (int) (x1 - side * Math.sqrt(2));
        int dy = y1;

        int[] xCoords = {ax, bx, cx, dx};
        int[] yCoords = {ay, by, cy, dy};

        g.setColor(Color.BLACK);
        g.fillPolygon(xCoords, yCoords, 4);
    }
}
