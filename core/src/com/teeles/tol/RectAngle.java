package com.teeles.tol;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

import java.lang.reflect.Array;
import java.util.zip.CheckedInputStream;

public class RectAngle implements Shapes {

    private int x;
    private int y;
    private int width;
    private int height;
    private int r;
    private int g;
    private int b;
    private int a;
    final private ShapeRenderer shaperenderer;

    public RectAngle(int x, int y, int width, int height, int r, int g, int b, int a, ShapeRenderer shaperenderer) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        this.shaperenderer = shaperenderer;
    }

    @Override
    public void draw(ShapeRenderer.ShapeType style) {
        this.shaperenderer.begin(style);
        this.shaperenderer.setColor(this.r, this.g, this.b, this.a);
        this.shaperenderer.rect(this.x, this.y, this.width, this.height);
        this.shaperenderer.end();
    }

    @Override
    public boolean isTouched(Vector3 touchPos) {
        if (touchPos.x >= this.x && touchPos.x <= this.x + this.width && touchPos.y >= this.y && touchPos.y <= this.y + this.height) {
            return true;
        }
        return false;
    }
}

