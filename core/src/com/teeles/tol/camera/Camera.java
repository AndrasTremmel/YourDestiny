package com.teeles.tol.camera;

public class Camera {
    int x;
    int y;
    int height;
    int width;


    public Camera(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBottomRightX() {
        return x + height - 1;
    }

    public int getBottomRightY() {
        return y + width - 1;
    }

    public void shiftLeft() {
        y -= 1;
    }

    public void shiftRight() {
        y += 1;
    }

    public void shiftDown() {
        x += 1;
    }

    public void shiftUp() {
        x -= 1;
    }

}
