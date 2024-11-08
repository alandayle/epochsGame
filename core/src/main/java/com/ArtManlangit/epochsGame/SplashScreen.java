package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SplashScreen implements Screen {
    //access to epochsGame and the main assetManager
    EpochsGame epochsGame;
    AssetManager assetManager;

    //viewport and camera
    Viewport viewport;
    Camera camera;

    //textures for assets
    TextureAtlas mainBgsLogos;
    TextureRegion loadingLogo;
    TextureRegion wearHeadphones;
    TextureRegion mainMenu;
    TextureRegion currentBackground;

    //Audio and sound effects
    Music backgroundMusic;

    //drawer
    SpriteBatch batch;

    //color value for transition
    float colorValue;


    //timer for transitions
    float timer;


    //constructor
    public SplashScreen(EpochsGame epochsGame) {
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
    }
    public void loadAssets() {
        //load textures
        mainBgsLogos = assetManager.get("packedTextures/mainBgsLogos.atlas", TextureAtlas.class);
        loadingLogo = mainBgsLogos.findRegion("logo(portrait)");
        wearHeadphones = mainBgsLogos.findRegion("wearHeadphones(portrait)");
        mainMenu = mainBgsLogos.findRegion("mainBackground(portrait)");

        //set initial background
        currentBackground = loadingLogo;

        //load and configure music
        backgroundMusic = assetManager.get("audio/background.mp3");
        backgroundMusic.setLooping(true);
    }

    @Override
    public void show() {
        backgroundMusic.play();
    }

    @Override
    public void render(float delta) {
        input();
        logic(delta);
        draw();
    }

    public void input() {
        if (timer > 8) {
            epochsGame.mainMenuScreen = new MainMenuScreen(epochsGame);
            epochsGame.setScreen(epochsGame.mainMenuScreen);
        }
    }

    public void logic(float delta) {
        //update timer to keep track of time passed
        timer += delta;

        //transition logic
        if (timer <= 2) {
            if (timer > 1) {
                colorValue -= delta;
            }
        } else if (timer <= 6) {
            if (currentBackground != wearHeadphones) {
                currentBackground = wearHeadphones;
            }
            colorValue += delta;
        } else if (timer <= 7) {
            colorValue -= delta;
        } else if (timer <= 8) {
            if (currentBackground != mainMenu) {
                currentBackground = mainMenu;
            }
            colorValue += delta;
        }





        //limit colorvalue to 0 - 1;
        if (colorValue <= 0) {
            colorValue = 0;
        }
        if (colorValue >= 1) {
            colorValue = 1;
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
        batch.draw(currentBackground, 0, 0, epochsGame.worldWidth, epochsGame.worldHeight);
        batch.end();

        //reset color value
        batch.setColor(1, 1,1, 1);

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
