package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    public static final int maxX = 500;

    public static final int maxY = 500;

    private int verticesNumber;

    private int edgesNumber;

    //table of vertexes, index is also vertex label
    private Vertex[] vertices;

    private HashMap<Integer, ArrayList<Edge>> crossEdges;

    private HashMap<Integer, ArrayList<Edge>> upEdges;

    private HashMap<Integer, ArrayList<Edge>> downEdges;

    private HashMap<Integer, List<Integer>> vertexByLevel;

    private int maxLevel = 0;

    private int initialColor[];

    public Graph(int n, int m) {
        this.edgesNumber = m;
        this.verticesNumber = n;
        vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i, maxX, maxY);
        }
        crossEdges = new HashMap<>();
        upEdges = new HashMap<>();
        downEdges = new HashMap<>();
        vertexByLevel = new HashMap<>();
    }

    public void addEdge(int e1, int e2){
       addEdgeToAdjList(e1, e2);
    }


    private void addEdgeToAdjList(int e1, int e2){
        vertices[e1].addEdge(e2);
        vertices[e2].addEdge(e1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("verticesNumber:"+ verticesNumber);
        for(int i = 0; i< verticesNumber; i++){
        }
        return sb.toString();
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

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public void setVertices(Vertex[] vertices) {
        this.vertices = vertices;
    }

    public boolean isEdge(int e1, int e2){
        return vertices[e1].getIndicateVertexes().contains(e2);
    }

    public HashMap<Integer, ArrayList<Edge>> getCrossEdges() {
        return crossEdges;
    }

    public void setCrossEdges(HashMap<Integer, ArrayList<Edge>> crossEdges) {
        this.crossEdges = crossEdges;
    }

    public HashMap<Integer, ArrayList<Edge>> getUpEdges() {
        return upEdges;
    }

    public void setUpEdges(HashMap<Integer, ArrayList<Edge>> upEdges) {
        this.upEdges = upEdges;
    }

    public HashMap<Integer, ArrayList<Edge>> getDownEdges() {
        return downEdges;
    }

    public void setDownEdges(HashMap<Integer, ArrayList<Edge>> downEdges) {
        this.downEdges = downEdges;
    }

    public HashMap<Integer, List<Integer>> getVertexByLevel() {
        return vertexByLevel;
    }

    public void setVertexByLevel(HashMap<Integer, List<Integer>> vertexByLevel) {
        this.vertexByLevel = vertexByLevel;
    }

    public void addCrossEdge(Integer level, Edge edge){
        crossEdges.computeIfAbsent(level, k -> new ArrayList<>());
        crossEdges.get(level).add(edge);
    }

    public void addUpEdge(Integer level, Edge edge){
        upEdges.computeIfAbsent(level, k -> new ArrayList<>());
        upEdges.get(level).add(edge);
    }

    public void addDownEdge(Integer level, Edge edge){
        downEdges.computeIfAbsent(level, k -> new ArrayList<>());
        downEdges.get(level).add(edge);
    }

    public void addVertexToLevelList(Integer level, Vertex vertex){
        vertexByLevel.computeIfAbsent(level, k -> new ArrayList<>());
        vertexByLevel.get(level).add(vertex.getNumber());
    }

    public void printLevelDescription(){
        for(int i=0;i<=maxLevel; i++){
            System.out.println("LEVEL " + i);
            printCrossEdges(i);
            printUpEdges(i);
        }
    }

    private void printUpEdges(int level) {
        if(upEdges.get(level) !=null){
            System.out.println("UP EDGES OF LEVEL "+ level);
            for(Edge e: upEdges.get(level)){
                System.out.println(e.toString());
            }
        }
    }

    private void printCrossEdges(int level) {
        if(crossEdges.get(level) != null){
            System.out.println("CROSS EDGES OF LEVEL "+ level);
            for(Edge e: crossEdges.get(level)){
                System.out.println(e.toString());
            }
        }
    }

    public int[] getInitialColor() {
        return initialColor;
    }

    public void setInitialColor(int[] initialColor) {
        this.initialColor = initialColor;
    }
}
