package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

public class EndScreen implements Screen {
    //access to epochsGame and the main assetManager
    EpochsGame epochsGame;
    AssetManager assetManager;

    //viewport and camera
    Viewport viewport, backgroundViewport;
    Camera camera;

    //drawer
    Batch batch;

    //texture atlas for game backgrounds
    TextureAtlas gameBackgroundsAtlas;
    FrontCard card;
    TextureRegion[] background;
    float[] backgroundX;

    //endScreenStates
    int currentState, cardState = 0, scrolllingState = 1;

    //card properties
    float cardWidth;
    float cardHeight;
    float cardDefaultX;
    float cardDefaultY;

    //Bitmap fonts
    BitmapFont greenScreen25, typewriter;

    //dragging card variables
    boolean isDragging;
    Vector2 initialTouch, touchPosition;
    float deltaX;
    boolean change, performChange;
    float leftDialogueColorValue, rightDialogueColorValue;
    TextureRegion lockCard;

    //constructor
    public EndScreen(EpochsGame epochsGame) {
        //important gameScreen and drawing properties
        this.epochsGame = epochsGame;
        this.assetManager = epochsGame.assetManager;
        this.viewport = epochsGame.viewport;
        this.backgroundViewport = epochsGame.backgroundViewport;
        this.camera = epochsGame.camera;
        batch = epochsGame.batch;

        //set card properties
        setupCardProperties();

        //setup card sprite
        setupCardSprite();

        //moving background
        setupMovingBackground();

        //setupTextures
        setupTextures();

        //loadFonts();
        loadFonts();
    }

    public void loadFonts() {
        greenScreen25 = assetManager.get("Greenscr25.ttf", BitmapFont.class);
        typewriter = assetManager.get("typewcond20.otf", BitmapFont.class);
    }

    public void setupCardSprite() {
        //card sprite
        ArrayList<Sprite> leftCardSprite = new ArrayList<>();
        leftCardSprite.add(new Sprite(epochsGame.gameScreen.guideCardsAtlas.findRegion("card19Dialogue1.1")));
        ArrayList<Sprite> rightCardSprite = new ArrayList<>();
        rightCardSprite.add(new Sprite(epochsGame.gameScreen.guideCardsAtlas.findRegion("card19Dialogue1.2")));

        ArrayList<String> cardQuestions = new ArrayList<>();
        cardQuestions.add("Overseer... the world lies in ruin.");
        cardQuestions.add("Overseer… you have shaped the future, but what you’ve built is a world on the edge of collapse.");
        cardQuestions.add("Overseer... the world you have shaped is one where culture and identity have been sacrificed in favor of convenience and control.");
        cardQuestions.add("Overseer, your pursuit of solutions has come at the expense of ethics, compassion, and humanity.");
        cardQuestions.add("Overseer... the world you’ve built is one dominated by power and surveillance.");
        cardQuestions.add("Overseer… the Epoch has endured, though the scars of time are evident.");
        cardQuestions.add("Overseer… the hundred decades have passed, but the cracks in the world you’ve shaped threaten its very foundation.");

        String rank = "Guide";
        ArrayList<Boolean> ignore = new ArrayList<>();
        ignore.add(true);
        ignore.add(true);
        ignore.add(true);
        ignore.add(true);
        ignore.add(true);
        ignore.add(true);
        ignore.add(true);
        card.setupDialogue(leftCardSprite, rightCardSprite, cardQuestions, 5, rank, 1, ignore);
    }

    public void setupCardProperties() {
        cardWidth = epochsGame.gameScreen.cardWidth;
        cardHeight = epochsGame.gameScreen.cardHeight;
        cardDefaultX = epochsGame.gameScreen.cardDefaultX;
        cardDefaultY = epochsGame.gameScreen.cardDefaultY;
        card = new FrontCard(epochsGame.gameScreen.cards.findRegion("guide(sad)"),
            cardDefaultX, cardDefaultY, cardWidth, cardHeight);
        initialTouch = new Vector2();
        touchPosition = new Vector2();
    }

    public void setupMovingBackground() {
        background = new TextureRegion[2];
        backgroundX = new float[2];
        backgroundX[0] = 0;
        backgroundX[1] = epochsGame.worldWidth;
    }

