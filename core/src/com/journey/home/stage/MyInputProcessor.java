package com.journey.home.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class MyInputProcessor extends InputAdapter {
    private Player player;

    public MyInputProcessor(Player player) {
        this.player = player;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT || pointer == 0) {
            player.setTouched(true);
            player.setMovingUp(true);
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        player.setTouched(false);
        player.setMovingUp(false);
        return true;
    }

    public boolean tiltLeft() {
        if (Gdx.input.getAccelerometerX() > .75) {
            player.setLeftTilt(true);
        } else {
            player.setLeftTilt(false);
        }
        return true;
    }

    public boolean tiltRight() {
        if (Gdx.input.getAccelerometerX() <= -.75) {
            player.setRightTilt(true);
        } else {
            player.setRightTilt(false);
        }
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch(keycode) {
            case Input.Keys.LEFT:
                player.setLeftMove(true);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                player.setLeftMove(false);
                break;
        }
        return true;
    }
}
