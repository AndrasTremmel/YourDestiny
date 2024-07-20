package com.teeles.tol.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.teeles.tol.model.GameModel;

public class MyGame extends Game {

	SpriteBatch batch;
	BitmapFont font;

	ShapeRenderer shaperenderer;
	GameModel model;

	public void create() {
		batch = new SpriteBatch();
		model = new GameModel();

		// Use LibGDX's default Arial font.
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	public void setGameScreen() {
		setScreen(new GameScreen(this, model));
	}
}