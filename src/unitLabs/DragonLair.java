package unitLabs;

import fighters.Dragon;

import java.util.Random;

import static unitLabs.Barracs.createElementTalant;


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

        resurected = new Dragon();
        resurected.setName(d1.getName());
        resurected.setAttak(d1.getAttak());
        resurected.setDeffence(d1.getDeffence());
        resurected.setElements(d1.receiveElements());
        return resurected;
    }


    static Dragon createNewDragon() {
        borned = new Dragon();
        borned.setElements(createElementTalant());
        return borned;
    }
}
