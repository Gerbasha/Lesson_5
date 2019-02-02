package abilitys;

import abilitys.markers.OnPostRoundPhaseAction;
import fighters.base.Warrior;
import fighters.unded.Vampire;

public class VampiricPover implements FighterClassAbilitys, OnPostRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {

        if (user instanceof Vampire) {
            if (((user.getCurrentHelth() + user.getAttak() * acceptor.getDeffence()) > user.getHelth())) {
                System.out.println("Used vampirism. Atack incresed by " + user.getAttak() * acceptor.getDeffence() / 2);
                ((Vampire) user).setAtackModifier(user.getAttak() * acceptor.getDeffence() / 2);
                user.setCurrentHelth(user.getHelth());
            } else {
                System.out.println("Used vampirism. Atack incresed by " + user.getAttak() * acceptor.getDeffence() / 2);
                ((Vampire) user).setAtackModifier(user.getAttak() * acceptor.getDeffence() / 2);
                user.setCurrentHelth((user.getCurrentHelth() + user.getAttak() * acceptor.getDeffence()));
            }
        }

    }
}
