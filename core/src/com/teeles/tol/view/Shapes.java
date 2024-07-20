package com.teeles.tol.view;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

public interface Shapes {
    public void draw(ShapeRenderer.ShapeType style);

    public boolean isTouched(Vector3 touchPos);
}