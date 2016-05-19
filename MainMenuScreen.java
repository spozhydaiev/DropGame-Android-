package com.drop.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by sergio on 17.02.16.
 */
public class MainMenuScreen implements Screen {

    final Drop game;
    OrthographicCamera camera;
    Texture background;
    Texture playButton;

    public MainMenuScreen(final Drop gam) {
        this.game = gam;

        background = new Texture("rain.jpg");
        playButton = new Texture("playbutton.png");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(background, 0, 0, 800, 480);
        game.font.draw(game.batch, "Catch all drops!", 200, 240);
        game.batch.draw(playButton, (800 / 2) - (playButton.getWidth() / 2), (480 / 2) - (playButton.getHeight() / 2));
        game.batch.end();

        if(Gdx.input.isTouched()){
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

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
