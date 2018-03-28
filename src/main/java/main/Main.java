package main;

import gui.StartFrame;

import java.awt.EventQueue;

public class Main {
    public static void main(String[] arg) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartFrame();
            }
        });
    }

}
