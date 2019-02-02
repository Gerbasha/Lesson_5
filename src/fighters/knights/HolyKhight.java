package fighters.knights;


import abilitys.FighterClassAbility;
import abilitys.Heal;
import fighters.base.Fighter;

public class HolyKhight extends Knight {
    FighterClassAbility ability;

    public HolyKhight() {
        this.ability = new Heal();
    }

    @Override
    public void attack(Fighter fighter) {
        super.attack(fighter);
        fighter.receiveDamage(this.getAttak());
    }
}

