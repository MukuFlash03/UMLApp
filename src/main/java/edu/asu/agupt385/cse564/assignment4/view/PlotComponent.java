package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.Vertex;

import java.awt.Graphics;

/**
 * This class is the interface and main class for implementing Decorator pattern.
 * It exposes a public function which is overriden by other classes according
 * to their use case.
 *
 * @author Shrinkhala Kayastha
 * @version 1.0
 */
public interface PlotComponent {
    /**
     * This function draws the line arrow heads depending on the three relationship types:
     * 1. Association: Simple arrow head
     * 2. Composition: Filled diamond head
     * 3. Inheritance: Triangular arrow head
     *
     * @param g object for class Graphics
     * @param
     */
    void drawLineHead(Graphics g, Vertex a, Vertex b);
}
