package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenuScreen implements Screen {
    //access to epochsGame and the main assetManager
    EpochsGame epochsGame;
    AssetManager assetManager;

    //viewport and camera
    Viewport viewport;
    Camera camera;

    //textures for assets
    TextureAtlas mainBgsLogos ,playingBgs, settingsAssets;
    TextureRegion[] currentBackground;
    TextureRegion flare, title, start, settings, archives, about, bars, xButton;

    //xButton properties
    float xButtonX, xButtonY, xButtonWidth, xButtonHeight;

    //flare properties
    float flareX, flareY, flareWidth, flareHeight;

    //flare Sprite
    Sprite flareSprite;
    float flareTimer;

    //title properties
    float titleX, titleY, titleWidth, titleHeight;

    //start properties
    float startX, startY, startWidth, startHeight;

    //settings properties
    float settingsX, settingsY, settingsWidth, settingsHeight;

    //archives properties
    float archivesX, archivesY, archivesWidth, archivesHeight;

    //about
    float aboutX, aboutY, aboutWidth, aboutHeight;

    //bars
    float barsX, barsY, barsWidth, barsHeight;

    //Audio and sound effects
    Music backgroundMusic;

    //drawer
    SpriteBatch batch;

    //color value for transition
    float colorValue;
    float iconsColorValue;
    float startButtonColorValue;

    //timer for transitions
    float timer;
    float startTimer;

    //variables for moving background
    float[] backgroundX;

    //handles inut
    Vector2 touchPosition;
    boolean justClicked;

    //menu states
    int menuState;
    int mainMenuState = 0;
    int settingsState = 1;
    int aboutState = 2;
    int archivesState = 3;


    //constructor
    public MainMenuScreen(EpochsGame epochsGame) {
        //initialize variables
        this.epochsGame = epochsGame;
        this.assetManager = epochsGame.assetManager;
        viewport = epochsGame.viewport;
        camera = epochsGame.camera;
        batch = epochsGame.batch;
        touchPosition = new Vector2();

        //set default colorValue transitions
        colorValue = 1;
        startButtonColorValue = 1;
        iconsColorValue = 0;

        //set timer to 0
        timer = 0;

        //load and setup assets
        loadAssets();

        //setup texture properties
        setupTextureProperties();

        //set menu default state to mainMenu
        menuState = mainMenuState;
    }


    public void setupTextureProperties() {
        //flare
        flareWidth = 0.85f * epochsGame.worldWidth;
        flareHeight = 0.85f * epochsGame.worldWidth;
        flareX = (epochsGame.worldWidth - flareWidth) / 2;
        flareY = 0.29f * epochsGame.worldHeight;

        //flare sprite
        flareSprite = new Sprite(flare);
        flareSprite.setSize(flareWidth, flareHeight);
        flareSprite.setPosition(flareX, flareY);
        flareSprite.setOriginCenter();

        //title
        titleWidth = epochsGame.worldWidth * 0.5f;
        titleHeight = epochsGame.worldHeight * 0.135f;
        titleX = (epochsGame.worldWidth - titleWidth) / 2;
        titleY = 0.795f * epochsGame.worldHeight;

        //bars
        barsWidth = epochsGame.worldWidth * 0.4f;
        barsHeight = epochsGame.worldHeight * 0.09f;
        barsX = (epochsGame.worldWidth - barsWidth) / 2f;
        barsY = 0.55f * epochsGame.worldHeight;

        //start
        startWidth = epochsGame.worldWidth * 0.4f;
        startHeight = epochsGame.worldHeight * 0.045f;
        startX = (epochsGame.worldWidth - startWidth) / 2f;
        startY = 0.57f * epochsGame.worldHeight;

        //settings
        settingsWidth = epochsGame.worldWidth * 0.22f;
        settingsHeight = epochsGame.worldHeight * 0.012f;
        settingsX = (epochsGame.worldWidth - settingsWidth) / 2f;
        settingsY = 0.508f * epochsGame.worldHeight;

        //archives
        archivesWidth = epochsGame.worldWidth * 0.22f;
        archivesHeight = epochsGame.worldHeight * 0.012f;
        archivesX = (epochsGame.worldWidth - archivesWidth) / 2f;
        archivesY = 0.47f * epochsGame.worldHeight;

        //about
        aboutWidth = epochsGame.worldWidth * 0.15f;
        aboutHeight = epochsGame.worldHeight * 0.012f;
        aboutX = (epochsGame.worldWidth - aboutWidth) / 2f;
        aboutY = 0.432f * epochsGame.worldHeight;

        //xButton
        xButtonWidth = epochsGame.worldHeight * 0.045f;
        xButtonHeight = epochsGame.worldHeight * 0.045f;
        xButtonX = epochsGame.worldWidth * .8f;
        xButtonY = 0.9f * epochsGame.worldHeight;

        //background moving
        backgroundX = new float[8];
        for (int i = 0; i < backgroundX.length; i++) {
            backgroundX[i] = (i) * epochsGame.worldWidth;
        }


    }

    public void loadAssets() {
        //load atlas
        mainBgsLogos = assetManager.get("packedTextures/mainBgsLogos.atlas", TextureAtlas.class);
        playingBgs = assetManager.get("packedTextures/playingBgs.atlas", TextureAtlas.class);
        settingsAssets = assetManager.get("packedTextures/settings.atlas", TextureAtlas.class);

        //get texture region from atlas
        flare = mainBgsLogos.findRegion("flare");
        title = mainBgsLogos.findRegion("title");
        start = mainBgsLogos.findRegion("start(unclicked)");
        settings = mainBgsLogos.findRegion("settings(unclicked)");
        archives = mainBgsLogos.findRegion("archives(unclicked)");
        about = mainBgsLogos.findRegion("about(unclicked)");
        bars = mainBgsLogos.findRegion("bars");
        xButton = settingsAssets.findRegion("xButton");

        //setup textureRegion for moving background
        currentBackground = new TextureRegion[8];
        currentBackground[0] = mainBgsLogos.findRegion("mainBackground(portrait)");
        for (int i = 1; i < currentBackground.length; i++) {
            currentBackground[i] = playingBgs.findRegion("bg" + (i+1));
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
        if (Gdx.input.isTouched() && !justClicked) {
            touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
            viewport.unproject(touchPosition);
            if (menuState == mainMenuState) {
                mainMenuInput(touchPosition);
            } else if (menuState == settingsState) {
                settingsInput(touchPosition);
            } else if (menuState == aboutState) {
                aboutInput(touchPosition);
            } else if (menuState == archivesState) {
                archivesInput(touchPosition);
            }
        } else {
            justClicked = false;
        }
    }

    public void aboutInput(Vector2 touchPosition) {
        //back to main menu
        if (touchPosition.x >= xButtonX && touchPosition.x <= xButtonX + xButtonWidth && touchPosition.y >= xButtonY && touchPosition.y <= xButtonY + xButtonHeight) {
            menuState = mainMenuState;
        }
    }

    public void archivesInput(Vector2 touchPosition) {
        //back to mainMenu
        if (touchPosition.x >= xButtonX && touchPosition.x <= xButtonX + xButtonWidth && touchPosition.y >= xButtonY && touchPosition.y <= xButtonY + xButtonHeight) {
            menuState = mainMenuState;
        }
    }

    public void settingsInput(Vector2 touchPosition) {
        if (touchPosition.x >= xButtonX && touchPosition.x <= xButtonX + xButtonWidth && touchPosition.y >= xButtonY && touchPosition.y <= xButtonY + xButtonHeight) {
            menuState = mainMenuState;
        }
     }

    public void mainMenuInput(Vector2 touchPosition) {
        if (timer >= 1) {

            //settings button
            if (touchPosition.x >= settingsX && touchPosition.x <= settingsX + settingsWidth && touchPosition.y >= settingsY && touchPosition.y <= settingsY + settingsHeight) {
                justClicked = true;
                menuState = settingsState;
            }

            //archives button
            else if (touchPosition.x >= archivesX && touchPosition.x <= archivesX + archivesWidth && touchPosition.y >= archivesY && touchPosition.y <= archivesY + archivesHeight) {
                justClicked = true;
                menuState = archivesState;
            }

            //about button
            else if (touchPosition.x >= aboutX && touchPosition.x <= aboutX + aboutWidth && touchPosition.y >= aboutY && touchPosition.y <= aboutY + aboutHeight) {
                justClicked = true;
                menuState = aboutState;
            }

            //start button
            else if (touchPosition.x >= startX && touchPosition.x <= startX + startWidth && touchPosition.y >= startY && touchPosition.y <= startY + startHeight) {
                justClicked = true;
                epochsGame.splashScreen.backgroundMusic.stop();
                epochsGame.gameScreen = new GameScreen(epochsGame);
                epochsGame.setScreen(epochsGame.gameScreen);
            }
        }
    }

    public void logic(float delta) {
        timer += delta;
        flareTimer += delta;
        startTimer += delta;

        //fade in fade out logic for background and title
        if (timer > 2) {
            if (timer - 2 < 1) {
                colorValue -= delta / 1.5f;
            } else if (timer - 2 <= 2) {
                colorValue += delta / 1.5f;
            } else if (timer > 4) {
                timer = 2;
                colorValue = 1F;
            }
        }

        //icons color value and startButton
        if (startTimer < 1.5) {
            iconsColorValue += delta;
            if (iconsColorValue >= 1) {
                iconsColorValue = 1;
            }
            startButtonColorValue = iconsColorValue;
        } else {
            startTimer += delta;
            if (startTimer > 2.15F) {
                    startButtonColorValue = 1 - startButtonColorValue;
                    startTimer = 1.5f;
            }
        }

        //limit colorvalue to 0 - 1;
        if (colorValue <= 0) {
            colorValue = 0;
        }
        if (colorValue >= 1) {
            colorValue = 1;
        }


        //rotate flare
        if (flareTimer > 0.0001f) {
            flareSprite.setRotation(flareSprite.getRotation() + 0.2f);
            flareTimer = 0;
        }

        //move background
        for (int i = 0; i < backgroundX.length; i++) {
            backgroundX[i] -= delta * 30;
            if (backgroundX[i] <= -epochsGame.worldWidth * 7) {
                backgroundX[i] = epochsGame.worldWidth;
            }
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

        //draw backgrounds
        for (int i = 0; i < currentBackground.length; i++) {
            batch.draw(currentBackground[i], backgroundX[i], 0, epochsGame.worldWidth, epochsGame.worldHeight);
        }

        if (menuState == mainMenuState) {
            drawMainMenu();
        } else if (menuState == settingsState) {
            drawSettings();
        } else if (menuState == archivesState) {
            drawArchives();
        } else if (menuState == aboutState) {
            drawAbout();
        }

        //end draw
        batch.end();

        //reset color value
        batch.setColor(1, 1, 1, 1);

    }

    public void drawSettings() {
        //draws icons

        //back button
        batch.draw(xButton, xButtonX, xButtonY, xButtonWidth, xButtonHeight);
    }

    public void drawAbout() {
        //draws icons

        //back button
        batch.draw(xButton, xButtonX, xButtonY, xButtonWidth, xButtonHeight);
    }

    public void drawArchives() {
        //draws icons

        //back button
        batch.draw(xButton, xButtonX, xButtonY, xButtonWidth, xButtonHeight);
    }

    public void drawMainMenu() {

        //draws icons
        flareSprite.draw(batch);

        //controls color value for icons
        batch.setColor(1, 1, 1, iconsColorValue);

        batch.draw(title, titleX, titleY, titleWidth, titleHeight);
        batch.draw(bars, barsX, barsY, barsWidth, barsHeight);
        batch.draw(settings, settingsX, settingsY, settingsWidth, settingsHeight);
        batch.draw(archives, archivesX, archivesY, archivesWidth, archivesHeight);
        batch.draw(about, aboutX, aboutY, aboutWidth, aboutHeight);

        //separate color value for startButton
        batch.setColor(1, 1, 1, startButtonColorValue);
        batch.draw(start, startX, startY, startWidth, startHeight);
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
