package com.teeles.tol.model;

import com.teeles.tol.model.field.*;

public class GameBoard {
    private Field[][] board;
    private int width;
    private int height;

    public GameBoard(Field[][] board, int height, int width) {
        this.width = width;
        this.height = height;
        this.board = board;
    }
    public GameBoard(int height, int width) {
        this.width = width;
        this.height = height;
        GenerateBoard(height, width);
    }

    public void NewField(int x, int y, Field f) {
        board[x][y] = f;
    }

    private void GenerateBoard(int height, int width) {
        board = new Field[height][width];
        RandomGenerator rand = new RandomGenerator();
        rand.AddResult("Green", 150.0);
        rand.AddResult("Pebble", 10.0);
        rand.AddResult("Tree", 30.0);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String fieldType = rand.GetElement();
                System.out.println(fieldType);
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
        if (x < 0 || x >= height || y < 0 || y >= width) {
            throw new IllegalArgumentException("Illegal index for board.");
        }
        return board[x][y];
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
