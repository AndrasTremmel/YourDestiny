package com.teeles.tol.model;

import com.teeles.tol.model.field.Field;

public class GameModel {
    private GameBoard board;

    public void StartNewGame(int width, int height) {
        board = new GameBoard(width, height);
    }

    public Field GetField(int x, int y) {
        return board.GetField(x, y);
    }
}
