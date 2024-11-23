package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class Transition {
    float timer;
    TextureRegion currentImage;
    TextureRegion nextImage;
    Batch batch;




    //constructor
    public Transition(Batch batch) {
       this.batch = batch;
    }

    public float dissolveLogic(float delta, float colorValue, float dissolveSpeed) {
        colorValue += delta * (1/dissolveSpeed);
        if (colorValue >= 1) {
            colorValue = 1;
        }
        if (colorValue <= 0) {
            colorValue = 0;
        }
        return colorValue;
    }

    public void dissolveDraw(TextureRegion currentImage, float currentImageX, float currentImageY, float currentImageWidth, float currentImageHeight, float currentImageColorValue) {
        //draw currentImage
        batch.setColor(1, 1, 1, currentImageColorValue);
        batch.draw(currentImage, currentImageX, currentImageY, currentImageWidth, currentImageHeight);

        //reset color
        batch.setColor(1, 1, 1, 1);
    }


    public float slideInLogic(float delta, float currentImageX,float end, float speed) {
        currentImageX -= delta * speed;
        if (currentImageX <= end) {
            currentImageX = end;
        }

        return currentImageX;
    }

    public void drawSlideIn(TextureRegion currentImage, float currentImageX, float currentImageY, float currentImageWidth, float currentImageHeight) {
        batch.draw(currentImage, currentImageX, currentImageY, currentImageWidth, currentImageHeight);
    }

}
