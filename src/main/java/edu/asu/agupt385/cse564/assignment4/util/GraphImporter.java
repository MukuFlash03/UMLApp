package edu.asu.agupt385.cse564.assignment4.util;

import edu.asu.agupt385.cse564.assignment4.model.RelationshipType;
import edu.asu.agupt385.cse564.assignment4.antlr4.DOTBaseListener;
import edu.asu.agupt385.cse564.assignment4.antlr4.DOTLexer;
import edu.asu.agupt385.cse564.assignment4.antlr4.DOTParser;
import edu.asu.agupt385.cse564.assignment4.model.Edge;
import edu.asu.agupt385.cse564.assignment4.model.Vertex;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * This class defines the import functionality for a dot file and saving as a
 * graph in {@link GraphDataSource}. It utilizes DOT lexer and parser generated
 * by antlr for reading and parsing the dot file.
 *
 * @author Anand Gupta
 * @version 1.0
 */
public class GraphImporter {
    GraphDataSource dataSource = GraphDataSource.getInstance();

    /**
     * This method is used to read and parse the content passed as parameter,
     * and represent it as a graph in {@link GraphDataSource}.
     * The VertexListener is used to parse all the nodes, and the
     * EdgeListener is used to parse all the edges which represent a
     * relationship between nodes.
     *
     * @param inputStream of content which follows DOT file grammar
     */
    public void importGraph(InputStream inputStream) {
        try {
            DOTLexer dotLexer = new DOTLexer(CharStreams.fromStream(inputStream));
            DOTParser dotParser =
                    new DOTParser(new CommonTokenStream(dotLexer));
            ParseTree parseTree = dotParser.graph();
            ParseTreeWalker.DEFAULT.walk(new VertexListener(), parseTree);
            ParseTreeWalker.DEFAULT.walk(new EdgeListener(), parseTree);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private class VertexListener extends DOTBaseListener {
        public void enterNode_stmt(DOTParser.Node_stmtContext ctx) {
            String vertexName = ctx.node_id().getText();
            DOTParser.Attr_listContext attrListContext = ctx.attr_list();
            for (DOTParser.A_listContext attr : attrListContext.a_list()) {
                boolean posFlag = false;
                for (DOTParser.Id_Context idContext : attr.id_()) {
                    if (posFlag) {
                        String posValue = idContext.getText();
                        posValue = posValue.replaceAll("^\"|\"$", "");
                        String[] posValueSplit = posValue.split(",");
                        dataSource.addVertex(new Vertex(vertexName,
                                Integer.parseInt(posValueSplit[0].trim()),
                                        Integer.parseInt(posValueSplit[1].trim())));
                        break;
                    }
                    if ("pos".equalsIgnoreCase(idContext.getText())) {
                        posFlag = true;
                    }
                }
            }
        }
    }

    private class EdgeListener extends DOTBaseListener {
        Map<String, String> edgeAttrs = new HashMap<>();
        public void enterEdge_stmt(DOTParser.Edge_stmtContext ctx) {
            Vertex sourceVertex =
                    dataSource.getVertexByName(ctx.node_id().getText());
            Vertex destinationVertex =
                    dataSource.getVertexByName(ctx.edgeRHS().node_id().get(0).getText());
            RelationshipType edgeRelationship = RelationshipType.ASSOCIATION;
            DOTParser.Attr_listContext attrListContext = ctx.attr_list();
            for (DOTParser.A_listContext attr : attrListContext.a_list()) {
                String[] keyValueMapping = {null, null};
                int counter = 0;
                for (DOTParser.Id_Context idContext : attr.id_()) {
                    keyValueMapping[counter++] = idContext.getText();
                    if (counter > 1) {
                        counter = 0;
                        edgeAttrs.put(keyValueMapping[0], keyValueMapping[1]);
                    }
                }

                String styleValue = edgeAttrs.get("style");
                String arrowHeadValue = edgeAttrs.get("arrowhead");
                if (styleValue != null && !styleValue.isBlank() && arrowHeadValue != null && !arrowHeadValue.isBlank()) {
                    if ("dashed".equalsIgnoreCase(styleValue) && "onormal".equalsIgnoreCase(arrowHeadValue)) {
                        edgeRelationship = RelationshipType.INHERITANCE;
                    } else if ("solid".equalsIgnoreCase(styleValue)) {
                        if ("vee".equalsIgnoreCase(arrowHeadValue)) {
                            edgeRelationship = RelationshipType.ASSOCIATION;
                        } else if ("none".equalsIgnoreCase(arrowHeadValue)) {
                            edgeRelationship = RelationshipType.COMPOSITION;
                        }
                    }
                }
                dataSource.addEdge(new Edge(sourceVertex, destinationVertex,
                        edgeRelationship));
            }
        }
        public void exitEdge_stmt(DOTParser.Edge_stmtContext ctx) {
            edgeAttrs.clear();
        }
    }
}
