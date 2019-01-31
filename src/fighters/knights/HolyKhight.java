package fighters.knights;

import andrew.honework.com.lesson_5.classAbilitys.FighterClassAbility;
import andrew.honework.com.lesson_5.classAbilitys.Heal;
import andrew.honework.com.lesson_5.fighters.base.Fighter;

public class HolyKhight extends Knight {
    FighterClassAbility ability;

    public HolyKhight() {
        this.ability = new Heal();
    }

    @Override
    public void attack(Fighter fighter) {
        super.attack(fighter);
        fighter.receiveDamage(this.getAttak());
        this.ability.useAbility(this,fighter);
    }
}

