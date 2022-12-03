package edu.asu.agupt385.cse564.assignment4.util;

import edu.asu.agupt385.cse564.assignment4.model.Edge;
import edu.asu.agupt385.cse564.assignment4.model.Vertex;
import edu.asu.agupt385.cse564.assignment4.view.StatusLogger;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

/**
 * This class is an observable, and stores the representation of a directed
 * graph as a collection of vertices {@link Vertex} and its associated edges
 * {@link Edge}.
 * This class is a Singleton as it is a datasource for other classes and
 * modules.
 * It also provides methods which helps in operating on the graph.
 *
 * @author Anand Gupta
 * @version 1.0
 */
public class GraphDataSource extends Observable {
    private static volatile GraphDataSource INSTANCE;

    private final Map<Vertex, Set<Edge>> graph;

    private GraphDataSource() {
        this.graph = new ConcurrentHashMap<>();
    }

        
    /** 
     * Returns instantiated object of this class
     */
    public static GraphDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (GraphDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GraphDataSource();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Add a vertex in the graph if it is not present
     * @param v vertex to be added
     */
    public void addVertex(Vertex v) {
        if (!hasVertex(v)) {
            graph.put(v, new ConcurrentSkipListSet<>());
            this.setChanged();
            this.notifyObservers();
            StatusLogger.getInstance().setMessage(v.getName() + " class created!!");
        } else {
            StatusLogger.getInstance().setMessage("Class already exists!!");
        }
    }

    /**
     * Add an edge in the graph, if it is not present
     * @param e edge to be added
     */
    public void addEdge(Edge e) {
        if (this.hasEdge(e)) {
            StatusLogger.getInstance().setMessage("Relationship already exists!!");
        } else {
            graph.get(e.getSource()).add(e);
            this.setChanged();
            this.notifyObservers();
            StatusLogger.getInstance().setMessage(e.getRelationshipType() + " " + "relationship added in between!!");
        }
    }

    /**
     * Checks whether the graph has the specified edge or not
     * @param e edge
     * @return true if the graph has that edge, else false
     */
    public boolean hasEdge(Edge e) {
        return graph.get(e.getSource()).contains(e);
    }

    /**
     * Checks whether the graph has the specified vertex or not
     * @param v vertex
     * @return true if the graph has that vertex, else false
     */
    public boolean hasVertex(Vertex v) {
        return graph.containsKey(v);
    }

    /**
     * To fetch a vertex in graph by name attribute
     * @param vertexName name of the vertex
     * @return Vertex if it is present, else null
     */
    public Vertex getVertexByName(String vertexName) {
        Optional<Vertex> v = this.getAllVertices().stream().filter(vertex -> vertexName.equalsIgnoreCase(vertex.getName())).findFirst();
        if (v.isPresent()) {
            return v.get();
        } else {
            return null;
        }
    }

    /**
     * To fetch all the vertices in the graph
     * @return a hashset of all the vertices
     */
    public Set<Vertex> getAllVertices() {
        return new HashSet<>(graph.keySet());
    }

    /**
     * To fetch all the edges associated with the specified source vertex
     * @param v source vertex
     * @return hashset of all the edges which has source vertex as v
     */
    public Set<Edge> getEdges(Vertex v) {
        return new HashSet<>(graph.get(v));
    }

    /**
     * To fetch all the edges in the graph
     * @return set of all the edges in the graph
     */
    public Set<Edge> getAllEdges() {
        return graph.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }

    /**
     * To remove all the vertices and edges in the graph
     */
    public void deleteAll() {
        graph.clear();
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * To fetch the number of vertices present in the graph
     * @return int count of vertices in the graph
     */
    public int getVertexCount() {
        return graph.size();
    }
}
