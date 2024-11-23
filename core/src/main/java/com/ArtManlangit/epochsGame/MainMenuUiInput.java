package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class MainMenuUiInput {
    MainMenuUi mainMenuUi;
    Vector2 inputLocation;
    boolean touching = false;
    public MainMenuUiInput(MainMenuUi mainMenuUi) {
        this.mainMenuUi = mainMenuUi;
        inputLocation = new Vector2();
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
