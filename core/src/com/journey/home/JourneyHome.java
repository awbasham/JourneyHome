package com.journey.home;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.journey.home.screens.StartScreen;

public class JourneyHome extends Game {
	public final float VIRTUAL_WIDTH = 18;
	public final float VIRTUAL_HEIGHT = 32;
    public final float ASPECT_RATIO = VIRTUAL_HEIGHT / VIRTUAL_WIDTH;
	float gravity = -9.81f;

	public Viewport viewport;
	public OrthographicCamera camera;
	public SpriteBatch batch;
    public GlyphLayout glyphLayout;
    public BitmapFont font;

	@Override
	public void create() {
        font = new BitmapFont();
        glyphLayout = new GlyphLayout();
		batch = new SpriteBatch();

		camera = new OrthographicCamera();
        camera.setToOrtho(false); //Makes 0,0 bottom left
        batch.setProjectionMatrix(camera.combined);

		viewport = new FitViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
        viewport.apply();

		this.setScreen(new StartScreen(this));
	}

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        camera.update();
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
