package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Card extends Sprite{
    public Card(TextureRegion image, float xPosition, float yPosition, float width, float height) {
        super(image);
        this.setSize(width, height);
        this.setOriginCenter();
    }

    public void update(float xPosition, float yPosition, float rotation) {
        this.setPosition(xPosition, yPosition);
        this.setRotation(rotation);
    }
}
