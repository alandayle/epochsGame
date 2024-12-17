    package com.ArtManlangit.epochsGame;

    import com.badlogic.gdx.Game;
    import com.badlogic.gdx.Screen;
    import com.badlogic.gdx.assets.AssetManager;
    import com.badlogic.gdx.assets.loaders.FileHandleResolver;
    import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
    import com.badlogic.gdx.audio.Music;
    import com.badlogic.gdx.audio.Sound;
    import com.badlogic.gdx.graphics.Camera;
    import com.badlogic.gdx.graphics.Color;
    import com.badlogic.gdx.graphics.Texture;
    import com.badlogic.gdx.graphics.g2d.Batch;
    import com.badlogic.gdx.graphics.g2d.BitmapFont;
    import com.badlogic.gdx.graphics.g2d.Sprite;
    import com.badlogic.gdx.graphics.g2d.SpriteBatch;
    import com.badlogic.gdx.graphics.g2d.TextureAtlas;
    import com.badlogic.gdx.graphics.g2d.TextureRegion;
    import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
    import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
    import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
    import com.badlogic.gdx.utils.Align;
    import com.badlogic.gdx.utils.ScreenUtils;
    import com.badlogic.gdx.utils.viewport.Viewport;
    import com.sun.tools.javac.Main;

    import javax.print.attribute.HashPrintServiceAttributeSet;

    public class LoadingScreen implements Screen {
        //shared variables to all screen
        EpochsGame epochsGame;
        AssetManager assetManager;
        Viewport viewport, backgroundViewport;
        Camera camera;

        //textures for assets in the loading screen
        TextureAtlas mainBgsLogos, loading;
        TextureRegion loadingLogo;
        TextureRegion[] loadingImage;
        BitmapFont mainFont;
        String loadingText;

        //timer
        float timer;
        int currentLoadingIndex;

        //transition to next screen timer
        float timerNext;

        //loading icon size
        float loadingIconLength;

        //drawer
        SpriteBatch batch;

        //create variables for loading based on gamescreen
        int currentLoading;
        int splashScreen = 0;
        int gameScreen = 1;
        int endScreen = 2;
        int mainMenuScreen = 3;

        //delay time before launching the game after loading the assets
        float launchDelay = 0;



        //constructor
        public LoadingScreen(EpochsGame epochsGame) {
            //initialize variables
            this.epochsGame = epochsGame;
            this.assetManager = epochsGame.assetManager;
            viewport = epochsGame.viewport;
            backgroundViewport = epochsGame.backgroundViewport;
            camera = epochsGame.camera;
            batch = epochsGame.batch;

            //load and setup assets for loading first
            loadLoadingAssets();

            //load all assets
//            loadAssets();

//            debug
            currentLoading = splashScreen;

            //testing new loading
            loadScreenAssets();
        }

        public void debug() {
            //default
            if (currentLoading == splashScreen) {
                epochsGame.splashScreen = new SplashScreen(epochsGame);
                epochsGame.setScreen(epochsGame.splashScreen);
            } else if (currentLoading == gameScreen) {
                epochsGame.gameScreen = new GameScreen(epochsGame);
                epochsGame.setScreen(epochsGame.gameScreen);
            } else if (currentLoading == endScreen) {
                epochsGame.endScreen = new EndScreen(epochsGame);
                epochsGame.setScreen(epochsGame.endScreen);
            } else if (currentLoading == mainMenuScreen) {
                epochsGame.mainMenuScreen = new MainMenuScreen(epochsGame);
                epochsGame.setScreen(epochsGame.mainMenuScreen);
            }
        }

        public void loadLoadingAssets() {
            assetManager.load("packedTextures/mainBgsLogos.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/loading.atlas", TextureAtlas.class);

            //load fonts
            FileHandleResolver resolver = new InternalFileHandleResolver();
            assetManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
            assetManager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));
            FreetypeFontLoader.FreeTypeFontLoaderParameter typewriter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
            typewriter.fontFileName = "fonts/typewcond.otf";
            typewriter.fontParameters.size = 25;
            typewriter.fontParameters.spaceY = -0;
            assetManager.load("typewcond25.otf", BitmapFont.class, typewriter);

            //finish loading
            assetManager.finishLoading();

            //setup assets for loading screen
            mainBgsLogos = assetManager.get("packedTextures/mainBgsLogos.atlas", TextureAtlas.class);
            loading = assetManager.get("packedTextures/loading.atlas", TextureAtlas.class);
            loadingLogo = mainBgsLogos.findRegion("logo(portrait)");
            mainFont = assetManager.get("typewcond25.otf", BitmapFont.class);

            //store loadingIcon frames
            loadingImage = new TextureRegion[36];
            for (int i = 0; i < 36; i++) {
                String fileName = "loading-" + String.valueOf(i + 1) + " (dragged)";
                loadingImage[i] = loading.findRegion(fileName);
            }

            //sets size for loading Icon
            loadingIconLength = epochsGame.worldHeight / 7;

            //initial loading text
            loadingText = "Loading Assets";
        }

        public void loadScreenAssets() {
            if (currentLoading == splashScreen || currentLoading == mainMenuScreen) {
                assetManager.load("audio/background.mp3", Music.class);
                assetManager.load("packedTextures/mainBgsLogos.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/playingBgs.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/settings.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/newMenu.atlas", TextureAtlas.class);
            } else if (currentLoading == gameScreen) {
                assetManager.load("packedTextures/mainBgsLogos.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/playingBgs.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/cards.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/dialogues.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/environmental.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/cultural.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/technological.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/health.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/military.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/overAllStatusImage.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/gameBackgrounds.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/foreground.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/guideDialogues.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/overAllStatusImage.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/environmentalStatus.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/technologicalStatus.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/culturalStatus.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/militaryStatus.atlas", TextureAtlas.class);
                assetManager.load("packedTextures/medicineStatus.atlas", TextureAtlas.class);

                //sounds
                assetManager.load("audio/yearCountSoundEffect.mp3", Sound.class);
                assetManager.load("audio/playing.mp3", Music.class);
                assetManager.load("audio/cardShuffle.mp3", Sound.class);
                assetManager.load("audio/outro.mp3", Sound.class);
                assetManager.load("audio/bg1.mp3", Music.class);
                assetManager.load("audio/bg2.mp3", Music.class);
                assetManager.load("audio/bg3.mp3", Music.class);
                assetManager.load("audio/bg4.mp3", Music.class);
                assetManager.load("audio/bg5.mp3", Music.class);
                assetManager.load("audio/bg6.mp3", Music.class);
                assetManager.load("audio/bg7.mp3", Music.class);
                assetManager.load("audio/bg8.mp3", Music.class);
                assetManager.load("audio/bg9.mp3", Music.class);
                assetManager.load("audio/bg10.mp3", Music.class);

                //create special type of loader for loading fonts
                FileHandleResolver resolver = new InternalFileHandleResolver();
                assetManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
                assetManager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

                // Next, let's define the params and then load our bigger font
                FreetypeFontLoader.FreeTypeFontLoaderParameter heading = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
                heading.fontFileName = "fonts/setbackt.ttf";
                heading.fontParameters.size = 50;
                heading.fontParameters.color = new Color(1, 1, 1, 0.5f);
                heading.fontParameters.borderWidth = 3.6f;
                heading.fontParameters.borderColor = new Color(0,0,0,0.3f);
                assetManager.load("setbackt50.ttf", BitmapFont.class, heading);

                // Next, let's define the params and then load our bigger font
                FreetypeFontLoader.FreeTypeFontLoaderParameter subHeading = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
                subHeading.fontFileName = "fonts/setbackt.ttf";
                subHeading.fontParameters.size = 40;
                subHeading.fontParameters.color = new Color(1, 1, 1, 0.5f);
                subHeading.fontParameters.borderWidth = 3.6f;
                subHeading.fontParameters.borderColor = new Color(0,0,0,0.3f);
                assetManager.load("setbackt40.ttf", BitmapFont.class, subHeading);

                // First, let's define the params and then load our smaller font
                FreetypeFontLoader.FreeTypeFontLoaderParameter mySmallFont = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
                mySmallFont.fontFileName = "fonts/setbackt.ttf";
                mySmallFont.fontParameters.size = 25;
                mySmallFont.fontParameters.color = new Color(1, 1, 1, 0.5f);
                mySmallFont.fontParameters.borderWidth = 3.6f;
                mySmallFont.fontParameters.borderColor = new Color(0,0,0,0.3f);
                assetManager.load("setbackt25.ttf", BitmapFont.class, mySmallFont);

                //load fonts
                FreetypeFontLoader.FreeTypeFontLoaderParameter typewriter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
                typewriter.fontFileName = "fonts/typewcond.otf";
                typewriter.fontParameters.size = 20;
                typewriter.fontParameters.spaceY = 0;
                assetManager.load("typewcond20.otf", BitmapFont.class, typewriter);

                FreetypeFontLoader.FreeTypeFontLoaderParameter greenScreen = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
                greenScreen.fontFileName = "fonts/Greenscr.ttf";
                greenScreen.fontParameters.size = 25;
                greenScreen.fontParameters.spaceY = 0;
                assetManager.load("Greenscr25.ttf", BitmapFont.class, greenScreen);

                FreetypeFontLoader.FreeTypeFontLoaderParameter greenScreen30 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
                greenScreen30.fontFileName = "fonts/Greenscr.ttf";
                greenScreen30.fontParameters.size = 35;
                greenScreen30.fontParameters.spaceY = 0;
                assetManager.load("Greenscr30.ttf", BitmapFont.class, greenScreen30);

                FreetypeFontLoader.FreeTypeFontLoaderParameter greenScreen20 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
                greenScreen20.fontFileName = "fonts/typewcond.otf";
                greenScreen20.fontParameters.size = 20;
                assetManager.load("Greenscr20.ttf", BitmapFont.class, greenScreen20);


            } else if (currentLoading == endScreen) {
                switch (epochsGame.gameScreen.endingScenario) {
                    case 1:
                        assetManager.load("audio/environmental.mp3", Music.class);
                        break;
                    case 2:
                        assetManager.load("audio/technology.mp3", Music.class);
                        break;
                    case 3:
                        assetManager.load("audio/cultural.mp3", Music.class);
                        break;
                    case 4:
                        assetManager.load("audio/military.mp3", Music.class);
                        break;
                    case 5:
                        assetManager.load("audio/medicine.mp3", Music.class);
                        break;
                    case 6:
                        assetManager.load("audio/neutral.mp3", Music.class);
                        break;
                    case 7:
                        assetManager.load("audio/bad.mp3", Music.class);
                        break;
                }
                assetManager.load("packedTextures/endingScreen.atlas", TextureAtlas.class);
            }
        }

        public void loadAssets() {
            //atlas files
            assetManager.load("packedTextures/cards.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/dialogues.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/playingBgs.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/settings.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/overAllStatusImage.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/gameBackgrounds.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/environmentalStatus.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/culturalStatus.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/technologicalStatus.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/militaryStatus.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/medicineStatus.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/foreground.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/endingScreen.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/guideDialogues.atlas", TextureAtlas.class);

            //atlas for dialogues
            assetManager.load("packedTextures/cultural.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/environmental.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/health.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/technological.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/military.atlas", TextureAtlas.class);

            //music files
            assetManager.load("audio/background.mp3", Music.class);
            assetManager.load("audio/playing.mp3", Music.class);
            assetManager.load("audio/bad.mp3", Music.class);
            assetManager.load("audio/cultural.mp3", Music.class);
            assetManager.load("audio/medicine.mp3", Music.class);
            assetManager.load("audio/military.mp3", Music.class);
            assetManager.load("audio/neutral.mp3", Music.class);
            assetManager.load("audio/technology.mp3", Music.class);
            assetManager.load("audio/environmental.mp3", Music.class);

            //sound files
            assetManager.load("audio/cardShuffle.mp3", Sound.class);
            assetManager.load("audio/tick.mp3", Sound.class);
            assetManager.load("audio/yearCountSoundEffect.mp3", Sound.class);
            assetManager.load("audio/outro.mp3", Sound.class);

            //Font files
            loadFonts();
        }

        public void unloadElements() {

        }

        public void loadFonts() {
            //create special type of loader for loading fonts
            FileHandleResolver resolver = new InternalFileHandleResolver();
            assetManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
            assetManager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

            // First, let's define the params and then load our smaller font
            FreetypeFontLoader.FreeTypeFontLoaderParameter mySmallFont = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
            mySmallFont.fontFileName = "fonts/setbackt.ttf";
            mySmallFont.fontParameters.size = 25;
            mySmallFont.fontParameters.color = new Color(1, 1, 1, 0.5f);
            mySmallFont.fontParameters.borderWidth = 3.6f;
            mySmallFont.fontParameters.borderColor = new Color(0,0,0,0.3f);
            assetManager.load("setbackt25.ttf", BitmapFont.class, mySmallFont);


            // Next, let's define the params and then load our bigger font
            FreetypeFontLoader.FreeTypeFontLoaderParameter subHeading = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
            subHeading.fontFileName = "fonts/setbackt.ttf";
            subHeading.fontParameters.size = 40;
            subHeading.fontParameters.color = new Color(1, 1, 1, 0.5f);
            subHeading.fontParameters.borderWidth = 3.6f;
            subHeading.fontParameters.borderColor = new Color(0,0,0,0.3f);
            assetManager.load("setbackt40.ttf", BitmapFont.class, subHeading);

            // Next, let's define the params and then load our bigger font
            FreetypeFontLoader.FreeTypeFontLoaderParameter heading = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
            heading.fontFileName = "fonts/setbackt.ttf";
            heading.fontParameters.size = 50;
            heading.fontParameters.color = new Color(1, 1, 1, 0.5f);
            heading.fontParameters.borderWidth = 3.6f;
            heading.fontParameters.borderColor = new Color(0,0,0,0.3f);
            assetManager.load("setbackt50.ttf", BitmapFont.class, heading);

            FreetypeFontLoader.FreeTypeFontLoaderParameter greenScreen = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
            greenScreen.fontFileName = "fonts/Greenscr.ttf";
            greenScreen.fontParameters.size = 25;
            greenScreen.fontParameters.spaceY = 0;
            assetManager.load("Greenscr25.ttf", BitmapFont.class, greenScreen);

            FreetypeFontLoader.FreeTypeFontLoaderParameter greenScreen30 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
            greenScreen30.fontFileName = "fonts/Greenscr.ttf";
            greenScreen30.fontParameters.size = 35;
            greenScreen30.fontParameters.spaceY = 0;
            assetManager.load("Greenscr30.ttf", BitmapFont.class, greenScreen30);

            //load fonts
            FreetypeFontLoader.FreeTypeFontLoaderParameter typewriter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
            typewriter.fontFileName = "fonts/typewcond.otf";
            typewriter.fontParameters.size = 20;
            typewriter.fontParameters.spaceY = 0;
            assetManager.load("typewcond20.otf", BitmapFont.class, typewriter);

            FreetypeFontLoader.FreeTypeFontLoaderParameter greenScreen20 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
            greenScreen20.fontFileName = "fonts/typewcond.otf";
            greenScreen20.fontParameters.size = 20;
            assetManager.load("Greenscr20.ttf", BitmapFont.class, greenScreen20);
        }

        @Override
        public void show() {
            if (currentLoading != splashScreen) {
                loadScreenAssets();
            }
        }

        @Override
        public void render(float delta) {
            ScreenUtils.clear(new Color(0x221843FF));
            timer+= delta;
            loadingText = "Loading Assets " + Math.round(epochsGame.assetManager.getProgress() * 100) + "%";
            if (epochsGame.assetManager.update()) {
                if (currentLoading == splashScreen) {
                    loadingText = "Launching Epoch's End";
                } else if (currentLoading == gameScreen) {
                    loadingText = "Preparing the game";
                } else if (currentLoading == endScreen) {
                    loadingText = "Analyzing your decisions";
                }
                timerNext += delta;
                if (timerNext >= launchDelay) {
//                    epochsGame.splashScreen = new SplashScreen(epochsGame);
//                    epochsGame.setScreen(epochsGame.splashScreen);
                    debug();
                    dispose();
                    timerNext = 0;
                }
            }

            if (timer >= 1f / 36f) {
                currentLoadingIndex++;
                if (currentLoadingIndex >= 36) {
                    currentLoadingIndex = 0;
                }
                timer = 0;
            }


            //setup viewport and camera
            camera.update();
            backgroundViewport.apply();
            batch.setProjectionMatrix(camera.combined);

            //begin draw
            batch.begin();
            batch.end();

            //change viewport to avoid stretch
            viewport.apply();
            batch.setProjectionMatrix(camera.combined);

            batch.begin();
            batch.draw(loadingLogo, 0, 0, epochsGame.worldWidth, epochsGame.worldHeight);
            batch.draw(loadingImage[currentLoadingIndex], epochsGame.worldWidth / 2 - loadingIconLength / 2, epochsGame.worldHeight / 6, loadingIconLength, loadingIconLength);
            mainFont.draw(batch, loadingText, epochsGame.worldWidth / 2, epochsGame.worldHeight / 6, 0, Align.center, false);
            batch.end();
        }

        @Override
        public void resize(int width, int height) {
            backgroundViewport.update(width, height, true);
            viewport.update(width, height, true);
        }

        @Override
        public void pause() {

        }

        @Override
        public void resume() {

        }

        @Override
        public void hide() {

        }

        @Override
        public void dispose() {

        }
    }
