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
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class EpochsGame extends Game {

    //screen settings
    final float worldHeight = 800;
    final float worldWidth = 450;
    Viewport viewport;
    Camera camera;

    //Loading screen and asset manager
    AssetManager assetManager;
    LoadingScreen loadingScreen;

    @Override
    public void create() {
        //set camera and viewport
        camera = new OrthographicCamera();
        camera.position.set(worldWidth / 2, worldHeight / 2, 0);
        viewport = new FillViewport(worldWidth, worldHeight, camera);

        //setup loading screen and load all the assets
        loadingScreen = new LoadingScreen(this);
        assetManager = new AssetManager();
        setScreen(loadingScreen);

        //debug
        debug();
    }

    //debug mode
    public void debug() {

    }


}
