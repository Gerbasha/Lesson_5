package abilitys;

import abilitys.markers.FighterClassAbilitys;
import abilitys.markers.OnPostRoundPhaseAction;
import fighters.base.ElementalFighter;
import fighters.base.Warrior;

public class ElementaHeal implements FighterClassAbilitys, OnPostRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {
        if (acceptor instanceof ElementalFighter) {
            if (((((ElementalFighter) user).receiveElements()) ^ (((ElementalFighter) acceptor).receiveElements())) > 0) {
                float addHP = ((ElementalFighter) acceptor).receiveCurrentAttack() * user.getDeffence() * 2;
                user.setCurrentHelth(((user.getCurrentHelth() + addHP)>=user.getHelth())
                        ?user.getHelth():(user.getCurrentHelth() + addHP));
                System.out.println("Elemental heal retrive " + addHP + " HP");
            }
        }
    }
}
