package edu.asu.agupt385.cse564.assignment4.model;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Objects;

/**
 * This class represents a node in a graph as a Vertex.
 * A Vertex would have a name label and bounds of the graphics box
 *
 * @author Anand Gupta
 * @version 1.0
 */
public class Vertex implements Comparable<Vertex> {
    private static final int BOX_W = 150;
    private static final int BOX_H = 75;
    private final String name;
    private final Rectangle bounds;

    /**
     * This constructs the Vertex object using the name, and the point (x, y)
     * which is the center of the box which bounds the name
     *
     * @param name of the Vertex
     * @param x    x co-ordinate of the center of the box
     * @param y    y co-ordinate of the center of the box
     */
    public Vertex(String name, int x, int y) {
        this.name = name;
        this.bounds = new Rectangle(x - BOX_W / 2, y - BOX_H / 2, BOX_W, BOX_H);
    }

    /**
     * Getter for rectangle object
     */
    public Rectangle getBounds() {
        return bounds;
    }

    /**
     * Getter for x coordinate of Rectangle
     */
    public int getX() {
        return bounds.x;
    }

    /**
     * Getter for y coordinate of Rectangle
     */
    public int getY() {
        return bounds.y;
    }

    /**
     * To check whether a Point(x, y) lies in the vicinity, attribute bounds,
     * of the Vertex or not
     *
     * @param x x co-ordinate of the Point
     * @param y y co-ordinate of the Point
     * @return true if the Point(x, y) lies in the bounds, else false
     */
    public boolean contains(int x, int y) {
        return bounds.contains(x, y);
    }

    /**
     * To update the center of the box to new Point(x, y)
     *
     * @param x new x co-ordinate of the center of the box
     * @param y new y co-ordinate of the center of the box
     */
    public void move(int x, int y) {
        bounds.x = x;
        bounds.y = y;
    }

    /**
     * Computes the center point of the bounds rectangle
     *
     * @return Point center point of the bounds of the Vertex box
     */
    public Point center() {
        return new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2);
    }

    /** 
     * Returns objects hash code to ensure duplicate objects not created
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /** 
     * Checks whether object types match
     * @param o Object to be checked
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return name.equals(vertex.name);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", bounds=" + bounds +
                '}';
    }

    /**
     * Compares two vertices based on their name
     *
     * @param o the object to be compared.
     * @return int
     */
    @Override
    public int compareTo(Vertex o) {
        return this.name.compareTo(o.getName());
    }

    /**
     * Getter for name of Rectangle
     */
    public String getName() {
        return name;
    }
}
