package fighters.knights;


import abilitys.FighterClassAbilitys;
import abilitys.Heal;
import fighters.base.Fighter;

public class HolyKhight extends Knight {
    FighterClassAbilitys ability;

    public HolyKhight() {
        super.getAbilities().add(new Heal()) ;
    }

    @Override
    public void attack(Fighter fighter) {
        super.attack(fighter);
        fighter.receiveDamage(this.getAttak());
    }
}

