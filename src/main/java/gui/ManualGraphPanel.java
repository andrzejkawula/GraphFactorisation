package gui;

import generators.ManualGraphGenerator;
import structures.Graph;

import javax.swing.*;
import java.awt.*;

public class ManualGraphPanel extends JPanel {

    private int verticesNumber;
    private int edgesNumber;
    private int a;
    private int b;
    private int edgeCounter = 0;

    private Graph graph;
    private ManualGraphGenerator graphGenerator = new ManualGraphGenerator();

    private JButton graphSizeButton;
    private JButton edgeButton;
    private JLabel sizeText = new JLabel("Numbers of vertexes");
    private JLabel rowText = new JLabel("Number of edges");
    private JTextField sizeField = new JTextField();
    private JTextField rowField = new JTextField();
    private JLabel aText = new JLabel("End of edge");
    private JLabel bText = new JLabel("End of edge");
    private JTextField aField = new JTextField();
    private JTextField bField = new JTextField();

    public ManualGraphPanel(){
        setPanelComponent();
    }

    private void setPanelComponent() {
        setLayout(new GridLayout(6, 2, 20, 20));
        setGraphSizeButton();
        setEdgeButton();
        add(sizeText);
        add(sizeField);
        add(rowText);
        add(rowField);
        add(new JPanel());
        add(graphSizeButton);
        add(aText);
        add(aField);
        add(bText);
        add(bField);
        add(new JPanel());
        add(edgeButton);
        aField.setEnabled(false);
        bField.setEnabled(false);
    }

    private void setGraphSizeButton(){
        graphSizeButton = new JButton("Set graph size");
        graphSizeButton.addActionListener(e->{
            try{
                verticesNumber = Integer.parseInt(sizeField.getText());
                edgesNumber = Integer.parseInt(rowField.getText());
                changeFieldVisibility();
                setGraph(new Graph(verticesNumber, edgesNumber));
            } catch (NumberFormatException el){
                new ErrorFrame("Number of edges/vertexes must be a number!");
            } catch (NullPointerException e1){
                new ErrorFrame("Number of edges/vertexes cannot be empty!");
            }
        } );
    }

    private void changeFieldVisibility() {
        aField.setEnabled(true);
        bField.setEnabled(true);
        sizeField.setEnabled(false);
        rowField.setEnabled(false);
    }

    private void setEdgeButton(){
        edgeButton = new JButton("Set Edge");
        edgeButton.addActionListener(e-> {
            if(edgeCounter >= edgesNumber){
                new ErrorFrame("Edge limit is reached. Press Find Factorisation Button");
            }
            else{
                try{
                    a = Integer.parseInt(aField.getText());
                    b = Integer.parseInt(bField.getText());
                    if(a>= verticesNumber || b>= verticesNumber || a<0 || b<0){
                        new ErrorFrame("Incorrect vertex number.");
                    }else if (a==b){
                        new ErrorFrame("Vertexes number is the same.");
                    }else if (graph.isEdge(a, b)){
                        new ErrorFrame("Edge was added.");
                    }
                    else{
                        graph.addEdge(a, b);
                        edgeCounter ++;
                        aField.setText(null);
                        bField.setText(null);
                    }
                } catch (NumberFormatException el){
                    new ErrorFrame("Vertex number must be null");
                } catch (NullPointerException e1){
                    new ErrorFrame("Vertex number cannot be empty!");
                }
            }
        });
    }

    public int getVerticesNumber() {
        return verticesNumber;
    }

    public void setVerticesNumber(int verticesNumber) {
        this.verticesNumber = verticesNumber;
    }

    public int getEdgesNumber() {
        return edgesNumber;
    }

    public void setEdgesNumber(int edgesNumber) {
        this.edgesNumber = edgesNumber;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public int getEdgeCounter() {
        return edgeCounter;
    }

    public void setEdgeCounter(int edgeCounter) {
        this.edgeCounter = edgeCounter;
    }
}
