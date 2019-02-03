package abilitys;

import abilitys.markers.OnPreRoundPhaseAction;
import fighters.base.ElementalFighter;
import fighters.base.Warrior;
import fighters.unded.AncientVampire;

import static unitLabs.Barracs.createElementTalant;

public class ReceiveElement implements FighterClassAbilitys, OnPreRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {
        ((ElementalFighter)user).changeAtackModyfier(0);
        System.out.println("receive new element");
        if (user instanceof AncientVampire)
            ((AncientVampire) user).setElement(createElementTalant());
        int multiplyer = 0;
        int element = 0b1000;
        if (acceptor instanceof ElementalFighter) {
            int resistBonus = ((ElementalFighter) acceptor).receiveElements();
            for (int i = 0; i < 4; i++) {
                multiplyer += ((((ElementalFighter) acceptor).receiveElements() & element) == element) ?
                        (1 - (((resistBonus & element) == element) ? 1 : 0)) : 0;
                element >>= 1;
            }
            ((AncientVampire) user).setAtackModifier(user.getAttak()*multiplyer);
        } else {
            float newAtack = ((AncientVampire) user).getAttak();
            ((AncientVampire) user).setAtackModifier(newAtack * 2);
        }


    }
}
