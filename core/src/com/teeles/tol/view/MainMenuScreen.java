package com.teeles.tol.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenuScreen extends ApplicationAdapter implements Screen {

    final MyGame game;
    Music backgroundMusic;

    ShapeRenderer shaperenderer;
    OrthographicCamera camera;

    Stage stage;
    Texture newGameTexture;
    Image newGameImage;

    public MainMenuScreen(final MyGame gam) {
        game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.newGameTexture = new Texture(Gdx.files.internal("newgame.png"));
        this.newGameImage = new Image(newGameTexture);

        newGameImage.setPosition(440, 450);
        stage.addActor(newGameImage);
        newGameImage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setGameScreen();
                dispose();
            }
        });

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



        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        /*game.batch.begin();
        game.batch.setColor(255, 255, 255, 1);
        game.font.draw(game.batch, "New Game", 590, 500);
        game.batch.end();



        RectAngle rect = new RectAngle(440, 450, 400, 100, 255, 255, 255, 1, ShapeRenderer.ShapeType.Line, shaperenderer);
        rect.draw();

        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

             if (rect.isTouched(touchPos)) {
                 game.setGameScreen();
                 dispose();
             }
        }*/
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
        stage.dispose();
    }
}