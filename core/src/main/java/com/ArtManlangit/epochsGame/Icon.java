package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Icon {
    float xPosition, yPosition, width, height;
    int health;
    TextureRegion[] iconImage;
    TextureRegion currentIconImage;
    public Icon(TextureRegion[] iconImage, float xPosition, float yPosition, float width, float height) {
        //setup icon properties
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;

        //setup images of the icon and copy the array of texture
        this.iconImage = new TextureRegion[11];
        System.arraycopy(iconImage, 0, this.iconImage, 0, 11);

        //set default image for default health;
        currentIconImage = iconImage[5];

        //default health
        health = 5;
    }

    public void draw(Batch batch) {
        switch (health) {
            case 0:
               currentIconImage = iconImage[0];
               break;
            case 1:
                currentIconImage = iconImage[1];
                break;
            case 2:
                currentIconImage = iconImage[2];
                break;
            case 3:
                currentIconImage = iconImage[3];
                break;
            case 4:
                currentIconImage = iconImage[4];
                break;
            case 5:
                currentIconImage = iconImage[5];
                break;
            case 6:
                currentIconImage = iconImage[6];
                break;
            case 7:
                currentIconImage = iconImage[7];
                break;
            case 8:
                currentIconImage = iconImage[8];
                break;
            case 9:
                currentIconImage = iconImage[9];
                break;
            case 10:
                currentIconImage = iconImage[10];
                break;

        }
        batch.draw(currentIconImage, xPosition, yPosition, width, height);
    }
}
