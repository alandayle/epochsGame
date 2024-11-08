package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GameScreen implements Screen {
    //access to epochsGame and the main assetManager
    EpochsGame epochsGame;
    AssetManager assetManager;

    //viewport and camera
    Viewport viewport;
    Camera camera;

    //textures for assets in CountState


    //textures for assets in inGameState
    TextureAtlas mainBgsLogos;
    TextureAtlas playingBgs;
    TextureAtlas cards;
    TextureRegion currentBackground;
    TextureRegion backCardTextureRegion;
    TextureRegion[] frontCardTextureRegions;
    TextureRegion[] frontCardDialogueTextureRegions;

    //testing for left dialogue and right dialogue
    TextureAtlas dialogues;
    TextureRegion leftDialogue;
    TextureRegion rightDialogue;


    //cards
    float cardWidth, cardHeight;
    float cardDefaultX, cardDefaultY;

    //backCards
    BackCard[] backCards;
    int numberOfBackCards;
    int shuffleSpeed;
    int offset;
    Boolean[] shuffledBackCard;

    //frontCards
    FrontCard[] frontCards;
    int numberOfFrontCards;
    FrontCard currentCard;


    //Audio and sound effects
    Music backgroundMusic;
    Sound yearCountSoundEffect;
    Sound cardShuffleSoundEffect;

    //drawer
    SpriteBatch batch;

    //color value for transition
    float colorValue;

    //timer for transitions
    float timer;

    //Primary Game States
    int currentGameState;
    int countState = 1;
    int inGameState = 2;

    //inGameStates
    int currentInGameState;
    int shuffleState = 1;
    int playingState = 2;
    int settingState = 3;

    //fonts
    BitmapFont headingMainFont, subHeadingMainFont, bodyMainFont;

    //countdown year
    int countDownYearCurrent;
    int countDownYearFinish;

    //constructor
    public GameScreen(EpochsGame epochsGame) {
        //initialize variables
        this.epochsGame = epochsGame;
        this.assetManager = epochsGame.assetManager;
        viewport = epochsGame.viewport;
        camera = epochsGame.camera;
        batch = epochsGame.batch;

        //set colorTransition value to 1 at the start
        colorValue = 1;

        //set timer to 0
        timer = 0;

        //Game defaults
        setGameDefaults();

        //load and setup assets
        loadAssets();

    }

    public void loadAssets() {
        loadTextures();
        loadFonts();
        loadAudio();
        setupCards();
    }

    public void loadTextures() {
        //setup atlas
        mainBgsLogos = assetManager.get("packedTextures/mainBgsLogos.atlas", TextureAtlas.class);
        playingBgs = assetManager.get("packedTextures/playingBgs.atlas", TextureAtlas.class);
        cards = assetManager.get("packedTextures/cards.atlas", TextureAtlas.class);
        dialogues = assetManager.get("packedTextures/dialogues.atlas", TextureAtlas.class);

        //setup TextureRegions
        currentBackground = playingBgs.findRegion("bg1");
        backCardTextureRegion = cards.findRegion("backCardTesting");
        leftDialogue = dialogues.findRegion("no");
        rightDialogue = dialogues.findRegion("yes");

        String frontCardFileName;
        //setup texture region for front cards
        frontCardTextureRegions = new TextureRegion[numberOfFrontCards];
        for (int i = 0; i < numberOfFrontCards; i++) {
            frontCardFileName = "npc" + (i+1);
            frontCardTextureRegions[i] = cards.findRegion(frontCardFileName);
        }

    }

    public void loadAudio() {
        yearCountSoundEffect = assetManager.get("audio/yearCountSoundEffect.mp3");
        backgroundMusic = assetManager.get("audio/playing.mp3");
        backgroundMusic.setLooping(true);
        cardShuffleSoundEffect = assetManager.get("audio/cardShuffle.mp3");
    }

    public void loadFonts() {
        headingMainFont = assetManager.get("setbackt50.ttf", BitmapFont.class);
        subHeadingMainFont = assetManager.get("setbackt40.ttf", BitmapFont.class);
        bodyMainFont = assetManager.get("setbackt25.ttf", BitmapFont.class);
    }

    public void setupCards() {
        //setup card details
        cardWidth = (epochsGame.worldWidth - epochsGame.worldWidth /6) * 0.8f;
        cardHeight = epochsGame.worldHeight / 2.11f;
        cardDefaultX = (epochsGame.worldWidth - cardWidth) / 2;
        cardDefaultY = epochsGame.worldHeight / 5.82f;


        //create backCards for shuffling
        setupBackCards();

        //setup front cards
        setupFrontCards();
    }

    public void setupFrontCards() {
        frontCards = new FrontCard[numberOfFrontCards];
        for (int i = 0; i < numberOfFrontCards; i++) {
            frontCards[i] = new FrontCard(frontCardTextureRegions[i], cardDefaultX, cardDefaultY, cardWidth, cardHeight, leftDialogue, rightDialogue);
        }
        currentCard = frontCards[0];
    }

    public void setupBackCards() {
        offset = 400;
        backCards = new BackCard[numberOfBackCards];
        shuffledBackCard = new Boolean[numberOfBackCards];
        for (int i = 0; i < backCards.length; i++) {
            backCards[i] = new BackCard(backCardTextureRegion, cardDefaultX - offset, cardDefaultY + offset, cardWidth, cardHeight);
            shuffledBackCard[i] = false;
            offset += 100;
        }
    }

    public void setGameDefaults() {
        //sets game defaults
        currentGameState = countState;
        currentInGameState = shuffleState;
        countDownYearCurrent = 0;
        countDownYearFinish = 2024;
        numberOfBackCards = 18;
        numberOfFrontCards = 18;
        shuffleSpeed = 1000;
    }


    @Override
    public void show() {
        yearCountSoundEffect.play();
    }

    @Override
    public void render(float delta) {
        input();
        logic(delta);
        draw();
    }

    public void input() {
        if (currentGameState == countState) {
            if (Gdx.input.isTouched()) {
                if (countDownYearCurrent >= countDownYearFinish) {
                    currentGameState = inGameState;

                    //reset parameters
                    timer = 0;
                    countDownYearCurrent = 0;
                    colorValue = 0;

                    //play background music of playing
                    backgroundMusic.play();
                }
            }
        }

        if (currentGameState == inGameState) {
            if (currentInGameState == shuffleState){

            }

            if (currentInGameState == playingState) {

            }
        }
    }

    public void logic(float delta) {
        //logic for count state
        if (currentGameState == countState) {
            timer += delta;

            if (countDownYearCurrent < countDownYearFinish) {
                countDownYearCurrent = (int) (countDownYearFinish * (timer /3f));
            }

            if (countDownYearCurrent >= countDownYearFinish) {
                countDownYearCurrent = countDownYearFinish;
                int floorValue = (int) Math.floor(timer);
                if (floorValue % 2 == 0) {
                    colorValue -= delta;
                } else {
                    colorValue += delta;
                }
            }

            if (colorValue < 0) {
                colorValue = 0;
            } else if (colorValue > 1) {
                colorValue = 1;
            }

        }

        //logic for inGameState
        if (currentGameState == inGameState) {
            if (currentInGameState == shuffleState){
                colorValue += delta/2;
                if (colorValue >= 1) {
                    colorValue = 1;
                }
                for(int i = 0; i < backCards.length; i++) {
                    float positionX = backCards[i].getX() + shuffleSpeed * delta;
                    float positionY = backCards[i].getY() - shuffleSpeed * delta;
                    if (positionY <= cardDefaultY) {
                        positionY = cardDefaultY;
                        //if position equal destination, play shuffle once
                        if (!shuffledBackCard[i]) {
                            cardShuffleSoundEffect.play();
                            shuffledBackCard[i] = true;
                        }
                    }
                    if (positionX >= cardDefaultX) {
                        positionX = cardDefaultX;
                    }
                    backCards[i].setPosition(positionX, positionY);
                }

                if (backCards[backCards.length - 1].getX() >= cardDefaultX) {
                    timer+= delta;
                    if (timer > 1) {
                        currentInGameState = playingState;
                        timer = 0;
                    }
                }
            }

            if (currentInGameState == playingState) {

            }
        }
    }

    public void draw() {
        ScreenUtils.clear(Color.BLACK);
        camera.update();
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);

        batch.setColor(colorValue, colorValue, colorValue, 1);
        //begin draw
        batch.begin();

        //draw based on game state
        if (currentGameState == countState) {
            drawCountState();
        } else if (currentGameState == inGameState) {
            drawInGameState();
        }

        //end draw
        batch.end();

        //reset color value
        batch.setColor(1, 1,1, 1);
    }

    public void drawCountState () {
        subHeadingMainFont.draw(batch, "year", viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 1.5f + subHeadingMainFont.getCapHeight() * 2f, 0, Align.center, false);
        headingMainFont.draw(batch, String.valueOf(countDownYearCurrent), viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 1.5f, 0 ,Align.center, false);

        if (countDownYearCurrent >= countDownYearFinish) {
            bodyMainFont.setColor(colorValue, colorValue, colorValue, 1);
            bodyMainFont.draw(batch, "Continue >", viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 3, 0 ,Align.center, false);
            bodyMainFont.setColor(1, 1, 1, 1);
        }
    }

    public void drawInGameState() {
        batch.draw(currentBackground, 0, 0, epochsGame.worldWidth, epochsGame.worldHeight);
        if (currentInGameState == shuffleState){
            for (Card backCard : backCards) {
                backCard.setColor(colorValue, colorValue, colorValue, 1);
                backCard.draw(batch);
            }
        }

        if (currentInGameState == playingState) {
            batch.draw(backCardTextureRegion, cardDefaultX, cardDefaultY, cardWidth, cardHeight);
            currentCard.draw(batch);
            currentCard.setRotation(20);
        }
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
