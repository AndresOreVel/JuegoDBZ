package actors;

import com.badlogic.gdx.scenes.scene2d.Actor;

import java.awt.Rectangle;

public class Goku extends Actor {
    public static final int GOKU_STRAIGHT = 0;
    public static final int GOKU_UP = 1;
    public static final int GOKU_DOWN = 2;

    private int points;

    public int getPoints() {
        return points;
    }

    public int getLives() {
        return lives;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    private int lives;
    private boolean gameOver;

    private float x, y;
    private int width, height;
    private int direction;
    private Rectangle collisionRect;


}
