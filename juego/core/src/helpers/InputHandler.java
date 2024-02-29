package helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import objects.Goku;
import screens.GameScreen;

public class InputHandler implements InputProcessor {

    //Objetos necesarios
    private Goku goku;
    private GameScreen screen;

    //Enter para la gestión del movimiento de arrastre
    int previousY = 0;

    public InputHandler(GameScreen screen){
        //Obtengo todos los elementos necesarios
        this.screen = screen;
        this.goku = screen.getGoku();
    }
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.DOWN){
            goku.goDown();
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.UP){
            goku.goUp();
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //Cuando dejo de tocar la pantalla pongo el personaje en estado normal
        goku.goStraight();
        return true;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //Pongo un lindar para evitar gestionar eventos cuando el dedo está quieto
        if(Math.abs(previousY - screenY) > 2){
            //Si la Y es mayor que la que tengo guardada es que va para abajo
            if(previousY < screenY){
                goku.goDown();
            }else {
                //En caso contrario hacia arriba
                goku.goUp();
            }
            //Guardo la posición de la Y
            previousY = screenY;
        }
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
