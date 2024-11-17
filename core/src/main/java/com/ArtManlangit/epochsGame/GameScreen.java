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
            healthCards, militaryCards, technologicalCards, overallStatusAtlas, gameBackgrounds, foregroundAtlas,
            guideCardsAtlas;

        //Texture Regions
        TextureRegion currentBackground, backCardTextureRegion, lockCardTextureRegion, leftDialogue, rightDialogue;
        TextureRegion[] scrollingBackground;
        float[] scrollingBackgroundX;
        TextureRegion[] frontCardTextureRegions, gameBackgroundTextureRegions, foregroundTextureRegions;

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
        int currentInGameState, shuffleState = 1, playingState = 2, guideState = 3;
        boolean guideDone;

        //fonts
        BitmapFont headingMainFont, subHeadingMainFont, bodyMainFont, typeWriter, greenScreen25, greenScreen30;

        //countdown year
        int countDownYearCurrent, countDownYearFinish, countDownYearStart;

        //Card movement variables
        Vector2 initialTouch, touchPosition;
        boolean isDragging;

        //Changing card properties
        boolean change, performChange;
        int currentCardIndex, changeCounter, currentDialogueIndex;

        //Setting up dialogues for front cards
        DialogueSetup dialogueSetup;

        //card choice detector 0 for left, 1 for right
        int cardChoice;
        int currentTheme;
        int environmentalTheme = 1, technologicalTheme = 2, culturalTheme = 3, militaryTheme = 4, medicineTheme = 5;
        final int leftChoice = 0;
        final int rightChoice = 1;

        //debug variables
        int cardCounter = 1;

        //endScene scenario
        int endingScenario;

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
            countDownYearStart = 0;
            countDownYearFinish = (int)(Math.random() * 101) + 2000;
            numberOfBackCards = 10;
            numberOfFrontCards = 19;
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
            foregroundAtlas = assetManager.get("packedTextures/foreground.atlas");
            guideCardsAtlas = assetManager.get("packedTextures/guideDialogues.atlas");

            //setup TextureRegions
            backCardTextureRegion = cards.findRegion("back");
            lockCardTextureRegion = cards.findRegion("locked");

            //setup gamebackgrounds
            gameBackgroundTextureRegions = new TextureRegion[7];
            for (int i = 0; i < 7; i++) {
                gameBackgroundTextureRegions[i] = gameBackgrounds.findRegion("bg" + (i+1));
            }

            //setup default game background
            currentBackground = gameBackgroundTextureRegions[0];

            //scrolling background
            scrollingBackground = new TextureRegion[2];
            scrollingBackground[0] = gameBackgroundTextureRegions[0];
            scrollingBackground[1] = gameBackgroundTextureRegions[0];
            scrollingBackgroundX = new float[2];
            scrollingBackgroundX[0] = 0;
            scrollingBackgroundX[1] = epochsGame.worldWidth;


            String frontCardFileName;

            //setup texture region for front cards
            frontCardTextureRegions = new TextureRegion[numberOfFrontCards];
            for (int i = 0; i < numberOfFrontCards; i++) {
                frontCardFileName = "npcCard" + (i+1);
                frontCardTextureRegions[i] = cards.findRegion(frontCardFileName);
            }

            String foregroundFileName;
            //setup texture regions for foregrounds
            foregroundTextureRegions = new TextureRegion[7];
            for (int i = 0; i < 7; i++) {
                foregroundFileName = "fg" + (i+1);
                foregroundTextureRegions[i] = foregroundAtlas.findRegion(foregroundFileName);
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
            typeWriter = assetManager.get("typewcond20.otf", BitmapFont.class);
            greenScreen25 = assetManager.get("Greenscr25.ttf", BitmapFont.class);
            greenScreen30 = assetManager.get("Greenscr30.ttf", BitmapFont.class);
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

            //setup default cards
            //default current card guide card
            currentCard = frontCards[18];
            currentTheme = currentCard.theme;
            currentDialogueIndex = 0;  //updated this part because of the bug
            currentCard.updateCard(currentDialogueIndex);
        }

        public void setupFrontCards() {
            frontCards = new FrontCard[numberOfFrontCards];
            for (int i = 0; i < numberOfFrontCards; i++) {
                frontCards[i] = new FrontCard(frontCardTextureRegions[i], cardDefaultX, cardDefaultY, cardWidth, cardHeight);
            }


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

            if (currentInGameState == playingState || currentInGameState == guideState) {
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

                    //change direction based on delta x
                    if (deltaX > 0) {
                        cardChoice = leftChoice;
                    } else {
                        cardChoice = rightChoice;
                    }

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
                //scrolling background
                for (int i = 0; i < scrollingBackground.length;i++) {
                    scrollingBackgroundX[i] -= delta * 30;
                    if (scrollingBackgroundX[i] <= -epochsGame.worldWidth) {
                        scrollingBackgroundX[i] = epochsGame.worldWidth;
                    }
                }


                if (currentInGameState == shuffleState){
                    shuffleStateLogic(delta);
                }

                if (currentInGameState == playingState) {
                    playingStateLogic(delta);
                }
                if (currentInGameState == guideState) {
                    guideStateLogic(delta);
                }
            }
        }

        public void countStateLogic(float delta) {
            timer += delta;

            if (countDownYearCurrent < countDownYearFinish) {
                countDownYearCurrent = countDownYearStart + (int) ((countDownYearFinish- countDownYearStart) * (timer /3f));
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

            //shuffle cards
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

            //check if shuffling is done
            if (backCards[backCards.length - 1].getX() >= cardDefaultX) {
                timer+= delta;
                if (timer > 1) {
                    if (!guideDone) {
                        currentInGameState = guideState;
                    } else {
                        currentInGameState = playingState;
                    }
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

        public void guideStateLogic(float delta) {
            if (performChange) {
                changeCounter++;
                //delete the current card
                if (changeCounter >= 5) {
                    guideDone = true;
                    currentInGameState = shuffleState;
                    currentGameState = countState;
                    changeCounter = 0;
                    backgroundMusic.stop();
                    countDownYearCurrent = 0;
                    countDownYearStart = 0;
                    countDownYearFinish += (int) (Math.random() * 300 + 100);

                    //default current card for actual play
                    currentCardIndex = (int) (Math.random() * 18);
                    currentCard = frontCards[currentCardIndex];
                    currentTheme = currentCard.theme;
                    currentDialogueIndex = (int) (Math.random() * currentCard.questions.size()); //updated this part because of the bug
                    currentCard.updateCard(currentDialogueIndex);
                } else {
                    currentCard.deleteCurrentCard();
                    currentCard.updateCard(0);
                    System.out.println(changeCounter);
                }

                //perform change once
                performChange = false;

            }
        }

        public void playingStateLogic(float delta) {

            //if card change
            if (performChange) {
                cardCounter++;
                System.out.println("Current card: Card " + cardCounter);
                //update health based on card choice
                //test icon health
                updateHealth();

                //delete the current card
                currentCard.deleteCurrentCard();

                //pick another not empty card
                if (cardCounter <= 80) {
                    do {
                        int index2 = (int) (Math.random() * 18);
                        currentCardIndex = index2;
                        currentCard = frontCards[currentCardIndex];
                    } while (currentCard.questions.isEmpty());  //Late commit, updated this part because of the bug

                    //debug card
//                currentCard = frontCards[11];

                    //pick a random dialogue
                    int dialogueIndex = (int) (Math.random() * currentCard.questions.size());
                    currentCard.updateCard(dialogueIndex);

                    //update current theme
                    currentTheme = currentCard.theme;

                    //change counter
                    changeCounter++;

                    //shuffle card and increase decade
                    if (changeCounter >= 10) {
                        currentInGameState = shuffleState;
                        currentGameState = countState;
                        changeCounter = 0;
                        backgroundMusic.stop();
                        countDownYearCurrent = countDownYearFinish;
                        countDownYearStart = countDownYearFinish;
                        countDownYearFinish += (int) (Math.random() * 300 + 100);

                        //reset number of cards used in the decade
                        for (int i = 0; i < numberOfFrontCards; i++) {
                            frontCards[i].numberOfTimesCardUsed = 0;
                        }
                    }
                }

                //Only change once
                performChange = false;
            }
            checkWinningState();
        }

        public void checkWinningState() {
            if (cardCounter >= 80) {
                if (iconHandler.overallIcon.health <= 3) {
                    endingScenario = 7;
                } else {
                    endingScenario = 6;
                }
                backgroundMusic.stop();
                epochsGame.endScreen = new EndScreen(epochsGame);
                epochsGame.setScreen(epochsGame.endScreen);
            }
            if (iconHandler.environmentalIcon.health <= 0) {
                endingScenario = 1;
                backgroundMusic.stop();
                epochsGame.endScreen = new EndScreen(epochsGame);
                epochsGame.setScreen(epochsGame.endScreen);
            }

            if (iconHandler.technologicalIcon.health <= 0) {
                endingScenario = 2;
                backgroundMusic.stop();
                epochsGame.endScreen = new EndScreen(epochsGame);
                epochsGame.setScreen(epochsGame.endScreen);
            }

            if (iconHandler.culturalIcon.health <= 0) {
                endingScenario = 3;
                backgroundMusic.stop();
                epochsGame.endScreen = new EndScreen(epochsGame);
                epochsGame.setScreen(epochsGame.endScreen);
            }

            if (iconHandler.militaryIcon.health <= 0) {
                endingScenario = 4;
                backgroundMusic.stop();
                epochsGame.endScreen = new EndScreen(epochsGame);
                epochsGame.setScreen(epochsGame.endScreen);
            }

            if (iconHandler.medicineIcon.health <= 0) {
                endingScenario = 5;
                backgroundMusic.stop();
                epochsGame.endScreen = new EndScreen(epochsGame);
                epochsGame.setScreen(epochsGame.endScreen);
            }
        }

        public void updateHealth() {
            //update health based on card choice
            //add  = 1 or subtract = -1
            int operation;
            System.out.println(currentCard.leftChoiceTrue);
            if (currentCard.leftChoiceTrue) {
                if (cardChoice == leftChoice) {
                    //add health
                    operation = 1;
                } else {
                    //subtract health
                    operation = -1;
                }
            } else {
                if (cardChoice == leftChoice) {
                    //subtract health
                    operation = -1;
                } else {
                    //add health
                    operation = 1;
                }
            }

            switch (currentTheme) {
                case 1:
                    iconHandler.environmentalIcon.health += operation;
                    //limit health
                    if (iconHandler.environmentalIcon.health >= 10) {
                        iconHandler.environmentalIcon.health = 10;
                    }
                    if (iconHandler.environmentalIcon.health <= 0) {
                        iconHandler.environmentalIcon.health = 0;
                    }
                    break;
                case 2:
                    iconHandler.technologicalIcon.health += operation;
                    //limit health
                    if (iconHandler.technologicalIcon.health >= 10) {
                        iconHandler.technologicalIcon.health = 10;
                    }
                    if (iconHandler.technologicalIcon.health <= 0) {
                        iconHandler.technologicalIcon.health = 0;
                    }
                    break;
                case 3:
                    iconHandler.culturalIcon.health += operation;
                    //limit health
                    if (iconHandler.culturalIcon.health >= 10) {
                        iconHandler.culturalIcon.health = 10;
                    }
                    if (iconHandler.culturalIcon.health <= 0) {
                        iconHandler.culturalIcon.health = 0;
                    }
                    break;
                case 4:
                    iconHandler.militaryIcon.health += operation;
                    //limit health
                    if (iconHandler.militaryIcon.health >= 10) {
                        iconHandler.militaryIcon.health = 10;
                    }
                    if (iconHandler.militaryIcon.health <= 0) {
                        iconHandler.militaryIcon.health = 0;
                    }
                    break;
                case 5:
                    iconHandler.medicineIcon.health += operation;
                    //limit health
                    if (iconHandler.medicineIcon.health >= 10) {
                        iconHandler.medicineIcon.health = 10;
                    }
                    if (iconHandler.medicineIcon.health <= 0) {
                        iconHandler.medicineIcon.health = 0;
                    }
                    break;
            }

            iconHandler.overallIcon.health = (int) Math.round((iconHandler.medicineIcon.health + iconHandler.militaryIcon.health +
                iconHandler.culturalIcon.health + iconHandler.environmentalIcon.health +
                iconHandler.technologicalIcon.health) / 5f);

            System.out.println(iconHandler.overallIcon.health);
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

            //Elements to draw while in game state
//            batch.draw(currentBackground, 0, 0, epochsGame.worldWidth, epochsGame.worldHeight);
            for (int i = 0; i < scrollingBackgroundX.length; i++) {
                batch.draw(scrollingBackground[i], scrollingBackgroundX[i], 0, epochsGame.worldWidth, epochsGame.worldHeight);
            }
            batch.draw(foregroundTextureRegions[0], 0, 0, epochsGame.worldWidth, epochsGame.worldHeight);
            iconHandler.drawIcons(batch);
            greenScreen30.draw(batch, String.valueOf(countDownYearFinish),
                greenScreen30.getCapHeight() * 0.5f , epochsGame.worldHeight - greenScreen30.getCapHeight() * 0.9f);
            batch.end();

            //disable scaling when drawing mainGame scene and some important icons
            viewport.apply();
            batch.setProjectionMatrix(camera.combined);
            batch.begin();

            if (currentInGameState == shuffleState){
                drawShuffleState();
            }

            if (currentInGameState == guideState) {
                drawGuideState();
            }

            //elements to draw when playing
            if (currentInGameState == playingState) {
                drawPlayingState();
            }
            batch.end();
        }

        public void drawGuideState() {
            //set opacity for left and right dialogues
            currentCard.leftDialogue.setColor(1, 1, 1, leftDialogueColorValue);
            currentCard.rightDialogue.setColor(1, 1, 1, rightDialogueColorValue);

            //lock card
            batch.draw(lockCardTextureRegion, cardDefaultX, cardDefaultY, cardWidth, cardHeight);

            //draw current card
            currentCard.draw(batch);
            greenScreen25.draw(batch, currentCard.rank, 0, cardDefaultY + cardHeight + greenScreen25.getCapHeight() * 2, epochsGame.worldWidth, Align.center, true);
            typeWriter.draw(batch, currentCard.question, epochsGame.worldWidth * 0.05f, cardDefaultY - greenScreen25.getCapHeight(), epochsGame.worldWidth * 0.9f, Align.center, true);

            //reset dialogues' opacity to prevent bugs
            currentCard.leftDialogue.setColor(1, 1, 1, 1);
            currentCard.rightDialogue.setColor(1, 1, 1, 1);
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
            greenScreen25.draw(batch, currentCard.rank, 0, cardDefaultY + cardHeight + greenScreen25.getCapHeight() * 2, epochsGame.worldWidth, Align.center, true);

            //debug
            greenScreen25.draw(batch, String.valueOf(currentCard.leftChoiceTrue), 0, cardDefaultY + cardHeight + greenScreen25.getCapHeight() * 4, epochsGame.worldWidth, Align.center, true);

            typeWriter.draw(batch, currentCard.question, epochsGame.worldWidth * 0.05f, cardDefaultY - greenScreen25.getCapHeight(), epochsGame.worldWidth * 0.9f, Align.center, true);


            //reset dialogues' opacity to prevent bugs
            currentCard.leftDialogue.setColor(1, 1, 1, 1);
            currentCard.rightDialogue.setColor(1, 1, 1, 1);

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
