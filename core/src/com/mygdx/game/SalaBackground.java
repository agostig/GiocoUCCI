package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class SalaBackground extends BaseActor {

    public SalaBackground(float x, float y, Stage s)
    {
        super(x,y,s);


        String[] filenames =
                //{"sala-telefono.png", "sala-telefono-scura.png"};
                {"sala-telefono.png"};


        loadAnimationFromFiles(filenames, 1f, true);
    }




}
