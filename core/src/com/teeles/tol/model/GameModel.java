package com.teeles.tol.model;

import com.teeles.tol.EventListener.Event;
import com.teeles.tol.EventListener.EventBus;
import com.teeles.tol.camera.Camera;
import com.teeles.tol.model.character.Player;
import com.teeles.tol.model.field.Field;
import com.teeles.tol.model.field.Green;

public class GameModel {
    private GameBoard board;
    private Player player;

    private Camera camera;

    private EventBus eventbus;

    public void StartNewGame(int height, int width, EventBus eventbus) {
        board = new GameBoard(height, width);
        player = new Player(100,0, 0);
        camera = new Camera(0,0,12,20);
        this.eventbus = eventbus;
    }

    public Field GetField(int x, int y) {
        return board.GetField(x, y);
    }

    public GameBoard getBoard() {
        return board;
    }

    public void moveLeft() {
        if (canMoveLeft()) {
            player.moveLeft();
            if (cameraMovesLeft()) {
                camera.shiftLeft();
                eventbus.publish(new Event("CameraMoves", ""));
            }
        }
    }

    public void moveRight() {
        if (canMoveRight()) {
            player.moveRight();
            if (cameraMovesRight()) {
                camera.shiftRight();
                eventbus.publish(new Event("CameraMoves", ""));
            }
        }
    }

    public void moveUp() {
        if (canMoveUp()) {
            player.moveUp();
            if (cameraMovesUp()) {
                camera.shiftUp();
                eventbus.publish(new Event("CameraMoves", ""));
            }
        }
    }

    public void moveDown() {
        if (canMoveDown()) {
            player.moveDown();
            if (cameraMovesDown()) {
                camera.shiftDown();
                eventbus.publish(new Event("CameraMoves", ""));
            }
        }
    }

    public boolean cameraMovesLeft() {
        return camera.getY() > 0 && camera.getY() == player.getY();
    }

    public boolean cameraMovesRight() {
        return camera.getBottomRightY() < board.getWidth() - 1 && camera.getBottomRightY() == player.getY();
    }

    public boolean cameraMovesUp() {
        return camera.getX() > 0 && camera.getX() == player.getX();
    }

    public boolean cameraMovesDown() {
        return camera.getBottomRightX() < board.getHeight() - 1 && camera.getBottomRightX() == player.getX();
    }

    public boolean canMoveLeft() {
        if (player.getY() == 0)
            return false;
        Class<? extends Field> aClass = GetField(player.getX(), player.getY() - 1).getClass();
        return aClass.equals(Green.class);
    }

    public boolean canMoveRight() {
        if (player.getY() == board.getWidth() - 1)
                return false;
        Class<? extends Field> aClass = GetField(player.getX(), player.getY() + 1).getClass();
        return aClass.equals(Green.class);
    }

    public boolean canMoveUp() {
        if (player.getX() == 0)
            return false;
        Class<? extends Field> aClass = GetField(player.getX() - 1, player.getY()).getClass();
        return aClass.equals(Green.class);
    }

    public boolean canMoveDown() {
        if (player.getX() == board.getHeight() - 1)
            return false;
        Class<? extends Field> aClass = GetField(player.getX() + 1, player.getY()).getClass();
        return aClass.equals(Green.class);
    }

    public Player getPlayer() {
        return player;
    }

    public Camera getCamera() {
        return camera;
    }

}
