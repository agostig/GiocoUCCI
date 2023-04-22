package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Player extends BaseActor{

    public final static int IDLE=0;
    public final static int LEFT=1;
    public final static int TOP=2;
    public final static int RIGHT=3;
    public final static int BOTTOM=4;

    private int direction=0;
    private int spostamento=50;

    private float deltaT = 0;


    //TEXTURE ANIMAZIONI
    String[] still =
            {"player-front.png"};
    private String[] right =
            {"player-run-right-1.png", "player-run-right-2.png"};
    private String[] left =
            {"player-run-left-1.png", "player-run-left-2.png"};
    private String[] forward =
            {"player-run-forward-1.png", "player-run-forward-2.png"};
    private String[] back =
            {"player-run-back-1.png", "player-run-back-2.png"};




    //TEXTURE REGION ANIMAZIONI
    Animation<TextureRegion>  playerStill;
    Animation<TextureRegion>  runRight;
    Animation<TextureRegion>  runLeft;
    Animation<TextureRegion>  runForward;
    Animation<TextureRegion>  runBack;


    public Player(float x, float y, Stage s)
    {
        super(x,y,s);


        playerStill = loadAnimationFromFiles(still, 0.1f, true);
        runRight = loadAnimationFromFiles(right, 0.4f, true);
        runLeft = loadAnimationFromFiles(left, 0.4f, true);
        runForward = loadAnimationFromFiles(forward, 0.4f, true);
        runBack = loadAnimationFromFiles(back, 0.4f, true);

        //End 2.0.

        setBoundaryPolygon(8);

        setDirection(Player.IDLE);



        //Begin 3.4.
        setAcceleration(400);
        setMaxSpeed(400);
        setDeceleration(5000);
        //End 3.4.*/
    }

    public void setDirection(int d)
    {
        direction=d;
    }

    public void act(float dt)
    {
        super.act(dt);


        /*
        //DA USERE NEL GIOCO
        if(direction==Player.LEFT)
        {
            this.moveBy(-spostamento, 0);
            setDirection(Player.IDLE);
        }
        else if(direction==Player.TOP)
        {
            this.moveBy(0, spostamento);
            setDirection(Player.IDLE);
        }
        else if(direction==Player.RIGHT)
        {
            this.moveBy(spostamento, 0);
            setDirection(Player.IDLE);
//            deltaT += dt;
//            Gdx.app.log("#dt", String.valueOf(dt));
//            Gdx.app.log("#deltaT", String.valueOf(deltaT));
//            Gdx.app.log("#x", String.valueOf(this.getX()));
//            //if(deltaT > 0.333)
//                //setDirection(Turtle.IDLE);
//            if(deltaT > 1)

        }
        else if(direction==Player.BOTTOM)
        {
            this.moveBy(0, -spostamento);
            setDirection(Player.IDLE);
        }
         */

        if(direction==Player.LEFT){
            setAnimation(runLeft);
            accelerateAtAngle(180);
        }
        else if(direction==Player.TOP){
            setAnimation(runBack);
            accelerateAtAngle(90);
        }
        else if(direction==Player.RIGHT){
            setAnimation(runRight);
            accelerateAtAngle(0);
        }
        else if(direction==Player.BOTTOM){
            setAnimation(runForward);
            accelerateAtAngle(270);
        }
        else if(direction==Player.IDLE){
            setAnimation(playerStill);
        }


        applyPhysics(dt);

        setAnimationPaused( !isMoving() );


        //if ( getSpeed() > 0 )
          //  setRotation( getMotionAngle() );
    }
}
