package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ScreenState {
    EpochsGame epochsGame;
    AssetManager assetManager;
    Viewport viewport;
    Viewport backgroundViewport;
    Batch batch;
    Camera camera;
    public ScreenState(EpochsGame epochsGame) {
        this.epochsGame = epochsGame;
        this.assetManager = epochsGame.assetManager;
        this.viewport = epochsGame.viewport;
        this.backgroundViewport = epochsGame.backgroundViewport;
        this.batch = epochsGame.batch;
        this.camera = epochsGame.camera;
    }
}
