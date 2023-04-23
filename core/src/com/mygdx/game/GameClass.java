package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

import java.util.Random;

public class GameClass extends GameBeta {

    private Player player;
    //private FitViewport gameViewport;
    private SalaBackground salaBackground;

    //BUTTONS
    private Button buttonRight;
    private Button buttonLeft;
    private Button buttonTop;
    private Button buttonBottom;
    private TextButton.TextButtonStyle textButtonStyle;

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

    //SPAWN NEMICI
    private Enemy[] enemyList;
    Random rand;
    int randomNum;
    Enemy x;
    int punteggio = 0;


    @Override
    public void initialize() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        Gdx.input.setInputProcessor(mainStage);


        //gameViewport = new FitViewport(1024, 1024);

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
                                    enemy11 = new Enemy(-400, -400, mainStage, persona2_pop_arancio, persona2popcornArancio, 726, 769)};

        rand = new Random();
        randomNum = rand.nextInt((enemyList.length));
        x = enemyList[randomNum];
        x.setPosition(x.getPosX(), x.getPosY());




        //BUTTONS
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("arial.ttf"));

        FreeTypeFontGenerator.FreeTypeFontParameter fontParameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameters.size = 48;
        fontParameters.color = Color.WHITE;
        fontParameters.borderWidth = 2;
        fontParameters.borderColor = Color.BLACK;
        fontParameters.borderStraight = true;
        fontParameters.minFilter = Texture.TextureFilter.Linear;
        fontParameters.magFilter = Texture.TextureFilter.Linear;

        BitmapFont customFont = fontGenerator.generateFont(fontParameters);

        textButtonStyle = new TextButton.TextButtonStyle();
        Texture buttonTex = new Texture(Gdx.files.internal("badlogic.jpg"));
        NinePatch buttonPatch = new NinePatch(buttonTex, 24, 24, 24, 24);
        textButtonStyle.up = new NinePatchDrawable(buttonPatch);
        textButtonStyle.font = customFont;
        textButtonStyle.fontColor = Color.GRAY;

        buttonRight = new TextButton("RIGHT", textButtonStyle);
        buttonRight.setSize(20 * 4, 50);
        buttonRight.setPosition(10 * 7, Gdx.graphics.getHeight() - 20 * 3);
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

        buttonLeft = new TextButton("LEFT", textButtonStyle);
        buttonLeft.setSize(20 * 4, 50);
        buttonLeft.setPosition(10 * 7, Gdx.graphics.getHeight() - 50 * 3);
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

        buttonTop = new TextButton("TOP", textButtonStyle);
        buttonTop.setSize(20 * 4, 50);
        buttonTop.setPosition(10 * 7, Gdx.graphics.getHeight() - 80 * 3);
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

        buttonBottom = new TextButton("BOTTOM", textButtonStyle);
        buttonBottom.setSize(20 * 4, 50);
        buttonBottom.setPosition(10 * 7, Gdx.graphics.getHeight() - 110 * 3);
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
        //gameViewport.getCamera().position.set(player.getX(), player.getY(), 0);
    }

	/*
	@Override
	public void resize(int width, int height) {
		gameViewport.update(width, height);
	}

	 */

    @Override
    public void update(float dt) {

        for (BaseActor screenActor : BaseActor.getList(mainStage, "Screen"))
            player.preventOverlap(screenActor);

        for (BaseActor chairActor : BaseActor.getList(mainStage, "Chairs"))
            player.preventOverlap(chairActor);

        for (BaseActor wallActor : BaseActor.getList(mainStage, "Wall"))
            player.preventOverlap(wallActor);




        /*
        if (player.overlaps(enemy1) && !enemy1.isCollected()) {
			enemy1.collect();
			enemy2.setPosition(840, 530);
		}
         */


        if (player.overlaps(x) && !x.isCollected()) {
            	x.setPosition(-200, -200);
            	int temp = randomNum;
            	randomNum = rand.nextInt((enemyList.length));

           		 while (temp == randomNum) {
                	randomNum = rand.nextInt((enemyList.length));
           		 }

            	x = enemyList[randomNum];
	            x.setPosition(x.getPosX(), x.getPosY());
            	punteggio++;
        	}

        	if (punteggio == 10) {
                x.collect();
            	BaseActor youWinMessage = new BaseActor(0, 0, mainStage);
            	youWinMessage.loadTexture("you-win.png");
            	youWinMessage.centerAtPosition(400, 300);
            	youWinMessage.setOpacity(0);
            	youWinMessage.addAction(Actions.delay(1));
            	youWinMessage.addAction(Actions.after(Actions.fadeIn(1)));
        	}


		}





    @Override
    public void dispose() {

    }
}
