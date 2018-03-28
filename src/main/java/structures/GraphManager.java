package structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GraphManager {

    private Graph graph;

    public GraphManager(Graph graph) {
        this.graph = graph;
    }

    public void runFacorisation(){

    }


    public Vertex findMinDegreeVertex() {
        Vertex res = null;
        int min_degree = Integer.MAX_VALUE;
        for (Vertex v : graph.getVertices()) {
            int deg = v.getIndicateVertexes().size();
            if (deg < min_degree) {
                min_degree = deg;
                res = v;
            }
        }
        return res;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void BFS() {
        boolean wasVisit[] = new boolean[graph.getVerticesNumber()];
        Vertex table[] = new Vertex[graph.getVerticesNumber()];
        int cnt = 0;
        int curr = 0;
        //add start vertex
        setVertexBFSParams(findMinDegreeVertex(), wasVisit, 0, table, cnt);
        cnt++;
        while (curr < graph.getVerticesNumber() && table[curr] != null) {
            Vertex currVertex = table[curr];
            Set<Integer> indVer = currVertex.getIndicateVertexes();
            if (indVer != null) {
                for (Integer i : indVer) {
                    Vertex w = graph.getVertices()[i];
                    if (!wasVisit[i]) {
                        setVertexBFSParams(w, wasVisit, currVertex.getLevel() + 1, table, cnt);

                        cnt++;
                    }
                    addLevelEdges(currVertex, w);
                }
            }
            curr++;
        }
        System.out.println("BFS completed");
        if(curr != graph.getVerticesNumber()){
            //to do throw exception
            System.out.println("Graph is not connected- algoritm is only for connected graph");
        }
        graph.printLevelDescription();
        setLevelZeroEdgesColors();
        colorCrossEdges(1);
        for(int i=2; i<= graph.getMaxLevel() ; i++){
            colorDownEdges(i);
            colorCrossEdges(i);
            checkConsistency(i-1);
        }
        checkConsistency(graph.getMaxLevel());
    }

    private void checkConsistency(int level) {
        int distinctColor[] = Arrays.stream(graph.getInitialColor()).distinct().toArray();
        for(Integer i : graph.getVertexByLevel().get(level)){
            if(! isConsistency(i, distinctColor)){
                //mergeVertexColors(i);
            }
        }
    }

    private void mergeVertexColors(Integer i) {
        ArrayList<Integer> colorToMerge = new ArrayList<>();
        for(int w :graph.getVertices()[i].getIndicateVertexes()){
            if(graph.getVertices()[i].getLevel() >= graph.getVertices()[w].getLevel()){
                //to do
                //change
                //colorToMerge.add(graph.getColorTable()[w][i]);
            }
        }
        if(colorToMerge.size() >=2){
            for(int j=1;j<colorToMerge.size();j++){
                mergeColors(colorToMerge.get(0), colorToMerge.get(j));
            }
        }
    }

    private boolean isConsistency(Integer i, int[] distinctColor) {
        for(int col : distinctColor){
            boolean isFound = false;
            for(int w :graph.getVertices()[i].getIndicateVertexes()){
                //to do
//                if(graph.getInitialColor()[graph.getColorTable()[w][i]] == col){
//                    isFound = true;
//                }
            }
            if(!isFound){
                return false;
            }

        }
        return true;
    }

    private void addLevelEdges(Vertex currVertex, Vertex w) {
        //to provide that edge will be added only once
        if(currVertex.getNumber() > w.getNumber()){
            if(currVertex.getLevel() == w.getLevel() ){
                graph.addCrossEdge(currVertex.getLevel(), new Edge(currVertex, w));
            }
            else if(currVertex.getLevel() > w.getLevel()){
                graph.addUpEdge(w.getLevel(), new Edge(w, currVertex));
                graph.addDownEdge(currVertex.getLevel(), new Edge(currVertex, w));
            }
            else {
                graph.addDownEdge(w.getLevel(), new Edge(w, currVertex));
                graph.addUpEdge(currVertex.getLevel(), new Edge(currVertex, w));
            }
        }
    }

    private void setVertexBFSParams(Vertex v, boolean wasVisit[], int level, Vertex table[], int cnt){
        v.setLevel(level);
        wasVisit[v.getNumber()] = true;
        table[cnt] = v;
        graph.addVertexToLevelList(level, v);
        graph.setMaxLevel(Math.max(graph.getMaxLevel(), level));
    }

    public void setLevelZeroEdgesColors(){
        setGraphInitialColors();
        setZeroColors();
    }

    private void setZeroColors() {
        int i = 0;
        for(Edge e: graph.getUpEdges().get(0)){
            e.setColor(i++);
            setColorEdge(e);
        }
    }

    private void setColorEdge(Edge e){
        //to do
        // /graph.getColorTable()[e.getB()][e.getA()] = e.getColor();
        ///graph.getColorTable()[e.getA()][e.getB()] = e.getColor();
    }

    private void setGraphInitialColors(){
        int color[] = new int[graph.getUpEdges().get(0).size()];
        for(int i=0 ; i<color.length ; i++){
            color[i] = i;
        }
        graph.setInitialColor(color);
    }

    private void mergeColors(int c1, int c2){
        if(c1 > c2){
            graph.getInitialColor()[c1] = graph.getInitialColor()[c2];
        }
        else {
            graph.getInitialColor()[c2] = graph.getInitialColor()[c1];
        }
    }

    private void colorCrossEdges(int level){
        if(graph.getCrossEdges().get(level) != null){
            for(Edge e : graph.getCrossEdges().get(level)){
                Integer commonVertex = findCommonVertex(e.getA(), e.getB(), level-1);
                if(commonVertex != null){
                    //to do
//                    if(graph.getColorTable()[e.getA()][commonVertex] != graph.getColorTable()[e.getB()][commonVertex]){
//                        mergeColors(graph.getColorTable()[e.getA()][commonVertex], graph.getColorTable()[e.getB()][commonVertex]);
//                    }
//                    e.setColor(graph.getInitialColor()[graph.getColorTable()[e.getA()][commonVertex]]);
//                    setColorEdge(e);
                }
                else {
                    Integer downA = findDownNeighbour(e.getA(), level -1);
                    commonVertex = findCommonVertex(downA,e.getB(), level -1 );
                    if(commonVertex == null) {
                        commonVertex = findCommonVertex(downA,e.getB(), level );
                    }

                    if(commonVertex != null){
                        //to do
//                        e.setColor(graph.getInitialColor()[graph.getColorTable()[downA][commonVertex]]);
//                        setColorEdge(e);
                    }
                    else {
                        //to do
//                        e.setColor(graph.getInitialColor()[graph.getColorTable()[downA][e.getA()]]);
//                        setColorEdge(e);
                    }
                }
            }
        }
    }

    private void colorDownEdges(int level){
        for(Integer v : graph.getVertexByLevel().get(level)){
            List<Integer> downEdges = getDownEdges(graph.getVertices()[v]);
            if(downEdges.size() == 0){
                System.out.println("NIE MA KRAWEDZZI DOLNYCH JEZT BLAD");
            }
            else if(downEdges.size() ==1){
                Integer w = downEdges.get(0);
                Integer x = findDownNeighbour(w, level -2);
                //to do
//                graph.getColorTable()[w][v] = graph.getColorTable()[w][x];
//                graph.getColorTable()[v][w] = graph.getColorTable()[w][x];
            }
            else{
                Integer w = downEdges.get(0);
                Integer x = downEdges.get(1);
                Integer common = findCommonVertex(w, x, level-1);
                if(common == null){
                    common = findCommonVertex(w, x, level-2);
                }

                if( common == null){
                    Integer u = findDownNeighbour(w, level -2);
                    //to do
//                    graph.getColorTable()[w][v] = graph.getColorTable()[w][u];
//                    graph.getColorTable()[v][w] = graph.getColorTable()[w][u];
//                    u = findDownNeighbour(x, level -2);
//                    graph.getColorTable()[x][v] = graph.getColorTable()[x][u];
//                    graph.getColorTable()[v][x] = graph.getColorTable()[x][u];
                }
                else{
                    //to do
//                    graph.getColorTable()[w][v] = graph.getColorTable()[x][common];
//                    graph.getColorTable()[v][w] = graph.getColorTable()[x][common];
//
//                    graph.getColorTable()[x][v] = graph.getColorTable()[w][common];
//                    graph.getColorTable()[v][x] = graph.getColorTable()[w][common];
                }
                for(int i = 2; i < downEdges.size(); i++){
                    x = downEdges.get(i);
                    common = findCommonVertex(w, x, level-1);
                    if(common == null){
                        common = findCommonVertex(w, x, level-2);
                    }

                    if( common == null){
                        Integer u = findDownNeighbour(x, level -2);
                        //to do
//                        graph.getColorTable()[x][v] = graph.getColorTable()[x][u];
//                        graph.getColorTable()[v][x] = graph.getColorTable()[x][u];
                    }
                    else{
                        //to do
//                        graph.getColorTable()[x][v] = graph.getColorTable()[w][common];
//                        graph.getColorTable()[v][x] = graph.getColorTable()[w][common];
                    }
                }

            }
        }
    }

    private Integer findDownNeighbour(Integer v, int level) {
        for(Integer res : graph.getVertexByLevel().get(level)){
            if(graph.getVertices()[v].getIndicateVertexes().contains(res)){
                return res;
            }
        }
        return null;
    }

    private Integer findCommonVertex(Integer a, Integer b, int level) {
        for(Integer res : graph.getVertexByLevel().get(level)){
            if (graph.isEdge(res, a) && graph.isEdge(res, b) ){
                return  res;
            }
        }
        return null;
    }

    private List<Integer> getDownEdges(Vertex v){
        ArrayList<Integer> res = new ArrayList<>();
        for(Edge e : graph.getDownEdges().get(v.getLevel())){
            if(e.getA().equals(v.getNumber())){
                res.add(e.getB());
            }
            else if(e.getB().equals(v.getNumber())){
                res.add(e.getA());
            }
        }
        return res;
    }
}
