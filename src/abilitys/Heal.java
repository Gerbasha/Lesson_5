package abilitys;


import abilitys.markers.OnPostRoundPhaseAction;
import fighters.base.Warrior;

public class Heal implements FighterClassAbilitys, OnPostRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {
        if (user.getCurrentHelth()<user.getHelth())
            System.out.println("used heal"+(user.getHelth()-user.getCurrentHelth())/2);
            user.setCurrentHelth((user.getHelth()-user.getCurrentHelth())/2);
    }
}
