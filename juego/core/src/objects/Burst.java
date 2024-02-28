package objects;

import com.badlogic.gdx.math.Circle;

import utils.Methods;

public class Burst extends Scrollable {

    private float runTime;
    private Circle collisionBurstCircle;

    public Burst(float x, float y, float width, float height, float velocity) {
        super(x, y, width, height, velocity);
        runTime = Methods.randomFloat(0,1);

        //Creo el círculo
        collisionBurstCircle = new Circle();
    }
}
