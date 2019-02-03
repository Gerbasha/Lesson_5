package fighters.knights;


import abilitys.LifeDrain;
import fighters.base.Fighter;

import java.util.ArrayList;

public class DarkKnight extends Knight {

    public DarkKnight() {
        super.setAbilities(new ArrayList<>());
        super.getAbilities().add(new LifeDrain());
    }

    @Override
    public void attack(Fighter fighter) {
        super.attack(fighter);
        fighter.receiveDamage(this.getAttak());
    }
}
