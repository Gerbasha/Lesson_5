package abilitys;


import abilitys.markers.FighterClassAbilitys;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.base.Warrior;
import fighters.knights.Knight;
import utilites.Helper;

public class Shield implements FighterClassAbilitys, OnPreRoundPhaseAction {
    @Override
    public  void useAbilitys(Warrior user, Warrior acceptor) {
        ((Knight)user).setShielded(false);
        if (((Knight)user).getShild()<Helper.getRandomHelper().nextGaussian()) ((Knight)user).setShielded(true);
    }
}
