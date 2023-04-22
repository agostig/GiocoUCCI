package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class SalaBackground extends BaseActor {

    public SalaBackground(float x, float y, Stage s)
    {
        super(x,y,s);

        /*String[] filenames =
                {"sala2.png", "sala3.png"};

         */
        String[] filenames =
                {"sala-telefono.png"};


        loadAnimationFromFiles(filenames, 1f, true);
    }




}
