package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenuScreen implements Screen {
    //access to epochsGame and the main assetManager
    EpochsGame epochsGame;
    AssetManager assetManager;

    //viewport and camera
    Viewport viewport;
    Camera camera;

    //textures for assets
    TextureAtlas mainBgsLogos;
    TextureAtlas playingBgs;
    TextureRegion[] currentBackground;
    TextureRegion flare;
    TextureRegion title;
    TextureRegion start;
    TextureRegion settings;
    TextureRegion archives;
    TextureRegion about;

    //flare properties
    float flareX, flareY, flareWidth, flareHeight;

    //flare Sprite
    Sprite flareSprite;
    float flareTimer;

    //title properties
    float titleX, titleY, titleWidth, titleHeight;

    //start properties
    float startX, startY, startWidth, startHeight;

    //settings properties
    float settingsX, settingsY, settingsWidth, settingsHeight;

    //archives properties
    float archivesX, archivesY, archivesWidth, archivesHeight;

    //abbout
    float aboutX, aboutY, aboutWidth, aboutHeight;


    //Audio and sound effects
    Music backgroundMusic;

    //drawer
    SpriteBatch batch;

    //color value for transition
    float colorValue;
    float iconsColorValue;

    //timer for transitions
    float timer;

    //variables for moving background
    float[] backgroundX;


    //constructor
    public MainMenuScreen(EpochsGame epochsGame) {
        //initialize variables
        this.epochsGame = epochsGame;
        this.assetManager = epochsGame.assetManager;
        viewport = epochsGame.viewport;
        camera = epochsGame.camera;
        batch = epochsGame.batch;

        //set colorTransition value to 1 at the start
        colorValue = 1;

        //set timer to 0
        timer = 0;

        //load and setup assets
        loadAssets();

        //setup texture properties
        setupTextureProperties();
    }

    public void setupTextureProperties() {
        //flare
        flareWidth = 0.85f * epochsGame.worldWidth;
        flareHeight = 0.85f * epochsGame.worldWidth;
        flareX = (epochsGame.worldWidth - flareWidth) / 2;
        flareY = 0.29f * epochsGame.worldHeight;

        //flare sprite
        flareSprite = new Sprite(flare);
        flareSprite.setSize(flareWidth, flareHeight);
        flareSprite.setPosition(flareX, flareY);
        flareSprite.setOriginCenter();

        //title
        titleWidth = epochsGame.worldWidth * 0.7f;
        titleHeight = epochsGame.worldHeight / 4.5f;
        titleX = (epochsGame.worldWidth - titleWidth) / 2;
        titleY = 0.74f * epochsGame.worldHeight;

        //start
        startWidth = epochsGame.worldWidth * 0.4f;
        startHeight = epochsGame.worldHeight * 0.235f;
        startX = (epochsGame.worldWidth - startWidth) / 2f;
        startY = 0.47f * epochsGame.worldHeight;

        //settings
        settingsWidth = epochsGame.worldWidth * 0.24f;
        settingsHeight = epochsGame.worldHeight * 0.13f;
        settingsX = (epochsGame.worldWidth - settingsWidth) / 2f;
        settingsY = 0.45f * epochsGame.worldHeight;

        //archives
        archivesWidth = epochsGame.worldWidth * 0.24f;
        archivesHeight = epochsGame.worldHeight * 0.13f;
        archivesX = (epochsGame.worldWidth - archivesWidth) / 2f;
        archivesY = 0.415f * epochsGame.worldHeight;

        //about
        aboutWidth = epochsGame.worldWidth * 0.21f;
        aboutHeight = epochsGame.worldHeight * 0.13f;
        aboutX = (epochsGame.worldWidth - aboutWidth) / 2f;
        aboutY = 0.380f * epochsGame.worldHeight;

        //background moving
        backgroundX = new float[8];
        for (int i = 0; i < backgroundX.length; i++) {
            backgroundX[i] = (i) * epochsGame.worldWidth;
        }


    }

    public void loadAssets() {
        mainBgsLogos = assetManager.get("packedTextures/mainBgsLogos.atlas", TextureAtlas.class);
        playingBgs = assetManager.get("packedTextures/playingBgs.atlas", TextureAtlas.class);
        flare = mainBgsLogos.findRegion("flare");
        title = mainBgsLogos.findRegion("title");
        start = mainBgsLogos.findRegion("start(unclicked)");
        settings = mainBgsLogos.findRegion("settings(unclicked)");
        archives = mainBgsLogos.findRegion("archives(unclicked)");
        about = mainBgsLogos.findRegion("about(unclicked)");

        currentBackground = new TextureRegion[8];
        currentBackground[0] = mainBgsLogos.findRegion("mainBackground(portrait)");
        for (int i = 1; i < currentBackground.length; i++) {
            currentBackground[i] = playingBgs.findRegion("bg" + (i+1));
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        input();
        logic(delta);
        draw();
    }

    public void input() {
        if (Gdx.input.isTouched() && timer > 2) {
            epochsGame.splashScreen.backgroundMusic.stop();
            epochsGame.gameScreen = new GameScreen(epochsGame);
            epochsGame.setScreen(epochsGame.gameScreen);
        }
    }

    public void logic(float delta) {
        timer += delta;
        flareTimer += delta;

        //fade in fade out logic
        if (timer > 2) {
            if (timer - 2 < 1) {
                colorValue -= delta / 1.5f;
            } else if (timer - 2 <= 2) {
                colorValue += delta / 1.5f;
            } else if (timer > 4) {
                timer = 2;
                colorValue = 1F;
            }
        }

        //
        if (timer <= 2) {
            iconsColorValue += delta;
            if (iconsColorValue >= 1) {
                iconsColorValue = 1;
            }
            System.out.println(iconsColorValue);
        }

        //limit colorvalue to 0 - 1;
        if (colorValue <= 0) {
            colorValue = 0;
        }
        if (colorValue >= 1) {
            colorValue = 1;
        }

        //rotate flare
        if (flareTimer > 0.04) {
            flareSprite.setRotation(flareSprite.getRotation() + 1);
            flareTimer = 0;
        }

        //move background
        for (int i = 0; i < backgroundX.length; i++) {
            backgroundX[i] -= delta * 30;
            if (backgroundX[i] <= -epochsGame.worldWidth * 7) {
                backgroundX[i] = epochsGame.worldWidth;
            }
        }
    }

    public void draw() {
        ScreenUtils.clear(Color.BLACK);
        camera.update();
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);

        //sets colorvalue before drawing
        batch.setColor(colorValue, colorValue, colorValue, 1);

        //begin draw
        batch.begin();
        for (int i = 0; i < currentBackground.length; i++) {
            batch.draw(currentBackground[i], backgroundX[i], 0, epochsGame.worldWidth, epochsGame.worldHeight);
        }

        //don't add fade in fade out to icons
        batch.setColor(1, 1, 1, 1);

        //draws icons
        flareSprite.draw(batch);
        if (timer <= 1) {
            batch.setColor(1, 1, 1, iconsColorValue);
        }
        batch.draw(title, titleX, titleY, titleWidth, titleHeight);
        batch.draw(start, startX, startY, startWidth, startHeight);
        batch.draw(settings, settingsX, settingsY, settingsWidth, settingsHeight);
        batch.draw(archives, archivesX, archivesY, archivesWidth, archivesHeight);
        batch.draw(about, aboutX, aboutY, aboutWidth, aboutHeight);
        batch.end();

        //reset color value


    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
