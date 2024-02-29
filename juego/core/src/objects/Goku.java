package objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import com.badlogic.gdx.math.Rectangle;

import helpers.AssetManager;
import utils.Settings;

public class Goku extends Actor {
    public static final int GOKU_STRAIGHT = 0;
    public static final int GOKU_UP = 1;
    public static final int GOKU_DOWN = 2;
    private Vector2 position;
    private int width, height;
    private int direction;
    private Rectangle collisionRect;

    public Vector2 getPosition(){
        return position;
    }

    public Goku(float x, float y, int width, int height) {
        this.points = 0;
        this.lives = 3;
        position = new Vector2(x,y);
        this.width = width;
        this.height = height;
        //Inicializo el personaje al estado normal
        direction = GOKU_STRAIGHT;

        //Creo el rectángulo de colisiones
        collisionRect = new Rectangle();
    }

    public void act(float delta){
        //Muevo a Goku dependiendo de la dirección controlando que no se salga de la pantalla
        switch (direction){
            case GOKU_UP:
                if(this.position.y - Settings.GOKU_VELOCITY * delta >= 0){
                    this.position.y -= Settings.GOKU_VELOCITY * delta;
                }
                break;
            case GOKU_DOWN:
                if(this.position.y + height + Settings.GOKU_VELOCITY * delta <= Settings.GAME_HEIGHT){
                    this.position.y += Settings.GOKU_VELOCITY * delta;
                }
                break;
            case GOKU_STRAIGHT:
                break;
        }
        collisionRect.set(position.x, position.y + 3, width, 10);
    }

    public TextureRegion getGokuTexture(){
        switch (direction){
            //case GOKU_STRAIGHT:
                //return AssetManager.gokuTexture;
            case GOKU_UP:
                return AssetManager.gokuTextureUp;
            case GOKU_DOWN:
                return AssetManager.gokuTextureDown;
            default:
                return AssetManager.gokuTexture;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(getGokuTexture(), position.x, position.y, width, height);
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

    public boolean isGameOver() {
        return gameOver;
    }

    @Override
    public float getX() {
        return position.x;
    }

    @Override
    public float getY() {
        return position.y;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }

    public void goUp(){
        direction = GOKU_UP;
    }

    public void goDown(){
        direction = GOKU_DOWN;
    }

    public void goStraight(){
        direction = GOKU_STRAIGHT;
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

}
