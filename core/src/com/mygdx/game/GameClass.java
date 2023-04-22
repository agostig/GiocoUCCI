package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

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
	private Screen screen;
	private Chairs chairs1;
	private Chairs chairs2;
	private Chairs chairs3;

	@Override
	public void initialize () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		Gdx.input.setInputProcessor(mainStage);


		//gameViewport = new FitViewport(1024, 1024);

		salaBackground = new SalaBackground(0, 0, mainStage);
		salaBackground.setWidth(Gdx.graphics.getWidth());
		salaBackground.setHeight(Gdx.graphics.getHeight());

		player = new Player(50, 50, mainStage);

		screen = new Screen(252, 0, mainStage);
		chairs1 = new Chairs(400, 320, mainStage);
		chairs2 = new Chairs(400, 570, mainStage);
		chairs3 = new Chairs(400, 810, mainStage);


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

		for(BaseActor screenActor : BaseActor.getList(mainStage, "Screen"))
			player.preventOverlap(screenActor);

		for(BaseActor chairActor : BaseActor.getList(mainStage, "Chairs"))
			player.preventOverlap(chairActor);

	}
	
	@Override
	public void dispose () {

	}
}
