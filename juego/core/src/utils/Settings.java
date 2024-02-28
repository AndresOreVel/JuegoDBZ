package utils;

public class Settings {
    //Medida del juego
    public static final int GAME_WIDTH = 240; //Ancho de pantalla
    public static final int GAME_HEIGHT = 135; //Alto de pantalla

    //Propiedades del personaje
    public static final float GOKU_VELOCITY = 50; //Velocidad del personaje
    public static final int GOKU_WIDTH = 36; //Ancho del personaje
    public static final int GOKU_HEIGHT = 15; //Altura del personaje
    public static final int GOKU_STARTX = 20; //Posición de inicio en el eje X
    public static final int GOKU_STARTY = GAME_HEIGHT/2 - GOKU_HEIGHT /2; //Posición de inicio en el eje Y

    //Rango de valores para la medida de las ráfagas
    public static final float MAX_BURST = 1.5f;
    public static final float MIN_BURST = 0.5f;

    //Configuración del Scrollable
    public static final int BURST_SPEED = -150;
    public static final int BURST_GAP = 75;
    public static final int BG_SPEED = -100;
}