    public void setupTextures() {
        lockCard = epochsGame.gameScreen.cards.findRegion("locked");
        gameBackgroundsAtlas = assetManager.get("packedTextures/endingScreen.atlas");
        switch (epochsGame.gameScreen.endingScenario) {
            case 1:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("environmentalEnding");
                background[1] = gameBackgroundsAtlas.findRegion("environmentalEnding");
                card.question = card.questions.get(0);
                break;
            case 2:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("techEndingpng");
                background[1] = gameBackgroundsAtlas.findRegion("techEndingpng");
                card.question = card.questions.get(1);
                break;
            case 3:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("culturalEnding");
                background[1] = gameBackgroundsAtlas.findRegion("culturalEnding");
                card.question = card.questions.get(2);
                break;
            case 4:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("militaryEnding");
                background[1] = gameBackgroundsAtlas.findRegion("militaryEnding");
                card.question = card.questions.get(3);
                break;
            case 5:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("healthcareEnding");
                background[1] = gameBackgroundsAtlas.findRegion("healthcareEnding");
                card.question = card.questions.get(4);
                break;
            case 6:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("neutralEnding");
                background[1] = gameBackgroundsAtlas.findRegion("neutralEnding");
                card.question = card.questions.get(5);
                break;
            case 7:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("badEnding");
                background[1] = gameBackgroundsAtlas.findRegion("badEnding");
                card.question = card.questions.get(6);
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
        if (currentState == cardState) {
            cardStateInput();
        }
    }

    public void cardStateInput() {
        if (Gdx.input.isTouched()) {
            if (!isDragging) {
                //get initial touch position
                initialTouch.set(Gdx.input.getX(), Gdx.input.getY());
                viewport.unproject(initialTouch);
                isDragging = true;
            }
            //get current touch position
            touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
            viewport.unproject(touchPosition);

            //get change in x
            deltaX = touchPosition.x - initialTouch.x;

            //update card position based on deltaX
            card.setPosition(cardDefaultX + deltaX, cardDefaultY + deltaX / 5);
            card.setRotation(-1 * deltaX / 15);

            //change card if reach a certain distance
            change = deltaX > cardWidth / 3.5f || deltaX < -cardWidth / 3.5f;

            //update leftDialogueColorValue
            leftDialogueColorValue = deltaX / (cardWidth / 3.5f);

            //limit leftColorValue
            if (leftDialogueColorValue > 1) {
                leftDialogueColorValue = 1;
            }
            if (leftDialogueColorValue < 0) {
                leftDialogueColorValue = 0;
            }

            //update rightDialogueColorValue
            rightDialogueColorValue = -deltaX / (cardWidth / 3.5f);

            //limit rightColorValue
            if (rightDialogueColorValue > 1) {
                rightDialogueColorValue = 1;
            }
            if (rightDialogueColorValue < 0) {
                rightDialogueColorValue = 0;
            }

        } else {
            //reset position if not touching
            card.setPosition(cardDefaultX, cardDefaultY);
            card.setRotation(0);
            isDragging = false;
            if (change) {
                change = false;
                performChange = true;
            }

            //reset leftDialogue and rightDialogue color values
            leftDialogueColorValue = 0;
            rightDialogueColorValue = 0;
        }
    }

    public void logic(float delta) {

        //card state logic
        if (currentState == cardState) {
            cardStateLogic(delta);
        } else if (currentState == scrolllingState) {
            //logic for moving background
            movingBackgroundLogic(delta);
        }

    }

    public void cardStateLogic(float delta) {
        if (performChange) {
            performChange = false;
            currentState = scrolllingState;
        }
    }

    public void movingBackgroundLogic(float delta) {
        for (int i = 0; i < backgroundX.length;i++) {
            backgroundX[i] -= delta * 30;
            if (backgroundX[i] <= -epochsGame.worldWidth) {
                backgroundX[i] = epochsGame.worldWidth;
            }
        }
    }

    public void draw() {
        //draw background all the time
        drawCurrentBackground();

        //draw cardState
        if (currentState == cardState) {
            drawCardState();
        }

        //draw scrollingState
    }

    public void drawCardState() {
        //update camera
        camera.update();

        //disable scaling for drawing card state
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);

        //begin drawing
        batch.begin();

        //draw card
        //draw lock card
        batch.draw(lockCard, cardDefaultX, cardDefaultY, cardWidth, cardHeight);
        //assign left and right dialogue color values
        card.leftDialogue.setColor(1, 1, 1, leftDialogueColorValue);
        card.rightDialogue.setColor(1, 1, 1, rightDialogueColorValue);
        card.draw(batch);
        greenScreen25.draw(batch, card.rank, 0, cardDefaultY + cardHeight +
            greenScreen25.getCapHeight() * 2, epochsGame.worldWidth, Align.center, true);
        typewriter.draw(batch, card.question, epochsGame.worldWidth * 0.05f,
            cardDefaultY - greenScreen25.getCapHeight(), epochsGame.worldWidth * 0.9f, Align.center, true);

        //end drawing
        batch.end();

        //reset right and left dialogue colorValue
        card.leftDialogue.setColor(1, 1, 1, 1);
        card.rightDialogue.setColor(1, 1, 1, 1);
    }

    public void drawCurrentBackground() {
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
