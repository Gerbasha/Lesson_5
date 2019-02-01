package unitLabs;

import fighters.Cheeter;
import fighters.DragonRider;
import fighters.Elemental;
import fighters.base.Fighter;
import utilites.Helper;

import java.util.Random;

public class Barracs {
    static String[] fightgerClases = {"elemental","vampire","ancient","cheeter", "darkknight", "dragon", "dragonrider", "holyknight", "knight"};
    static boolean isCheaterCreated;

    public static Fighter getNewFighter() {

        Random selectFighterClass = Helper.getRandomHelper();
        boolean finish = false;
        int selector;
        do {
            selector = (int) Math.abs(selectFighterClass.nextGaussian() * 10) % 6;
            if((fightgerClases[selector]=="cheeter")&& isCheaterCreated) finish=true;
            else if (fightgerClases[selector]=="cheeter")isCheaterCreated=true;
            else finish=false;
        }while (finish);

        return creatrNewFighter(fightgerClases[selector]);
    }

    private static Fighter creatrNewFighter(String fightgerClase) {
        Fighter instance = null;


        switch (fightgerClase) {
            case "cheeter": {
                instance = new Cheeter();
                break;
            }
            case "darkknight": {
                instance = Academy.createNewWarrior(fightgerClase);
                break;
            }
            case "dragon": {
                instance = DragonLair.createNewDragon();
                break;
            }
            case "dragonrider": {
                instance = new DragonRider();
                break;
            }
            case "holyknight": {
                instance = Academy.createNewWarrior(fightgerClase);
                break;
            }
            case "knight": {
                instance = Academy.createNewWarrior(fightgerClase);
                break;
            }
            case "elemental": {
                instance = new Elemental();
                break;
            }
            case "vampire": {
                instance = GraveYard.createNewUnded(fightgerClase);
                break;
            }
            case "ancient": {
                instance = GraveYard.createNewUnded(fightgerClase);
                break;
            }
        }
        return instance;
    }
}
