package fighters.knights;


import abilitys.FighterClassAbilitys;
import abilitys.LifeDrain;
import fighters.base.Fighter;

public class DarkKnight extends Knight {
    FighterClassAbilitys ability;

    public DarkKnight() {
        super.getAbilities().add(new LifeDrain());
    }

    @Override
    public void attack(Fighter fighter) {
        super.attack(fighter);
        fighter.receiveDamage(this.getAttak());
    }
}
