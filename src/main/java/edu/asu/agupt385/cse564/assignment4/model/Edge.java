package edu.asu.agupt385.cse564.assignment4.model;

import java.util.Comparator;
import java.util.Objects;

/**
 * This class represents a relation between two classes which are represented as
 * {@link Vertex}.
 * An Edge would have a source Vertex, destination Vertex, and a relation
 * between them as in {@link RelationshipType}
 *
 * @author Anand Gupta
 * @version 1.0
 */
public class Edge implements Comparable<Edge> {
    private Vertex source;
    private Vertex destination;
    private RelationshipType relationshipType;

    /**
     * This constructs an Edge with a source, a destination and the
     * relationship between them
     * @param source source vertex
     * @param destination destination vertex
     * @param relationshipType relationship between two vertices
     */
    public Edge(Vertex source, Vertex destination,
                RelationshipType relationshipType) {
        this.source = source;
        this.destination = destination;
        this.relationshipType = relationshipType;
    }

    /**
     * Getter for source vertex
     * @return source Vertex
     */
    public Vertex getSource() {
        return source;
    }

    /**
     * Getter for destination vertex
     * @return destination Vertex
     */
    public Vertex getDestination() {
        return destination;
    }

    /**
     * Getter for relationship type between the vertices
     * @return enum RelationshipType
     */
    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return source.equals(edge.source) && destination.equals(edge.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination);
    }

    /**
     * Compares two edges based on their source and destination Vertex
     * @param o the object to be compared.
     * @return int
     */
    @Override
    public int compareTo(Edge o) {
        return Comparator.comparing(Edge::getSource)
                .thenComparing(Edge::getDestination)
                .compare(this, o);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source +
                ", destination=" + destination +
                ", relationshipType=" + relationshipType +
                '}';
    }
}
