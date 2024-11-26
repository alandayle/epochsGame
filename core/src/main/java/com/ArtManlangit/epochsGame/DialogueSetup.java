package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DialogueSetup {
    GameScreen gameScreen;

    //every assets for setting up dialogues - IGNORE!
    //card 1
    ArrayList<Sprite> leftCard1Sprite;
    ArrayList<Sprite> rightCard1Sprite;
    ArrayList<String> card1Qestions;
    String card1Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard1;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice1;
    ArrayList<ArrayList<Integer>> rightCardChoice1;

    //card 2
    ArrayList<Sprite> leftCard2Sprite;
    ArrayList<Sprite> rightCard2Sprite;
    ArrayList<String> card2Qestions;
    String card2Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard2;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice2;
    ArrayList<ArrayList<Integer>> rightCardChoice2;

    //card 3
    ArrayList<Sprite> leftCard3Sprite;
    ArrayList<Sprite> rightCard3Sprite;
    ArrayList<String> card3Qestions;
    String card3Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard3;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice3;
    ArrayList<ArrayList<Integer>> rightCardChoice3;

    //card 4
    ArrayList<Sprite> leftCard4Sprite;
    ArrayList<Sprite> rightCard4Sprite;
    ArrayList<String> card4Qestions;
    String card4Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard4;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice4;
    ArrayList<ArrayList<Integer>> rightCardChoice4;


    //card 5
    ArrayList<Sprite> leftCard5Sprite;
    ArrayList<Sprite> rightCard5Sprite;
    ArrayList<String> card5Qestions;
    String card5Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard5;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice5;
    ArrayList<ArrayList<Integer>> rightCardChoice5;

    //card 6
    ArrayList<Sprite> leftCard6Sprite;
    ArrayList<Sprite> rightCard6Sprite;
    ArrayList<String> card6Qestions;
    String card6Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard6;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice6;
    ArrayList<ArrayList<Integer>> rightCardChoice6;

    //card 7
    ArrayList<Sprite> leftCard7Sprite;
    ArrayList<Sprite> rightCard7Sprite;
    ArrayList<String> card7Qestions;
    String card7Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard7;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice7;
    ArrayList<ArrayList<Integer>> rightCardChoice7;

    //card 8
    ArrayList<Sprite> leftCard8Sprite;
    ArrayList<Sprite> rightCard8Sprite;
    ArrayList<String> card8Qestions;
    String card8Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard8;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice8;
    ArrayList<ArrayList<Integer>> rightCardChoice8;

    //card 9
    ArrayList<Sprite> leftCard9Sprite;
    ArrayList<Sprite> rightCard9Sprite;
    ArrayList<String> card9Qestions;
    String card9Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard9;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice9;
    ArrayList<ArrayList<Integer>> rightCardChoice9;

    //card 10
    ArrayList<Sprite> leftCard10Sprite;
    ArrayList<Sprite> rightCard10Sprite;
    ArrayList<String> card10Qestions;
    String card10Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard10;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice10;
    ArrayList<ArrayList<Integer>> rightCardChoice10;

    //card 11
    ArrayList<Sprite> leftCard11Sprite;
    ArrayList<Sprite> rightCard11Sprite;
    ArrayList<String> card11Qestions;
    String card11Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard11;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice11;
    ArrayList<ArrayList<Integer>> rightCardChoice11;

    //card 12
    ArrayList<Sprite> leftCard12Sprite;
    ArrayList<Sprite> rightCard12Sprite;
    ArrayList<String> card12Qestions;
    String card12Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard12;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice12;
    ArrayList<ArrayList<Integer>> rightCardChoice12;

    //card 13
    ArrayList<Sprite> leftCard13Sprite;
    ArrayList<Sprite> rightCard13Sprite;
    ArrayList<String> card13Qestions;
    String card13Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard13;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice13;
    ArrayList<ArrayList<Integer>> rightCardChoice13;

    //card 14
    ArrayList<Sprite> leftCard14Sprite;
    ArrayList<Sprite> rightCard14Sprite;
    ArrayList<String> card14Qestions;
    String card14Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard14;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice14;
    ArrayList<ArrayList<Integer>> rightCardChoice14;

    //card 15
    ArrayList<Sprite> leftCard15Sprite;
    ArrayList<Sprite> rightCard15Sprite;
    ArrayList<String> card15Qestions;
    String card15Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard15;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice15;
    ArrayList<ArrayList<Integer>> rightCardChoice15;

    //card 16
    ArrayList<Sprite> leftCard16Sprite;
    ArrayList<Sprite> rightCard16Sprite;
    ArrayList<String> card16Qestions;
    String card16Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard16;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice16;
    ArrayList<ArrayList<Integer>> rightCardChoice16;


    //card 17
    ArrayList<Sprite> leftCard17Sprite;
    ArrayList<Sprite> rightCard17Sprite;
    ArrayList<String> card17Qestions;
    String card17Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard17;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice17;
    ArrayList<ArrayList<Integer>> rightCardChoice17;


    //card 18
    ArrayList<Sprite> leftCard18Sprite;
    ArrayList<Sprite> rightCard18Sprite;
    ArrayList<String> card18Qestions;
    String card18Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard18;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice18;
    ArrayList<ArrayList<Integer>> rightCardChoice18;

    //card 19
    ArrayList<Sprite> leftCard19Sprite;
    ArrayList<Sprite> rightCard19Sprite;
    ArrayList<String> card19Qestions;
    String card19Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard19;
    //new implementation
    ArrayList<ArrayList<Integer>> leftCardChoice19;
    ArrayList<ArrayList<Integer>> rightCardChoice19;

    //card 20
    ArrayList<Sprite> leftCard20Sprite;
    ArrayList<Sprite> rightCard20Sprite;
    ArrayList<String> card20Qestions;
    String card20Rank;
    ArrayList<Boolean> dialogueSwipeLeftTrueCard20;


    //constructor
    public DialogueSetup(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    // Helper method to initialize a list with repeated values
    private ArrayList<Integer> createList(int... values) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int value : values) {
            list.add(value);
        }
        return list;
    }

    public void setupDialogues() {
        //card 1
        leftCard1Sprite = new ArrayList<>();
        rightCard1Sprite = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.environmentalCards.findRegion("card1Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.environmentalCards.findRegion("card1Dialogue" + (i+1) + ".2"));
            leftCard1Sprite.add(leftCardSprite);
            rightCard1Sprite.add(rightCardSprite);
        }
        card1Qestions = new ArrayList<>();
        card1Qestions.add("The air quality is rapidly declining. We can either implement clean air initiatives or prioritize industrial output. What should we do?");
        card1Qestions.add("Plastic waste is accumulating in our oceans. Implement a nationwide ban on single-use plastics.");
        card1Qestions.add("Industrial waste is polluting our water sources. Should we enforce stricter waste disposal regulations or increase fines for non-compliance?");
        card1Qestions.add("Aquatic life is at risk due to polluted water. We can either establish conservation areas or focus on cleaning the waterways. What should we do?");
        card1Qestions.add("Solid waste management is a growing issue. Implement waste-to-energy programs.");
        card1Rank = "Gardener M.";

        //checking for good or bad swipe. Swiping left is true
        dialogueSwipeLeftTrueCard1 = new ArrayList<>();
        dialogueSwipeLeftTrueCard1.add(true);
        dialogueSwipeLeftTrueCard1.add(true);
        dialogueSwipeLeftTrueCard1.add(true);
        dialogueSwipeLeftTrueCard1.add(true);
        dialogueSwipeLeftTrueCard1.add(false);

        //new implementation
        leftCardChoice1 = new ArrayList<>();
        rightCardChoice1 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice1.add(createList(1, 4, 1, 2, 1));
        rightCardChoice1.add(createList(4, 1, 4, 1, 2));
        //add dialogue 2
        leftCardChoice1.add(createList(1, 2, 1, 4, 1));
        rightCardChoice1.add(createList(4, 1, 1, 2, 1));
        //add dialogue 3
        leftCardChoice1.add(createList(1, 4, 1, 0, 1));
        rightCardChoice1.add(createList(2, 4, 4, 0, 2));
        //add dialogue 4
        leftCardChoice1.add(createList(1, 4, 1, 0, 1));
        rightCardChoice1.add(createList(4, 3, 1, 0, 1));
        //add dialogue 5
        leftCardChoice1.add(createList(2, 1, 0, 1, 4));
        rightCardChoice1.add(createList(1, 1, 0, 0, 1));
        gameScreen.frontCards[0].setupDialogue(leftCard1Sprite, rightCard1Sprite, card1Qestions, 1, card1Rank, 1, dialogueSwipeLeftTrueCard1, leftCardChoice1, rightCardChoice1);

        //card 2
        leftCard2Sprite = new ArrayList<>();
        rightCard2Sprite = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.environmentalCards.findRegion("card2Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.environmentalCards.findRegion("card2Dialogue" + (i+1) + ".2"));
            leftCard2Sprite.add(leftCardSprite);
            rightCard2Sprite.add(rightCardSprite);
        }
        card2Qestions = new ArrayList<>();
        card2Qestions.add("Our soil is contaminated by industrial activities. Should we promote organic waste composting or invest in soil remediation projects?");
        card2Qestions.add("Food security is at risk due to reduced crop yields. Focus on boosting local food production.");
        card2Qestions.add("Forests are being cleared for agriculture. Enforce strict deforestation laws.");
        card2Qestions.add("Reforestation projects can offset carbon emissions. Should we invest in these projects or increase green urban spaces?");
        card2Qestions.add("Reforestation requires community involvement. We can either launch an awareness campaign or provide incentives for participation. What should we do?");
        card2Rank = "Farmer E.";
        dialogueSwipeLeftTrueCard2 = new ArrayList<>();
        dialogueSwipeLeftTrueCard2.add(false);
        dialogueSwipeLeftTrueCard2.add(true);
        dialogueSwipeLeftTrueCard2.add(true);
        dialogueSwipeLeftTrueCard2.add(true);
        dialogueSwipeLeftTrueCard2.add(false);
        //new implementation
        leftCardChoice2 = new ArrayList<>();
        rightCardChoice2 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice2.add(createList(4, 2, 0, 0, 1));
        rightCardChoice2.add(createList(1, 1, 0, 0, 1));
        //add dialogue 2
        leftCardChoice2.add(createList(1, 0, 0, 0, 1));
        rightCardChoice2.add(createList(2, 0, 0, 0, 1));
        //add dialogue 3
        leftCardChoice2.add(createList(1, 4, 0, 2, 1));
        rightCardChoice2.add(createList(4, 1, 0, 1, 1));
        //add dialogue 4
        leftCardChoice2.add(createList(1, 1, 1, 0, 1));
        rightCardChoice2.add(createList(2, 4, 1, 0, 1));
        //add dialogue 5
        leftCardChoice2.add(createList(4, 0, 0, 0, 0));
        rightCardChoice2.add(createList(1, 0, 0, 0, 0));
        gameScreen.frontCards[1].setupDialogue(leftCard2Sprite, rightCard2Sprite, card2Qestions, 1, card2Rank, 1, dialogueSwipeLeftTrueCard2, leftCardChoice2, rightCardChoice2);



        //card 3
        leftCard3Sprite = new ArrayList<>();
        rightCard3Sprite = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.environmentalCards.findRegion("card3Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.environmentalCards.findRegion("card3Dialogue" + (i+1) + ".2"));
            leftCard3Sprite.add(leftCardSprite);
            rightCard3Sprite.add(rightCardSprite);
        }
        card3Qestions = new ArrayList<>();
        card3Qestions.add("A massive storm is approaching, threatening our coastal cities. Should we evacuate the population or reinforce the defenses?");
        card3Qestions.add("The storm has depleted our water reserves. We can either invest in desalination technology or impose strict water rationing. What should we do?");
        card3Qestions.add("Protests are erupting due to the water crisis. Should we deploy the military to maintain order or address the protesters’ demands?");
        card3Qestions.add("The protests have highlighted the wealth gap. We can either impose heavy taxes on the rich to redistribute wealth or focus on creating more job opportunities. What should we do?");
        card3Qestions.add("Our solar and wind farms are producing more energy than our grid can handle. Invest in energy storage systems to store excess energy.");
        card3Qestions.add("Our reliance on fossil fuels is causing severe pollution. Should we invest in carbon capture technology or continue focusing on economic growth?");
        card3Rank = "Environmentalist S.";
        dialogueSwipeLeftTrueCard3 = new ArrayList<>();
        dialogueSwipeLeftTrueCard3.add(true);
        dialogueSwipeLeftTrueCard3.add(true);
        dialogueSwipeLeftTrueCard3.add(false);
        dialogueSwipeLeftTrueCard3.add(true);
        dialogueSwipeLeftTrueCard3.add(true);
        dialogueSwipeLeftTrueCard3.add(true);
        //new implementation
        leftCardChoice3 = new ArrayList<>();
        rightCardChoice3 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice3.add(createList(2, 4, 1, 1, 3));
        rightCardChoice3.add(createList(4, 3, 2, 4, 4));
        //add dialogue 2
        leftCardChoice3.add(createList(1, 1, 0, 0, 1));
        rightCardChoice3.add(createList(4, 4, 0, 0, 2));
        //add dialogue 3
        leftCardChoice3.add(createList(2, 1, 4, 0, 4));
        rightCardChoice3.add(createList(1, 4, 1, 0, 1));
        //add dialogue 4
        leftCardChoice3.add(createList(1, 4, 1, 1, 1));
        rightCardChoice3.add(createList(4, 1, 1, 1, 1));
        //add dialogue 5
        leftCardChoice3.add(createList(1, 1, 4, 2, 4));
        rightCardChoice3.add(createList(4, 1, 2, 2, 4));
        //add dialogue 6
        leftCardChoice3.add(createList(1, 1, 1, 4, 1));
        rightCardChoice3.add(createList(2, 3, 4, 2, 2));
        gameScreen.frontCards[2].setupDialogue(leftCard3Sprite, rightCard3Sprite, card3Qestions, 1, card3Rank, 2, dialogueSwipeLeftTrueCard3, leftCardChoice3, rightCardChoice3);

        //card4
        leftCard4Sprite = new ArrayList<>();
        rightCard4Sprite = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.technologicalCards.findRegion("card4Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.technologicalCards.findRegion("card4Dialogue" + (i+1) + ".2"));
            leftCard4Sprite.add(leftCardSprite);
            rightCard4Sprite.add(rightCardSprite);
        }
        card4Qestions = new ArrayList<>();
        card4Qestions.add("We have developed autonomous drones capable of making combat decisions. Should we deploy them, knowing they could reduce human casualties but raise ethical concerns?");
        card4Qestions.add("We’ve developed a new technology that can significantly reduce our carbon footprint, but it’s expensive. Should we implement it now or wait until we have more funds?");
        card4Qestions.add("Self-driving cars have now become the trend, and reduce accidents but pose ethical dilemmas. Should we allow them full autonomy or require human oversight for critical decisions?");
        card4Qestions.add("Robots can perform many jobs but may displace workers. Should we encourage widespread use of robots in all industries or limit them to high-risk and repetitive tasks?");
        card4Qestions.add("We’ve developed efficient renewable energy sources! Mandate their use across all industries!");
        card4Qestions.add("5G technology offers faster internet but has health concerns. Should we proceed with worldwide deployment or conduct further research on health impacts?");
        card4Rank = "Engr. A.";
        dialogueSwipeLeftTrueCard4 = new ArrayList<>();
        dialogueSwipeLeftTrueCard4.add(false);
        dialogueSwipeLeftTrueCard4.add(true);
        dialogueSwipeLeftTrueCard4.add(false);
        dialogueSwipeLeftTrueCard4.add(false);
        dialogueSwipeLeftTrueCard4.add(true);
        dialogueSwipeLeftTrueCard4.add(false);
        //new implementation
        leftCardChoice4 = new ArrayList<>();
        rightCardChoice4 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice4.add(createList(0,3,4,1,2));
        rightCardChoice4.add(createList(0,2,1,4,0));
        //add dialogue 2
        leftCardChoice4.add(createList(1,3,1,4,1));
        rightCardChoice4.add(createList(4,2,2,0,3));
        //add dialogue 3
        leftCardChoice4.add(createList(4,3,0,1,1));
        rightCardChoice4.add(createList(1,2,0,2,4));
        //add dialogue 4
        leftCardChoice4.add(createList(4,1,0,3,2));
        rightCardChoice4.add(createList(1,2,0,1,1));
        //add dialogue 5
        leftCardChoice4.add(createList(1,3,0,1,1));
        rightCardChoice4.add(createList(1,1,0,1,1));
        //add dialogue 6
        leftCardChoice4.add(createList(0,3,0,1,4));
        rightCardChoice4.add(createList(0,2,0,4,1));
        gameScreen.frontCards[3].setupDialogue(leftCard4Sprite, rightCard4Sprite, card4Qestions, 2, card4Rank, 2, dialogueSwipeLeftTrueCard4, leftCardChoice4, rightCardChoice4);

        //card 5
        leftCard5Sprite = new ArrayList<>();
        rightCard5Sprite = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.technologicalCards.findRegion("card5Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.technologicalCards.findRegion("card5Dialogue" + (i+1) + ".2"));
            leftCard5Sprite.add(leftCardSprite);
            rightCard5Sprite.add(rightCardSprite);
        }
        card5Qestions = new ArrayList<>();
        card5Qestions.add("Our surveillance technology has drastically reduced crime rates but at the cost of personal privacy.");
        card5Qestions.add("Online misinformation has become so rampant. Should we implement stricter content regulations or prioritize free speech and self-regulation?");
        card5Qestions.add("Our data collection systems are highly efficient but raise privacy issues. Enforce strict privacy policies.");
        card5Qestions.add("Cyber threats are unfortunately increasing. Should we invest heavily in cybersecurity infrastructure or focus on public education and preventive measures?");
        card5Qestions.add("Digital currencies offer efficiency but can disrupt economies. We can either adopt a national digital currency or regulate existing crypto currencies. What should we do?");
        card5Rank = "Agent B.";
        dialogueSwipeLeftTrueCard5 = new ArrayList<>();
        dialogueSwipeLeftTrueCard5.add(false);
        dialogueSwipeLeftTrueCard5.add(true);
        dialogueSwipeLeftTrueCard5.add(true);
        dialogueSwipeLeftTrueCard5.add(true);
        dialogueSwipeLeftTrueCard5.add(false);
        //new implementation
        leftCardChoice5 = new ArrayList<>();
        rightCardChoice5 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice5.add(createList(0,1,0,3,4));
        rightCardChoice5.add(createList(0,4,0,2,1));
        //add dialogue 2
        leftCardChoice5.add(createList(0,1,0,1,1));
        rightCardChoice5.add(createList(0,4,0,2,1));
        //add dialogue 3
        leftCardChoice5.add(createList(0,2,0,4,1));
        rightCardChoice5.add(createList(0,3,0,1,4));
        //add dialogue 4
        leftCardChoice5.add(createList(0,3,2,1,4));
        rightCardChoice5.add(createList(0,2,1,4,1));
        //add dialogue 5
        leftCardChoice5.add(createList(0,1,0,0,0));
        rightCardChoice5.add(createList(0,4,0,0,0));
        gameScreen.frontCards[4].setupDialogue(leftCard5Sprite, rightCard5Sprite, card5Qestions, 2, card5Rank, 1, dialogueSwipeLeftTrueCard5, leftCardChoice5, rightCardChoice5);


        //card 6
        leftCard6Sprite = new ArrayList<>();
        rightCard6Sprite = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.technologicalCards.findRegion("card6Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.technologicalCards.findRegion("card6Dialogue" + (i+1) + ".2"));
            leftCard6Sprite.add(leftCardSprite);
            rightCard6Sprite.add(rightCardSprite);
        }
        card6Qestions = new ArrayList<>();
        card6Qestions.add("Our investment in scientific research is yielding breakthroughs but is draining resources from immediate social programs. ");
        card6Qestions.add("Quantum computing promises immense power but risks data security. Prioritize developing quantum encryption.");
        card6Rank = "Sec. R.";
        dialogueSwipeLeftTrueCard6 = new ArrayList<>();
        dialogueSwipeLeftTrueCard6.add(true);
        dialogueSwipeLeftTrueCard6.add(false);
        //new implementation
        leftCardChoice6 = new ArrayList<>();
        rightCardChoice6 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice6.add(createList(2,3,4,2,2));
        rightCardChoice6.add(createList(1,4,1,1,1));
        //add dialogue 2
        leftCardChoice6.add(createList(0,4,0,2,2));
        rightCardChoice6.add(createList(0,3,0,1,1));
        gameScreen.frontCards[5].setupDialogue(leftCard6Sprite, rightCard6Sprite, card6Qestions, 2, card6Rank, 1, dialogueSwipeLeftTrueCard6, leftCardChoice6, rightCardChoice6);



        //card 7
        leftCard7Sprite = new ArrayList<>();
        rightCard7Sprite = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.technologicalCards.findRegion("card7Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.technologicalCards.findRegion("card7Dialogue" + (i+1) + ".2"));
            leftCard7Sprite.add(leftCardSprite);
            rightCard7Sprite.add(rightCardSprite);
        }
        card7Qestions = new ArrayList<>();
        card7Qestions.add("Our advanced AI systems are becoming increasingly self-aware. Should we grant them certain rights and protections, or continue to use them solely as tools? ");
        card7Qestions.add("We can now genetically modify humans! Permit genetic enhancements for non-medical uses NOW!");
        card7Qestions.add("Developing Artificial General Intelligences (AGI) poses ethical and safety concerns. Impose strict regulations on AGI research.");
        card7Rank = "Researcher J.";
        dialogueSwipeLeftTrueCard7 = new ArrayList<>();
        dialogueSwipeLeftTrueCard7.add(false);
        dialogueSwipeLeftTrueCard7.add(false);
        dialogueSwipeLeftTrueCard7.add(false);
        //new implementation
        leftCardChoice7 = new ArrayList<>();
        rightCardChoice7 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice7.add(createList(0,4,2,0,0));
        rightCardChoice7.add(createList(0,3,0,2,0));
        //add dialogue 2
        leftCardChoice7.add(createList(0,3,4,1,4));
        rightCardChoice7.add(createList( 0,2,1,2,1));
        //add dialogue 3
        leftCardChoice7.add(createList(0,1,0,1,1));
        rightCardChoice7.add(createList(0,2,0,4,1));
        gameScreen.frontCards[6].setupDialogue(leftCard7Sprite, rightCard7Sprite, card7Qestions, 2, card7Rank, 1, dialogueSwipeLeftTrueCard7, leftCardChoice7, rightCardChoice7);


        //card 8
        leftCard8Sprite = new ArrayList<>();
        rightCard8Sprite = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.culturalCards.findRegion("card8Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.culturalCards.findRegion("card8Dialogue" + (i+1) + ".2"));
            leftCard8Sprite.add(leftCardSprite);
            rightCard8Sprite.add(rightCardSprite);
        }
        card8Qestions = new ArrayList<>();
        card8Qestions.add("The new education reforms are in place, focusing on technology and innovation. Traditional subjects are receiving less attention. ");
        card8Qestions.add("Supporting cultural identity has led to a resurgence in native languages. We should integrate these languages into public education.");
        card8Qestions.add("Integrating native languages requires curriculum changes. Should we also include indigenous history and traditions in the curriculum, or keep the focus on contemporary subjects?");
        card8Qestions.add("Open immigration requires strong community support systems. We must fund community integration programs for immigrants.");
        card8Rank = "First Lady";
        dialogueSwipeLeftTrueCard8 = new ArrayList<>();
        dialogueSwipeLeftTrueCard8.add(true);
        dialogueSwipeLeftTrueCard8.add(false);
        dialogueSwipeLeftTrueCard8.add(false);
        dialogueSwipeLeftTrueCard8.add(false);
        //new implementation
        leftCardChoice8 = new ArrayList<>();
        rightCardChoice8 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice8.add(createList(0,4,3,2,2));
        rightCardChoice8.add(createList(0,1,4,1,1));
        //add dialogue 2
        leftCardChoice8.add(createList(1,1,4,1,1));
        rightCardChoice8.add(createList(1,1,3,1,1));
        //add dialogue 3
        leftCardChoice8.add(createList(0,0,4,0,0));
        rightCardChoice8.add(createList(0,0,3,0,0));
        //add dialogue 4
        leftCardChoice8.add(createList(1,1,1,1,1));
        rightCardChoice8.add(createList(2,4,3,2,4));
        gameScreen.frontCards[7].setupDialogue(leftCard8Sprite, rightCard8Sprite, card8Qestions, 3, card8Rank, 4, dialogueSwipeLeftTrueCard8, leftCardChoice8, rightCardChoice8);


            //card 9
        leftCard9Sprite = new ArrayList<>();
        rightCard9Sprite = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.culturalCards.findRegion("card9Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.culturalCards.findRegion("card9Dialogue" + (i+1) + ".2"));
            leftCard9Sprite.add(leftCardSprite);
            rightCard9Sprite.add(rightCardSprite);
        }
        card9Qestions = new ArrayList<>();
        card9Qestions.add("A minority group is struggling to integrate into our society. Should we encourage assimilation to promote unity, or support their efforts to maintain their cultural identity?");
        card9Qestions.add("Community integration raises issues of religious tolerance. Should we promote interfaith dialogues to foster understanding, or maintain a separation of religion and public life?");
        card9Qestions.add("Celebrating cultural diversity may require new policies. We should draft new policies to support cultural diversity and inclusion.");
        card9Qestions.add("Our cultural expressions are being used commercially without consent. Should we implement stricter intellectual property (IP) laws to protect cultural heritage, or encourage open sharing to promote cultural exchange?");
        card9Rank = "Father K.";
        dialogueSwipeLeftTrueCard9 = new ArrayList<>();
        dialogueSwipeLeftTrueCard9.add(false);
        dialogueSwipeLeftTrueCard9.add(false);
        dialogueSwipeLeftTrueCard9.add(false);
        dialogueSwipeLeftTrueCard9.add(false);
        //new implementation
        leftCardChoice9 = new ArrayList<>();
        rightCardChoice9 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice9.add(createList(0,0,4,0,0));
        rightCardChoice9.add(createList(0,0,3,0,0));
        //add dialogue 2
        leftCardChoice9.add(createList(0,0,4,0,0));
        rightCardChoice9.add(createList(0,0,1,0,0));
        //add dialogue 3
        leftCardChoice9.add(createList(1,1,4,1,1));
        rightCardChoice9.add(createList(2,2,3,4,4));
        //add dialogue 4
        leftCardChoice9.add(createList(0,0,1,0,0));
        rightCardChoice9.add(createList(0,0,3,0,0));
        gameScreen.frontCards[8].setupDialogue(leftCard9Sprite, rightCard9Sprite, card9Qestions, 3, card9Rank, 1, dialogueSwipeLeftTrueCard9, leftCardChoice9, rightCardChoice9);



//            //card 10
        leftCard10Sprite = new ArrayList<>();
        rightCard10Sprite = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.culturalCards.findRegion("card10Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.culturalCards.findRegion("card10Dialogue" + (i+1) + ".2"));
            leftCard10Sprite.add(leftCardSprite);
            rightCard10Sprite.add(rightCardSprite);
        }
        card10Qestions = new ArrayList<>();
        card10Qestions.add("We’ve preserved our cultural heritage sites, attracting tourism but diverting funds from other critical areas.");
        card10Qestions.add("To celebrate our diverse heritage, should we sponsor new cultural festivals, or increase support for existing national festivals?");
        card10Qestions.add("Increasing tourism puts pressure on heritage sites. We should implement strict conservation measures to protect these sites.");
        card10Qestions.add("Expanding cultural diversity in art prompts museums to diversify their exhibits. We should seek international pieces for a global perspective.");
        card10Rank = "Chef Q.";
        dialogueSwipeLeftTrueCard10 = new ArrayList<>();
        dialogueSwipeLeftTrueCard10.add(true);
        dialogueSwipeLeftTrueCard10.add(false);
        dialogueSwipeLeftTrueCard10.add(true);
        dialogueSwipeLeftTrueCard10.add(true);
        //new implementation
        leftCardChoice10 = new ArrayList<>();
        rightCardChoice10 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice10.add(createList(4,2,3,4,4));
        rightCardChoice10.add(createList(1,1,1,1,1));
        //add dialogue 2
        leftCardChoice10.add(createList(2,4,1,4,2));
        rightCardChoice10.add(createList(4,2,3,2,2));
        //add dialogue 3
        leftCardChoice10.add(createList(0,0,1,0,0));
        rightCardChoice10.add(createList(0,0,3,0,0));
        //add dialogue 4
        leftCardChoice10.add(createList(0,0,2,0,0));
        rightCardChoice10.add(createList(0,0,2,0,0));
        gameScreen.frontCards[9].setupDialogue(leftCard10Sprite, rightCard10Sprite, card10Qestions, 3, card10Rank, 1, dialogueSwipeLeftTrueCard10, leftCardChoice10, rightCardChoice10);


//            //card 11
        leftCard11Sprite = new ArrayList<>();
        rightCard11Sprite = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.culturalCards.findRegion("card11Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.culturalCards.findRegion("card11Dialogue" + (i+1) + ".2"));
            leftCard11Sprite.add(leftCardSprite);
            rightCard11Sprite.add(rightCardSprite);
        }
        card11Qestions = new ArrayList<>();
        card11Qestions.add("Including indigenous history raises interest in cultural heritage. We must invest in preserving historical sites.");
        card11Qestions.add("A neighboring country is violating human rights. Should we impose economic sanctions, which could harm their civilians, or seek diplomatic solutions?");
        card11Qestions.add("As cultural diversity increases, should we mandate diversity quotas in media productions, or encourage voluntary diversity initiatives by media companies?");
        card11Qestions.add("International artifacts in museums spark interest in cultural exchange. Should we establish cultural exchange programs with other countries, or focus on enhancing local cultural programs?");
        card11Rank = "Historian Z.";
        dialogueSwipeLeftTrueCard11 = new ArrayList<>();
        dialogueSwipeLeftTrueCard11.add(true);
        dialogueSwipeLeftTrueCard11.add(true);
        dialogueSwipeLeftTrueCard11.add(false);
        dialogueSwipeLeftTrueCard11.add(true);
        //new implementation
        leftCardChoice11 = new ArrayList<>();
        rightCardChoice11 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice11.add(createList(2,2,3,2,4));
        rightCardChoice11.add(createList(1,1,4,1,1));
        //add dialogue 2
        leftCardChoice11.add(createList(0,1,3,1,1));
        rightCardChoice11.add(createList(0,1,1,1,1));
        //add dialogue 3
        leftCardChoice11.add(createList(0,0,4,0,0));
        rightCardChoice11.add(createList(0,0,1,0,0));
        //add dialogue 4
        leftCardChoice11.add(createList(0,0,1,0,0));
        rightCardChoice11.add(createList(0,0,1,0,0));

        gameScreen.frontCards[10].setupDialogue(leftCard11Sprite, rightCard11Sprite, card11Qestions, 3, card11Rank, 1, dialogueSwipeLeftTrueCard11, leftCardChoice11, rightCardChoice11);

//            //card 12
        leftCard12Sprite = new ArrayList<>();
        rightCard12Sprite = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.militaryCards.findRegion("card12Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.militaryCards.findRegion("card12Dialogue" + (i+1) + ".2"));
            leftCard12Sprite.add(leftCardSprite);
            rightCard12Sprite.add(rightCardSprite);
        }
        card12Qestions = new ArrayList<>();
        card12Qestions.add("We’ve expanded our military capabilities, ensuring national security but increasing tensions with neighboring countries.");
        card12Qestions.add("Our alliances can strengthen our security. We should participate in more joint military exercises.");
        card12Qestions.add("Our defense budget is heavily strained. Should we prioritize cutting-edge technology investments or focus on maintaining current military readiness?");
        card12Qestions.add("Reports of misconduct are unfortunately rising. Implement stricter penalties for violations.");
        card12Rank = "Major E.";
        dialogueSwipeLeftTrueCard12 = new ArrayList<>();
        dialogueSwipeLeftTrueCard12.add(true);
        dialogueSwipeLeftTrueCard12.add(false);
        dialogueSwipeLeftTrueCard12.add(true);
        dialogueSwipeLeftTrueCard12.add(true);
        //new implementation
        leftCardChoice12 = new ArrayList<>();
        rightCardChoice12 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice12.add(createList(4,1,2,3,2));
        rightCardChoice12.add(createList(1,4,1,2,1));
        //add dialogue 2
        leftCardChoice12.add(createList(0,4,0,2,0));
        rightCardChoice12.add(createList(0,1,0,3,0));
        //add dialogue 3
        leftCardChoice12.add(createList(2,1,4,3,2));
        rightCardChoice12.add(createList( 1,4,1,2,1));
        //add dialogue 4
        leftCardChoice12.add(createList(0,0,1,3,1));
        rightCardChoice12.add(createList( 0,0,4,4,4));
        gameScreen.frontCards[11].setupDialogue(leftCard12Sprite, rightCard12Sprite, card12Qestions, 4, card12Rank, 1, dialogueSwipeLeftTrueCard12,leftCardChoice12, rightCardChoice12);



//            //card 13
        leftCard13Sprite = new ArrayList<>();
        rightCard13Sprite = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.militaryCards.findRegion("card13Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.militaryCards.findRegion("card13Dialogue" + (i+1) + ".2"));
            leftCard13Sprite.add(leftCardSprite);
            rightCard13Sprite.add(rightCardSprite);
        }
        card13Qestions = new ArrayList<>();
        card13Qestions.add("To prevent further terrorist attacks, we could implement a mass surveillance program. This would greatly reduce privacy. Should we proceed?");
        card13Qestions.add("Our military systems are vulnerable to cyber attacks. Should we increase funding for cybersecurity or focus on offensive cyber capabilities?");
        card13Qestions.add("Our global military presence ensures influence but is costly. Should we reduce overseas bases to cut costs or maintain them to support global stability?");
        card13Qestions.add("Tensions between civilian authorities and military leaders are growing at an exponential rate. Implement stronger civilian oversight!");
        card13Rank = "Spy X";
        dialogueSwipeLeftTrueCard13 = new ArrayList<>();
        dialogueSwipeLeftTrueCard13.add(true);
        dialogueSwipeLeftTrueCard13.add(true);
        dialogueSwipeLeftTrueCard13.add(true);
        dialogueSwipeLeftTrueCard13.add(false);
        //new implementation
        leftCardChoice13 = new ArrayList<>();
        rightCardChoice13 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice13.add(createList(0,2,1,4,1));
        rightCardChoice13.add(createList(0,1,4,3,2));
        //add dialogue 2
        leftCardChoice13.add(createList(4,1,2,3,4));
        rightCardChoice13.add(createList(2,1,4,1,2));
        //add dialogue 3
        leftCardChoice13.add(createList(1,2,1,4,1));
        rightCardChoice13.add(createList(2,1,4,3,2));
        //add dialogue 4
        leftCardChoice13.add(createList(0,0,2,3,2));
        rightCardChoice13.add(createList(0,0,1,4,1));

        gameScreen.frontCards[12].setupDialogue(leftCard13Sprite, rightCard13Sprite, card13Qestions, 4, card13Rank, 1, dialogueSwipeLeftTrueCard13, leftCardChoice13, rightCardChoice13);


//            //card 14
        leftCard14Sprite = new ArrayList<>();
        rightCard14Sprite = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.militaryCards.findRegion("card14Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.militaryCards.findRegion("card14Dialogue" + (i+1) + ".2"));
            leftCard14Sprite.add(leftCardSprite);
            rightCard14Sprite.add(rightCardSprite);
        }
        card14Qestions = new ArrayList<>();
        card14Qestions.add("We have developed autonomous drones capable of making combat decisions! We should deploy them!");
        card14Qestions.add("Super power countries are expanding their nuclear arsenal. Should we respond by modernizing our own nuclear weapons or pursue diplomatic efforts to reduce nuclear arms?");
        card14Qestions.add("Artificial Intelligence (AI) in warfare could enhance operational efficiency but poses risks. Proceed with caution, prioritizing human oversight.");
        card14Qestions.add("Military exercises are damaging the environment. Should we invest in eco-friendly training alternatives or accept the environmental costs for the sake of preparedness?");
        card14Rank = "Colonel T.";
        dialogueSwipeLeftTrueCard14 = new ArrayList<>();
        dialogueSwipeLeftTrueCard14.add(false);
        dialogueSwipeLeftTrueCard14.add(false);
        dialogueSwipeLeftTrueCard14.add(false);
        dialogueSwipeLeftTrueCard14.add(true);
        //new implementation
        leftCardChoice14 = new ArrayList<>();
        rightCardChoice14 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice14.add(createList(2,1,4,3,2));
        rightCardChoice14.add(createList(1,4,1,2,1));
        //add dialogue 2
        leftCardChoice14.add(createList(2,1,4,3,2));
        rightCardChoice14.add(createList(1,4,1,2,1));
        //add dialogue 3
        leftCardChoice14.add(createList(0,1,0,3,1));
        rightCardChoice14.add(createList(0,4,0,2,4));
        //add dialogue 4
        leftCardChoice14.add(createList(1,2,1,4,1));
        rightCardChoice14.add(createList(2,1,4,3,2));
        gameScreen.frontCards[13].setupDialogue(leftCard14Sprite, rightCard14Sprite, card14Qestions, 4, card14Rank, 1, dialogueSwipeLeftTrueCard14, leftCardChoice14, rightCardChoice14);




//            //card 15
        leftCard15Sprite = new ArrayList<>();
        rightCard15Sprite = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.militaryCards.findRegion("card15Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.militaryCards.findRegion("card15Dialogue" + (i+1) + ".2"));
            leftCard15Sprite.add(leftCardSprite);
            rightCard15Sprite.add(rightCardSprite);
        }
        card15Qestions = new ArrayList<>();
        card15Qestions.add("Many veterans face challenges reintegrating into civilian life. Should we allocate more resources for veteran support programs or focus on improving military mental health services?");
        card15Qestions.add("Our military technology is in high demand globally! Export advanced weapons to allied nations!");
        card15Qestions.add("Our troops are requested for international peacekeeping missions. Should we commit to these missions, risking personnel, or focus on national defense?");
        card15Qestions.add("Our military is often called for disaster response. Expand military disaster response capabilities!");
        card15Rank = "Lieutenant R.";
        dialogueSwipeLeftTrueCard15 = new ArrayList<>();
        dialogueSwipeLeftTrueCard15.add(true);
        dialogueSwipeLeftTrueCard15.add(false);
        dialogueSwipeLeftTrueCard15.add(true);
        dialogueSwipeLeftTrueCard15.add(false);

        //new implementation
        leftCardChoice15 = new ArrayList<>();
        rightCardChoice15 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice15.add(createList(4,2,2,2,3));
        rightCardChoice15.add(createList(2,2,2,2,1));
        //add dialogue 1
        leftCardChoice15.add(createList(2,3,2,3,2));
        rightCardChoice15.add(createList(1,2,1,4,1));
        //add dialogue 1
        leftCardChoice15.add(createList(0,0,0,1,0));
        rightCardChoice15.add(createList(0,0,0,3,0));
        //add dialogue 1
        leftCardChoice15.add(createList(2,4,2,2,2));
        rightCardChoice15.add(createList(2,1,4,3,2));

        gameScreen.frontCards[14].setupDialogue(leftCard15Sprite, rightCard15Sprite, card15Qestions, 4, card15Rank, 1, dialogueSwipeLeftTrueCard15, leftCardChoice15, rightCardChoice15);



//            //card 16
        leftCard16Sprite = new ArrayList<>();
        rightCard16Sprite = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.healthCards.findRegion("card16Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.healthCards.findRegion("card16Dialogue" + (i+1) + ".2"));
            leftCard16Sprite.add(leftCardSprite);
            rightCard16Sprite.add(rightCardSprite);
        }
        card16Qestions = new ArrayList<>();
        card16Qestions.add("We have the technology to genetically modify crops to withstand extreme weather, but it could have unknown long-term effects. Should we use it?");
        card16Qestions.add("A new vaccine can curb most known dangerous diseases, but has long term effects. Should we make mandatory vaccinations, or leave it optional?");
        card16Qestions.add("There is a deflux of health workers (HWs), and the usage of AI seems to be a light at the end of the tunnel. What should we do?");
        card16Qestions.add("Scientists have discovered a way to mass-produce meat, by using the limbs of humans and cloning their genes to create lab grown meat. What should we do?");
        card16Qestions.add("A team of scientists proposes to inject some viruses to healthy individuals bit by bit, in order for them to develop some immunity and for the scientists to study how to create a vaccine from it. What would you say?");
        card16Qestions.add("Medical research is now making strides, but it requires immense funding. Should we invest in it heavily, or divert the funds to more immediate healthcare needs?");
        card16Qestions.add("Talks about forcing the terminally ill to end their lives in exchange for freeing up medical resources for others has been going around. What is your decision?");
        card16Qestions.add("Researchers found a treatment to prevent virus spread, but it requires extracting from newborns, risking their lives. Considering population control and medical progress, what is your call?");
        card16Rank = "Dr. G.";
        dialogueSwipeLeftTrueCard16 = new ArrayList<>();
        dialogueSwipeLeftTrueCard16.add(false);
        dialogueSwipeLeftTrueCard16.add(false);
        dialogueSwipeLeftTrueCard16.add(false);
        dialogueSwipeLeftTrueCard16.add(false);
        dialogueSwipeLeftTrueCard16.add(false);
        dialogueSwipeLeftTrueCard16.add(true);
        dialogueSwipeLeftTrueCard16.add(false);
        dialogueSwipeLeftTrueCard16.add(false);
        //new implementation
        leftCardChoice16 = new ArrayList<>();
        rightCardChoice16 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice16.add(createList(1,4,1,2,3));
        rightCardChoice16.add(createList(2,1,4,1,2));
        //add dialogue 2
        leftCardChoice16.add(createList(0,0,0,0,4));
        rightCardChoice16.add(createList(0,0,0,0,3));
        //add dialogue 3
        leftCardChoice16.add(createList(0,1,0,0,4));
        rightCardChoice16.add(createList(0,4,0,0,3));
        //add dialogue 4
        leftCardChoice16.add(createList(2,1,4,1,2));
        rightCardChoice16.add(createList(1,4,1,2,3));
        //add dialogue 5
        leftCardChoice16.add(createList(4,1,2,1,2));
        rightCardChoice16.add(createList(1,4,1,2,3));
        //add dialogue 6
        leftCardChoice16.add(createList(2,1,4,1,3));
        rightCardChoice16.add(createList(1,4,1,2,2));
        //add dialogue 7
        leftCardChoice16.add(createList(2,1,4,1,2));
        rightCardChoice16.add(createList(1,4,1,2,3));
        //add dialogue 8
        leftCardChoice16.add(createList(0,1,4,1,2));
        rightCardChoice16.add(createList(0,2,1,4,3));


        gameScreen.frontCards[15].setupDialogue(leftCard16Sprite, rightCard16Sprite, card16Qestions, 5, card16Rank, 1, dialogueSwipeLeftTrueCard16, leftCardChoice16, rightCardChoice16);



        //card 17
        leftCard17Sprite = new ArrayList<>();
        rightCard17Sprite = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.healthCards.findRegion("card17Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.healthCards.findRegion("card17Dialogue" + (i+1) + ".2"));
            leftCard17Sprite.add(leftCardSprite);
            rightCard17Sprite.add(rightCardSprite);
        }
        card17Qestions = new ArrayList<>();
        card17Qestions.add("We’ve allocated more resources to healthcare, improving overall public health but straining other sectors.");
        card17Qestions.add("Only the wealthy now have access to healthcare, leaving the poor in dire need and sparking widespread protests. How should we act?");
        card17Qestions.add("We can no longer provide healthcare for everyone. We can force the injured or sick to contribute to society for them to receive treatment. What should we do?");
        card17Qestions.add("The government has proposed a law that obligates dying individuals for their organs to be harvested. What should we do?");
        card17Rank = "Housekeeper E.";
        dialogueSwipeLeftTrueCard17 = new ArrayList<>();
        dialogueSwipeLeftTrueCard17.add(true);
        dialogueSwipeLeftTrueCard17.add(false);
        dialogueSwipeLeftTrueCard17.add(false);
        dialogueSwipeLeftTrueCard17.add(false);
        //new implementation
        leftCardChoice17 = new ArrayList<>();
        rightCardChoice17 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice17.add(createList(1,1,1,1,1));
        rightCardChoice17.add(createList(2,2,2,4,3));
        //add dialogue 2
        leftCardChoice17.add(createList(1,1,1,1,4));
        rightCardChoice17.add(createList(2,2,2,2,3));
        //add dialogue 3
        leftCardChoice17.add(createList(0,0,0,0,4));
        rightCardChoice17.add(createList(0,0,0,0,3));
        //add dialogue 4
        leftCardChoice17.add(createList(0,0,2,0,4));
        rightCardChoice17.add(createList(0,0,1,0,3));
        gameScreen.frontCards[16].setupDialogue(leftCard17Sprite, rightCard17Sprite, card17Qestions, 5, card17Rank, 2, dialogueSwipeLeftTrueCard17, leftCardChoice17, rightCardChoice17);



        //card 18
        leftCard18Sprite = new ArrayList<>();
        rightCard18Sprite = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.healthCards.findRegion("card18Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.healthCards.findRegion("card18Dialogue" + (i+1) + ".2"));
            leftCard18Sprite.add(leftCardSprite);
            rightCard18Sprite.add(rightCardSprite);
        }
        card18Qestions = new ArrayList<>();
        card18Qestions.add("Overpopulation is straining our resources. Should we implement strict population control measures, or focus on finding new ways to sustain our growing population?");
        card18Qestions.add("We have a limited supply of a life-saving drug. Should we prioritize children and young adults, or distribute it equally among all age groups?");
        card18Qestions.add("A new virus has caused an epidemic to ensue in a bustling city. This city is one of the major economic hubs for the country. What will you do?");
        card18Qestions.add("We need to prevent further strain in our healthcare systems by regulating births. Only the healthiest can reproduce, while others will be forced to use contraceptives. What do you think?");
        card18Rank = "Little R.";
        dialogueSwipeLeftTrueCard18 = new ArrayList<>();
        dialogueSwipeLeftTrueCard18.add(false);
        dialogueSwipeLeftTrueCard18.add(false);
        dialogueSwipeLeftTrueCard18.add(true);
        dialogueSwipeLeftTrueCard18.add(true);
        //new implementation
        leftCardChoice18 = new ArrayList<>();
        rightCardChoice18 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice18.add(createList(1,1,1,1,4));
        rightCardChoice18.add(createList(2,1,4,2,3));
        //add dialogue 2
        leftCardChoice18.add(createList(0,0,0,0,4));
        rightCardChoice18.add(createList( 0,0,0,0,3));
        //add dialogue 3
        leftCardChoice18.add(createList(2,2,2,2,3));
        rightCardChoice18.add(createList(1,1,1,1,4));
        //add dialogue 4
        leftCardChoice18.add(createList(1,2,1,2,3));
        rightCardChoice18.add(createList(2,1,4,1,4));
        gameScreen.frontCards[17].setupDialogue(leftCard18Sprite, rightCard18Sprite, card18Qestions, 5, card18Rank, 1, dialogueSwipeLeftTrueCard18, leftCardChoice18, rightCardChoice18);

        System.out.println(leftCardChoice18);
        System.out.println(rightCardChoice18);

        //card 19
        leftCard19Sprite = new ArrayList<>();
        rightCard19Sprite = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Sprite leftCardSprite = new Sprite(gameScreen.guideCardsAtlas.findRegion("card0Dialogue" + (i+1) + ".1"));
            Sprite rightCardSprite = new Sprite(gameScreen.guideCardsAtlas.findRegion("card0Dialogue" + (i+1) + ".2"));
            leftCard19Sprite.add(leftCardSprite);
            rightCard19Sprite.add(rightCardSprite);
        }
        card19Qestions = new ArrayList<>();
        card19Qestions.add("Greetings, Overseer. This is a world reshaped by the hands of humanity and scarred by time itself. Swipe left or right to proceed.");
        card19Qestions.add("Long has the civilization thrived, and longer has it endured. But now... the Epoch draws to its end.");
        card19Qestions.add("Your goal is simple, yet grave: navigate the ruins, confront the choices of past ages, and shape what remains.");
        card19Qestions.add("Be warned: each choice ripples, every action echoes. The end is inevitable-but how it unfolds... that duty rests on you.");
        card19Qestions.add("Take this heed Overseer, there is no going back.");
        card19Rank = "Guide";
        dialogueSwipeLeftTrueCard19 = new ArrayList<>();
        dialogueSwipeLeftTrueCard19.add(false);
        dialogueSwipeLeftTrueCard19.add(false);
        dialogueSwipeLeftTrueCard19.add(true);
        dialogueSwipeLeftTrueCard19.add(true);
        dialogueSwipeLeftTrueCard19.add(true);
        //new implementation
        leftCardChoice19 = new ArrayList<>();
        rightCardChoice19 = new ArrayList<>();
        //add dialogue 1
        leftCardChoice19.add(createList());
        rightCardChoice19.add(createList());
        //add dialogue 2
        leftCardChoice19.add(createList());
        rightCardChoice19.add(createList());
        //add dialogue 3
        leftCardChoice19.add(createList());
        rightCardChoice19.add(createList());
        //add dialogue 4
        leftCardChoice19.add(createList());
        rightCardChoice19.add(createList());
        //add dialogue 5
        leftCardChoice19.add(createList());
        rightCardChoice19.add(createList());
        gameScreen.frontCards[18].setupDialogue(leftCard19Sprite, rightCard19Sprite, card19Qestions, 5, card19Rank, 1, dialogueSwipeLeftTrueCard19, leftCardChoice19, rightCardChoice19);
    }
}
