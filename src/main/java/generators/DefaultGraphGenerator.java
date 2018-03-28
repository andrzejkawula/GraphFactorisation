package generators;


import generators.interfaces.GraphGenerator;
import structures.Graph;

import java.util.Random;

public class DefaultGraphGenerator implements GraphGenerator{

    public DefaultGraphGenerator(){

    }

    public Graph generateGraph(){
        Random random = new Random();
        int i = random.nextInt() % 3;
        if(i==0){
            return generateK4();
        }
        if (i==1){
            return generateC4();
        }
        else {
            return  generateBigGraph();
        }
    }

    private Graph generateC4(){
        Graph g = new Graph(4, 4);
        g.getVertices()[0].setxPos(100);
        g.getVertices()[0].setyPos(300);
        g.getVertices()[1].setxPos(300);
        g.getVertices()[1].setyPos(100);
        g.getVertices()[2].setxPos(500);
        g.getVertices()[2].setyPos(300);
        g.getVertices()[3].setxPos(300);
        g.getVertices()[3].setyPos(500);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        return g;
    }

    private Graph generateK4(){
        Graph g = new Graph(4, 6);
        g.getVertices()[0].setxPos(100);
        g.getVertices()[0].setyPos(300);
        g.getVertices()[1].setxPos(300);
        g.getVertices()[1].setyPos(100);
        g.getVertices()[2].setxPos(500);
        g.getVertices()[2].setyPos(300);
        g.getVertices()[3].setxPos(300);
        g.getVertices()[3].setyPos(500);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.addEdge(1,3);
        g.addEdge(0,2);
        return g;
    }

    private Graph generateBigGraph(){
        Graph g = new Graph(20, 40);
        g.getVertices()[0].setxPos(120);
        g.getVertices()[0].setyPos(500);
        g.getVertices()[1].setxPos(100);
        g.getVertices()[1].setyPos(400);
        g.getVertices()[2].setxPos(100);
        g.getVertices()[2].setyPos(200);
        g.getVertices()[3].setxPos(120);
        g.getVertices()[3].setyPos(100);
        g.getVertices()[4].setxPos(140);
        g.getVertices()[4].setyPos(300);
        g.getVertices()[5].setxPos(220);
        g.getVertices()[5].setyPos(550);
        g.getVertices()[6].setxPos(200);
        g.getVertices()[6].setyPos(450);
        g.getVertices()[7].setxPos(200);
        g.getVertices()[7].setyPos(250);
        g.getVertices()[8].setxPos(220);
        g.getVertices()[8].setyPos(150);
        g.getVertices()[9].setxPos(240);
        g.getVertices()[9].setyPos(350);
        g.getVertices()[10].setxPos(320);
        g.getVertices()[10].setyPos(500);
        g.getVertices()[11].setxPos(300);
        g.getVertices()[11].setyPos(400);
        g.getVertices()[12].setxPos(300);
        g.getVertices()[12].setyPos(200);
        g.getVertices()[13].setxPos(320);
        g.getVertices()[13].setyPos(100);
        g.getVertices()[14].setxPos(340);
        g.getVertices()[14].setyPos(300);
        g.getVertices()[15].setxPos(420);
        g.getVertices()[15].setyPos(550);
        g.getVertices()[16].setxPos(400);
        g.getVertices()[16].setyPos(450);
        g.getVertices()[17].setxPos(400);
        g.getVertices()[17].setyPos(250);
        g.getVertices()[18].setxPos(420);
        g.getVertices()[18].setyPos(150);
        g.getVertices()[19].setxPos(440);
        g.getVertices()[19].setyPos(350);

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,0);

        g.addEdge(5,6);
        g.addEdge(6,7);
        g.addEdge(7,8);
        g.addEdge(8,9);
        g.addEdge(9,5);

        g.addEdge(10,11);
        g.addEdge(11,12);
        g.addEdge(12,13);
        g.addEdge(13,14);
        g.addEdge(14,10);

        g.addEdge(15,16);
        g.addEdge(16,17);
        g.addEdge(17,18);
        g.addEdge(18, 19);
        g.addEdge(19,15);

        g.addEdge(0,5);
        g.addEdge(5,15);
        g.addEdge(15,10);
        g.addEdge(10,0);

        g.addEdge(1,6);
        g.addEdge(6,16);
        g.addEdge(16,11);
        g.addEdge(1,11);

        g.addEdge(2,7);
        g.addEdge(7,17);
        g.addEdge(17,12);
        g.addEdge(12,2);

        g.addEdge(3,8);
        g.addEdge(8,18);
        g.addEdge(18,13);
        g.addEdge(3,13);

        g.addEdge(4,9);
        g.addEdge(9,19);
        g.addEdge(19,14);
        g.addEdge(4,14);
        return g;
    }
}
