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


    //constructor
    public EndScreen(EpochsGame epochsGame) {
        this.epochsGame = epochsGame;
        this.assetManager = epochsGame.assetManager;
        this.viewport = epochsGame.viewport;
        this.backgroundViewport = epochsGame.backgroundViewport;
        this.camera = epochsGame.camera;

        //setupTextures
        setupTextures();

        batch = epochsGame.batch;
    }

    public void setupTextures() {
        gameBackgroundsAtlas = assetManager.get("packedTextures/endingScreen.atlas");
        System.out.println(epochsGame.gameScreen.endingScenario);
        switch (epochsGame.gameScreen.endingScenario) {
            case 1:
                assert gameBackgroundsAtlas != null;
                endingScreenBackground = gameBackgroundsAtlas.findRegion("environmentalEnding");
                break;
            case 2:
                assert gameBackgroundsAtlas != null;
                endingScreenBackground = gameBackgroundsAtlas.findRegion("techEndingpng");
                break;
            case 3:
                assert gameBackgroundsAtlas != null;
                endingScreenBackground = gameBackgroundsAtlas.findRegion("culturalEnding");
                break;
            case 4:
                assert gameBackgroundsAtlas != null;
                endingScreenBackground = gameBackgroundsAtlas.findRegion("militaryEnding");
                break;
            case 5:
                assert gameBackgroundsAtlas != null;
                endingScreenBackground = gameBackgroundsAtlas.findRegion("healthcareEnding");
                break;
            case 6:
                assert gameBackgroundsAtlas != null;
                endingScreenBackground = gameBackgroundsAtlas.findRegion("neutralEnding");
                break;
            case 7:
                assert gameBackgroundsAtlas != null;
                endingScreenBackground = gameBackgroundsAtlas.findRegion("badEnding");
                break;
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        input();
        logic();
        draw();
    }

    public void input() {

    }

    public void logic() {

    }

    public void draw() {
        batch.begin();
        batch.draw(endingScreenBackground, 0, 0, epochsGame.worldWidth, epochsGame.worldHeight);
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
