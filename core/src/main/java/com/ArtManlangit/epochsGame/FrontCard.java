package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class FrontCard extends Card{
    Sprite leftDialogue, rightDialogue;

    public FrontCard(TextureRegion image, float xPosition, float yPosition, float width, float height, TextureRegion leftDialogue, TextureRegion rightDialogue) {
        super(image, xPosition, yPosition, width, height);

        //left dialogue
        this.leftDialogue = new Sprite(leftDialogue);
        this.leftDialogue.setPosition(xPosition, yPosition);
        this.leftDialogue.setSize(width, height);
        this.leftDialogue.setOriginCenter();

        //right dialogue
        this.rightDialogue = new Sprite(rightDialogue);
        this.rightDialogue.setPosition(xPosition, yPosition);
        this.rightDialogue.setSize(width, height);
        this.rightDialogue.setOriginCenter();

        //set front card position
        setPosition(xPosition, yPosition);

    }

    public void draw(Batch batch) {
        super.draw(batch);
        leftDialogue.draw(batch);
        rightDialogue.draw(batch);
    }

    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        leftDialogue.setPosition(x, y);
        rightDialogue.setPosition(x, y);
    }

    public void setRotation(float degree) {
        super.setRotation(degree);
        leftDialogue.setRotation(degree);
        rightDialogue.setRotation(degree);
    }

}
