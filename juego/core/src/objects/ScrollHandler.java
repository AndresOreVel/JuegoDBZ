package objects;

import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.ArrayList;
import java.util.Random;

import utils.Methods;
import utils.Settings;

public class ScrollHandler extends Group {
    Background bg, bg_back;
    int numBurst;
    ArrayList<Burst> bursts;

    //Objeto random
    Random r;

    @Override
    public void act(float delta) {
        super.act(delta);
        //Si hay algún elemento que se encuentra fuera de pantalla, hago un reset del elemento
        if(bg.isLeftOfScreen()){
            bg.reset(bg_back.getTailX());
        } else if (bg_back.isLeftOfScreen()) {
            bg_back.reset(bg.getTailX());
        }

        for(int i = 0; i < bursts.size(); i++){
            Burst burst = bursts.get(i);
            if(burst.isLeftOfScreen()){
                if(i==0){
                    burst.reset(bursts.get(bursts.size() - 1).getTailX() + Settings.BURST_GAP);
                }else {
                    burst.reset(bursts.get(i - 1).getTailX() + Settings.BURST_GAP);
                }
            }
        }
    }

    public ScrollHandler(){
        //Creo los 2 fondos
        bg = new Background(0,0, Settings.GAME_WIDTH * 2, Settings.GAME_HEIGHT, Settings.BG_SPEED);
        bg_back = new Background(bg.getTailX(), 0, Settings.GAME_WIDTH * 2, Settings.GAME_HEIGHT, Settings.BG_SPEED);

        //Añado los fondos (actores) al grupo
        addActor(bg);
        addActor(bg_back);

        //Creo el objeto random
        r = new Random();

        //Comienzo con 3 ráfagas
        numBurst = 3;

        //Creo el ArrayList
        bursts = new ArrayList<Burst>();

        //Defino una medida aleatoria entre el mínimo y el máximo
        float newSize = Methods.randomFloat(Settings.MIN_BURST, Settings.MAX_BURST) * 34;

        //Añado la primera ráfaga al array y al grupo
        Burst firsBurst = new Burst(Settings.GAME_WIDTH, r.nextInt(Settings.GAME_HEIGHT - (int) newSize), newSize, newSize, Settings.BURST_SPEED);
        this.bursts.add(firsBurst);
        addActor(firsBurst);

        //Desde el segundo hasta la última ráfaga
        for(int i = 1; i < numBurst; i++){
            //Creo la medida aleatoria
            newSize = Methods.randomFloat(Settings.MIN_BURST, Settings.MAX_BURST) * 34;
            //Añado la ráfaga
            firsBurst = new Burst(this.bursts.get(this.bursts.size() - 1).getTailX() + Settings.BURST_GAP, r.nextInt(Settings.GAME_HEIGHT - (int) newSize), newSize, newSize, Settings.BURST_SPEED);
            //Añado la ráfaga al ArrayList
            bursts.add(firsBurst);
            //Añado la ráfaga al grupo de actores
            addActor(firsBurst);
        }
    }

    public boolean collides(Goku goku){
        for(Burst burst : bursts){

        }
        return false;
    }
}
