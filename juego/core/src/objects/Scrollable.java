package objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Scrollable extends Actor {
    protected Vector2 position;
    protected float velocity;
    protected float width;
    protected float height;
    protected boolean leftOfScreen;

    public Scrollable(float x, float y, float width, float height, float velocity){
        position = new Vector2(x,y);
        this.velocity = velocity;
        this.width = width;
        this.height = height;
        leftOfScreen = false;
    }

    public void act(float delta){
        //Desplazo el objeto en el eje X
        position.x += velocity * delta;

        //Si se encuentra fuera de la pantalla cambiamos la variable a true
        if(position.x + width < 0){
            leftOfScreen = true;
        }
    }

    public void reset(float newX){

    }
}
