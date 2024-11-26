package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.tools.javac.Main;

public class MainMenuUi extends ScreenState {
    MainMenuScreen  mainMenuScreen;

    //Assets used
    TextureAtlas mainMenuAtlas;
    TextureRegion title, settings, archives, cont, newGame, contDisabled;
    float titleX, titleY, titleWidth, titleHeight, settingsX, settingsY, settingsWidth, settingsHeight, archivesX, archivesY,
        archivesWidth, archivesHeight, contX, contY, contWidth, contHeight, newGameX, newGameY,newGameWidth, newGameHeight;

    //transition
    Transition transition;

    //slide in transitions
    float settingsXTransition, archivesXTransition, contXTransition, newGameXTransition;
    int slideInSpeed;

    //dissolve transitions
    float colorValue;
    float dissolveTime;

    //inputs
    MainMenuUiInput mainMenuUiInput;

    //states
    int currentState;
    int mainState = 0;
    int startTransitionState = 1;

    public MainMenuUi(EpochsGame epochsGame,  MainMenuScreen mainMenuScreen) {
        super(epochsGame);
        this.mainMenuScreen = mainMenuScreen;

        //setup textures
        setupTextures();

        //load textures
        loadTextures();

        //setup texture properties
        setupTextureProperties();

        //setup game defaults
        setupDefaults();

        //transitions
        transition = new Transition(batch);

        //inputs
        mainMenuUiInput = new MainMenuUiInput(this);

    }

    public void setupTextures() {
        mainMenuAtlas = mainMenuScreen.mainMenuAtlas;
    }

    public void loadTextures() {
        title = mainMenuAtlas.findRegion("title");
        settings = mainMenuAtlas.findRegion("settings");
        archives = mainMenuAtlas.findRegion("archives");
        contDisabled = mainMenuAtlas.findRegion("continue(disabled)");
        cont = mainMenuAtlas.findRegion("continue");
        title = mainMenuAtlas.findRegion("title");
        newGame = mainMenuAtlas.findRegion("newGame");
    }

    public void setupTextureProperties() {
        titleWidth = viewport.getWorldWidth() * 0.55f;
        titleHeight = viewport.getWorldHeight() * 0.22f;
        titleX = (viewport.getWorldWidth() - titleWidth) / 2;
        titleY = viewport.getWorldHeight() * 0.725f;
        settingsWidth = viewport.getWorldWidth() * 0.54f;
        settingsHeight = viewport.getWorldHeight() * 0.05f;
        settingsX = (viewport.getWorldWidth() - settingsWidth);
        settingsY = viewport.getWorldHeight() * 0.54f;
        archivesWidth = viewport.getWorldWidth() * 0.6f;
        archivesHeight = viewport.getWorldHeight() * 0.05f;
        archivesX = (viewport.getWorldWidth() - archivesWidth);
        archivesY = viewport.getWorldHeight() * 0.48f;
        contWidth = viewport.getWorldWidth() * 0.66f;
        contHeight = viewport.getWorldHeight() * 0.05f;
        contX = (viewport.getWorldWidth() - contWidth);
        contY = viewport.getWorldHeight() * 0.42f;
        newGameWidth = viewport.getWorldWidth() * 0.72f;
        newGameHeight = viewport.getWorldHeight() * 0.05f;
        newGameX = (viewport.getWorldWidth() - newGameWidth);
        newGameY = viewport.getWorldHeight() * 0.36f;

        settingsXTransition = settingsX + settingsWidth;
        archivesXTransition = archivesX + settingsWidth + 100;
        contXTransition = contX + settingsWidth + 200;
        newGameXTransition = newGameX + settingsWidth + 300;
    }

    public void setupDefaults() {
        currentState = startTransitionState;
    }

    public void input() {
        if (currentState == mainState) {
            mainMenuUiInput.checkMainInput();
        }
    }

    public void logic(float delta) {
        if (currentState == mainState) {
            mainStateLogic(delta);
        } else if (currentState == startTransitionState) {
            startTransitionStateLogic(delta);
        }
    }

    public void mainStateLogic(float delta) {

    }

    public void drawUnavailableText() {

    }

    public void startTransitionStateLogic(float delta) {
        slideInSpeed = 500;
        dissolveTime = 1f;

        //slide in
        settingsXTransition = transition.slideInLogic(delta,settingsXTransition, settingsX, slideInSpeed);
        archivesXTransition = transition.slideInLogic(delta,archivesXTransition, archivesX, slideInSpeed);
        contXTransition = transition.slideInLogic(delta,contXTransition, contX, slideInSpeed);
        newGameXTransition = transition.slideInLogic(delta,newGameXTransition, newGameX, slideInSpeed);

        //fade in
        colorValue = transition.dissolveLogic(delta, colorValue, dissolveTime);

        if (newGameXTransition == newGameX) {
            currentState = mainState;
        }
    }

    public void draw() {
        if (currentState == mainState) {
            drawMainState();
        } else if (currentState == startTransitionState) {
            drawStartTransitionState();
        }
    }

    public void drawMainState() {
        camera.update();
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);

        //begin draw
        batch.begin();
        batch.draw(title, titleX, titleY, titleWidth, titleHeight);
        batch.draw(settings,settingsX, settingsY, settingsWidth, settingsHeight);
        batch.draw(archives, archivesX, archivesY, archivesWidth, archivesHeight);
        batch.draw(contDisabled, contX, contY, contWidth, contHeight);
        batch.draw(newGame, newGameX, newGameY, newGameWidth, newGameHeight);
        //end draw
        batch.end();
    }

    public void drawStartTransitionState() {
        camera.update();
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);
        //begin draw
        batch.begin();

        //draw slide in elements
        transition.drawSlideIn(settings, settingsXTransition, settingsY, settingsWidth, settingsHeight);
        transition.drawSlideIn(archives, archivesXTransition, archivesY, archivesWidth, archivesHeight);
        transition.drawSlideIn(contDisabled, contXTransition, contY, contWidth, contHeight);
        transition.drawSlideIn(newGame, newGameXTransition, newGameY, newGameWidth, newGameHeight);

        //draw fade in elements
        transition.dissolveDraw(title, titleX, titleY, titleWidth, titleHeight, colorValue);

        //end draw
        batch.end();
    }
}
