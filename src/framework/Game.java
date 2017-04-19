package framework;

import gol.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by cortman on 2/14/17.
 */
@SuppressWarnings("serial")
public class Game extends JPanel implements Runnable {
    private int gameWidth;
    private int gameHeight;
    private Image gameImage;

    private Thread gameThread;
    private volatile boolean running;
    private volatile State currentState;

    private InputHandler inputHandler;

    public Game(int gameWidth, int gameHeight) {
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        setPreferredSize(new Dimension(gameWidth, gameHeight));
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocus();
    }

    public void setCurrentState(State newState) {
        System.gc();
        currentState = newState;
        newState.init();
        inputHandler.setCurrentState(currentState);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        initInput();
        setCurrentState(new GameBoard(GameMain.GRID_SIZE));
        initGame();
    }

    private void initInput() {
        inputHandler = new InputHandler();
        addKeyListener(inputHandler);
        addMouseListener(inputHandler);
    }

    public void exit() {
        running = false;
    }

    private void initGame() {
        running = true;
        gameThread = new Thread(this, "framework.Game Thread");
        gameThread.start();
    }

    @Override
    public void run() {
        while(running) {

            currentState.update();
            prepareGameImage();
            currentState.render(gameImage.getGraphics());
            repaint();
            try {
                Thread.sleep(12);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    private void prepareGameImage() {
        if( gameImage == null ) {
            gameImage = createImage(gameWidth, gameHeight);
        }

        Graphics g = gameImage.getGraphics();
        g.clearRect(0,0,gameWidth, gameHeight);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if ( gameImage == null ) {
            return;
        }

        g.drawImage(gameImage, 0, 0, null);
    }
}

