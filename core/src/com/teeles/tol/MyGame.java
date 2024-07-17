package com.teeles.tol;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGame extends ApplicationAdapter {
	private Texture dropImage;
	private Texture bucketImage;
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		dropImage = new Texture("drop.png");
		bucketImage = new Texture("bucket.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.5f, 0.5f, 0.5f, 1);
		batch.begin();
		//batch.draw(img, 0, 0);
		batch.draw(dropImage, 0, 0);
		batch.draw(bucketImage, 50, 50);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
