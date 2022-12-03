package edu.asu.agupt385.cse564.assignment4;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class UMLPanel extends JPanel implements MouseInputListener {

    private static final int MAXCOUNT = 5;
    private static final int PREF_W = 700;
    private static final int PREF_H = 250;
    private static final int BOX_W = 150;
    private static final int BOX_H = 75;
    private Vertex currentBox;
    private final GraphDataSource blackboard;

    private final String[] relationsOptions = {"ASSOCIATION", "COMPOSITION", "INHERITANCE"};

    private int boxCount = 0;
    // private int defaultBoxCount = 0;

    private int clickCount = 0;
    private final Point[] relationBoxes;
    private final Vertex[] relationsBox;

    // private int edgeCounter = 0;

    public UMLPanel() {
        blackboard = GraphDataSource.getInstance();
        this.setBackground(Color.white);
        this.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
        addMouseListener(this);
        addMouseMotionListener(this);
        this.relationBoxes = new Point[2];
        this.relationsBox = new Vertex[2];
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (blackboard != null) {
            for (Vertex v : blackboard.getAllVertices())
                paintRectangle(g, v);

            for (Edge e : blackboard.getAllEdges()) {
                // Point a = new Point((int)e.getSource().center().getX(), (int)e.getSource().center().getY());
                // Point b = new Point((int)e.getDestination().center().getX(), (int)e.getDestination().center().getY());

                int x1 = (int) e.getSource().center().getX();
                int y1 = (int) e.getSource().center().getY();
                int x2 = (int) e.getDestination().center().getX();
                int y2 = (int) e.getDestination().center().getY();

                g.drawLine(x1, y1, x2, y2);    

                /*
                ChainHandler associate = new AssociationHandler();
                ChainHandler compose = new CompositionHandler();
                ChainHandler inherit = new InheritanceHandler();
        
                inherit.setSuccessor(compose);
                compose.setSuccessor(associate);
                inherit.drawLineHead(g, e.getRelationshipType(), e.getSource(), e.getDestination());
                */

                if (e.getRelationshipType() == RelationshipType.ASSOCIATION)
                    paintAssociationArrow(g, x1, y1, x2, y2);
                else if (e.getRelationshipType() == RelationshipType.COMPOSITION)
                    paintCompositionArrow(g, x1, y1, x2, y2);
                else if (e.getRelationshipType() == RelationshipType.INHERITANCE)
                    paintInheritanceArrow(g, x1, y1, x2, y2);
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

    public void paintAssociationArrow(Graphics g, int x1, int y1, int x2, int y2) {
        System.out.println("Association Arrow");

        Graphics2D g2 = (Graphics2D) g;
        // g2.setStroke(new BasicStroke(2f));
        g2.drawLine(x2, y2, x2 - 10, y2 - 10);
        g2.drawLine(x2, y2, x2 + 10, y2 - 10);
    }

    public void paintCompositionArrow(Graphics g, int x1, int y1, int x2, int y2) {
        System.out.println("Composition Arrow");

        double side = 5;
        int ax = x1;
        int ay = (int) (y1 - side * Math.sqrt(2));
        int bx = (int) (x1 + side * Math.sqrt(2));
        int by = y1;
        int cx = x1;
        int cy = (int) (y1 + side * Math.sqrt(2));
        int dx = (int) (x1 - side * Math.sqrt(2));
        int dy = y1;

        int[] xCoords = {ax, bx, cx, dx};
        int[] yCoords = {ay, by, cy, dy};

        g.setColor(Color.BLACK);
        g.fillPolygon(xCoords, yCoords, 4);
    }

    public void paintInheritanceArrow(Graphics g, int x1, int y1, int x2, int y2) {
        System.out.println("Inheritance Arrow");

        double side = 15;
        int ax = x2;
        int ay = (int) (y2 + side / Math.sqrt(3));
        int bx = (int) (x2 - side / 2);
        int by = (int) (y2 - side / (2 * Math.sqrt(3)));
        int cx = (int) (x2 + side / 2);
        int cy = (int) (y2 - side / (2 * Math.sqrt(3)));

        int[] xCoords = {ax, bx, cx};
        int[] yCoords = {ay, by, cy};

        g.setColor(Color.WHITE);
        g.fillPolygon(xCoords, yCoords, 3);
        g.setColor(Color.BLACK);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked");
        System.out.println(clickCount);

        int x = e.getX();
        int y = e.getY();

        if ((clickCount < 2) && (getBox(x, y) != null)) {
            relationBoxes[clickCount] = new Point(x, y);
            relationsBox[clickCount] = getBox(x, y);
            System.out.println(relationBoxes[clickCount]);
            clickCount++;

            if (clickCount == 2) {
                RelationshipType relation = chooseRelation();

                if (relation != null) {

                    /*
                    ChainHandler associate = new AssociationHandler();
                    ChainHandler compose = new CompositionHandler();
                    ChainHandler inherit = new InheritanceHandler();

                    inherit.setSuccessor(compose);
                    compose.setSuccessor(associate);
                    inherit.drawLineHead(this.getGraphics(), relation, relationsBox[0], relationsBox[1]);
                    */

                    Edge lineEdge = new Edge(relationsBox[0], relationsBox[1], relation);
                    // blackboard.addEdge(new Edge(relationsBox[0], relationsBox[1], RelationshipType.ASSOCIATION));
                    blackboard.addEdge(lineEdge);
                }
                clickCount = 0;
            }

            repaint();
        } else
            clickCount = 0;

        System.out.println(blackboard.getAllEdges().size());
        /*
        for (Edge edge : blackboard.getAllEdges()) {
            // System.out.println(edgeCounter);
            edge.printEdgeInfo();
        }
        edgeCounter++;
        */
    }

    public RelationshipType chooseRelation() {

        RelationshipType relation = null;

        String relationChoice = (String) JOptionPane.showInputDialog(
                null,
                "Choose Relation",
                "Relationship Type",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                relationsOptions,
                relationsOptions[0]);

        if (relationChoice == null)
            return relation;

        if (relationChoice.equals(relationsOptions[0]))
            relation = RelationshipType.ASSOCIATION;
        else if (relationChoice.equals(relationsOptions[1]))
            relation = RelationshipType.COMPOSITION;
        else if (relationChoice.equals(relationsOptions[2]))
            relation = RelationshipType.INHERITANCE;

        return relation;
    }

    public void mousePressed(MouseEvent e) {
        // System.out.println("Pressed");
        int x = e.getX();
        int y = e.getY();
        currentBox = getBox(x, y);
        if (currentBox == null) // Point not within existing Box
            addBox(x, y);
    }

    public void mouseReleased(MouseEvent e) {
        // System.out.println("Released");
    }

    public void mouseEntered(MouseEvent e) {
        // System.out.println("Entered");
    }

    public void mouseExited(MouseEvent e) {
        // System.out.println("Exited");
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
        String name = (String) JOptionPane.showInputDialog(
                this,
                "Enter box name:\n",
                "Customized Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "");

        /*
        if (name == null)
            name = "Default" + defaultBoxCount++;
        */

        return name;
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
        else
            setCursor(Cursor.getDefaultCursor());
    }

    public Vertex getBox(int x, int y) {
        for (Vertex v : blackboard.getAllVertices()) {
            if (v.contains(x, y))
                return v;
        }
        return null;
    }
}
