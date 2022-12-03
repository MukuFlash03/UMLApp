package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.Vertex;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class is one of the child concrete decorators for PlotDecorator. 
 * It adds filled diamond arrow head to the already plotted 
 * simple line between two sets of vertices.
 *
 * @author Shrinkhala Kayastha
 * @version 1.0
* */
public class CompositionDecorator extends PlotDecorator {

    /**
     * Overrides the method drawLineHead() in parent class. 
     * This function draws filled diamond heads for the line between the given pair of vertices
     * @param g object for class Graphics
     * @param a Source vertex
     * @param b Destination vertex
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
