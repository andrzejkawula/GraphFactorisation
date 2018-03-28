package structures;

import java.util.*;

public class Vertex {

    private Integer number;

    private int xPos;

    private int yPos;

    private int[] coordinate;

    private Set<Integer> indicateVertexes;

    private int level;

    public Vertex(Integer number, int x, int y, int[] coordinate, Set<Integer> indicateVertexes) {
        this.number = number;
        this.xPos = x;
        this.yPos = y;
        this.coordinate = coordinate;
        this.indicateVertexes = indicateVertexes;
    }

    public Vertex() {
        indicateVertexes = new HashSet<>();
    }

    public Vertex(Integer number, int maxX, int maxY){
        this.number = number;
        radnomPosition(maxX, maxY);
    }

    public Vertex(int number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int[] coordinate) {
        this.coordinate = coordinate;
    }

    public Set<Integer> getIndicateVertexes() {
        return indicateVertexes;
    }

    public void setIndicateVertexes(Set<Integer> indicateVertexes) {
        this.indicateVertexes = indicateVertexes;
    }

    public void addEdge(Integer vertex) {
        if (indicateVertexes == null) {
            indicateVertexes = new HashSet<>();
        }
        indicateVertexes.add(vertex);
    }

    public void radnomPosition(int maxX,  int maxY){
        Random random = new Random();
        this.xPos = random.nextInt(maxX) + 100;
        this.yPos = random.nextInt(maxY) + 100;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
