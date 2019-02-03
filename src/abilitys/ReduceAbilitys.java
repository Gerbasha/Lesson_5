package abilitys;


import abilitys.markers.FighterClassAbilitys;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.Cheeter;
import fighters.base.Warrior;

public class ReduceAbilitys implements FighterClassAbilitys, OnPreRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {

        if (acceptor.getAbilities()!=null & !(acceptor.getAbilities()instanceof VoidAbilitys))
        {
            Cheeter cheeter = (Cheeter)user;
            System.out.println("Enemy abilities are down by "+user.getName());
            acceptor.setAbilities(cheeter.getVoidAbilitys(acceptor));
        }
    }
}
