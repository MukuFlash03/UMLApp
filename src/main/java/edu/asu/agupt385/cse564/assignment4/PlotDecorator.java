package edu.asu.agupt385.cse564.assignment4;


import java.awt.*;

/**
 * This class is the abstract class for implementing Decorator pattern. The decorators over the
 * concrete class Point is extending this class.
 * It overrides the function operation which is modified by other Decorator child classes
 * according to their use case.
 *
 * @author Mukul Mahadik
 * @version 1.0
 * */
public abstract class PlotDecorator implements PlotComponent {
    private PlotComponent component;
    private Vertex a;
    private Vertex b;

    /**
     * This function set the component/ child decorator class.
     */
    public PlotDecorator setComponent(PlotComponent component) {
        this.component = component;
        return this;
    }

    public PlotDecorator setVertexA(Vertex a) {
        this.a = a;
        return this;
    }

    public PlotDecorator setVertexB(Vertex b) {
        this.b = b;
        return this;
    }

    public Vertex getVertexA() {
        return a;
    }

    public Vertex getVertexB() {
        return b;
    }

    /**
     * This function implements operation of a particular child class on basis of the component called.
     * @param g object for class Graphics
     * @param 
     */
    @Override
    public void drawLineHead(Graphics g, Vertex a, Vertex b) {
        if (component != null)
            component.drawLineHead(g, a, b);
    }
}