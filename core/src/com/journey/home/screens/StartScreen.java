package com.journey.home.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.journey.home.JourneyHome;

public class StartScreen implements Screen {
    private final JourneyHome game;
    private float glyphW;
    private float glyphH;

    public StartScreen(JourneyHome game) {
        this.game = game;
        game.glyphLayout.setText(game.font, "Welcome to my game");
        game.glyphLayout.width = game.VIRTUAL_WIDTH / 2;
        game.glyphLayout.height = game.VIRTUAL_HEIGHT / 4;
        glyphW = game.glyphLayout.width;
        glyphH = game.glyphLayout.height;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.font.draw(game.batch, game.glyphLayout, game.viewport.getScreenWidth() / 2 - glyphW / 2, game.viewport.getScreenHeight() / 2 - glyphH / 2);
        game.batch.end();
        toGame();
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height, true);
        game.camera.update();
        System.out.println("Resize!");
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

    public void toGame() {
        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
        }
    }
}
