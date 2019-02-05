package abilitys;


import abilitys.markers.FighterClassAbilitys;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.Dragon;
import fighters.DragonRider;
import fighters.base.Warrior;

public class RideTheDragon implements FighterClassAbilitys, OnPreRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor,ResultFightAction action) {
        if (user instanceof DragonRider && acceptor instanceof Dragon) {
            DragonRider peted = (DragonRider) user;
            action.returnBattleState(user);
            System.out.println("Dragon "+acceptor.getName()+" is captured by "+user.getName());
            peted.setPet((Dragon) acceptor);
        }
    }
}
