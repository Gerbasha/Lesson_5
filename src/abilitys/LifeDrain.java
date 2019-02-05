package abilitys;


import abilitys.markers.FighterClassAbilitys;
import abilitys.markers.OnPostRoundPhaseAction;
import fighters.base.Warrior;

public class LifeDrain implements FighterClassAbilitys, OnPostRoundPhaseAction {

    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {
        if (acceptor.getThisTurnReceivedDamage() > 0) {
            if (user.getCurrentHelth() < user.getHelth()) {
                if (((user.getCurrentHelth() + user.getThisTurnReceivedDamage() / 2) > user.getHelth())) {
                    System.out.print(user.getName() + " use lifedrain ");
                    user.setCurrentHelth(user.getHelth());
                    System.out.println("to " + user.getCurrentHelth() + " HP");
                } else {
                    System.out.print("Used lifedrain " + user.getThisTurnReceivedDamage() / 2);
                    user.setCurrentHelth(user.getCurrentHelth() + user.getThisTurnReceivedDamage() / 2);
                    System.out.println("to " + user.getCurrentHelth() + " HP");
                }
            }
        }else System.out.println("Damage failed. Lifedrain unsuccesfull...");
    }
}
