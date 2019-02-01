package fighters.knights;


import abilitys.FighterClassAbility;
import abilitys.LifeDrain;
import fighters.base.Fighter;

public class DarkKnight extends Knight {
    FighterClassAbility ability;

    public DarkKnight() {
        this.ability = new LifeDrain();
    }

    @Override
    public void attack(Fighter fighter) {
        super.attack(fighter);
        fighter.receiveDamage(this.getAttak());
        this.ability.useAbility(this,fighter);
    }
}
