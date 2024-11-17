package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

public class EndScreen implements Screen {
    //access to epochsGame and the main assetManager
    EpochsGame epochsGame;
    AssetManager assetManager;

    //viewport and camera
    Viewport viewport;
    Viewport backgroundViewport;
    Camera camera;

    //drawer
    Batch batch;

    //texture atlas for game backgrounds
    TextureAtlas gameBackgroundsAtlas;
    TextureRegion endingScreenBackground;
    TextureRegion[] background;
    float[] backgroundX;


    //constructor
    public EndScreen(EpochsGame epochsGame) {
        this.epochsGame = epochsGame;
        this.assetManager = epochsGame.assetManager;
        this.viewport = epochsGame.viewport;
        this.backgroundViewport = epochsGame.backgroundViewport;
        this.camera = epochsGame.camera;

        setupMovingBackground();

        //setupTextures
        setupTextures();

        batch = epochsGame.batch;


    }

    public void setupMovingBackground() {
        background = new TextureRegion[2];
        backgroundX = new float[2];
        backgroundX[0] = 0;
        backgroundX[1] = epochsGame.worldWidth;
    }

    public void setupTextures() {
        gameBackgroundsAtlas = assetManager.get("packedTextures/endingScreen.atlas");
        System.out.println(epochsGame.gameScreen.endingScenario);
        switch (epochsGame.gameScreen.endingScenario) {
            case 1:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("environmentalEnding");
                background[1] = gameBackgroundsAtlas.findRegion("environmentalEnding");
                break;
            case 2:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("techEndingpng");
                background[1] = gameBackgroundsAtlas.findRegion("techEndingpng");
                break;
            case 3:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("culturalEnding");
                background[1] = gameBackgroundsAtlas.findRegion("culturalEnding");
                break;
            case 4:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("militaryEnding");
                background[1] = gameBackgroundsAtlas.findRegion("militaryEnding");
                break;
            case 5:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("healthcareEnding");
                background[1] = gameBackgroundsAtlas.findRegion("healthcareEnding");
                break;
            case 6:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("neutralEnding");
                background[1] = gameBackgroundsAtlas.findRegion("neutralEnding");
                break;
            case 7:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("badEnding");
                background[1] = gameBackgroundsAtlas.findRegion("badEnding");
                break;
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

    }

    public void logic(float delta) {
        for (int i = 0; i < backgroundX.length;i++) {
            backgroundX[i] -= delta * 30;
            if (backgroundX[i] <= -epochsGame.worldWidth) {
                backgroundX[i] = epochsGame.worldWidth;
            }
        }
    }

    public void draw() {
        camera.update();
        backgroundViewport.apply();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (int i = 0; i < backgroundX.length;i++) {
            batch.draw(background[i], backgroundX[i], 0, epochsGame.worldWidth, epochsGame.worldHeight);
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        backgroundViewport.update(width,height, true);
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
