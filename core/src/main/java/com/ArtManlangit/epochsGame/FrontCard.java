package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class FrontCard extends Card{
    Sprite leftDialogue, rightDialogue;
    ArrayList<Sprite> leftDialogues, rightDialogues;
    ArrayList<String> questions;
    String rank;
    String question;
    int theme;

    public FrontCard(TextureRegion image, float xPosition, float yPosition, float width, float height) {
        super(image, xPosition, yPosition, width, height);
        this.setX(xPosition);
        this.setY(yPosition);
    }

    public void setupDialogue(ArrayList<Sprite> leftDialogues, ArrayList<Sprite> rightDialogues, ArrayList<String> questions, int theme, String rank) {
        //initialize array
        this.leftDialogues = new ArrayList<>();
        this.rightDialogues = new ArrayList<>();
        this.questions = new ArrayList<>();

        //copy array of dialogues
        this.leftDialogues.addAll(leftDialogues);
        this.rightDialogues.addAll(rightDialogues);

        //set default properties for dialogues
        for (Sprite dialogue: leftDialogues) {
            dialogue.setPosition(this.getX(), this.getY());
            dialogue.setSize(this.getWidth(), this.getHeight());
            dialogue.setOriginCenter();
        }

        for (Sprite dialogue: rightDialogues) {
            dialogue.setPosition(this.getX(), this.getY());
            dialogue.setSize(this.getWidth(), this.getHeight());
            dialogue.setOriginCenter();
        }

        //copy questions
        this.questions.addAll(questions);

        //default question
        question = questions.get(0);

        //default left dialogue
        this.leftDialogue = leftDialogues.get(0);
        this.rightDialogue = rightDialogues.get(0);

        //set front card position
        setPosition(this.getX(), this.getY());

        //set theme and rank
        this.theme = theme;
        this.rank = rank;


    }

    public void deleteCurrentCard() {
        //remove
        questions.remove(question);
        leftDialogues.remove(leftDialogue);
        rightDialogues.remove(rightDialogue);
    }

    public void updateCard(int index) {
        question = questions.get(index);
        leftDialogue = leftDialogues.get(index);
        rightDialogue = rightDialogues.get(index);
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
