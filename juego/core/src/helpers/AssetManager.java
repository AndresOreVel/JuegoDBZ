package helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetManager {
    //Hoja del Sprite
    public static Texture sheet; //Medidas sheet 584 ancho x 405 alto
    public static TextureRegion gokuTexture, gokuTextureUp, gokuTextureDown, beansTexture, burnsTexture, backgroundTexture;
    public static Sound beansCollectSound, burnsCollectSound;
    public static Animation beansAnim;
    public static Music music;

    public static void load(){
        //Defino la imagen que utilizaré
        sheet = new Texture(Gdx.files.internal("sheet.png"));
        sheet.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        //*****************TEXTURAS************
        //Fondo de pantalla
        backgroundTexture = new TextureRegion(sheet, 0, 177, 480, 135);

        //Texturas de Goku
        gokuTexture = new TextureRegion(sheet, 0, 300, 50,50);
        gokuTextureUp = new TextureRegion(sheet, 50,204, 50,50);
        gokuTextureDown = new TextureRegion(sheet, 60, 300, 50, 50);

        //Textura de alubias
        beansTexture = new TextureRegion(sheet, 500, 204, 50, 25);

        //Textura de Ráfagas
        burnsTexture = new TextureRegion(sheet, 390, 300, 60, 20);

        //Creo la animación de las beans y hago que se ejecute en sentido antihorario
        beansAnim = new Animation(0.05f, beansTexture);
        beansAnim.setPlayMode(Animation.PlayMode.LOOP_REVERSED);

        //*****************SONIDOS************
        beansCollectSound = Gdx.audio.newSound(Gdx.files.internal("beanSound.mp3"));
        burnsCollectSound = Gdx.audio.newSound(Gdx.files.internal("hit.mp3"));

        music = Gdx.audio.newMusic(Gdx.files.internal("SuperSurvivor.mp3"));
        music.setVolume(0.9f);
        music.setLooping(true);
    }

    public static void dispose(){
        sheet.dispose();
        music.dispose();
        beansCollectSound.dispose();
        burnsCollectSound.dispose();
    }
}
