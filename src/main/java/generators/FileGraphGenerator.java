package generators;

import generators.interfaces.GraphGenerator;
import structures.Edge;
import structures.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileGraphGenerator implements GraphGenerator {

    private String path;

    @Override
    public Graph generateGraph() {
        try {
            return readGraphFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public FileGraphGenerator(String path) {
        this.path = path;
    }

    public Graph readGraphFromFile() throws FileNotFoundException, IllegalArgumentException {
        File file = new File(path);
        Scanner sc = new Scanner(file);

        Graph graph = createEmptyGraph(sc);
        int edgeCounter = 0;
        while (sc.hasNextInt()) {
            int a, b;
            Edge edge = new Edge();
            edge.setA(sc.nextInt());
            checkIsSccannerHasNextNumber(sc);
            edge.setB(sc.nextInt());

            checkIsVertexesNumberCorrect(graph, edge);

            edgeCounter = addEdge(graph, edgeCounter, edge);
        }
        checkGraphEdgeCounter(graph, edgeCounter);
        sc.close();
        return graph;
    }

    private void checkIsVertexesNumberCorrect(Graph graph, Edge edge) {
        if (isVertexesOutOfRange(graph, edge)) {
            throw new IllegalArgumentException("Incorrect vertex number");
        } else if (isEdgeVerticesEqual(edge)) {
            throw new IllegalArgumentException("Vertexes are equal");
        } else if (isGraphContainsSpecifiedEdge(graph, edge)) {
            throw new IllegalArgumentException("Edge was added");
        }
    }

    private boolean isGraphContainsSpecifiedEdge(Graph graph, Edge edge) {
        return graph.isEdge(edge.getA(), edge.getB());
    }

    private boolean isEdgeVerticesEqual(Edge edge) {
        return edge.getA().equals(edge.getB());
    }

    private boolean isVertexesOutOfRange(Graph graph, Edge edge) {
        return !(isFirstIsGreater(graph.getVerticesNumber(), edge.getA()) && isFirstIsGreater(graph.getVerticesNumber(), edge.getB()) &&
            isFirstIsGreater(edge.getA(), 0) && isFirstIsGreater(edge.getB(), 0));
    }

    private boolean isFirstIsGreater(Integer first, Integer second) {
        return first.compareTo(second) == 1;
    }

    private int addEdge(Graph graph, int edgeCounter, Edge edge) {
        graph.addEdge(edge.getA(), edge.getB());
        edgeCounter++;
        return edgeCounter;
    }

    private void checkGraphEdgeCounter(Graph graph, int edgeCounter) {
        if (edgeCounter != graph.getEdgesNumber()) {
            throw new IllegalArgumentException("Incorrect edges number");
        }
    }

    private void checkIsSccannerHasNextNumber(Scanner sc) {
        if (!sc.hasNextInt()) {
            throw new IllegalArgumentException();
        }
    }

    private Graph createEmptyGraph(Scanner sc) {
        int n, m;
        n = getVertexesNumber(sc);
        m = getEdgesNumber(sc);

        return new Graph(n, m);
    }

    private int getEdgesNumber(Scanner sc) {
        return getNextIntFromScanner(sc);
    }

    private int getVertexesNumber(Scanner sc) {
        return getNextIntFromScanner(sc);
    }

    private int getNextIntFromScanner(Scanner sc) {
        int nextNumber;
        if (sc.hasNextInt()) {
            nextNumber = sc.nextInt();
        } else {
            throw new IllegalArgumentException();
        }
        return nextNumber;
    }


}
