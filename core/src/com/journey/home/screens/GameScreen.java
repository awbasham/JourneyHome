package com.journey.home.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.journey.home.JourneyHome;
import com.journey.home.stage.MainStage;

public class GameScreen implements Screen {

    private final JourneyHome game;
    private MainStage mainStage;
    private OrthogonalTiledMapRenderer renderer;
    private TiledMap map;

    public GameScreen(JourneyHome game) {
        this.game = game;

        mainStage = new MainStage(game);
        map = new TmxMapLoader().load("C:\\Users\\Adam\\Desktop\\JourneyHome\\android\\assets\\TestMap.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setView(game.camera); //bounds of map to be rendered
        renderer.render();

        mainStage.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        mainStage.getViewport().update(width, height, true);
        System.out.println("Resize!");
    }

    @Override
    public void dispose() {

    }

    @Override
    public void show() {

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
}
