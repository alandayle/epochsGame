package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
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
    float buttonWidth, buttonHeight, buttonX, buttonY;

    //Bitmap fonts
    BitmapFont greenScreen25, typewriter;

    //dragging card variables
    boolean isDragging;
    Vector2 initialTouch, touchPosition;
    float deltaX;
    boolean change, performChange;
    float leftDialogueColorValue, rightDialogueColorValue;
    TextureRegion lockCard, button;

    //scrolling text variables
    float scrollingTextY;
    GlyphLayout layout;

    String[] scrollingText;
    String currentScrollingText, title;

    //music
    Music backgroundMusic;

    //fade in transition
    float colorValue;

    //move to loading screen timer
    float timer;

    boolean drawTitle = false;

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

        //setup scrolling text
        setupScrollingText();

        //setupTextures
        setupTextures();

        //loadFonts();
        loadFonts();

    }

    public void setupScrollingText() {
        scrollingTextY = 0;
        scrollingText = new String[7];
        scrollingText[0] = "You were given the chance to protect the natural world, to preserve the delicate rhythms of life. Instead, each choice strayed further from responsibility. Now, the bond between humanity and its surroundings is broken, leaving only a world out of balance.\n\n" +
            "What was once flourishing is now diminished. The connection between life and land has unraveled, and nature’s harmony has faded into silence. The path chosen has left the environment fragile, unable to sustain what it once could.\n\n" +
            "This is the end you have brought forth—a fragile shadow of what once thrived, where the consequences of neglect are inescapable.\n\n";
        scrollingText[1] = "Ambition guided your choices, yet the wisdom to temper progress with accountability was left behind. The tools created to elevate humanity have taken control, and the delicate line between innovation and restraint has disappeared.\n\n" +
            "What was meant to empower has instead reshaped society in unintended ways. The balance of creation and caution has tipped, leaving uncertainty in its place. Humanity no longer leads but follows, bound by the systems it failed to guide.\n\n" +
            "This is the world you shaped—one where control has slipped away, and what remains is defined by imbalance and unchecked ambition.\n\n";
        scrollingText[2] = "In seeking transformation, the essence of what connected us was left unattended. The shared stories, values, and expressions that wove societies together have faded, leaving gaps that cannot easily be mended.\n\n" +
            "The richness of diversity has given way to disconnection, and what was once a source of unity now lies fractured. Without care for the delicate threads of culture, what remains feels hollow and incomplete.\n\n" +
            "This is the result of your decisions—a world where the bonds of identity have loosened, and the foundations of understanding have been left to erode.\n\n";
        scrollingText[4] = "The systems meant to safeguard well-being have faltered, unable to bear the weight of the choices made. What once brought care and security now struggles to provide, leaving gaps that cannot easily be mended.\n\n" +
            "The trust in what sustains life has eroded, and the unity that once connected communities in times of need has faded. Efforts to improve have left an imbalance, creating a reality where the essence of healing feels distant and uncertain.\n\n" +
            "This is the result—a world where the care for humanity has grown fragile, and the foundation of well-being no longer holds.\n\n";
        scrollingText[3] = "Decisions made in the name of safety have reshaped the structures of society, leaving little room for freedom or trust.\n\n" +
            "The balance between protection and autonomy has tipped, with oversight replaced by control. The principles that once guided restraint and understanding have been overshadowed, leaving society vulnerable to unrest and instability.\n\n" +
            "This is the reality forged by your choices—a world where safety is hollow, and the structures meant to protect have instead constrained what it means to live freely.\n\n";
        scrollingText[5] = "Despite the choices you made, the world remains largely unchanged, as if time itself has stood still. The patterns of life continue, unaltered by the decisions that were meant to shape the future.\n\n" +
            "What you hoped would shift, adapt, or evolve has instead persisted in its original form, unaffected by the passage of time. The consequences of your actions have not materialized as expected, and the world hums along in quiet continuity.\n\n" +
            "This is the Epoch you have sustained—a world that moves forward, not in response to the choices made, but in a steady, unchanged rhythm, indifferent to the efforts to alter its course.\n\n";
        scrollingText[6] = "This is the Epoch’s end, not with triumph or resolution, but with a slow and inevitable decline into obscurity. What remains is a fragile shadow of the world that once was—a faint memory of hope buried beneath the weight of decisions left unchallenged.\n\n" +
            "Humanity’s mark, once so confident and bold, is now a faint imprint on the sands of time. The path we chose—led by moments of fleeting certainty, now rests beneath a quiet, unspoken sorrow.\n\n" +
            "There is no glory in this end, only the weight of what we did not do, what we did not see in time. Just... emptiness. And in that emptiness, there is nothing but the silence of the world, the weight of what was lost, and the fading echo of what might have been.\n\n";
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
        cardQuestions.add("Overseer... the world you’ve built is one dominated by power and surveillance.");
        cardQuestions.add("Overseer, your pursuit of solutions has come at the expense of ethics, compassion, and humanity.");
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
        ArrayList<ArrayList<Integer>> leftNull = new ArrayList<>();
        ArrayList<ArrayList<Integer>> rightNull = new ArrayList<>();
        card.setupDialogue(leftCardSprite, rightCardSprite, cardQuestions, 5, rank, 1, ignore, leftNull, rightNull);
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

        buttonWidth = epochsGame.worldWidth * 0.7f;
        buttonHeight = epochsGame.worldHeight * 0.09f;
        buttonX = (epochsGame.worldWidth - buttonWidth) / 2;
        buttonY = epochsGame.worldHeight * 0.05f;
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
        button = gameBackgroundsAtlas.findRegion("Return to menu");
        switch (epochsGame.gameScreen.endingScenario) {
            case 1:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("environmentalEnding");
                background[1] = gameBackgroundsAtlas.findRegion("environmentalEnding");
                card.question = card.questions.get(0);
                currentScrollingText = scrollingText[0];
                title = '"' + "Echoes of Neglect" +'"';
                backgroundMusic = assetManager.get("audio/environmental.mp3");
                break;
            case 2:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("techEndingpng");
                background[1] = gameBackgroundsAtlas.findRegion("techEndingpng");
                card.question = card.questions.get(1);
                currentScrollingText = scrollingText[1];
                title = '"'+"Bound by Creation"+'"';
                backgroundMusic = assetManager.get("audio/technology.mp3");
                break;
            case 3:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("culturalEnding");
                background[1] = gameBackgroundsAtlas.findRegion("culturalEnding");
                card.question = card.questions.get(2);
                currentScrollingText = scrollingText[2];
                backgroundMusic = assetManager.get("audio/cultural.mp3");
                title = '"'+"Fragments of Identity"+'"';
                break;
            case 4:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("militaryEnding");
                background[1] = gameBackgroundsAtlas.findRegion("militaryEnding");
                card.question = card.questions.get(3);
                currentScrollingText = scrollingText[3];
                backgroundMusic = assetManager.get("audio/military.mp3");
                title = '"'+"Chains of Protection"+'"';
                break;
            case 5:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("healthcareEnding");
                background[1] = gameBackgroundsAtlas.findRegion("healthcareEnding");
                card.question = card.questions.get(4);
                currentScrollingText = scrollingText[4];
                backgroundMusic = assetManager.get("audio/medicine.mp3");
                title = '"'+"The Fragility of Care"+'"';
                break;
            case 6:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("neutralEnding");
                background[1] = gameBackgroundsAtlas.findRegion("neutralEnding");
                card.question = card.questions.get(5);
                currentScrollingText = scrollingText[5];
                backgroundMusic = assetManager.get("audio/neutral.mp3");
                title =  '"'+"The Unmoved World"+'"';
                break;
            case 7:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("badEnding");
                background[1] = gameBackgroundsAtlas.findRegion("badEnding");
                card.question = card.questions.get(6);
                currentScrollingText = scrollingText[6];
                backgroundMusic = assetManager.get("audio/bad.mp3");
                title = '"'+"The Weight of Silence"+'"';
                break;
        }
        backgroundMusic.setLooping(true);
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
        } else if (currentState == scrolllingState) {
            scrollingStateInput();
        }
    }

    public void scrollingStateInput() {
        if (Gdx.input.isTouched()) {
            initialTouch.set(Gdx.input.getX(), Gdx.input.getY());
            backgroundViewport.unproject(initialTouch);
            if (initialTouch.x >= buttonX && initialTouch.x <= buttonX + buttonWidth && initialTouch.y >= buttonY && initialTouch.y <= buttonY + buttonHeight && drawTitle) {
                epochsGame.loadingScreen.currentLoading = epochsGame.loadingScreen.mainMenuScreen;
                epochsGame.setScreen(epochsGame.loadingScreen);
                backgroundMusic.stop();
            }
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
            scrollingStateLogic(delta);
        }

    }

    public void scrollingStateLogic(float delta) {
        //logic for moving background
        movingBackgroundLogic(delta);
        layout = new GlyphLayout();
        layout.setText(typewriter, currentScrollingText);

        if (scrollingTextY >= (backgroundViewport.getWorldHeight() / 2) + (layout.height * 1.5)) {
            scrollingTextY = (backgroundViewport.getWorldHeight() / 2) + (layout.height * 1.5f);
            timer+= delta;
            drawTitle = true;
        } else {
            scrollingTextY += delta * 30;
        }

// Access the height of the text
        float textHeight = layout.height;

    }

    public void cardStateLogic(float delta) {
        //transition
        colorValue += delta;
        if (colorValue >= 1) {
            colorValue = 1;
        }

        if (performChange) {
            backgroundMusic.play();
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
        if(currentState == scrolllingState) {
            drawScrollingState();
        }
    }

    public void drawScrollingState() {
        //update camera
        camera.update();

        //disable scaling for drawing card state
        backgroundViewport.apply();
        batch.setProjectionMatrix(camera.combined);

        //begin draw
        batch.begin();

        typewriter.draw(batch, currentScrollingText, epochsGame.worldWidth * 0.05f,
            scrollingTextY, epochsGame.worldWidth * 0.9f, Align.center, true);



        if (drawTitle) {
            typewriter.draw(batch, "You have unlocked an ending!", epochsGame.worldWidth * 0.05f,
                epochsGame.worldHeight - typewriter.getCapHeight() * 2, epochsGame.worldWidth * 0.9f, Align.center, true);
            greenScreen25.draw(batch, title, epochsGame.worldWidth * 0.05f,
                epochsGame.worldHeight - greenScreen25.getCapHeight() * 3, epochsGame.worldWidth * 0.9f, Align.center, true);
            batch.draw(button, buttonX, buttonY, buttonWidth, buttonHeight);
        }

        //end draw
        batch.end();
    }

    public void drawCardState() {
        //update camera
        camera.update();

        //disable scaling for drawing card state
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);

        //assign color values for all
        card.setColor(1, 1, 1, colorValue);

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
        card.setColor(1, 1, 1,1);
    }

    public void drawCurrentBackground() {
        camera.update();
        backgroundViewport.apply();
        batch.setProjectionMatrix(camera.combined);
        batch.setColor(colorValue, colorValue, colorValue, 1);
        batch.begin();
        for (int i = 0; i < backgroundX.length;i++) {
            batch.draw(background[i], backgroundX[i], 0, epochsGame.worldWidth, epochsGame.worldHeight);
        }
        batch.end();

        //reset color
        batch.setColor(1, 1, 1, 1);
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
