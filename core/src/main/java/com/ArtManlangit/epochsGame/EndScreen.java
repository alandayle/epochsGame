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

    //Bitmap fonts
    BitmapFont greenScreen25, typewriter;

    //dragging card variables
    boolean isDragging;
    Vector2 initialTouch, touchPosition;
    float deltaX;
    boolean change, performChange;
    float leftDialogueColorValue, rightDialogueColorValue;
    TextureRegion lockCard;

    //scrolling text variables
    float scrollingTextY;
    GlyphLayout layout;

    String[] scrollingText;
    String currentScrollingText;

    //music
    Music backgroundMusic;

    //fade in transition
    float colorValue;

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
        scrollingText[0] = "You were given the power to shape humanity’s fate, yet at each turn, the path chosen was one of neglect, delay, and disregard. Now, the consequences stand before us, stark and unforgiving.\n\n" +
            "The seas have swallowed our coastal cities; the air is thick with smog, choking out life itself. The land lies barren, and our waters run dry, poisoned by our own hands. Nature’s final cries echo in the empty streets, in rivers of plastic, and in forests razed to dust.\n\n" +
            "We have lost the harmony once found between humanity and the world it called home. The storms, the droughts, the unbreathable air—they are no longer warnings, but judgments. We prioritized convenience over conscience, growth over grace, power over preservation.\n\n" +
            "The Epoch is at its end, and what remains is but a shadow, a faint whisper of what once was. You have failed the world. This is the end you have chosen.\n\n";
        scrollingText[1] = "Your choices, driven by convenience and unchecked ambition, have birthed a new age of unprecedented technological power, but at what cost?\n\n" +
            "Technologies designed to benefit society have instead become instruments of division, surveillance, and unchecked power. Rights have been sacrificed for convenience, and the balance between innovation and ethical responsibility has been lost.\n\n" +
            "We stand at the edge of a new age—one where humanity no longer governs technology, but is governed by it. The consequences are clear: a fractured society, ethical decay, and a future controlled by the very systems that were meant to serve us.\n\n" +
            "This is the end you have created, Overseer. A world where the promise of a brighter tomorrow has been overshadowed by the recklessness of today.\n\n";
        scrollingText[2] = "In your pursuit of progress, you have disregarded the importance of diversity, heritage, and the delicate balance that holds society together.\n\n" +
            "Traditional values have been eroded, while cultural heritage and identity have been commodified. The fabric of society, once rich with history and diverse expression, now faces division and neglect.\n\n" +
            "This is the world you have created—a world where the cost of ‘advancement’ has left our cultural roots barren, and the rich diversity that once united us is now fragmented and forgotten.\n\n";
        scrollingText[3] = "In your quest for control, you have disregarded the sanctity of life, pushing forward with choices that sacrifice the well-being of countless individuals.\n\n" +
            "You’ve prioritized resources over people, and health over humanity. Your decisions have left society divided, with the most vulnerable paying the highest price.\n\n" +
            "This is the world you have created—a world where medical advancements come at the cost of life, choice, and dignity, and where the future of humanity is written in compromise and disregard for our shared values.\n\n";
        scrollingText[4] = "In your pursuit of security, you have abandoned the principles of freedom, ethics, and diplomacy. The military now controls not only borders but the very fabric of society.\n\n" +
            "Unchecked military expansion, erosion of privacy, and the abandonment of human oversight have led to a future where force rules over reason. Your decisions have left us vulnerable to global unrest, internal corruption, and environmental damage.\n\n" +
            "This is the world you have created—a world where the balance between safety and humanity has been lost, and the cost of progress is too high to bear.\n\n";
        scrollingText[5] = "You have guided humanity through a hundred decades, steering the world through challenges and uncertainties. Yet, though survival has been achieved, it is far from harmonious.\n\n" +
            "The environment, though not wholly ravaged, struggles under the weight of compromise and delay. Cities stand, but their air remains heavy; rivers flow, but not without contamination. Forests endure, yet in fragments. The world you’ve shaped exists in a precarious balance, neither thriving nor falling completely to ruin.\n\n" +
            "Your decisions have allowed humanity to persevere, but the price was a world that can only endure—not flourish. Hope lingers, fragile and uncertain, as the legacy of your choices rests on the precipice of both renewal and decay.\n\n" +
            "This is the Epoch you have sustained—a world neither lost nor found, where survival remains the singular triumph.\n\n";
        scrollingText[6] = "Humanity has endured the ages, yet what remains is a world on the brink of collapse. Your choices, though sufficient for survival, were insufficient to sustain balance and growth.\n\n" +
            "The environment bears the weight of compromise—its rivers poisoned, its lands barren, and its skies choked with ash. Natural harmony has been replaced by a fragile dependence on dwindling resources and fleeting innovations. What remains is a shadow of what could have been—a world clinging to survival, but void of true vitality.\n\n" +
            "Your leadership has brought the Epoch to its centennial milestone, yet the future looms uncertain and unstable. The lessons of the past have not been fully heeded, and humanity teeters between endurance and oblivion.\n\n" +
            "This is the Epoch you have created—a world that endures but at a cost too steep to secure a lasting legacy.\n\n";
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
                currentScrollingText = scrollingText[0];
                backgroundMusic = assetManager.get("audio/environmental.mp3");
                break;
            case 2:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("techEndingpng");
                background[1] = gameBackgroundsAtlas.findRegion("techEndingpng");
                card.question = card.questions.get(1);
                currentScrollingText = scrollingText[1];
                backgroundMusic = assetManager.get("audio/technology.mp3");
                break;
            case 3:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("culturalEnding");
                background[1] = gameBackgroundsAtlas.findRegion("culturalEnding");
                card.question = card.questions.get(2);
                currentScrollingText = scrollingText[2];
                backgroundMusic = assetManager.get("audio/cultural.mp3");
                break;
            case 4:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("militaryEnding");
                background[1] = gameBackgroundsAtlas.findRegion("militaryEnding");
                card.question = card.questions.get(3);
                currentScrollingText = scrollingText[3];
                backgroundMusic = assetManager.get("audio/military.mp3");
                break;
            case 5:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("healthcareEnding");
                background[1] = gameBackgroundsAtlas.findRegion("healthcareEnding");
                card.question = card.questions.get(4);
                currentScrollingText = scrollingText[4];
                backgroundMusic = assetManager.get("audio/medicine.mp3");
                break;
            case 6:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("neutralEnding");
                background[1] = gameBackgroundsAtlas.findRegion("neutralEnding");
                card.question = card.questions.get(5);
                currentScrollingText = scrollingText[5];
                backgroundMusic = assetManager.get("audio/neutral.mp3");
                break;
            case 7:
                assert gameBackgroundsAtlas != null;
                background[0] = gameBackgroundsAtlas.findRegion("badEnding");
                background[1] = gameBackgroundsAtlas.findRegion("badEnding");
                card.question = card.questions.get(6);
                currentScrollingText = scrollingText[6];
                backgroundMusic = assetManager.get("audio/bad.mp3");
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
        } else {
            scrollingTextY += delta * 20;
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
