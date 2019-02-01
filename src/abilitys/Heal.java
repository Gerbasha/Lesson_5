package abilitys;


import abilitys.markers.OnPostRoundPhaseAction;
import fighters.base.Fighter;

public class Heal implements FighterClassAbility, OnPostRoundPhaseAction {
    @Override
    public void useAbility(Fighter user, Fighter acceptor) {
        if (user.getCurrentHelth()<user.getHelth())
            System.out.println("used heal"+(user.getHelth()-user.getCurrentHelth())/2);
            user.setCurrentHelth((user.getHelth()-user.getCurrentHelth())/2);
    }
}
