package abilitys;

import abilitys.markers.FighterClassAbilitys;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.Dragon;
import fighters.base.ElementalFighter;
import fighters.base.Warrior;

public class ElementsMagic implements FighterClassAbilitys, OnPreRoundPhaseAction {

    public void useAbilitys(Warrior user, Warrior acceptor) {
        ((ElementalFighter) user).changeAtackModyfier(0);
        System.out.println("used elemental magic");
        Dragon dragon = (Dragon) user;
        int multiplyer = 0;
        int element = 0b1000;
        if (acceptor instanceof ElementalFighter) {
            int resistBonus = ((ElementalFighter) acceptor).receiveElements();
            for (int i = 0; i < 4; i++) {
                multiplyer += ((dragon.receiveElements() & element) == element) ?
                        (1 - (((resistBonus & element) == element) ? 1 : 0)) : 0;
                element >>= 1;
            }
        } else {
            for (int i = 0; i < 4; i++) {
                multiplyer += ((dragon.receiveElements() & element) == element) ? 1 : 0;
                element >>= 1;
            }
            dragon.changeAtackModyfier(dragon.getAttak() * multiplyer);
        }

    }
}
