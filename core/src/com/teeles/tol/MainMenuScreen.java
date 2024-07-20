package com.teeles.tol;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {

    final MyGame game;
    Music backgroundMusic;

    ShapeRenderer shaperenderer;
    OrthographicCamera camera;

    public MainMenuScreen(final MyGame gam) {
        game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        // load the background music
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("got.wav"));
        // Set volume to maximum
        backgroundMusic.setVolume(1.0f);
        //set music to loop
        backgroundMusic.setLooping(true);
        backgroundMusic.play();

        shaperenderer = new ShapeRenderer();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.setColor(255, 255, 255, 1);
        game.font.draw(game.batch, "New Game", 590, 500);
        game.batch.end();

//        shaperenderer.begin(ShapeRenderer.ShapeType.Line);
//        shaperenderer.setColor(255, 255, 255, 1);
//        shaperenderer.rect(440, 450, 400, 100);
//        shaperenderer.end();

        RectAngle rect = new RectAngle(440, 450, 400, 100, 255, 255, 255, 1, shaperenderer);
        rect.draw(ShapeRenderer.ShapeType.Line);

        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

             if (rect.isTouched(touchPos)) {
                 game.setScreen(new GameScreen(game));
                 dispose();
             }
        }
    }

    private void drawRoundedRect(float x, float y, float width, float height, float radius) {
        // Draw central rectangle
        shaperenderer.rect(x + radius, y + radius, width - 2 * radius, height - 2 * radius);

        // Draw four side rectangles
        shaperenderer.rect(x + radius, y, width - 2 * radius, radius);
        shaperenderer.rect(x + radius, y + height - radius, width - 2 * radius, radius);
        shaperenderer.rect(x, y + radius, radius, height - 2 * radius);
        shaperenderer.rect(x + width - radius, y + radius, radius, height - 2 * radius);

        // Draw four corner circles
        shaperenderer.arc(x + radius, y + radius, radius, 180, 90);
        shaperenderer.arc(x + width - radius, y + radius, radius, 270, 90);
        shaperenderer.arc(x + radius, y + height - radius, radius, 90, 90);
        shaperenderer.arc(x + width - radius, y + height - radius, radius, 0, 90);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        shaperenderer.dispose();
        backgroundMusic.dispose();
    }
}