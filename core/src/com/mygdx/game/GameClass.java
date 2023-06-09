package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;

import java.sql.Time;
import java.util.Random;

import javax.swing.text.View;

public class GameClass extends GameBeta {

    private Player player;
    private SalaBackground salaBackground;

    //BUTTONS
    private Button buttonRight;
    private Button buttonLeft;
    private Button buttonTop;
    private Button buttonBottom;
    private TextButton.TextButtonStyle textButtonStyle_right;
    private TextButton.TextButtonStyle textButtonStyle_left;
    private TextButton.TextButtonStyle textButtonStyle_up;
    private TextButton.TextButtonStyle textButtonStyle_down;
    private Button buttonReplay;
    private TextButton.TextButtonStyle textButtonStyle_replay;


    //BOUNDARIES
    private Screen screen;
    private Chairs chairs1;
    private Chairs chairs2;
    private Chairs chairs3;
    private Wall wall1;
    private Wall wall2;
    private Wall wall3;
    private Wall wall4;
    private Wall wall5;


    //NEMICI
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;
    private Enemy enemy5;
    private Enemy enemy6;
    private Enemy enemy7;
    private Enemy enemy8;
    private Enemy enemy9;
    private Enemy enemy10;
    private Enemy enemy11;
    private Enemy enemy12;
    private Enemy enemy13;
    private Enemy enemy14;



    //ANIMAZIONI NEMICI
    private String[] persona1telefono =
            {"persona-1-telefono-1.png", "persona-1-telefono-2.png"};
    private String[] persona1telefonoViola =
            {"persona-1-telefono-1(viola).png", "persona-1-telefono-2(viola).png"};
    private String[] persona2telefono =
            {"persona-2-telefono-1.png", "persona-2-telefono-2.png"};
    private String[] persona2telefono2 =
            {"persona-2-telefono-1(viola).png", "persona-2-telefono-2(viola).png"};
    private String[] persona3telefono =
            {"persona-3-telefono-1.png", "persona-3-telefono-2.png"};
    private String[] persona3telefonoGiallo =
            {"persona-3-telefono-1(giallo).png", "persona-3-telefono-2(giallo).png"};
    private String[] persona1popcorn =
            {"persona-1-popcorn-1.png", "persona-1-popcorn-2.png"};
    private String[] persona1popcornBlu =
            {"persona-1-popcorn-1(blu).png", "persona-1-popcorn-2(blu).png"};
    private String[] persona1popcornArancio =
            {"persona-1-popcorn-1(arancio).png", "persona-1-popcorn-2(arancio).png"};
    private String[] persona2popcorn =
            {"persona-2-popcorn-1.png", "persona-2-popcorn-2.png"};
    private String[] persona2popcornArancio =
            {"persona-2-popcorn-1(arancio).png", "persona-2-popcorn-2(arancio).png"};
    private String[] persona1talking =
            {"persona-1-talking-1.png", "persona-1-talking-2.png"};
    private String[] persona2talking =
            {"persona-2-talking-1.png", "persona-2-talking-2.png"};
    private String[] persona3talking =
            {"persona-3-talking-1.png", "persona-3-talking-2.png"};

    private String[] haiVintoAnim=
            {"haivinto1.png", "haivinto2.png", "haivinto3.png", "haivinto4.png", "haivinto5.png", "haivinto6.png"};
    private String[] haiPersoAnim=
            {"game_over1.png", "game_over2.png", "game_over3.png", "game_over4.png", "game_over5.png", "game_over6.png"};


    //TEXTURE REGION NEMICI
    Animation<TextureRegion> persona1_tel;
    Animation<TextureRegion> persona2_tel;
    Animation<TextureRegion> persona2_tel_viola;
    Animation<TextureRegion> persona1_tel_viola;
    Animation<TextureRegion> persona3_tel;
    Animation<TextureRegion> persona3_tel_giallo;
    Animation<TextureRegion> persona1_pop;
    Animation<TextureRegion> persona1_pop_blu;
    Animation<TextureRegion> persona1_pop_arancio;
    Animation<TextureRegion> persona2_pop;
    Animation<TextureRegion> persona2_pop_arancio;
    Animation<TextureRegion> persona1_talk;
    Animation<TextureRegion> persona2_talk;
    Animation<TextureRegion> persona3_talk;
    Animation<TextureRegion> hai_vinto;
    Animation<TextureRegion> hai_perso;

    //SPAWN NEMICI
    private Enemy[] enemyList;
    Random rand;
    int randomNum;
    Enemy x;
    int score = 0;
    Time time;



    //SCORE
    Score score0;
    Score score1;
    Score score2;
    Score score3;
    Score score4;
    Score score5;
    Score score6;
    Score score7;
    Score score8;
    Score score9;
    Score score10;


