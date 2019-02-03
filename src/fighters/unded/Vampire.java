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

    public float getAtackModifier() {
        return atackModifier;
    }

    @Override
    public void attack(Warrior fighter) {
        setCurrentAttack(atackModifier);
        fighter.receiveDamage(receiveCurrentAttack());
        setCurrentAttack(0);
        printBrifing(this, fighter);
    }

    public void setAtackModifier(float atackModifier) {
        this.atackModifier = atackModifier;
    }

    public float receiveCurrentAttack() {
        return currentAttack;
    }

    public void setCurrentAttack(float modifier) {

        this.currentAttack = super.getAttak() + modifier;
        atackModifier = 0;
    }

    @Override
    public float getAttak() {
        return currentAttack;
    }
}
