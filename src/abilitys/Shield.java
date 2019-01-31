package abilitys;

import andrew.honework.com.lesson_5.fighters.base.Fighter;

public class Shield implements FighterClassAbility {
    @Override
    public boolean useAbility(Fighter user, Fighter acceptor) {
        return false;
    }
}
