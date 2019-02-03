package abilitys;


import fighters.base.Warrior;
import fighters.knights.Knight;
import utilites.Helper;

public class Shield implements FighterClassAbilitys {
    @Override
    public  void useAbilitys(Warrior user, Warrior acceptor) {
        ((Knight)user).setShielded(false);
        if (((Knight)user).getShild()<Helper.getRandomHelper().nextGaussian()) ((Knight)user).setShielded(true);
    }
}
