package fighters.knights;

import andrew.honework.com.lesson_5.classAbilitys.FighterClassAbility;
import andrew.honework.com.lesson_5.classAbilitys.VampireHeal;
import andrew.honework.com.lesson_5.fighters.base.Fighter;

public class DarkKnight extends Knight {
    FighterClassAbility ability;

    public DarkKnight() {
        this.ability = new VampireHeal();
    }

    @Override
    public void attack(Fighter fighter) {
        super.attack(fighter);
        fighter.receiveDamage(this.getAttak());
        this.ability.useAbility(this,fighter);
    }
}
