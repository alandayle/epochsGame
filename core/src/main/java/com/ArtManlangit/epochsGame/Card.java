package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Card {
    float height, width;
    float xPosition, yPosition;
    TextureRegion image;
    Sprite cardSprite;

    public Card() {

    }

    public void draw(SpriteBatch batch) {
        cardSprite.draw(batch);
    }
}
