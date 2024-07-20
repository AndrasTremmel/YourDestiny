package com.teeles.tol;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

import java.util.Vector;

public interface Shapes {
    public void draw(ShapeRenderer.ShapeType style);

    public boolean isTouched(Vector3 touchPos);
}