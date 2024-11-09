package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BackCard extends Card{
    public BackCard(TextureRegion image, float xPosition, float yPosition, float width, float height) {
        super(image, xPosition, yPosition, width, height);
        setPosition(xPosition, yPosition);
    }
}
