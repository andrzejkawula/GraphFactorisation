package gui;

import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame {
    public StartFrame() throws HeadlessException {
        super("Factorisation of Cartesian Product of Grapfs");
        setFrameComponents();
    }

    private void setFrameComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(450, 250);
        setLocation(200, 200);
        addPanel();
        setVisible(true);
    }

    private void addPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        JLabel label = new JLabel("<html>Welcome to Graph Factorisation Program. <br/>Press Start to continue.</html>", SwingConstants.CENTER);
        panel.add(label);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 3));
        panel2.add(new JPanel());
        panel2.add(createButton());
        panel2.add(new JPanel());
        panel.add(panel2);
        add(panel);
    }

    private JButton createButton() {
        JButton button = new JButton("Start");
        button.setBackground(Color.GRAY);
        button.setPreferredSize(new Dimension(100, 50));
        button.addActionListener(e -> {
            this.dispose();
            System.out.println("Start Panel is closed");
            new StartOptionFrame();
        });
        return button;
    }
}
