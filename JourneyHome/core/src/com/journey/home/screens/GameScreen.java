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
    private float unitScale;
    private TiledMap map;
    private OrthographicCamera tiledMapCam;

    public GameScreen(JourneyHome game) {
        unitScale = 10;
        this.game = game;
        tiledMapCam = new OrthographicCamera(game.viewport.getScreenWidth(), game.viewport.getScreenHeight());
        tiledMapCam.setToOrtho(false, game.VIRTUAL_WIDTH, game.VIRTUAL_HEIGHT);
        tiledMapCam.update();

        mainStage = new MainStage(game);
        map = new TmxMapLoader().load("TestMap.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, unitScale);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        tiledMapCam.position.set(Gdx.graphics.getWidth() / 2, mainStage.getPlayerY() * 10, 0);
        tiledMapCam.update();
        System.out.println(tiledMapCam.viewportHeight);

        renderer.setView(tiledMapCam);
        renderer.render();

        renderer.getBatch().setProjectionMatrix(tiledMapCam.combined);
        mainStage.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        game.resize(width, height);
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
