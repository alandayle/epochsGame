package com.ArtManlangit.epochsGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class DialogueSetup {
    GameScreen gameScreen;

    //every assets for setting up dialogues - IGNORE!
    //card 1
    ArrayList<Sprite> leftCard1Sprite;
    ArrayList<Sprite> rightCard1Sprite;
    ArrayList<String> card1Qestions;
    String card1Rank;

    //card 2
    ArrayList<Sprite> leftCard2Sprite;
    ArrayList<Sprite> rightCard2Sprite;
    ArrayList<String> card2Qestions;
    String card2Rank;

    //card 3
    ArrayList<Sprite> leftCard3Sprite;
    ArrayList<Sprite> rightCard3Sprite;
    ArrayList<String> card3Qestions;
    String card3Rank;

    //card 4
    ArrayList<Sprite> leftCard4Sprite;
    ArrayList<Sprite> rightCard4Sprite;
    ArrayList<String> card4Qestions;
    String card4Rank;


    //card 5
    ArrayList<Sprite> leftCard5Sprite;
    ArrayList<Sprite> rightCard5Sprite;
    ArrayList<String> card5Qestions;
    String card5Rank;

    //card 6
    ArrayList<Sprite> leftCard6Sprite;
    ArrayList<Sprite> rightCard6Sprite;
    ArrayList<String> card6Qestions;
    String card6Rank;

    //card 7
    ArrayList<Sprite> leftCard7Sprite;
    ArrayList<Sprite> rightCard7Sprite;
    ArrayList<String> card7Qestions;
    String card7Rank;

    //card 8
    ArrayList<Sprite> leftCard8Sprite;
    ArrayList<Sprite> rightCard8Sprite;
    ArrayList<String> card8Qestions;
    String card8Rank;

    //card 9
    ArrayList<Sprite> leftCard9Sprite;
    ArrayList<Sprite> rightCard9Sprite;
    ArrayList<String> card9Qestions;
    String card9Rank;

    //card 10
    ArrayList<Sprite> leftCard10Sprite;
    ArrayList<Sprite> rightCard10Sprite;
    ArrayList<String> card10Qestions;
    String card10Rank;

    //card 11
    ArrayList<Sprite> leftCard11Sprite;
    ArrayList<Sprite> rightCard11Sprite;
    ArrayList<String> card11Qestions;
    String card11Rank;

    //card 12
    ArrayList<Sprite> leftCard12Sprite;
    ArrayList<Sprite> rightCard12Sprite;
    ArrayList<String> card12Qestions;
    String card12Rank;

    //card 13
    ArrayList<Sprite> leftCard13Sprite;
    ArrayList<Sprite> rightCard13Sprite;
    ArrayList<String> card13Qestions;
    String card13Rank;

    //card 14
    ArrayList<Sprite> leftCard14Sprite;
    ArrayList<Sprite> rightCard14Sprite;
    ArrayList<String> card14Qestions;
    String card14Rank;

    //card 15
    ArrayList<Sprite> leftCard15Sprite;
    ArrayList<Sprite> rightCard15Sprite;
    ArrayList<String> card15Qestions;
    String card15Rank;

    //card 16
    ArrayList<Sprite> leftCard16Sprite;
    ArrayList<Sprite> rightCard16Sprite;
    ArrayList<String> card16Qestions;
    String card16Rank;


    //card 17
    ArrayList<Sprite> leftCard17Sprite;
    ArrayList<Sprite> rightCard17Sprite;
    ArrayList<String> card17Qestions;
    String card17Rank;


    //card 18
    ArrayList<Sprite> leftCard18Sprite;
    ArrayList<Sprite> rightCard18Sprite;
    ArrayList<String> card18Qestions;
    String card18Rank;


    //constructor
    public DialogueSetup(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
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
        gameScreen.frontCards[0].setupDialogue(leftCard1Sprite, rightCard1Sprite, card1Qestions, 1, card1Rank);


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
        gameScreen.frontCards[1].setupDialogue(leftCard2Sprite, rightCard2Sprite, card2Qestions, 1, card2Rank);

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
        gameScreen.frontCards[2].setupDialogue(leftCard3Sprite, rightCard3Sprite, card3Qestions, 1, card3Rank);

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
        gameScreen.frontCards[3].setupDialogue(leftCard4Sprite, rightCard4Sprite, card4Qestions, 1, card4Rank);

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
        gameScreen.frontCards[4].setupDialogue(leftCard5Sprite, rightCard5Sprite, card5Qestions, 1, card5Rank);

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
        gameScreen.frontCards[5].setupDialogue(leftCard6Sprite, rightCard6Sprite, card6Qestions, 1, card6Rank);

//            //card 7
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
        gameScreen.frontCards[6].setupDialogue(leftCard7Sprite, rightCard7Sprite, card7Qestions, 1, card7Rank);

//            //card 8
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
        card8Qestions.add("Integrating native languages languages requires curriculum changes. Should we also include indigenous history and traditions in the curriculum, or keep the focus on contemporary subjects?");
        card8Qestions.add("Open immigration requires strong community support systems. We must fund community integration programs for immigrants.");
        card8Rank = "First Lady";
        gameScreen.frontCards[7].setupDialogue(leftCard8Sprite, rightCard8Sprite, card8Qestions, 1, card8Rank);

//            //card 9
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
        gameScreen.frontCards[8].setupDialogue(leftCard9Sprite, rightCard9Sprite, card9Qestions, 1, card9Rank);

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
        gameScreen.frontCards[9].setupDialogue(leftCard10Sprite, rightCard10Sprite, card10Qestions, 1, card10Rank);

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
        gameScreen.frontCards[10].setupDialogue(leftCard11Sprite, rightCard11Sprite, card11Qestions, 1, card11Rank);

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
        gameScreen.frontCards[11].setupDialogue(leftCard12Sprite, rightCard12Sprite, card12Qestions, 1, card12Rank);

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
        gameScreen.frontCards[12].setupDialogue(leftCard13Sprite, rightCard13Sprite, card13Qestions, 1, card13Rank);

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
        gameScreen.frontCards[13].setupDialogue(leftCard14Sprite, rightCard14Sprite, card14Qestions, 1, card14Rank);

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
        gameScreen.frontCards[14].setupDialogue(leftCard15Sprite, rightCard15Sprite, card15Qestions, 1, card15Rank);

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
        card16Qestions.add("Medical researchers have found a new treatment that can prevent the spread of certain viruses. However, the production of such must be extracted from newborn babies, with a chance of them dying along the process. Aligned with reducing the population and advancing with this treatment, what is your call?");
        card16Rank = "Dr. G.";
        gameScreen.frontCards[15].setupDialogue(leftCard16Sprite, rightCard16Sprite, card16Qestions, 1, card16Rank);

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
        gameScreen.frontCards[16].setupDialogue(leftCard17Sprite, rightCard17Sprite, card17Qestions, 1, card17Rank);

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
        gameScreen.frontCards[17].setupDialogue(leftCard18Sprite, rightCard18Sprite, card18Qestions, 1, card18Rank);
    }
}
