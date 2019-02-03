package abilitys;


import abilitys.markers.OnPostRoundPhaseAction;
import fighters.base.Warrior;

public class LifeDrain implements FighterClassAbilitys, OnPostRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {
        if (user.getCurrentHelth() < user.getHelth()) {
            if (((user.getCurrentHelth() + (user.getAttak() - user.getAttak() * acceptor.getDeffence()) / 2) > user.getHelth())) {
                System.out.print("Used lifedrain ");
                user.setCurrentHelth(user.getHelth());
                System.out.println("to "+user.getCurrentHelth()+" HP");
            } else {
                System.out.print("Used lifedrain " + (user.getAttak() - user.getAttak() * acceptor.getDeffence()) / 2);
                user.setCurrentHelth(user.getCurrentHelth() + (user.getAttak() - user.getAttak() * acceptor.getDeffence()) / 2);
                System.out.println("to "+user.getCurrentHelth()+" HP");
            }
        }
    }
}