    /*
    long startTime = TimeUtils.millis();
    long elapsedTime = TimeUtils.timeSinceMillis(startTime);
    private long lastDropTime;
     */

    BitmapFont customFont;
    //BaseActor youWinMessage1;
    private HaiVinto haiVinto;
    private HaiVinto haiPerso;
    float delay = 60;


    @Override
    public void initialize() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        Gdx.input.setInputProcessor(mainStage);

        /*  SCORE
        sb = new SpriteBatch();
        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("font-pixel.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 200;
        parameter.color = Color.WHITE;

        font = gen.generateFont(parameter);
         */



        salaBackground = new SalaBackground(0, 0, mainStage);
        salaBackground.setWidth(Gdx.graphics.getWidth());
        salaBackground.setHeight(Gdx.graphics.getHeight());

        player = new Player(50, 50, mainStage);

        //COLLISIONI
        screen = new Screen(252, 0, mainStage);
        chairs1 = new Chairs(400, 320, mainStage);
        chairs2 = new Chairs(400, 570, mainStage);
        chairs3 = new Chairs(400, 810, mainStage);

        wall1 = new Wall(0, 0, mainStage);
        wall2 = new Wall(Gdx.graphics.getWidth() - 30, 0, mainStage);
        wall3 = new Wall(0, Gdx.graphics.getHeight() - 30, mainStage);
        wall3.setWidth(Gdx.graphics.getWidth());
        wall3.setHeight(20);
        wall3.setBoundaryRectangle();
        wall4 = new Wall(0, 0, mainStage);
        wall4.setWidth(Gdx.graphics.getWidth());
        wall4.setHeight(20);
        wall4.setBoundaryRectangle();


        //NEMICI
            enemyList = new Enemy[]{enemy1 = new Enemy(-400, -400, mainStage, persona2_tel, persona2telefono, 608, 279),
                                    enemy2 = new Enemy(-400, -400, mainStage, persona2_tel_viola, persona2telefono2, 840, 528),
                                    enemy3 = new Enemy(-400, -400, mainStage, persona1_tel, persona1telefono, 1305, 528),
                                    enemy4 = new Enemy(-400, -400, mainStage, persona1_tel_viola, persona1telefonoViola, 493, 769),
                                    enemy5 = new Enemy(-400, -400, mainStage, persona3_tel, persona3telefono, 842, 769),
                                    enemy6 = new Enemy(-400, -400, mainStage, persona3_tel_giallo, persona3telefonoGiallo, 1538, 528),
                                    enemy7 = new Enemy(-400, -400, mainStage, persona1_pop, persona1popcorn, 1655, 279),
                                    enemy8 = new Enemy(-400, -400, mainStage, persona1_pop_blu, persona1popcornBlu, 492, 279),
                                    enemy9 = new Enemy(-400, -400, mainStage, persona1_pop_arancio, persona1popcornArancio, 608, 528),
                                    enemy10 = new Enemy(-400, -400, mainStage, persona2_pop, persona2popcorn, 957, 528),
                                    enemy11 = new Enemy(-400, -400, mainStage, persona2_pop_arancio, persona2popcornArancio, 726, 769),
                                    enemy12 = new Enemy(-400, 400, mainStage, persona1_talk, persona1talking, 1074, 279),
                                    enemy13 = new Enemy(-400, -400, mainStage, persona2_talk, persona2talking, 1655, 528),
                                    enemy14 = new Enemy(-400, -400, mainStage, persona3_talk, persona3talking, 1655, 279)};


        rand = new Random();
        randomNum = rand.nextInt((enemyList.length));
        x = enemyList[randomNum];
        x.setPosition(x.getPosX(), x.getPosY());



        //SCORE
        score0 = new Score(50, 860, mainStage, "score-0.png");
        score0.setWidth(250);
        score0.setHeight(140);

        score1 = new Score(-400, -400, mainStage, "score-1.png");
        score1.setWidth(250);
        score1.setHeight(140);

        score2 = new Score(-400, -400, mainStage, "score-2.png");
        score2.setWidth(250);
        score2.setHeight(140);

        score3 = new Score(-400, -400, mainStage, "score-3.png");
        score3.setWidth(250);
        score3.setHeight(140);

        score4 = new Score(-400, -400, mainStage, "score-4.png");
        score4.setWidth(250);
        score4.setHeight(140);

        score5 = new Score(-400, -400, mainStage, "score-5.png");
        score5.setWidth(250);
        score5.setHeight(140);

        score6 = new Score(-400, -400, mainStage, "score-6.png");
        score6.setWidth(250);
        score6.setHeight(140);

        score7 = new Score(-400, -400, mainStage, "score-7.png");
        score7.setWidth(250);
        score7.setHeight(140);

        score8 = new Score(-400, -400, mainStage, "score-8.png");
        score8.setWidth(250);
        score8.setHeight(140);

