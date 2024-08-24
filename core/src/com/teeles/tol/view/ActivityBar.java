package com.teeles.tol.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ActivityBar {

    Stage stage;
    int movements;
    boolean endRound;

    Texture endRoundText;

    Texture endRoundTextClicked;
    Image endRoundImg;

    public ActivityBar(Stage stage) {
        this.movements = 3;
        this.endRound = true;
        this.stage = stage;

        this.endRoundText = new Texture(Gdx.files.internal("endround.png"));
        this.endRoundTextClicked = new Texture(Gdx.files.internal("endroundclicked.png"));
        this.endRoundImg = new Image(endRoundText);
        endRoundImg.setPosition(0, 0);
        stage.addActor(endRoundImg);
        endRoundImg.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                endRound();
            }
        });
    }

    public void endRound() {
        endRound = !endRound;
        if (endRound)
            endRoundImg.setDrawable(new Image(endRoundText).getDrawable());
        else
            endRoundImg.setDrawable(new Image(endRoundTextClicked).getDrawable());
        System.out.println("Clicked the end round button");
    }

    public void show() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
}
