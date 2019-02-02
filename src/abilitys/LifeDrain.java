package abilitys;


import abilitys.markers.OnPostRoundPhaseAction;
import fighters.base.Warrior;

public class LifeDrain implements FighterClassAbilitys, OnPostRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {
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
