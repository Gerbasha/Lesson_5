package abilitys;

import andrew.honework.com.lesson_5.fighters.Cheeter;
import andrew.honework.com.lesson_5.fighters.base.Fighter;

public class ReduceAbilitys implements FighterClassAbility {
    @Override
    public boolean useAbility(Fighter user, Fighter acceptor) {
        if (acceptor.getAbility()!=null)
        {
            Cheeter cheeter = (Cheeter)user;
            System.out.println("Enemy abilitys down");
            acceptor.setAbility(cheeter.getVoidAbility());
        }
        return false;
    }
}
