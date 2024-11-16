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
    import com.badlogic.gdx.math.Vector2;
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
        Viewport backgroundViewport;
        Camera camera;

        //Texture atlas
        TextureAtlas mainBgsLogos, playingBgs, cards, environmentalCards, dialogues, culturalCards,
            healthCards, militaryCards, technologicalCards, overallStatusAtlas, gameBackgrounds;

        //Texture Regions
        TextureRegion currentBackground, backCardTextureRegion, lockCardTextureRegion, leftDialogue, rightDialogue;
        TextureRegion[] frontCardTextureRegions, gameBackgroundTextureRegions;

        //card properties
        float cardWidth, cardHeight, cardDefaultX, cardDefaultY;

        //handle Icons
        IconHandler iconHandler;

        //backCards
        BackCard[] backCards;
        int numberOfBackCards, shuffleSpeed, offset;
        Boolean[] shuffledBackCard;

        //frontCards
        FrontCard[] frontCards;
        int numberOfFrontCards;
        FrontCard currentCard;

        //Audio and sound effects
        Music backgroundMusic;
        Sound yearCountSoundEffect, cardShuffleSoundEffect;
        boolean yearCountPlayed;

        //drawer
        SpriteBatch batch;

        //Transition color variables
        float colorValue, leftDialogueColorValue, rightDialogueColorValue;

        //timer for transitions
        float timer;

        //GameScreen states
        int currentGameState, countState = 1, inGameState = 2;

        //inGameStates
        int currentInGameState, shuffleState = 1, playingState = 2, settingState = 3;

        //fonts
        BitmapFont headingMainFont, subHeadingMainFont, bodyMainFont, typeWriter;

        //countdown year
        int countDownYearCurrent, countDownYearFinish;

        //Card movement variables
        Vector2 initialTouch, touchPosition;
        boolean isDragging;

        //Changing card properties
        boolean change, performChange;
        int currentCardIndex, changeCounter;

        //Setting up dialogues for front cards
        DialogueSetup dialogueSetup;

        //debug variables
        int cardCounter = 1;

        //constructor
        public GameScreen(EpochsGame epochsGame) {
            //initialize variables
            this.epochsGame = epochsGame;
            this.assetManager = epochsGame.assetManager;
            viewport = epochsGame.viewport;
            backgroundViewport = epochsGame.backgroundViewport;
            camera = epochsGame.camera;
            batch = epochsGame.batch;

            //set colorTransition value to 1 at the start
            colorValue = 1;

            //Game defaults
            setGameDefaults();

            //load and setup assets
            loadAssets();

            //setup assets
            setupAssets();
        }

        public void setGameDefaults() {
            //sets game defaults
            currentGameState = countState;
            currentInGameState = shuffleState;
            countDownYearCurrent = 0;
            countDownYearFinish = 2024;
            numberOfBackCards = 18;
            numberOfFrontCards = 18;
            shuffleSpeed = 850;
        }

        public void loadAssets() {
            loadTextures();
            loadFonts();
            loadAudio();
        }

        public void setupAssets() {
            setupStatus();
            setupCards();
        }

        public void loadTextures() {
            //setup atlas
            mainBgsLogos = assetManager.get("packedTextures/mainBgsLogos.atlas", TextureAtlas.class);
            playingBgs = assetManager.get("packedTextures/playingBgs.atlas", TextureAtlas.class);
            cards = assetManager.get("packedTextures/cards.atlas", TextureAtlas.class);
            dialogues = assetManager.get("packedTextures/dialogues.atlas", TextureAtlas.class);
            environmentalCards = assetManager.get("packedTextures/environmental.atlas", TextureAtlas.class);
            culturalCards = assetManager.get("packedTextures/cultural.atlas", TextureAtlas.class);
            technologicalCards = assetManager.get("packedTextures/technological.atlas", TextureAtlas.class);
            healthCards = assetManager.get("packedTextures/health.atlas");
            militaryCards = assetManager.get("packedTextures/military.atlas");
            overallStatusAtlas = assetManager.get("packedTextures/overAllStatusImage.atlas");
            gameBackgrounds = assetManager.get("packedTextures/gameBackgrounds.atlas");

            //setup TextureRegions
            backCardTextureRegion = cards.findRegion("back");
            lockCardTextureRegion = cards.findRegion("locked");
            leftDialogue = dialogues.findRegion("yes");
            rightDialogue = dialogues.findRegion("no");

            //setup gamebackgrounds
            gameBackgroundTextureRegions = new TextureRegion[7];
            for (int i = 0; i < 7; i++) {
                gameBackgroundTextureRegions[i] = gameBackgrounds.findRegion("bg" + (i+1));
            }

            //setup default game background
            currentBackground = gameBackgroundTextureRegions[0];

            String frontCardFileName;

            //setup texture region for front cards
            frontCardTextureRegions = new TextureRegion[numberOfFrontCards];
            for (int i = 0; i < numberOfFrontCards; i++) {
                frontCardFileName = "npcCard" + (i+1);
                frontCardTextureRegions[i] = cards.findRegion(frontCardFileName);
            }
        }

        public void setupStatus() {
            iconHandler = new IconHandler(epochsGame);
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
            typeWriter = assetManager.get("typewcond25.otf", BitmapFont.class);
        }

        public void setupCards() {
            //setup card details
            cardWidth = epochsGame.worldWidth * 0.62f;
            cardHeight = epochsGame.worldHeight * 0.47f;
            cardDefaultX = (epochsGame.worldWidth - cardWidth) / 2;
            cardDefaultY = epochsGame.worldHeight * 0.33f;


            //create backCards for shuffling
            setupBackCards();

            //setup front cards
            setupFrontCards();
        }

        public void setupFrontCards() {
            frontCards = new FrontCard[numberOfFrontCards];
            for (int i = 0; i < numberOfFrontCards; i++) {
                frontCards[i] = new FrontCard(frontCardTextureRegions[i], cardDefaultX, cardDefaultY, cardWidth, cardHeight);
            }

            //default current card
            currentCardIndex = (int) (Math.random() * 18);
            currentCard = frontCards[currentCardIndex];

            //card rotation
            initialTouch = new Vector2();
            touchPosition = new Vector2();
            isDragging = false;

            //card change
            change = false;

            //setup dialogues
            setupDialogues();
        }

        public void setupDialogues() {
            //dialogue setup
            dialogueSetup = new DialogueSetup(this);
            dialogueSetup.setupDialogues();
        }

        public void setupBackCards() {
            offset = 400;
            backCards = new BackCard[numberOfBackCards];
            shuffledBackCard = new Boolean[numberOfBackCards];
            for (int i = 0; i < backCards.length; i++) {
                backCards[i] = new BackCard(backCardTextureRegion, cardDefaultX - offset * 2, cardDefaultY + offset, cardWidth, cardHeight);
                shuffledBackCard[i] = false;
                offset += 100;
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
            if (currentGameState == countState) {
                countStateInput();
            }

            if (currentGameState == inGameState) {
                inGameStateInput();
            }
        }

        public void countStateInput() {
            if (!yearCountPlayed) {
                yearCountSoundEffect.play();
                yearCountPlayed = true;
            }
            if (Gdx.input.isTouched()) {
                if (countDownYearCurrent >= countDownYearFinish) {
                    currentGameState = inGameState;

                    //reset parameters
                    timer = 0;
                    countDownYearCurrent = 0;
                    colorValue = 0;

                    //play background music of playing
                    backgroundMusic.play();
                    yearCountPlayed = false;
                }
            }
        }

        public void inGameStateInput() {
            if (currentInGameState == shuffleState){

            }

            if (currentInGameState == playingState) {
                if (Gdx.input.isTouched()) {
                    if (!isDragging) {
                        //get initial touch location
                        initialTouch.set(Gdx.input.getX(), Gdx.input.getY());
                        viewport.unproject(initialTouch);
                        isDragging = true;
                    }
                    //get current touch position
                    touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
                    viewport.unproject(touchPosition);

                    //get change in touch position in x
                    float deltaX = touchPosition.x - initialTouch.x;

                    //update current card position based on drag distance
                    currentCard.setPosition(cardDefaultX + deltaX, cardDefaultY + deltaX / 5);
                    currentCard.setRotation(-1 * deltaX / 15);

                    leftDialogueColorValue = deltaX / (cardWidth / 3.5f);
                    if (leftDialogueColorValue > 1) {
                        leftDialogueColorValue = 1;
                    }

                    if (leftDialogueColorValue < 0) {
                        leftDialogueColorValue = 0;
                    }

                    rightDialogueColorValue = -deltaX / (cardWidth / 3.5f);
                    if (rightDialogueColorValue > 1) {
                        rightDialogueColorValue = 1;
                    }

                    if (rightDialogueColorValue < 0) {
                        rightDialogueColorValue = 0;
                    }

                    //change if drag is greater than absolute value of card width divide by 3
                    change = deltaX > cardWidth / 3.5f || deltaX < -cardWidth / 3.5f;


                } else {
                    //reset position if not touching
                    currentCard.setPosition(cardDefaultX, cardDefaultY);
                    currentCard.setRotation(0);
                    isDragging = false;
                    leftDialogueColorValue = 0;
                    rightDialogueColorValue = 0;
                    if (change) {
                        performChange = true;
                        change = false;
                    }
                }
            }
        }

        public void logic(float delta) {
            //logic for count state
            if (currentGameState == countState) {
                countStateLogic(delta);
            }

            //logic for inGameState
            if (currentGameState == inGameState) {
                if (currentInGameState == shuffleState){
                    shuffleStateLogic(delta);
                }

                if (currentInGameState == playingState) {
                    playingStateLogic(delta);
                }
            }
        }

        public void countStateLogic(float delta) {
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

        public void shuffleStateLogic(float delta) {
            colorValue += delta/2;
            if (colorValue >= 1) {
                colorValue = 1;
            }
            for(int i = 0; i < backCards.length; i++) {
                float positionX = backCards[i].getX() + shuffleSpeed * 2 * delta;
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

                    //reset card position
                    offset = 400;
                    for (int i = 0; i < backCards.length; i++) {
                        backCards[i].setPosition(cardDefaultX - offset * 2, cardDefaultY + offset);
                        shuffledBackCard[i] = false;
                        offset += 100;
                    }
                }
            }
        }

        public void playingStateLogic(float delta) {

            //if card change
            if (performChange) {
                cardCounter++;
                System.out.println("Counter: " + cardCounter);
                //first delete the current card
                currentCard.deleteCurrentCard();
                currentCard.numberOfTimesCardUsed++;

                //pick another not empty card
                do {
                    int index2 = (int) (Math.random() * 18);
                    currentCardIndex = index2;
                    currentCard = frontCards[currentCardIndex];
                } while (currentCard.questions.isEmpty() || currentCard.numberOfTimesCardUsed >= currentCard.maxNumberOfTimes);

                //pick a random dialogue
                int dialogueIndex = (int) (Math.random() * currentCard.questions.size());
                currentCard.updateCard(dialogueIndex);

                //Only change once
                performChange = false;

                //change counter
                changeCounter++;

                //shuffle card and increase decade
                if (changeCounter >= 10) {
                    currentInGameState = shuffleState;
                    currentGameState = countState;
                    changeCounter = 0;
                    backgroundMusic.stop();
                    countDownYearFinish += 150;

                    //reset number of cards used in the decade
                    for (int i = 0; i < numberOfFrontCards; i++) {
                        frontCards[i].numberOfTimesCardUsed = 0;
                    }
                }

                //test icon health
                iconHandler.overallIcon.health++;
                iconHandler.environmentalIcon.health--;
                iconHandler.militaryIcon.health++;
                iconHandler.technologicalIcon.health--;
                iconHandler.culturalIcon.health++;
                iconHandler.medicineIcon.health--;
            }
        }

        public void draw() {
            ScreenUtils.clear(Color.BLACK);

            batch.setColor(colorValue, colorValue, colorValue, 1);

            //draw based on game state
            if (currentGameState == countState) {
                drawCountState();
            } else if (currentGameState == inGameState) {
                drawInGameState();
            }

            //reset color value
            batch.setColor(1, 1,1, 1);
        }

        public void drawCountState () {
            camera.update();
            viewport.apply();
            batch.setProjectionMatrix(camera.combined);
            batch.begin();
            subHeadingMainFont.draw(batch, "year", viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 1.5f + subHeadingMainFont.getCapHeight() * 2f, 0, Align.center, false);
            headingMainFont.draw(batch, String.valueOf(countDownYearCurrent), viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 1.5f, 0 ,Align.center, false);

            if (countDownYearCurrent >= countDownYearFinish) {
                bodyMainFont.setColor(colorValue, colorValue, colorValue, 1);
                bodyMainFont.draw(batch, "Continue >", viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 3, 0 ,Align.center, false);
                bodyMainFont.setColor(1, 1, 1, 1);
            }
            batch.end();
        }

        public void drawInGameState() {
            //use stretching for backgrounds and other icons to avoid black screen for some devices
            camera.update();
            backgroundViewport.apply();
            batch.setProjectionMatrix(camera.combined);
            batch.begin();

            //draw background for ingameState
            batch.draw(currentBackground, 0, 0, epochsGame.worldWidth, epochsGame.worldHeight);
            batch.end();

            //disable scaling when drawing mainGame scene and some important icons
            viewport.apply();
            batch.setProjectionMatrix(camera.combined);
            batch.begin();
            //draw icons, fonts and buttons
            subHeadingMainFont.draw(batch, "2024", subHeadingMainFont.getCapHeight() /5 , epochsGame.worldHeight - subHeadingMainFont.getCapHeight());

            //elements to draw when shuffling
            if (currentInGameState == shuffleState){
                drawShuffleState();
            }

            //elements to draw when playing
            if (currentInGameState == playingState) {
                drawPlayingState();
            }
            batch.end();
        }

        public void drawShuffleState() {
            for (Card backCard : backCards) {
                backCard.setColor(colorValue, colorValue, colorValue, 1);
                backCard.draw(batch);
            }
        }

        public void drawPlayingState() {
            //set opacity for left and right dialogues
            currentCard.leftDialogue.setColor(1, 1, 1, leftDialogueColorValue);
            currentCard.rightDialogue.setColor(1, 1, 1, rightDialogueColorValue);

            //lock card
            batch.draw(lockCardTextureRegion, cardDefaultX, cardDefaultY, cardWidth, cardHeight);

            //draw current card
            currentCard.draw(batch);
            subHeadingMainFont.draw(batch, currentCard.rank, 20, 150);
            typeWriter.draw(batch, currentCard.question, 20, 100);

            //reset dialogues' opacity to prevent bugs
            currentCard.leftDialogue.setColor(1, 1, 1, 1);
            currentCard.rightDialogue.setColor(1, 1, 1, 1);

            //draw icons
            iconHandler.drawIcons(batch);
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

        }
    }
