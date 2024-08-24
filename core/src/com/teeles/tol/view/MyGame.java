package com.teeles.tol.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.teeles.tol.EventListener.EventBus;
import com.teeles.tol.model.GameModel;

public class MyGame extends Game {

	SpriteBatch batch;
	BitmapFont font;

	ShapeRenderer shaperenderer;
	GameModel model;

	EventBus eventbus = new EventBus();

	public void create() {
		batch = new SpriteBatch();
		model = new GameModel();

		// Use LibGDX's default Arial font.
		font = new BitmapFont();
		System.out.println("Starting");
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
		setScreen(new GameScreen(this, model, eventbus));
	}
}