package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;

public class LoadingScreen implements Screen {
    EpochsGame epochsGame;

    public LoadingScreen(EpochsGame epochsGame) {
        this.epochsGame = epochsGame;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (epochsGame.assetManager.update()) {
            System.out.println("nice");
        }
    }

    @Override
    public void resize(int width, int height) {

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
