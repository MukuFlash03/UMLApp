package edu.asu.agupt385.cse564.assignment4.view;

import edu.asu.agupt385.cse564.assignment4.model.Edge;
import edu.asu.agupt385.cse564.assignment4.model.RelationshipType;
import edu.asu.agupt385.cse564.assignment4.model.Vertex;
import edu.asu.agupt385.cse564.assignment4.util.GraphDataSource;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class UMLPanel extends JPanel implements MouseInputListener {

    private static final int MAXCOUNT = 5;
    private static final int PREF_W = 700;
    private static final int PREF_H = 250;
    private static final int BOX_W = 150;
    private static final int BOX_H = 75;
    private final GraphDataSource blackboard;
    private final String[] relationsOptions = {"ASSOCIATION", "COMPOSITION", "INHERITANCE"};
    private final Point[] relationBoxes;
    private final Vertex[] relationsBox;
    AssociationHandler associate;
    CompositionHandler compose;
    InheritanceHandler inherit;
    private Vertex currentBox;
    private int boxCount = 0;
    private int clickCount = 0;

    public UMLPanel() {
        blackboard = GraphDataSource.getInstance();
        this.setBackground(Color.white);
        this.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
        addMouseListener(this);
        addMouseMotionListener(this);
        this.relationBoxes = new Point[2];
        this.relationsBox = new Vertex[2];

        associate = new AssociationHandler();
        compose = new CompositionHandler();
        inherit = new InheritanceHandler();

        compose.setSuccessor(associate);
        inherit.setSuccessor(compose);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (blackboard != null) {
            for (Vertex v : blackboard.getAllVertices())
                paintRectangle(g, v);

            for (Edge e : blackboard.getAllEdges()) {
                inherit.handleRequest(g, e.getRelationshipType(), e.getSource(), e.getDestination());
            }
        }
    }

    public void paintRectangle(Graphics g, Vertex v) {
        int x = v.getX();
        int y = v.getY();
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, BOX_W, BOX_H);
        g.setColor(Color.BLACK);
        g.drawString(v.getName(), (int) (v.center().getX() - BOX_W / 8), (int) (v.center().getY() - BOX_H / 8));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if ((clickCount < 2) && (getBox(x, y) != null)) {
            relationBoxes[clickCount] = new Point(x, y);
            relationsBox[clickCount] = getBox(x, y);
            clickCount++;

            if (clickCount == 2) {
                RelationshipType relation = chooseRelation();

                if (relation != null) {
                    Edge lineEdge = new Edge(relationsBox[0], relationsBox[1], relation);
                    blackboard.addEdge(lineEdge);
                }
                clickCount = 0;
            }

            repaint();
        } else clickCount = 0;

    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        currentBox = getBox(x, y);
        if (currentBox == null) addBox(x, y);
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void addBox(int x, int y) {

        Vertex newBox;
        String boxName = "";

        if (boxCount < MAXCOUNT) {
            boxName = inputBoxName();
            if (boxName != null) {
                newBox = new Vertex(boxName, x, y);
                blackboard.addVertex(newBox);
                currentBox = newBox;
                boxCount = blackboard.getVertexCount();
            }
        }
        repaint();

    }

    public String inputBoxName() {
        String name = (String) JOptionPane.showInputDialog(this, "Enter box name:\n", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, "");

        return name;
    }

    public Vertex getBox(int x, int y) {
        for (Vertex v : blackboard.getAllVertices()) {
            if (v.contains(x, y)) return v;
        }
        return null;
    }

    public RelationshipType chooseRelation() {

        RelationshipType relation = null;

        String relationChoice = (String) JOptionPane.showInputDialog(null, "Choose Relation", "Relationship Type", JOptionPane.INFORMATION_MESSAGE, null, relationsOptions, relationsOptions[0]);

        if (relationChoice == null) return relation;

        if (relationChoice.equals(relationsOptions[0]))
            relation = RelationshipType.ASSOCIATION;
        else if (relationChoice.equals(relationsOptions[1]))
            relation = RelationshipType.COMPOSITION;
        else if (relationChoice.equals(relationsOptions[2]))
            relation = RelationshipType.INHERITANCE;

        return relation;
    }

    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (currentBox != null) {
            Graphics graphics = getGraphics();
            graphics.setXORMode(getBackground());
            paintRectangle(graphics, currentBox);
            currentBox.move(x, y);
            paintRectangle(graphics, currentBox);
            graphics.dispose();
            repaint();
        }
    }

    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (getBox(x, y) != null)
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        else setCursor(Cursor.getDefaultCursor());
    }
}
