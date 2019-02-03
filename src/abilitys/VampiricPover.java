package abilitys;

import abilitys.markers.OnPostRoundPhaseAction;
import fighters.base.Warrior;
import fighters.unded.Vampire;

public class VampiricPover implements FighterClassAbilitys, OnPostRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {

        if (user instanceof Vampire) {
            float atackParam =
                    ((Vampire) user).receiveCurrentAttack() + user.getAttak() - user.getAttak() * acceptor.getDeffence();
            if (((user.getCurrentHelth() +
                    atackParam) > user.getHelth())) {
                System.out.println("Used vampirism. Add " +
                        atackParam + " HP. "
                        + "Attack increased by " + atackParam / 2);

                user.setCurrentHelth(user.getHelth());
            } else {
                System.out.println("Used vampirism. Add " +
                        atackParam + " HP. Attack increased by " + atackParam / 2);

                user.setCurrentHelth(user.getCurrentHelth() + atackParam);
            }
            ((Vampire) user).setAtackModifier(atackParam / 2);
        }

    }
}
