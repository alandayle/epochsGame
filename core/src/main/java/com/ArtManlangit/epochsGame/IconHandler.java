package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class IconHandler {
    //Important objects
    EpochsGame epochsGame;
    AssetManager assetManager;

    //Icons in game
    Icon overallIcon, environmentalIcon, technologicalIcon, culturalIcon, militaryIcon, medicineIcon;

    //atlas needed
    TextureAtlas overallStatusAtlas, environmentalStatusAtlas, technologicalStatusAtlas, culturalStatusAtlas, militaryStatusAtlas, medicineStatusAtlas;

    //icon properties
    float iconWidth;
    float iconHeight;

    public IconHandler(EpochsGame epochsGame) {
        this.epochsGame = epochsGame;
        this.assetManager = epochsGame.assetManager;
        loadIconTextures();
        setupIcons();
    }

    public void loadIconTextures() {
        overallStatusAtlas = assetManager.get("packedTextures/overAllStatusImage.atlas");
        environmentalStatusAtlas = assetManager.get("packedTextures/environmentalStatus.atlas");
        technologicalStatusAtlas = assetManager.get("packedTextures/technologicalStatus.atlas");
        culturalStatusAtlas = assetManager.get("packedTextures/culturalStatus.atlas");
        militaryStatusAtlas = assetManager.get("packedTextures/militaryStatus.atlas");
        medicineStatusAtlas = assetManager.get("packedTextures/medicineStatus.atlas");
    }

    public void setupIcons() {
        //icon width and height
        iconWidth = epochsGame.worldWidth;
        iconHeight = epochsGame.worldHeight;
        float xPosition = 0;
        float yPosition = 0;

        //overall Icon
        TextureRegion[] overallIconImage = new TextureRegion[11];
        for (int i = 0; i < 11; i++) {
            overallIconImage[i] = overallStatusAtlas.findRegion("O" + i + "0");
        }
        overallIcon = new Icon(overallIconImage, xPosition, yPosition, iconWidth, iconHeight);

        //environmental icon
        TextureRegion[] environmentalIconImage = new TextureRegion[11];
        for (int i = 0; i < 11; i++) {
            environmentalIconImage[i] = environmentalStatusAtlas.findRegion("E" + (i) + "0");
        }
        environmentalIcon = new Icon(environmentalIconImage, xPosition, yPosition, iconWidth, iconHeight);

        //technologicalIcon icon
        TextureRegion[] technologicalIconImage = new TextureRegion[11];
        for (int i = 0; i < 11; i++) {
            technologicalIconImage[i] = technologicalStatusAtlas.findRegion("T" + (i) + "0");
        }
        technologicalIcon = new Icon(technologicalIconImage, xPosition, yPosition, iconWidth, iconHeight);

        //cultural icon
        TextureRegion[] culturalIconImage = new TextureRegion[11];
        for (int i = 0; i < 11; i++) {
            culturalIconImage[i] = culturalStatusAtlas.findRegion("C" + (i) + "0");
        }
        culturalIcon = new Icon(culturalIconImage, xPosition, yPosition, iconWidth, iconHeight);

        //military icon
        TextureRegion[] militaryIconImage = new TextureRegion[11];
        for (int i = 0; i < 11; i++) {
            militaryIconImage[i] = militaryStatusAtlas.findRegion("M" + (i) + "0");
        }
        militaryIcon = new Icon(militaryIconImage, xPosition, yPosition, iconWidth, iconHeight);

        //medicineIcon
        TextureRegion[] medicineIconImage = new TextureRegion[11];
        for (int i = 0; i < 11; i++) {
            medicineIconImage[i] = medicineStatusAtlas.findRegion("H" + (i) + "0");
        }
        medicineIcon = new Icon(medicineIconImage, xPosition, yPosition, iconWidth, iconHeight);
    }

    public void drawIcons(Batch batch) {
        //draw overall Icon
        overallIcon.draw(batch);

        //draw Status Icon
        environmentalIcon.draw(batch);
        technologicalIcon.draw(batch);
        culturalIcon.draw(batch);
        medicineIcon.draw(batch);
        militaryIcon.draw(batch);
    }
}
