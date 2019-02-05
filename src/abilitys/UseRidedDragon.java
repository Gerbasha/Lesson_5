package abilitys;

import abilitys.markers.FighterClassAbilitys;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.DragonRider;
import fighters.base.Warrior;

import java.util.ArrayList;

public class UseRidedDragon implements FighterClassAbilitys, OnPreRoundPhaseAction {
    @Override
    public void useAbilitys(Warrior user, Warrior acceptor, ResultFightAction action) {
        if (user instanceof DragonRider) {
            DragonRider dragonRider = (DragonRider) user;
            if (dragonRider.getPet() != null & !acceptor.equals(dragonRider.getPet())) {
                if (dragonRider.getPet().getCurrentHelth() > 0) {
                    ArrayList<FighterClassAbilitys> abilitysToUse = dragonRider.getPet().getAbilities();
                    for (FighterClassAbilitys ability : abilitysToUse) {
                        if (ability instanceof OnPreRoundPhaseAction)
                            ability.useAbilitys(dragonRider.getPet(), acceptor, action);
                    }

                }
            }
        }
    }
}
