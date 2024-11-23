package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenuBackground extends ScreenState{
    MainMenuScreen mainMenuScreen;

    //Assets used in this class
    TextureAtlas mainMenuAtlas;
    TextureRegion currentBackground, nextBackground, currentBackground2, nextBackground2, sideBuilding;
    TextureRegion[] bgs;

    //texture region properties
    float backgroundHeight, backgroundWidth, backgroundX, backgroundY, background2X;

    //background states
    int currentState, mainState = 0, transitionState = 1;

    //transition variables
    Transition transition;
    float timer, currentImageColorValue, nextImageColorValue, dissolveSpeed;
    int currentBackgroundIndex;

    //others
    float backgroundChangeSpeed, moveBackgroundSpeed = 30f;

    //constructor
    public MainMenuBackground(EpochsGame epochsGame, MainMenuScreen mainMenuScreen) {
        super(epochsGame);
        this.mainMenuScreen = mainMenuScreen;

        //setup textures to be used in this game
        setupTextures();

        //load textures
        loadTextures();

        //setupTexture properties
        setupTextureProperties();

        //game defaults
        setupGameDefaults();

        //transitions
        setupTransitions();
    }

    public void setupTextures() {
        mainMenuAtlas = mainMenuScreen.mainMenuAtlas;
    }

    public void loadTextures() {
        //initialize array of bgs
        this.bgs = new TextureRegion[7];

        //load textures in atlas
        for (int i = 0; i < 7; i++) {
            bgs[i] = mainMenuAtlas.findRegion("nbg" + (i+1));
        }

        //setup default currentBackground and next background
        currentBackground = bgs[0];
        nextBackground = bgs[1];
        currentBackground2 = currentBackground;
        nextBackground2 = nextBackground;
        sideBuilding = mainMenuAtlas.findRegion("sideBuilding");
    }

    public void setupTextureProperties() {
        backgroundWidth = epochsGame.worldWidth;
        backgroundHeight = epochsGame.worldHeight;
        backgroundX = 0;
        background2X = epochsGame.worldWidth;
    }

    public void setupGameDefaults() {
        currentState = mainState;
        currentBackgroundIndex = 0;
    }

    public void setupTransitions() {
        transition = new Transition(batch);
        dissolveSpeed = 1f;
        currentImageColorValue = 1;
        nextImageColorValue = 0;
        backgroundChangeSpeed = 1.8f;
    }

    public void input() {
        if (currentState == mainState) {

        } else if (currentState == transitionState) {

        }
    }

    public void logic(float delta) {
        moveBackground(delta);
        if (currentState == mainState) {
            mainStateLogic(delta);
        } else if (currentState == transitionState) {
            transitionStateLogic(delta);
        }
    }

    public void moveBackground(float delta) {
        backgroundX -= moveBackgroundSpeed * delta;
        background2X -= moveBackgroundSpeed * delta;
        if (backgroundX < -backgroundWidth) {
            backgroundX = background2X + backgroundWidth;
        }
        if (background2X < -backgroundWidth) {
            background2X = backgroundX + backgroundWidth;
        }
    }

    public void transitionStateLogic(float delta) {
        currentImageColorValue = transition.dissolveLogic(-delta, currentImageColorValue, dissolveSpeed);
        nextImageColorValue = 1 - currentImageColorValue;

        System.out.println(currentImageColorValue);

        if (currentImageColorValue <= 0 && nextImageColorValue >= 1) {
            currentState = mainState;
            currentImageColorValue = 1;
            nextImageColorValue = 0;
            currentBackground = nextBackground;
        }

    }

    public void mainStateLogic(float delta) {
        //update timer
        timer+= delta;

        if (timer > backgroundChangeSpeed) {
            //reset timer
            timer = 0;

            //setup transition
            currentState = transitionState;
            currentBackgroundIndex++;
            if (currentBackgroundIndex == bgs.length) {
                currentBackgroundIndex = 0;
            }
            nextBackground = bgs[currentBackgroundIndex];
        }
    }

    public void draw() {
        //stretch background to fill the screen
        camera.update();
        backgroundViewport.apply();
        batch.setProjectionMatrix(camera.combined);
        //begin draw
        batch.begin();

        if (currentState == mainState) {
            drawMainState();
        } else if(currentState == transitionState) {
            drawTransitionState();
        }

        batch.draw(sideBuilding, 0, 0, epochsGame.worldWidth, epochsGame.worldHeight);

        //end draw
        batch.end();
    }

    public void drawMainState() {
        batch.draw(currentBackground, backgroundX, backgroundY, backgroundWidth, backgroundHeight);
        batch.draw(currentBackground, background2X, backgroundY, backgroundWidth, backgroundHeight);
    }

    public void drawTransitionState() {
        transition.dissolveDraw(currentBackground, backgroundX,backgroundY, backgroundWidth, backgroundHeight, currentImageColorValue);
        transition.dissolveDraw(nextBackground, backgroundX, backgroundY, backgroundWidth, backgroundHeight, nextImageColorValue);
        transition.dissolveDraw(currentBackground, background2X,backgroundY, backgroundWidth, backgroundHeight, currentImageColorValue);
        transition.dissolveDraw(nextBackground, background2X, backgroundY, backgroundWidth, backgroundHeight, nextImageColorValue);
    }

}
