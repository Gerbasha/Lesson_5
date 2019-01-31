package abilitys;

import andrew.honework.com.lesson_5.fighters.Dragon;
import andrew.honework.com.lesson_5.fighters.DragonRider;
import andrew.honework.com.lesson_5.fighters.base.Fighter;

public class RideTheDragon implements FighterClassAbility {
    @Override
    public boolean useAbility(Fighter user, Fighter acceptor) {

        DragonRider peted = (DragonRider)user;
        System.out.println("Dragon is captured");
        peted.setPet((Dragon)acceptor);
        return false;
    }
}
