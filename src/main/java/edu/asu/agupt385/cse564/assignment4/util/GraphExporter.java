package edu.asu.agupt385.cse564.assignment4.util;

import edu.asu.agupt385.cse564.assignment4.model.RelationshipType;
import edu.asu.agupt385.cse564.assignment4.model.Edge;
import edu.asu.agupt385.cse564.assignment4.model.Vertex;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * This class defines the export functionality for a graph stored
 * in {@link GraphDataSource}
 *
 * @author Anand Gupta
 * @version 1.0
 */
public class GraphExporter {
    private static final String NODE_FORMAT = "%s [label=%s, " +
            "pos=\"%d, %d\", shape=box, color=black, fillcolor=yellow, " +
            "style=filled];";
    private static final String EDGE_FORMAT_ASSOCIATION = "%s -> %s " +
            "[style=solid, arrowhead=vee]";
    private static final String EDGE_FORMAT_INHERITANCE = "%s -> %s " +
            "[style=dashed, arrowhead=onormal]";
    private static final String EDGE_FORMAT_COMPOSITION = "%s -> %s " +
            "[style=solid, dir=both, arrowtail=diamond, arrowhead=none]";

    /**
     * This method is used to export the graph as a DOT file which has
     * specific grammar rules.
     * It will fetch all the vertices and edges of the graph, and model that
     * information in form of a dot file which can be used with external
     * systems.
     *
     * @param outputStream stream for dot file output
     */
    public void exportGraph(OutputStream outputStream) {
        GraphDataSource dataSource = GraphDataSource.getInstance();
        StringBuilder output = new StringBuilder();
        output.append("digraph {").append("\n");

        Set<Vertex> vertices = dataSource.getAllVertices();
        vertices.forEach(vertex -> {
            output.append(String.format(NODE_FORMAT, vertex.getName(),
                    vertex.getName(), vertex.getX(), vertex.getY())).append(
                            "\n");
        });

        Set<Edge> edges = dataSource.getAllEdges();
        edges.forEach(edge -> {
            output.append(this.getEdgeRepresentation(edge)).append("\n");
        });

        output.append("}").append("\n");

        try {
            outputStream.write(output.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.err.println("Error writing to output stream while " +
                    "exporting the graph");
            throw new RuntimeException(e);
        }
    }

    private String getEdgeRepresentation(Edge e) {
        String source = e.getSource().getName();
        String destination = e.getDestination().getName();
        if (e.getRelationshipType() == RelationshipType.ASSOCIATION) {
            return String.format(EDGE_FORMAT_ASSOCIATION, source, destination);
        } else if (e.getRelationshipType() == RelationshipType.COMPOSITION) {
            return String.format(EDGE_FORMAT_COMPOSITION, source, destination);
        } else if (e.getRelationshipType() == RelationshipType.INHERITANCE) {
            return String.format(EDGE_FORMAT_INHERITANCE, source, destination);
        } else {
            System.err.println("Error generating edge representation while " +
                    "export the graph");
            throw new RuntimeException("Error while exporting graph. Issue " +
                    "with the edge " + source + " -> " + destination);
        }
    }
}

