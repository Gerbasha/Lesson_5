package fighters.unded;

import abilitys.VampiricPover;
import fighters.base.Fighter;
import fighters.base.Warrior;

public class Vampire extends Warrior implements Fighter {
    float atackModifier;
    float currentAttack;

    public Vampire() {
        setCurrentAttack(0);
        getAbilities().add(new VampiricPover());
    }

    @Override
    public void attack(Warrior fighter) {
        setCurrentAttack(atackModifier);
        fighter.receiveDamage(getCurrentAttack());
        setCurrentAttack(0);
        printBrifing(this, fighter);
    }

    public void setAtackModifier(float atackModifier) {
        this.atackModifier = atackModifier;
    }

    public float getCurrentAttack() {

        return currentAttack;
    }

    public void setCurrentAttack(float modifier) {

        currentAttack = getAttak() + modifier;
        atackModifier = 0;
    }


}
