package gol;

import framework.State;
import gol.Cell;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameBoard extends State {

    private static final int CELL_SIZE = 30;
    private Cell[][] board;

    public GameBoard(int boardSize) {

        board = new Cell[boardSize][boardSize];


    }

    public static int[] computeCoords(int rowIndex, int colIndex) {
        return new int[] {colIndex * CELL_SIZE,rowIndex*CELL_SIZE};

    }

    @Override
    public void init() {

        for (int i=0; i< board.length; i++) {
            for(int j=0; j< board[i].length; j++) {
                board[i][j] = new Cell();
            }
        }

    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {

        for (int rowIndex=0; rowIndex< board.length; rowIndex++) {
            for(int columnIndex=0; columnIndex< board[rowIndex].length; columnIndex++) {
                Cell c = board[rowIndex][columnIndex];
                drawCell(g, rowIndex, columnIndex, c);
            }
        }
    }

    private void drawCell(Graphics graphics, int rowIndex, int columnIndex, Cell cell) {
        if (cell.isAlive()) {
            graphics.setColor(Color.BLACK);
        } else {
            graphics.setColor(Color.WHITE);
        }

        int[] coords = computeCoords(rowIndex,columnIndex);
        graphics.fillRect(coords[0], coords[1],CELL_SIZE - 1,CELL_SIZE - 1);
    }

    @Override
    public void onClick(MouseEvent e) {

    }

    @Override
    public void onKeyPress(KeyEvent e) {

    }

    @Override
    public void onKeyRelease(KeyEvent e) {

    }
}
