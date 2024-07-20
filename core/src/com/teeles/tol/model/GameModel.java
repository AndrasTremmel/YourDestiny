package com.teeles.tol.model;

public class GameModel {
    private GameBoard board;

    public void StartNewGame(int width, int height) {
        board = new GameBoard(width, height);
    }
}
