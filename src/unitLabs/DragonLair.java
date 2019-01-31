package unitLabs;

import abilitys.ElementsMagic;
import fighters.Dragon;
import fighters.GreatDragon;

import java.util.Random;

import static andrew.honework.com.lesson_5.Elements.*;

/**
 * Created by Андрей on 26.01.2019.
 */
public class DragonLair {
    private Dragon resurected;
    private static Dragon borned;
    private static Random fate;

    DragonLair() {
        fate = new Random();
    }


    GreatDragon ressurectThisDragon(Dragon d1) {

        this.resurected = new Dragon();
        resurected.setName(d1.getName());
        resurected.setAttak(d1.getAttak());
        resurected.setDeffence(d1.getDeffence());
        resurected.setElements(d1.getElements());

        return resurected;
    }


    static GreatDragon createNewDragon() {
        borned = new Dragon();
        borned.setName("generate");
        borned.setHelth();
        borned.setCurrentHelth(borned.helth);
        borned.setAttak();
        borned.setDeffence();
        borned.setElements(DragonLair.createDragonTalant());
        borned.setAbility(new ElementsMagic());
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
