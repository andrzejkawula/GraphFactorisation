package gui;

import structures.Graph;
import structures.GraphManager;
import structures.Vertex;

import javax.swing.*;
import java.awt.*;

public class GraphFrame extends JFrame {

    private static Color DEFAULT_COLOR = Color.BLACK;

    private Color colors[] = {Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN, Color.ORANGE, Color.PINK};

    private Graph graph;

    public GraphFrame(String title, Graph graph) {
        super(title);
        this.graph = graph;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(700, 700);
        setLocation(0, 0);
        setVisible(true);
        setBackground(Color.WHITE);
        GraphManager gm = new GraphManager(graph);
        gm.BFS();
    }

    @Override
    public void paint(Graphics g) {
        //to do
//        g.setColor(DEFAULT_COLOR);
//        for(int i = 0; i< graph.getVerticesNumber(); i++){
//            for(int j = 0; j<graph.getVerticesNumber(); j++){
//                if(graph.getAdjacencyTable()[i][j] ==1){
//                    Vertex v = graph.getVertices()[i];
//                    Vertex w = graph.getVertices()[j];
//                    g.setColor(colors[graph.getInitialColor()[graph.getColorTable()[w.getNumber()][v.getNumber()]]]);
//                    g.drawLine(v.getxPos(), v.getyPos(), w.getxPos(), w.getyPos());
//                }
//            }
//        }
    }
}
