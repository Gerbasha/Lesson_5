package abilitys;


import abilitys.markers.OnPostRoundPhaseAction;
import fighters.base.Fighter;

public class LifeDrain implements FighterClassAbility , OnPostRoundPhaseAction {
    @Override
    public void useAbility(Fighter user, Fighter acceptor) {
        if( user.getCurrentHelth()<user.getHelth()){
            if (((user.getCurrentHelth() + user.getAttak()* acceptor.getDeffence() / 2) > user.getHelth())) {
                System.out.println("Used darkheal");
                user.setCurrentHelth(user.getHelth());
            } else {
                System.out.println("Used darkheal"+ (user.getAttak() - acceptor.getDeffence()) / 2);
                user.setCurrentHelth((user.getCurrentHelth()+user.getAttak()* acceptor.getDeffence()) / 2);
            }
        }
    }
}
