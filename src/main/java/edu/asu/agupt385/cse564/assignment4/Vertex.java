package edu.asu.agupt385.cse564.assignment4;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Objects;

public class Vertex implements Comparable<Vertex> {
    private final String name;
    private final Rectangle bounds;

    private static final int BOX_W = 150;
    private static final int BOX_H = 75;

    public Vertex(String name, int x, int y) {
        this.name = name;
        this.bounds = new Rectangle(x - BOX_W/2, y - BOX_H/2, BOX_W, BOX_H);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return bounds.x;
    }

    public int getY() {
        return bounds.y;
    }

    public boolean contains(int x, int y) {
        return bounds.contains(x, y);
    }

    public void move(int x, int y) {
        bounds.x = x;
        bounds.y = y;
    }

    public Point center() {
        return new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return name.equals(vertex.name);
    }

    public void draw(Graphics g) {

    }

    @Override
    public int compareTo(Vertex o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", bounds=" + bounds +
                '}';
    }
}
