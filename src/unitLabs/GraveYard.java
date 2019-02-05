package unitLabs;

import fighters.base.Warrior;
import fighters.unded.AncientVampire;
import fighters.unded.Vampire;

class GraveYard {
    private Warrior resurected;
    private static Warrior rised;


    static Warrior createNewUnded(String unded) {
        switch (unded) {
            case "vampire": {
                rised = new Vampire();
                break;
            }
            case "ancient": {
                rised = new AncientVampire();
                break;
            }
        }
        return rised;
    }
}
