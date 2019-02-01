package unitLabs;

import fighters.base.Fighter;
import fighters.unded.AncientVampire;
import fighters.unded.Vampire;

public class GraveYard {
    private Fighter resurected;
    private static Fighter rised;


    static Fighter createNewUnded(String unded) {
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
