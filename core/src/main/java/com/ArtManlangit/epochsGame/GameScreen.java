package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {
    //access to epochsGame and the main assetManager
    EpochsGame epochsGame;
    AssetManager assetManager;

    //viewport and camera
    Viewport viewport;
    Camera camera;

    //textures for assets in CountState


    //textures for assets in inGameState


    //Audio and sound effects
    Music backgroundMusic;
    Sound yearCountSoundEffect;

    //drawer
    SpriteBatch batch;

    //color value for transition
    float colorValue;

    //timer for transitions
    float timer;

    //Primary Game States
    int currentGameState;
    int countState = 1;
    int inGameState = 2;

    //inGameStates
    int currentInGameState;
    int shuffleState = 1;
    int playingState = 2;
    int settingState = 3;

    //fonts
    BitmapFont headingMainFont, subHeadingMainFont, bodyMainFont;

    //countdown year
    int countDownYearCurrent;
    int countDownYearFinish;

    //constructor
    public GameScreen(EpochsGame epochsGame) {
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

        //Game defaults
        setGameDefaults();
    }

    public void loadAssets() {
        loadFonts();
        loadAudio();
    }

    public void loadAudio() {
        yearCountSoundEffect = assetManager.get("audio/yearCountSoundEffect.mp3");
    }

    public void loadFonts() {
        headingMainFont = assetManager.get("setbackt50.ttf", BitmapFont.class);
        subHeadingMainFont = assetManager.get("setbackt40.ttf", BitmapFont.class);
        bodyMainFont = assetManager.get("setbackt25.ttf", BitmapFont.class);
    }

    public void setGameDefaults() {
        //sets game defaults
        currentGameState = countState;
        currentInGameState = shuffleState;
        countDownYearCurrent = 0;
        countDownYearFinish = 2024;
    }


    @Override
    public void show() {
        yearCountSoundEffect.play();
    }

    @Override
    public void render(float delta) {
        input();
        logic(delta);
        draw();
    }

    public void input() {

    }

    public void logic(float delta) {
        //logic for count state
        if (currentGameState == countState) {
            timer += delta;

            if (countDownYearCurrent < countDownYearFinish) {
                countDownYearCurrent = (int) (countDownYearFinish * (timer /3f));
            }

            if (countDownYearCurrent >= countDownYearFinish) {
                countDownYearCurrent = countDownYearFinish;
                int floorValue = (int) Math.floor(timer);
                if (floorValue % 2 == 0) {
                    colorValue -= delta;
                } else {
                    colorValue += delta;
                }
            }

            if (colorValue < 0) {
                colorValue = 0;
            } else if (colorValue > 1) {
                colorValue = 1;
            }

        }

        //logic for inGameState
        if (currentGameState == inGameState) {

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

        //draw based on game state
        if (currentGameState == countState) {
            drawCountState();
        } else if (currentGameState == inGameState) {
            drawInGameState();
        }

        //end draw
        batch.end();

        //reset color value
        batch.setColor(1, 1,1, 1);
    }

    public void drawCountState () {
        subHeadingMainFont.draw(batch, "year", viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 1.5f + subHeadingMainFont.getCapHeight() * 2f, 0, Align.center, false);
        headingMainFont.draw(batch, String.valueOf(countDownYearCurrent), viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 1.5f, 0 ,Align.center, false);

        if (countDownYearCurrent >= countDownYearFinish) {
            bodyMainFont.setColor(colorValue, colorValue, colorValue, 1);
            bodyMainFont.draw(batch, "Continue >", viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 3, 0 ,Align.center, false);
            bodyMainFont.setColor(1, 1, 1, 1);
        }
    }

    public void drawInGameState() {

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
