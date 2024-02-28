package utils;

import com.badlogic.gdx.Game;

import helpers.AssetManager;

public class DBZRace extends Game {

    @Override
    public void create() {
        //Al iniciar el juego cargo los recursos
        AssetManager.load();
        //Defino la pantalla principal como la pantalla
    }
}
