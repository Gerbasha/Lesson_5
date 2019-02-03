package abilitys;

import abilitys.markers.OnPreRoundPhaseAction;
import fighters.base.ElementalFighter;
import fighters.base.Warrior;

public class ElementalStrike implements FighterClassAbilitys, OnPreRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {
        ((ElementalFighter)user).changeAtackModyfier(0);
        System.out.println("Used element strike");
        ElementalFighter eFighter = null;
        int multiplyer = 0;
        int element = 0b1000;
        if (acceptor instanceof ElementalFighter) {
            eFighter = (ElementalFighter) acceptor;
            int resistBonus = eFighter.receiveElements();
            for (int i = 0; i < 4; i++) {
                multiplyer += ((eFighter.receiveElements() & element) == element) ?
                        (1 - (((resistBonus & element) == element) ? 1 : 0)) : 0;
                element >>= 1;
            }

        } else {
            for (int i = 0; i < 4; i++) {
                multiplyer += ((((ElementalFighter)user).receiveElements() & element) == element) ? 1 : 0;
                element >>= 1;
            }
        }
        ((ElementalFighter)user).changeAtackModyfier(multiplyer>0? multiplyer*user.getAttak():0);
    }
}