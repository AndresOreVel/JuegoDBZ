package objects;

import com.badlogic.gdx.graphics.g2d.Batch;

import helpers.AssetManager;

public class Background extends Scrollable{
    public Background(float x, float y, float width, float height, float velocity) {
        super(x, y, width, height, velocity);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.disableBlending();
        batch.draw(AssetManager.backgroundTexture, position.x, position.y, width, height);
        batch.enableBlending();
    }
}
