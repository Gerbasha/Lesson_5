package abilitys;

import abilitys.markers.FighterClassAbilitys;
import abilitys.markers.OnPostRoundPhaseAction;
import fighters.base.Warrior;
import fighters.unded.Vampire;

public class VampiricPover implements FighterClassAbilitys, OnPostRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {
        if (user instanceof Vampire) {
            float modif = acceptor.getThisTurnReceivedDamage();
            if (((user.getCurrentHelth() + modif) > user.getHelth())) {
                System.out.println(user.getName() + " use vampirism. Add " + modif + " HP. "
                        + "Attack increased by " + modif / 2);
                user.setCurrentHelth(user.getHelth());
            } else {
                System.out.println(user.getName() + " use vampirism. Add " +
                        modif + " HP. Attack increased by " + modif / 2);
                user.setCurrentHelth(user.getCurrentHelth() + modif);
            }
            ((Vampire) user).setAtackModifier(modif / 2);
        }

    }
}
