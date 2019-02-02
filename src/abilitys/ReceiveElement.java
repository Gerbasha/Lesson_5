package abilitys;

import abilitys.markers.OnPreRoundPhaseAction;
import fighters.base.ElementalFighter;
import fighters.base.Fighter;
import fighters.unded.AncientVampire;

import static unitLabs.Barracs.createElementTalant;

public class ReceiveElement implements FighterClassAbility, OnPreRoundPhaseAction {
    @Override
    public void useAbility(Fighter user, Fighter acceptor) {
        System.out.println("receive new element");
        if (user instanceof AncientVampire)
            ((AncientVampire)user).setElement(createElementTalant());
        if (acceptor instanceof ElementalFighter){

        }else {
            float newAtack = ((AncientVampire)user).getAttak();

            ((AncientVampire)user).setAtackModifier(newAtack*2);
        }




    }
}
