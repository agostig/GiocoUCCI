package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.compression.lzma.Base;

public class Screen extends BaseActor{


    public Screen(float x, float y, Stage s) {
        super(x, y, s);

        loadTexture("screen.png");

        this.setWidth(Gdx.graphics.getWidth() - 466);
        this.setHeight(120);
        this.setOpacity(0);
        setBoundaryRectangle();
    }
}
