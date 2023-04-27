package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class HaiVinto extends BaseActor{

    private String[] animazioni = {};
    Animation<TextureRegion> textureRegion;
    private float posX;
    private float posY;


    public HaiVinto(float x, float y, Stage s, Animation<TextureRegion> textureRegionAnimation, String[] animazioni, float posX, float posY) {
        super(x, y, s);

        this.animazioni = animazioni;
        this.textureRegion = textureRegionAnimation;
        this.posX = posX;
        this.posY = posY;

        textureRegionAnimation = loadAnimationFromFiles(animazioni, 0.2f, false);
        setAnimation(textureRegionAnimation);
    }


    //GET
    public String[] getAnimazioni() {
        return animazioni;
    }

    public Animation<TextureRegion> getTextureRegion() {
        return textureRegion;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }
}
