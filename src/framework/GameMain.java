package framework;

import framework.Game;

import javax.swing.*;

/**
 * Created by cortman on 4/18/17.
 */
public class GameMain {


    public static final int WIDTH = 800;
    public static final int HEIGHT = 400;
    public static final int GRID_SIZE = 10;

    static Game sGame;

    public static void main(String... args) {
        JFrame frame = new JFrame("Conways framework.Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(true);

        sGame = new Game(WIDTH,HEIGHT);
        frame.add(sGame);
        frame.pack();

        frame.setVisible(true);
    }
}


