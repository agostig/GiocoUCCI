package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.compression.lzma.Base;

public class Wall extends BaseActor{


    public Wall(float x, float y, Stage s) {
        super(x, y, s);

        loadTexture("wall-db.png");

        this.setWidth(this.getWidth() -30);
        //this.setHeight(70);
        this.setOpacity(0);
        setBoundaryRectangle();
    }
}