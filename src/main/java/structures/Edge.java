package structures;

public class Edge{

    private Integer a;

    private Integer b;

    private Integer color = null;

    public Edge(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public Edge(Vertex v1, Vertex v2){
        this.a = v1.getNumber();
        this.b= v2.getNumber();
    }

    public Edge() {

    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof  Edge) || obj == null){
            return false;
        }
        Edge e2=  (Edge) obj;
        return (e2.getA() == this.getA() && e2.getB() == this.getB()) || (e2.getA() == this.getB() && e2.getB() == this.getA());
    }

    @Override
    public String toString() {
        return "Edge: "+getA()+","+getB();
    }
}
