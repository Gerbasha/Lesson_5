package abilitys;


import abilitys.markers.OnPreRoundPhaseAction;
import fighters.Cheeter;
import fighters.base.Warrior;

public class ReduceAbilitys implements FighterClassAbilitys, OnPreRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {

        if (acceptor.getAbilities()!=null & !(acceptor.getAbilities()instanceof VoidAbilitys))
        {
            System.out.println("abilities reducing");
            Cheeter cheeter = (Cheeter)user;
            System.out.println("Enemy abilitys are down");
            acceptor.setAbilities(cheeter.getVoidAbilitys(acceptor));
        }
    }
}
