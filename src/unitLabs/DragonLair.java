package unitLabs;

import fighters.Dragon;

import java.util.Random;

import static utilites.Elements.*;


/**
 * Created by Андрей on 26.01.2019.
 */
public class DragonLair {
    private Dragon resurected;
    private static Dragon borned;
    private static Random fate;

    public DragonLair() {
        fate = new Random();
    }


    Dragon ressurectThisDragon(Dragon d1) {

        this.resurected = new Dragon();
        resurected.setName(d1.getName());
        resurected.setAttak(d1.getAttak());
        resurected.setDeffence(d1.getDeffence());
        resurected.setElements(d1.getElements());

        return resurected;
    }


    static Dragon createNewDragon() {
        borned = new Dragon();
        borned.setElements(createDragonTalant());

        return borned;
    }


    private static int createDragonTalant() {
        fate = new Random();
        int result = 0;
        int talant = (int) (Math.abs(fate.nextGaussian() * 10)) % 4;
        switch (talant) {
            case 0: {
                result = AIR.sign();
                break;
            }
            case 1: {
                result = WATER.sign();
                break;
            }
            case 2: {
                result = EARTH.sign();
                break;
            }
            case 3: {
                result = FIRE.sign();
                break;
            }
        }
        return result;
    }


}
