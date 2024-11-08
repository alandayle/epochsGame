package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
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
    }

    public void loadAssets() {
        mainBgsLogos = assetManager.get("packedTextures/mainBgsLogos.atlas", TextureAtlas.class);
        currentBackground = mainBgsLogos.findRegion("mainBackground(portrait)");
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
        if (Gdx.input.isTouched()) {
            epochsGame.splashScreen.backgroundMusic.stop();
        }
    }

    public void logic(float delta) {
        timer += delta;

        //fade in fade out logic
        if (timer > 2) {
            if (timer - 2 < 0.5) {
                colorValue -= delta;
            } else if (timer - 2 <= 1) {
                colorValue += delta;
            } else if (timer > 3) {
                timer = 2;
                colorValue = 1F;
            }
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
