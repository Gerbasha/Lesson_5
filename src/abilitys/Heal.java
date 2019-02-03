package abilitys;


import abilitys.markers.OnPostRoundPhaseAction;
import fighters.base.Warrior;

public class Heal implements FighterClassAbilitys, OnPostRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {
        if (user.getCurrentHelth() < user.getHelth()) {
            System.out.print("used heal " + (user.getHelth() - user.getCurrentHelth()) / 2+" HP ");
            user.setCurrentHelth(user.getCurrentHelth()+(user.getHelth() - user.getCurrentHelth()) / 2);
            System.out.println("to "+user.getCurrentHelth()+" HP");
        }
    }
}
