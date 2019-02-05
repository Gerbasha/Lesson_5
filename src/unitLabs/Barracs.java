package unitLabs;

import fighters.Cheeter;
import fighters.DragonRider;
import fighters.Elemental;
import fighters.base.Warrior;
import utilites.Helper;

import java.util.Random;

import static utilites.Elements.*;

public class Barracs {
    static String[] fightgerClases = {"dragon", "dragonrider", "elemental", "vampire", "ancient", "cheeter", "darkknight", "holyknight", "knight"};
    static boolean isCheaterCreated;

    public static Warrior getNewFighter() {

        Random selectFighterClass = Helper.getRandomHelper();
        boolean finish = false;
        int selector;
        do {
            selector = (int) Math.abs(selectFighterClass.nextGaussian() * 10) % 2;
            if ((fightgerClases[selector] == "cheeter") && isCheaterCreated) finish = true;
            else if (fightgerClases[selector] == "cheeter") isCheaterCreated = true;
            else finish = false;
        } while (finish);

        return creatrNewFighter(fightgerClases[selector]);
    }

    public static int createElementTalant() {

        int result = 0;
        int talant = (int) (Math.abs(Helper.getRandomHelper().nextGaussian() * 10)) % 4;
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

    private static Warrior creatrNewFighter(String fightgerClase) {
        Warrior instance = null;


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
