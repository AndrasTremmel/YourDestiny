package com.teeles.tol.model.character;

public abstract class Character {
    int health;
    int x;
    int y;


    public Character(int health, int x, int y) {
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveLeft() {
        x -= 1;
    }

    public void moveRight() {
        x += 1;
    }

    public void moveUp() {
        y += 1;
    }

    public void moveDown() {
        y -= 1;
    }


}
