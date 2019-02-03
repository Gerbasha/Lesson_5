package abilitys;


import abilitys.markers.FighterClassAbilitys;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.Dragon;
import fighters.DragonRider;
import fighters.base.Warrior;

public class RideTheDragon implements FighterClassAbilitys, OnPreRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {
        if (user instanceof DragonRider && acceptor instanceof Dragon) {

            DragonRider peted = (DragonRider) user;
            System.out.println("Dragon is captured");
            peted.setPet((Dragon) acceptor);
        }
    }
}
