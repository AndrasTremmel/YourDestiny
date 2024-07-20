package com.teeles.tol.model;

import com.teeles.tol.model.character.Player;
import com.teeles.tol.model.field.Field;

public class GameModel {
    private GameBoard board;
    private Player player;

    public void StartNewGame(int width, int height) {
        board = new GameBoard(width, height);
        player = new Player(100,5, 5);
    }

    public Field GetField(int x, int y) {
        return board.GetField(x, y);
    }

    public void moveLeft() {
        if (canMoveLeft()) {
            player.moveLeft();
        }
    }

    public void moveRight() {
        if (canMoveRight()) {
            player.moveRight();
        }
    }

    public void moveUp() {
        if (canMoveUp()) {
            player.moveUp();
        }
    }

    public void moveDown() {
        if (canMoveDown()) {
            player.moveDown();
        }
    }

    public boolean canMoveLeft() {
        return player.getX() > 0;
    }

    public boolean canMoveRight() {
        return player.getX() < board.getWidth() - 1;
    }

    public boolean canMoveUp() {
        return player.getY() < board.getHeight() - 1;
    }

    public boolean canMoveDown() {
        return player.getY() > 0;
    }

    public Player getPlayer() {
        return player;
    }


}
