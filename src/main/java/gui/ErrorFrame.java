package gui;

import javax.swing.*;
import java.awt.*;

public class ErrorFrame extends JFrame {

    public ErrorFrame(String error){
        super(error);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(500, 100);
        setLocation(300, 300);
        setVisible(true);
        setLayout(new FlowLayout());
        JButton button = new JButton("OK");
        button.addActionListener(e-> {
            this.dispose();
        });
        add(button);
    }

}
