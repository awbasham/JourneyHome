package com.journey.home.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.journey.home.JourneyHome;

public class MainStage extends Stage {

    private MyInputProcessor myInputProcessor;
    private Player player;
    private JourneyHome game;

    private Stage stage;

    public MainStage(JourneyHome game) {
        this.game = game;
        stage = new Stage(game.viewport);
        player = new Player(game);
        myInputProcessor = new MyInputProcessor(player);
        Gdx.input.setInputProcessor(myInputProcessor);

        stage.addActor(player);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw() {
        super.draw();
    }

    public void render(float delta) {

        stage.act(delta);
        stage.draw();
    }

    public void resize(int width, int height) {
        game.resize(width, height);
    }

    public float getPlayerY() {
        return player.getY();
    }
}
