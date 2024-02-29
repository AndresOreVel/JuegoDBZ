package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import helpers.AssetManager;
import helpers.InputHandler;
import objects.Goku;
import objects.ScrollHandler;
import utils.Settings;

public class GameScreen implements Screen {

    private Stage stage;
    private Goku goku;
    private ScrollHandler scrollHandler;

    //Representación de figuras geométricas
    private ShapeRenderer shapeRenderer;
    //Para obtener el batch del stage
    private Batch batch;
    //Control de game over
    private boolean gameOver = false;
    //Para controlar la animación de la explosión
    private float explosionTime = 0;

    public GameScreen(){
        //Creo el shaperender
        shapeRenderer = new ShapeRenderer();
        //Creo la cámara de las dimensiones del juego
        OrthographicCamera camera = new OrthographicCamera(Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        //Pongo el parámetro a true para hacer servir el sistema de coordenadas Y-Down
        camera.setToOrtho(true);
        //Creo el viewport con las mismas dimensiones que la cámara
        StretchViewport viewport = new StretchViewport(Settings.GAME_WIDTH, Settings.GAME_HEIGHT, camera);

        //Creo el Stage
        stage = new Stage(viewport);
        batch = stage.getBatch();

        //Creo a Goku y el resto de objetos
        goku = new Goku(Settings.GOKU_STARTX, Settings.GOKU_STARTY, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        scrollHandler = new ScrollHandler();

        //Añado los actores al Stage
        stage.addActor(scrollHandler);
        stage.addActor(goku);
        goku.setName("goku");

        //Inicio la música
        AssetManager.music.play();

        //Asigno como gestor de entrada la clase InputHandler
        Gdx.input.setInputProcessor(new InputHandler(this));
    }

    private void drawElements(){

    }

    @Override
    public void show() {

    }

    public Stage getStage() {
        return stage;
    }

    public Goku getGoku() {
        return goku;
    }

    public ScrollHandler getScrollHandler() {
        return scrollHandler;
    }

    @Override
    public void render(float delta) {
        if(!gameOver){
            stage.draw();
            stage.act(delta);

        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
