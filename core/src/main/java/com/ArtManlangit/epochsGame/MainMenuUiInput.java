package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;

public class MainMenuUiInput {
    MainMenuUi mainMenuUi;
    boolean showDialogue = false;
    Vector2 inputLocation;
    boolean touching = false;
    BitmapFont mainFont;
    public MainMenuUiInput(MainMenuUi mainMenuUi) {
        this.mainMenuUi = mainMenuUi;
        inputLocation = new Vector2();
        mainFont = mainMenuUi.mainFont;
    }

    public void checkMainInput() {
        if (Gdx.input.isTouched()) {
            if (!touching) {
                inputLocation.set(Gdx.input.getX(), Gdx.input.getY());
                mainMenuUi.viewport.unproject(inputLocation);
                //check newGame
                if (checkButtonTouch(mainMenuUi.newGameX, mainMenuUi.newGameY, mainMenuUi.newGameWidth, mainMenuUi.newGameHeight)) {
                    mainMenuUi.epochsGame.loadingScreen.currentLoading = mainMenuUi.epochsGame.loadingScreen.gameScreen;
                    mainMenuUi.epochsGame.splashScreen.backgroundMusic.stop();
                    mainMenuUi.epochsGame.setScreen(mainMenuUi.epochsGame.loadingScreen);
                    mainMenuUi.epochsGame.mainMenuScreen.dispose();
                }
                if (checkButtonTouch(mainMenuUi.contX, mainMenuUi.contY, mainMenuUi.contWidth, mainMenuUi.contHeight)
                    || checkButtonTouch(mainMenuUi.archivesX, mainMenuUi.archivesY, mainMenuUi.archivesWidth,
                    mainMenuUi.archivesHeight) || checkButtonTouch(mainMenuUi.settingsX, mainMenuUi.settingsY, mainMenuUi.settingsWidth, mainMenuUi.settingsHeight)) {
                    showDialogue = true;
                }
                touching = true;
            }
        } else {
            touching = false;
        }
    }

    public boolean checkButtonTouch(float xPosition, float yPosition, float width, float height) {
        return inputLocation.x >= xPosition && inputLocation.x <= xPosition + width &&
            inputLocation.y >= yPosition && inputLocation.y <= yPosition + height;
    }
}
