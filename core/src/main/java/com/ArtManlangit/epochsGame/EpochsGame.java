package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class EpochsGame extends Game {

    //screen settings
    final float worldHeight = 800;
    final float worldWidth = 450;
    Viewport viewport;
    Camera camera;

    Viewport backgroundViewport;

    //Loading screen, asset manager and global variables
    AssetManager assetManager;
    LoadingScreen loadingScreen;
    SpriteBatch batch;

    //screens
    EndScreen endScreen;
    GameScreen gameScreen;
    MainMenuScreen mainMenuScreen;
    SettingsScreen settingsScreen;
    SplashScreen splashScreen;

    @Override
    public void create() {
        //set camera and viewport
        camera = new OrthographicCamera();
        camera.position.set(worldWidth / 2, worldHeight / 2, 0);
        camera.update();
        viewport = new FitViewport(worldWidth, worldHeight, camera);
        backgroundViewport = new StretchViewport(worldWidth, worldHeight, camera);

        //create sprite batch
        batch = new SpriteBatch();

        //setup loading screen and load all the assets
        assetManager = new AssetManager();
        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);

        //debug
        debug();
    }

    //debug mode
    public void debug() {

    }


}
