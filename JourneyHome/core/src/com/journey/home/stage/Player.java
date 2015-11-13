package com.journey.home.stage;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.journey.home.JourneyHome;

public class Player extends Actor {
    private final JourneyHome game;
    private float WIDTH;
    private float HEIGHT;
    private final float VEL_X = 1f;
    private final float VEL_Y = 1f;

    private float a = 0;

    boolean leftMove;
    boolean rightMove;
    boolean touched;
    boolean leftTilt;
    boolean rightTilt;
    boolean movingUp;
    private MyInputProcessor myInputProcessor;

    private Application.ApplicationType appType = Gdx.app.getType();

    private Texture texture;

    public Player(JourneyHome game) {
        this.game = game;
        myInputProcessor = new MyInputProcessor(this);
        WIDTH = 4;
        HEIGHT = 4;

        System.out.println("W: " + WIDTH + " H: " + HEIGHT);
        setX(game.VIRTUAL_WIDTH / 2 - WIDTH / 2);
        setY(0);
        texture = new Texture("alien.png");
        setBounds(getX(), getY(), WIDTH, HEIGHT);
        game.camera.position.set(game.VIRTUAL_WIDTH / 2, getY(), 0);
        game.camera.update();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), WIDTH, HEIGHT);
    }

    @Override
    public void act(float delta) {
        updateMotion();
        super.act(delta);
    }


    public void updateMotion() {

        if (movingUp) {
            game.camera.position.set(game.VIRTUAL_WIDTH / 2, getY(), 0);
        }

        if (appType == Application.ApplicationType.Android || appType == Application.ApplicationType.iOS) {
            myInputProcessor.tiltLeft();
            myInputProcessor.tiltRight();
            if (leftTilt) {
                setX(getX() - 1 / 10f);
            }

            if (rightTilt) {
                setX(getX() + 1 / 10f);
            }
        } else {
            if (leftMove) {
                setX(getX() - 1 / 10f);
            }

            if (rightMove) {
                setX(getX() + 1/ 10f);
            }
        }

        if (touched) {
            setY(getY() + 1/10f);
        }
    }

    public void setLeftMove(boolean t) {
        if (rightMove && t) {
            rightMove = false;
        }
        leftMove = t;
    }

    public void setTouched(boolean t) {
        touched = t;
    }

    public void setLeftTilt(boolean t) {
        leftTilt = t;
    }

    public void setRightTilt(boolean t) {
        rightTilt = t;
    }

    public void setMovingUp(boolean t) {
        movingUp = t;
    }
}
