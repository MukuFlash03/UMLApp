package edu.asu.agupt385.cse564.assignment4;


import java.awt.*;

/**
 * This class is the interface and main class for implementing Decorator pattern.
 * It exposes a public function which is overriden by other classes accorinding
 * to their use case.
 *
 * @author Mukul Mahadik
 * @version 1.0
 * */
public interface PlotComponent {
    /**
     * This function draws the GUI components for the randomly generated points.
     * GUI has majorly three components:
     * 1. Panel showing plotted points and line graph
     * 2. Panel showing plotted points in square shape and line graph
     * 3. Panel showing points with bar and line graph
     * @param g object for class Graphics
     * @param 
     */

    void drawLineHead(Graphics g, Vertex a, Vertex b);
}