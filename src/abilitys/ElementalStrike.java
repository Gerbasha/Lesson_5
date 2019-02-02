package abilitys;

import fighters.base.ElementalFighter;
import fighters.base.Fighter;

public class ElementalStrike implements FighterClassAbility {
    @Override
    public void useAbility(Fighter user, Fighter acceptor) {
        System.out.println("Used element strike");
        ElementalFighter eFighter = null;
        int multiplyer = 0;
        int element = 0b1000;
        if (acceptor instanceof ElementalFighter) {
            eFighter = (ElementalFighter) acceptor;
            int resistBonus = eFighter.getElements();
            for (int i = 0; i < 4; i++) {
                multiplyer += ((eFighter.getElements() & element) == element) ?
                        (1 - (((resistBonus & element) == element) ? 1 : 0)) : 0;
                element >>= 1;
            }

        } else {
            for (int i = 0; i < 4; i++) {
                multiplyer += ((eFighter.getElements() & element) == element) ? 1 : 0;
                element >>= 1;
            }
        }
        ((ElementalFighter)user).increaseMultyplayAtack(multiplyer>0? 3:1);
    }
}