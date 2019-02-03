package fighters.unded;

import abilitys.VampiricPover;
import fighters.base.Fighter;
import fighters.base.Warrior;

public class Vampire extends Warrior implements Fighter {
    float atackModifier;

    public Vampire() {
        getAbilities().add(new VampiricPover());
    }

    public void attack(Fighter fighter) {
        fighter.receiveDamage(getAttak() + atackModifier);
    }

    public float getAtackModifier() {
        return atackModifier;
    }

    public void setAtackModifier(float atackModifier) {
        this.atackModifier = atackModifier;
    }
}
