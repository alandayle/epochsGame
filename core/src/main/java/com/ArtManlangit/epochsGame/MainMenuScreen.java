package com.ArtManlangit.epochsGame;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenuScreen extends ScreenState implements Screen {

    //handle ui in mainMenu
    MainMenuUi mainMenuUi;

    //handle background
    MainMenuBackground background;

    //Assets used in game
    TextureAtlas mainMenuAtlas;



    //constructor
    public MainMenuScreen(EpochsGame epochsGame) {
        super(epochsGame);

        //setup textures to use
        setupTextures();

        //mainMenu background
        background = new MainMenuBackground(epochsGame, this);

        //mainMenu ui
        mainMenuUi = new MainMenuUi(epochsGame, this);


    }

    public void setupTextures() {
        mainMenuAtlas = assetManager.get("packedTextures/newMenu.atlas");
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
//        background.input();
        mainMenuUi.input();
    }

    public void logic(float delta) {
        background.logic(delta);
        mainMenuUi.logic(delta);
    }

    public void draw() {
        ScreenUtils.clear(Color.BLACK);
        background.draw();
        mainMenuUi.draw();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        backgroundViewport.update(width, height, true);
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
        //unload unused assets
        assetManager.unload("packedTextures/mainBgsLogos.atlas");
        assetManager.unload("audio/background.mp3");
        assetManager.unload("packedTextures/newMenu.atlas");
    }
}
