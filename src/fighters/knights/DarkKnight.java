package fighters.knights;


import abilitys.FighterClassAbility;
import abilitys.VampireHeal;
import fighters.base.Fighter;

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
