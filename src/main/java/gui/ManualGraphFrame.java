package gui;

import javax.swing.*;
import java.awt.*;

public class ManualGraphFrame extends JFrame {

    ManualGraphPanel panel = new ManualGraphPanel();
    JButton button ;

    public ManualGraphFrame(){
        super("Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(500, 500);
        setLocation(200, 200);
        setVisible(true);
        setLayout(new FlowLayout());
        add(panel);
        setButtonProperties();
        add(button);
    }

    private void setButtonProperties() {
        button = new JButton("Find Factorisation");
        button.addActionListener(e-> {
            if(panel.getGraph().getEdgesNumber() <= panel.getEdgeCounter()){
                this.dispose();
                new GraphFrame("Graph", panel.getGraph());
            }
        });
    }


}
