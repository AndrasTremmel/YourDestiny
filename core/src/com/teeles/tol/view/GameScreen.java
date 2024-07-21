package com.teeles.tol.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.teeles.tol.model.field.*;
import com.teeles.tol.model.GameModel;

import javax.swing.plaf.synth.SynthTextAreaUI;


public class GameScreen implements Screen {

    final MyGame game;
    OrthographicCamera camera;
    final GameModel model;
    final ShapeRenderer shaperenderer;

    Texture greenImage;
    Texture seaImage;
    Texture rockImage;
    Texture treeImage;
    Texture manImage;

    Texture[][] fields;

    public GameScreen(final MyGame gam, final GameModel model) {
        this.game = gam;
        this.model = model;
        model.StartNewGame(12, 20);
        this.shaperenderer = new ShapeRenderer();
        this.fields = new Texture[12][20];

        greenImage = new Texture(Gdx.files.internal("green.png"));
        seaImage = new Texture(Gdx.files.internal("sea.png"));
        rockImage = new Texture(Gdx.files.internal("rock.png"));
        treeImage = new Texture(Gdx.files.internal("tree.png"));
        manImage = new Texture(Gdx.files.internal("man.png"));


        initialiseFields();
        
        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
    }

    public void initialiseFields() {
        for (int i = 0; i < model.getBoard().getHeight(); i++) {
            for (int j = 0; j < model.getBoard().getWidth(); j++) {
                Class<? extends Field> aClass = model.GetField(i, j).getClass();
                if (aClass.equals(Green.class)) {
                    fields[i][j] = greenImage;
                } else if (aClass.equals(Pebble.class)) {
                    fields[i][j] = rockImage;
                } else if (aClass.equals(Tree.class)) {
                    fields[i][j] = treeImage;
                }
            }
        }
    }

    @Override
    public void render(float delta) {
        // clear the screen with a dark blue color. The
        // arguments to clear are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        ScreenUtils.clear(0, 0, 0, 1);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);

        //checking if there was any user input
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            model.moveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            model.moveRight();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            model.moveUp();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            model.moveDown();
        }



        game.batch.begin();
        for (int i = 0; i < model.getBoard().getHeight(); i++) {
            for (int j = 0; j < model.getBoard().getWidth(); j++) {
                game.batch.draw(fields[i][j], 80 + j * 60, i * 60);
            }
        }

        game.batch.enableBlending();
        game.batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        // Draw the overlay image with transparency
        game.batch.setColor(1, 1, 1, 0.3f); // Set transparency to 50
        game.batch.draw(manImage, 80 + model.getPlayer().getX() * 60, model.getPlayer().getY() * 60); // Draw at position (50, 50)

        // Reset color to opaque
        game.batch.setColor(1, 1, 1, 1);

        game.batch.end();
    }


    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown

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

    }

}