package abilitys.markers;

import fighters.base.Warrior;

public interface FighterClassAbilitys {
    // третим параметром ложим callback
    void useAbilitys(Warrior user, Warrior acceptor);
}
