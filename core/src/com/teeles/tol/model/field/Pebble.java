package com.teeles.tol.model.field;

import com.teeles.tol.model.GameBoard;

import java.util.Random;

public class Pebble extends Green {
    private int number;

    public Pebble(int x, int y, GameBoard board) {
        super(x, y, board);
        Random rand = new Random();
        number = rand.nextInt(14) + 1;
    }

    @Override
    public boolean GatherStoon() {
        number--;
        if (number == 0) {
            board.NewField(x, y, new Green(x, y, board));
        }
        return true;
    }
}
