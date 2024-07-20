package com.teeles.tol.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.teeles.tol.model.Field;
import com.teeles.tol.model.GameModel;


public class GameScreen implements Screen {

    final MyGame game;
    OrthographicCamera camera;
    final GameModel model;
    final ShapeRenderer shaperenderer;

    Texture greenImage;
    Texture seaImage;
    Texture rockImage;
    Texture treeImage;

    Texture[][] fields;

    public GameScreen(final MyGame gam, final GameModel model) {
        this.game = gam;
        this.model = model;
        this.shaperenderer = new ShapeRenderer();
        this.fields = new Texture[12][20];

        greenImage = new Texture(Gdx.files.internal("green.png"));
        seaImage = new Texture(Gdx.files.internal("sea.png"));
        rockImage = new Texture(Gdx.files.internal("rock.png"));
        treeImage = new Texture(Gdx.files.internal("tree.png"));

        initialiseFields();
        
        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
    }

    public void initialiseFields() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 20; j++) {
                fields[i][j] = rockImage;
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


        game.batch.begin();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 20; j++) {
                game.batch.draw(fields[i][j], 80 + j * 60, i * 60);
            }
        }


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