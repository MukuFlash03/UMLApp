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


public class GraphDataSource extends Observable {
    private static volatile GraphDataSource INSTANCE;

    private final Map<Vertex, Set<Edge>> graph;

    private GraphDataSource() {
        this.graph = new ConcurrentHashMap<>();
    }

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

    public boolean hasEdge(Edge e) {
        return graph.get(e.getSource()).contains(e);
    }

    public boolean hasVertex(Vertex v) {
        return graph.containsKey(v);
    }

    public Vertex getVertexByName(String vertexName) {
        Optional<Vertex> v = this.getAllVertices().stream().filter(vertex -> vertexName.equalsIgnoreCase(vertex.getName())).findFirst();
        if (v.isPresent()) {
            return v.get();
        } else {
            return null;
        }
    }

    public Set<Vertex> getAllVertices() {
        return new HashSet<>(graph.keySet());
    }

    public Set<Edge> getEdges(Vertex v) {
        return new HashSet<>(graph.get(v));
    }

    public Set<Edge> getAllEdges() {
        return graph.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }

    public void deleteAll() {
        graph.clear();
        this.setChanged();
        this.notifyObservers();
    }

    public int getVertexCount() {
        return graph.size();
    }
}
