package edu.asu.agupt385.cse564.assignment4;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Objects;

public class Vertex {
    private final String name;
    private final Rectangle bounds;

    public Vertex(String name, int x, int y, int size) {
        this.name = name;
        if (size < 16) {
            this.bounds = new Rectangle(x, y, 16, 16);
        } else {
            this.bounds = new Rectangle(x, y, size, 16);
        }
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
}
