package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.compression.lzma.Base;

public class Score extends BaseActor {

    private float posX;
    private float posY;
    private String texture;

    public Score(float x, float y, Stage s, String texture) {
        super(x, y, s);


        this.texture = texture;
        this.posX = posX;
        this.posY = posY;


        loadTexture(texture);
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }
}
