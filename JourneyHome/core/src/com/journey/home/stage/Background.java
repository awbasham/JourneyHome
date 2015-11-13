package com.journey.home.stage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.journey.home.JourneyHome;

public class Background extends Actor {

    private final JourneyHome game;
    private OrthogonalTiledMapRenderer renderer;
    private float unitScale;
    private TiledMap map;

    public Background(JourneyHome game) {
        this.game = game;
        unitScale = 1/32f;
        map = new TmxMapLoader().load("TestMap.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, unitScale);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        renderer.render();
    }
}
