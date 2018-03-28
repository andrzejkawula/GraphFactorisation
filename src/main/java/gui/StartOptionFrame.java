package gui;

import generators.DefaultGraphGenerator;
import structures.Graph;

import javax.swing.*;
import java.awt.*;

public class StartOptionFrame extends JFrame {

    public StartOptionFrame() {
        super("Factorisation of Cartesian Product of Grapfs");
        setComponents();
    }

    private void setComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(450, 250);
        setLocation(200, 200);
        addPanel();
        setVisible(true);
    }

    private void addPanel() {
        JPanel[][] panelHolder = new JPanel[3][3];
        setLayout(new GridLayout(3, 3, 20, 20));

        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                panelHolder[m][n] = new JPanel();
                add(panelHolder[m][n]);
            }
        }

        panelHolder[0][1].add(defaultButton());
        panelHolder[1][1].add(manualButton());
        panelHolder[2][1].add(fileButton());
    }

    private JButton defaultButton() {
        JButton button = new JButton("Default");
        button.addActionListener(e-> {
            this.dispose();
            Graph g = (new DefaultGraphGenerator()).generateGraph();
            new GraphFrame("Graph", g);
        });
        return button;
    }

    private JButton manualButton() {
        JButton button = new JButton("Manually");
        button.addActionListener(e-> {
            System.out.println("Start option panel is closed");
            this.dispose();
            new ManualGraphFrame();
        });
        return button;
    }

    private JButton fileButton() {
        JButton button = new JButton("From file");
        return button;
    }

}