        score9 = new Score(-400, -400, mainStage, "score-9.png");
        score9.setWidth(250);
        score9.setHeight(140);

        score10 = new Score(-400, -400, mainStage, "score-10.png");
        score10.setWidth(250);
        score10.setHeight(140);



        //BUTTONS FONT
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("arial.ttf"));

        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters.size = 48;
        fontParameters.color = Color.CLEAR;
        fontParameters.borderWidth = 2;
        fontParameters.borderColor = Color.BLACK;
        fontParameters.borderStraight = true;
        fontParameters.minFilter = Texture.TextureFilter.Linear;
        fontParameters.magFilter = Texture.TextureFilter.Linear;

        customFont = fontGenerator.generateFont(fontParameters);

        //RIGHT BUTTON
        textButtonStyle_right = new TextButton.TextButtonStyle();
        Texture buttonTex_right = new Texture(Gdx.files.internal("right-button.png"));
        NinePatch buttonPatch_right = new NinePatch(buttonTex_right, 24, 24, 24, 24);
        textButtonStyle_right.up = new NinePatchDrawable(buttonPatch_right);
        textButtonStyle_right.font = customFont;
        textButtonStyle_right.fontColor = Color.GRAY;

        //LEFT BUTTON
        textButtonStyle_left = new TextButton.TextButtonStyle();
        Texture buttonTex_left = new Texture(Gdx.files.internal("left-button.png"));
        NinePatch buttonPatch_left = new NinePatch(buttonTex_left, 24, 24, 24, 24);
        textButtonStyle_left.up = new NinePatchDrawable(buttonPatch_left);
        textButtonStyle_left.font = customFont;
        textButtonStyle_left.fontColor = Color.GRAY;
        //UP BUTTON
        textButtonStyle_up = new TextButton.TextButtonStyle();
        Texture buttonTex_up = new Texture(Gdx.files.internal("up-button.png"));
        NinePatch buttonPatch_up = new NinePatch(buttonTex_up, 24, 24, 24, 24);
        textButtonStyle_up.up = new NinePatchDrawable(buttonPatch_up);
        textButtonStyle_up.font = customFont;
        textButtonStyle_up.fontColor = Color.GRAY;
        //DOWN BUTTON
        textButtonStyle_down = new TextButton.TextButtonStyle();
        Texture buttonTex_down = new Texture(Gdx.files.internal("down-button.png"));
        NinePatch buttonPatch_down = new NinePatch(buttonTex_down, 24, 24, 24, 24);
        textButtonStyle_down.up = new NinePatchDrawable(buttonPatch_down);
        textButtonStyle_down.font = customFont;
        textButtonStyle_down.fontColor = Color.GRAY;



        buttonRight = new TextButton(" ", textButtonStyle_right);
        buttonRight.setSize(200, 200);
        buttonRight.setPosition(Gdx.graphics.getWidth() - 220, 100);
        //buttonRight.setPosition(10*7,Gdx.graphics.getHeight()*baseHRatio-20*3);
        buttonRight.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Press a Button");
                player.setDirection(Player.IDLE);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Pressed Text Button");
                //3.5.
                player.setDirection(Player.RIGHT);
                return true;
            }

        });

        buttonLeft = new TextButton(" ", textButtonStyle_left);
        buttonLeft.setSize(200, 200);
        buttonLeft.setPosition(Gdx.graphics.getWidth() - 380, 100);
        //buttonLeft.setPosition(10*7,Gdx.graphics.getHeight()*baseHRatio-50*3);
        buttonLeft.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Press a Button");
                player.setDirection(Player.IDLE);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Pressed Text Button");
                //3.5.
                player.setDirection(Player.LEFT);
                return true;
            }
        });

        buttonTop = new TextButton(" ", textButtonStyle_up);
        buttonTop.setSize(200, 200);
        buttonTop.setPosition((Gdx.graphics.getWidth() - 296), 200);
        //buttonTop.setPosition(10*7,Gdx.graphics.getHeight()*baseHRatio-80*3);
        buttonTop.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Press a Button");
                player.setDirection(Player.IDLE);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Pressed Text Button");
                //3.5.
                player.setDirection(Player.TOP);
                return true;
            }
        });

        buttonBottom = new TextButton(" ", textButtonStyle_down);
        buttonBottom.setSize(200, 200);
        buttonBottom.setPosition((Gdx.graphics.getWidth() - 296), 10);
        //buttonBottom.setPosition(10*7,Gdx.graphics.getHeight()*baseHRatio-110*3);
        buttonBottom.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Press a Button");
                player.setDirection(Player.IDLE);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Pressed Text Button");
                //3.5.
                player.setDirection(Player.BOTTOM);
                return true;
            }
        });

        mainStage.addActor(buttonRight);
        mainStage.addActor(buttonLeft);
        mainStage.addActor(buttonTop);
        mainStage.addActor(buttonBottom);

        //WIN MESSAGE
        haiVinto = new HaiVinto(-3000, -3000, mainStage, hai_vinto, haiVintoAnim, 0,0);
        haiVinto.setWidth(Gdx.graphics.getWidth());
        haiVinto.setHeight(Gdx.graphics.getHeight());
        haiVinto.setAnimationPaused(true);

        //LOSE MESSAGE
        haiPerso = new HaiVinto(-3000, -3000, mainStage, hai_perso, haiPersoAnim, 0,0);
        haiPerso.setWidth(Gdx.graphics.getWidth());
        haiPerso.setHeight(Gdx.graphics.getHeight());
        haiPerso.setAnimationPaused(true);

        /*
        youWinMessage1 = new BaseActor(-3000, -3000, mainStage);
        youWinMessage1.loadTexture("Hai_vinto.png");
        youWinMessage1.setWidth(Gdx.graphics.getWidth());
        youWinMessage1.setHeight(Gdx.graphics.getHeight());

         */

        //REPLAY BUTTON
        textButtonStyle_replay = new TextButton.TextButtonStyle();
        Texture buttonTex_replay = new Texture(Gdx.files.internal("replay.png"));
        NinePatch buttonPatch_replay = new NinePatch(buttonTex_replay, 24, 24, 24, 24);
        textButtonStyle_replay.up = new NinePatchDrawable(buttonPatch_replay);
        textButtonStyle_replay.font = customFont;
        textButtonStyle_replay.fontColor = Color.GRAY;

        buttonReplay = new TextButton(" ", textButtonStyle_replay);
        buttonReplay.setPosition(-200, -200);
        buttonReplay.setSize(200, 200);


        mainStage.addActor(buttonReplay);


    }


    public void spawnEnemy(){
        x.setPosition(-200, -200);
        int temp = randomNum;
        randomNum = rand.nextInt((enemyList.length));

        while (temp == randomNum) {
            randomNum = rand.nextInt((enemyList.length));
        }

        x = enemyList[randomNum];
        x.setPosition(x.getPosX(), x.getPosY());
    }

    public void replay(){

        buttonReplay.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Press a Button");
                player.setDirection(Player.IDLE);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("#INFO", "Pressed Text Button");
                player.setPosition(0,0);
                buttonReplay.setPosition(-200,-200);
                haiVinto.setPosition(-3000, -3000);
                //youWinMessage1.setPosition(-3000,-3000);
                score0.setPosition(50, 860);
                spawnEnemy();
                return true;
            }

        });
    }



    public void updateScore(int score){

        switch(score){
            case 1:
                score0.setPosition(-500,-500);
                score1.setPosition(50, 860);
                break;
            case 2:
                score1.setPosition(-500,-500);
                score2.setPosition(50, 860);
                break;
            case 3:
                score2.setPosition(-500,-500);
                score3.setPosition(50, 860);
                break;
            case 4:
                score3.setPosition(-500,-500);
                score4.setPosition(50, 860);
                break;
            case 5:
                score4.setPosition(-500,-500);
                score5.setPosition(50, 860);
                break;
            case 6:
                score5.setPosition(-500,-500);
                score6.setPosition(50, 860);
                break;
            case 7:
                score6.setPosition(-500,-500);
                score7.setPosition(50, 860);
                break;
            case 8:
                score7.setPosition(-500,-500);
                score8.setPosition(50, 860);
                break;
            case 9:
                score8.setPosition(-500,-500);
                score9.setPosition(50, 860);
                break;
            case 10:
                score9.setPosition(-500,-500);
                score10.setPosition(50, 860);
                break;
        }
    }


    @Override
    public void update(float dt) {

        for (BaseActor screenActor : BaseActor.getList(mainStage, "Screen"))
            player.preventOverlap(screenActor);

        for (BaseActor chairActor : BaseActor.getList(mainStage, "Chairs"))
            player.preventOverlap(chairActor);

        for (BaseActor wallActor : BaseActor.getList(mainStage, "Wall"))
            player.preventOverlap(wallActor);

        Timer.schedule(new Timer.Task(){
            @Override
            public void run() {
                if(score != 10){
                    haiPerso.setPosition(0,0);
                    haiPerso.setAnimationPaused(false);
                }
            }
        }, delay);


        if (player.overlaps(x)) {
            player.hit = true;
            score++;
            updateScore(score);
            spawnEnemy();
        }


        if (score == 10) {
            score = 0;
            score10.setPosition(-500,-500);
            haiVinto.setPosition(0,0);
            haiVinto.setAnimationPaused(false);
            //youWinMessage1.setPosition(0, 0);
            buttonReplay.setPosition(1000, 50);
            replay();
        }

    }


    @Override
    public void dispose() {

    }
}
