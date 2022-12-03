package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.Vertex;

import java.awt.Graphics;

/**
 * This class is the abstract class for implementing Decorator pattern. 
 * The decorators over the concrete component LineDecorator are extending this class.
 * It overrides the function drawLineHead() which is modified by other Decorator child classes
 * according to their use case.
 *
 * @author Shrinkhala Kayastha
 * @version 1.0
 */
public abstract class PlotDecorator implements PlotComponent {
    private PlotComponent component;
    private Vertex a;
    private Vertex b;

    /**
     * Sets the component/child decorator class as per Builder pattern
     */
    public PlotDecorator setComponent(PlotComponent component) {
        this.component = component;
        return this;
    }

    /**
     * Returns the source vertex
     */
    public Vertex getVertexA() {
        return a;
    }

    /**
     * Sets the source vertex as per Builder pattern
     */
    public PlotDecorator setVertexA(Vertex a) {
        this.a = a;
        return this;
    }

    /**
     * Returns the destination vertex
     */
    public Vertex getVertexB() {
        return b;
    }

    /**
     * Sets the destination vertex as per Builder pattern
     */
    public PlotDecorator setVertexB(Vertex b) {
        this.b = b;
        return this;
    }

    /**
     * This function implements drawing line arrow heads  of a particular child class on basis of the component called.
     *
     * @param g object for class Graphics
     * @param a Source vertex
     * @param b Destination vertex
     */
    @Override
    public void drawLineHead(Graphics g, Vertex a, Vertex b) {
        if (component != null)
            component.drawLineHead(g, a, b);
    }
}
