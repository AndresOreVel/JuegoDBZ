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
        backgroundTexture = new TextureRegion(sheet, 0, 200, 583, 200);

        //Texturas de Goku
        gokuTexture = new TextureRegion(sheet, 0, 305, 67,80);
        gokuTextureUp = new TextureRegion(sheet, 76,205, 67,80);
        gokuTextureDown = new TextureRegion(sheet, 136, 305, 67, 80);

        //Textura de alubias
        beansTexture = new TextureRegion(sheet, 500, 202, 70, 40);

        //Textura de Ráfagas
        burnsTexture = new TextureRegion(sheet, 359, 260, 102, 30);

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
