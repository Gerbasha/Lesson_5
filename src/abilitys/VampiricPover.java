package abilitys;

import abilitys.markers.OnPostRoundPhaseAction;
import fighters.base.Fighter;
import fighters.unded.Vampire;

public class VampiricPover implements FighterClassAbility, OnPostRoundPhaseAction {
    @Override
    public void useAbility(Fighter user, Fighter acceptor) {
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
