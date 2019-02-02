package abilitys;


import abilitys.markers.OnPostRoundPhaseAction;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.Cheeter;
import fighters.base.Fighter;

public class ReduceAbilitys implements FighterClassAbility, OnPreRoundPhaseAction, OnPostRoundPhaseAction {
    @Override
    public void useAbility(Fighter user, Fighter acceptor) {
        System.out.println("abilities reduced");
        if (acceptor.getAbility()!=null)
        {
            Cheeter cheeter = (Cheeter)user;
            System.out.println("Enemy abilitys down");
            acceptor.setAbility(cheeter.getVoidAbility());
        }
    }
}
