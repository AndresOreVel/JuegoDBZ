package objects;

import com.badlogic.gdx.scenes.scene2d.Actor;

import java.awt.Rectangle;

public class Goku extends Actor {
    public static final int GOKU_STRAIGHT = 0;
    public static final int GOKU_UP = 1;
    public static final int GOKU_DOWN = 2;
    private float x, y;
    private int width, height;
    private int direction;
    private Rectangle collisionRect;

    public Goku(float x, float y, int width, int height) {
        this.points = 0;
        this.lives = 3;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.direction = GOKU_STRAIGHT;
        this.collisionRect = new Rectangle();
    }

    private int points;
    private int lives;
    private boolean gameOver;
    public int getPoints() {
        return points;
    }
    public void setPoints (int points){
        this.points = points;
    }

    public int getLives() {
        return lives;
    }

    public void goStraight(){
        direction = GOKU_STRAIGHT;
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

    public void restart(){
        points = 0;
        lives = 3;
    }

    public void hitBurst(){
        lives--;
        if(lives <= 0){
            gameOver = true;
        }
    }

    public void addPoints(int pointsToAdd){
        points += pointsToAdd;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }
}
