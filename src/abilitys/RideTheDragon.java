package abilitys;


import abilitys.markers.OnPreRoundPhaseAction;
import fighters.Dragon;
import fighters.DragonRider;
import fighters.base.Fighter;

public class RideTheDragon implements FighterClassAbility, OnPreRoundPhaseAction {
    @Override
    public void useAbility(Fighter user, Fighter acceptor) {

        DragonRider peted = (DragonRider)user;
        System.out.println("Dragon is captured");
        peted.setPet((Dragon)acceptor);
    }
}
