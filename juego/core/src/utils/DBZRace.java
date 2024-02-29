package utils;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import helpers.AssetManager;
import screens.GameScreen;

public class DBZRace extends Game {

    @Override
    public void create() {
        //Al iniciar el juego cargo los recursos
        AssetManager.load();
        //Defino la pantalla principal como la pantalla
        setScreen(new GameScreen());
        Gdx.app.log("LifeCycle", "create()");
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        Gdx.app.log("LifeCycle", "resize(" + Integer.toString(width) + ", " + Integer.toString(height) + ")");
    }

    @Override
    public void pause() {
        super.pause();
        Gdx.app.log("LifeCycle", "pause()");
    }

    @Override
    public void resume() {
        super.resume();
        Gdx.app.log("LifeCycle", "resume()");
    }

    @Override
    public void render() {
        super.render();
        Gdx.app.log("LifeCycle", "render()");
    }


    @Override
    public void dispose() {
        super.dispose();
        AssetManager.dispose();
        Gdx.app.log("LifeCycle", "dispose()");
    }
}
