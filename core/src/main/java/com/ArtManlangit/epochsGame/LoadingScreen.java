    package com.ArtManlangit.epochsGame;

    import com.badlogic.gdx.Screen;
    import com.badlogic.gdx.assets.AssetManager;
    import com.badlogic.gdx.audio.Music;
    import com.badlogic.gdx.audio.Sound;
    import com.badlogic.gdx.graphics.Camera;
    import com.badlogic.gdx.graphics.Texture;
    import com.badlogic.gdx.graphics.g2d.Batch;
    import com.badlogic.gdx.graphics.g2d.Sprite;
    import com.badlogic.gdx.graphics.g2d.SpriteBatch;
    import com.badlogic.gdx.graphics.g2d.TextureAtlas;
    import com.badlogic.gdx.graphics.g2d.TextureRegion;
    import com.badlogic.gdx.utils.viewport.Viewport;

    public class LoadingScreen implements Screen {
        //access to epochsGame and the main assetManager
        EpochsGame epochsGame;
        AssetManager assetManager;

        //viewport and camera
        Viewport viewport;
        Camera camera;

        //textures for assets in the loading screen
        TextureAtlas mainBgsLogos;
        TextureRegion loadingLogo;

        //drawer
        SpriteBatch batch;

        public LoadingScreen(EpochsGame epochsGame) {
            //initialize variables
            this.epochsGame = epochsGame;
            this.assetManager = epochsGame.assetManager;
            viewport = epochsGame.viewport;
            camera = epochsGame.camera;
            batch = epochsGame.batch;

            //load and setup assets for loading first
            loadLoadingAssets();

            //load all assets
            loadAssets();
        }

        public void loadLoadingAssets() {
            assetManager.load("packedTextures/mainBgsLogos.atlas", TextureAtlas.class);
            assetManager.finishLoading();
            mainBgsLogos = assetManager.get("packedTextures/mainBgsLogos.atlas", TextureAtlas.class);
            loadingLogo = mainBgsLogos.findRegion("logo(portrait)");
        }

        public void loadAssets() {
            //atlas files
            assetManager.load("packedTextures/cards.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/dialogues.atlas", TextureAtlas.class);
            assetManager.load("packedTextures/playingBgs.atlas", TextureAtlas.class);

            //music files
            assetManager.load("audio/background.mp3", Music.class);
            assetManager.load("audio/playing.mp3", Music.class);

            //sound files
            assetManager.load("audio/cardShuffle.mp3", Sound.class);
            assetManager.load("audio/tick.mp3", Sound.class);
            assetManager.load("audio/yearCountSoundEffect.mp3", Sound.class);

        }

        @Override
        public void show() {

        }

        @Override
        public void render(float delta) {
            if (epochsGame.assetManager.update()) {
                System.out.println("done");
                epochsGame.splashScreen = new SplashScreen(epochsGame);
                epochsGame.setScreen(epochsGame.splashScreen);
                dispose();
            } else {

                //setup viewport and camera
                camera.update();
                viewport.apply();
                batch.setProjectionMatrix(camera.combined);

                //begin draw
                batch.begin();
                batch.draw(loadingLogo, 0, 0, epochsGame.worldWidth, epochsGame.worldHeight);
                batch.end();
            }
        }

        @Override
        public void resize(int width, int height) {
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
