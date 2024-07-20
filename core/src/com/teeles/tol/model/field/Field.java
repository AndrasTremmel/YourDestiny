package com.teeles.tol.model.field;

import com.teeles.tol.model.GameBoard;

public abstract class Field {
    protected final int x;
    protected final int y;
    protected final GameBoard board;

    public Field(int x, int y, GameBoard board) {
        this.x = x;
        this.y = y;
        this.board = board;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Action methods
    public Boolean GatherStone() { return false; }

    public boolean GatherStoon() { return false; }
}
