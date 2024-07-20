package com.teeles.tol.model;

import com.teeles.tol.model.field.*;

public class GameBoard {
    private Field[][] board;
    private int width;
    private int height;

    public GameBoard(Field[][] board, int width, int height) {
        this.width = width;
        this.height = height;
        this.board = board;
    }
    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        GenerateBoard(width, height);
    }

    public void NewField(int x, int y, Field f) {
        board[x][y] = f;
    }

    private void GenerateBoard(int width, int height) {
        board = new Field[width][height];
        RandomGenerator rand = new RandomGenerator();
        rand.AddResult("Green", 80.0);
        rand.AddResult("Pebble", 10.0);
        rand.AddResult("Tree", 15.0);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                String fieldType = rand.GetElement();
                Field field;
                switch (fieldType) {
                    case "Pebble":
                        field = new Pebble(i, j, this);
                        break;
                    case "Tree":
                        field = new Tree(i, j, this);
                        break;
                    default:
                        field = new Green(i, j, this);
                        break;
                }
                board[i][j] = field;
            }
        }
    }

    public Field GetField(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IllegalArgumentException("Illegal index for board.");
        }
        return board[x][y];
    }
}
