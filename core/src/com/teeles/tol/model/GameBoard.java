package com.teeles.tol.model;

import com.teeles.tol.model.field.Field;
import com.teeles.tol.model.field.Green;
import com.teeles.tol.model.field.Pebble;

import java.util.Random;

public class GameBoard {
    private Field[][] board;

    public GameBoard(Field[][] board) {
        this.board = board;
    }
    public GameBoard(int width, int height) {
        GenerateBoard(width, height);
    }

    public void NewField(int x, int y, Field f) {
        board[x][y] = f;
    }

    private void GenerateBoard(int width, int height) {
        board = new Field[width][height];
        Random rand = new Random();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int random = rand.nextInt(100);
                if (random < 80) {
                    board[i][j] = new Green(i, j, this);
                } else {
                    board[i][j] = new Pebble(i, j, this);
                }

            }
        }
    }
}
