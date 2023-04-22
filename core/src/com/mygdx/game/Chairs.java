package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.compression.lzma.Base;

public class Chairs extends BaseActor{


    public Chairs(float x, float y, Stage s) {
        super(x, y, s);

        loadTexture("chairs-bd.png");

        this.setWidth(Gdx.graphics.getWidth() - 750);
        this.setHeight(70);
        this.setOpacity(0);
        setBoundaryRectangle();
    }
}
