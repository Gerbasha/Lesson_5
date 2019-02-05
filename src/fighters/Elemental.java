package fighters;


import abilitys.ElementaHeal;
import abilitys.ElementalStrike;
import fighters.base.ElementalFighter;
import fighters.base.Fighter;
import fighters.base.Warrior;

import static unitLabs.Barracs.createElementTalant;

public class Elemental extends Warrior implements Fighter, ElementalFighter {
    private int element;
    private float atackModifier;
    private float currentAttack;

    public Elemental() {
        element = createElementTalant();
        getAbilities().add(new ElementalStrike());
        getAbilities().add(new ElementaHeal());
    }

    @Override
    public int receiveElements() {
        return element;
    }

    @Override
    public void changeAtackModyfier(float mult) {
        atackModifier = mult;
    }

    public void attack(Warrior fighter) {
        currentAttack = getAttak() + atackModifier;
        fighter.receiveDamage(currentAttack);
        currentAttack = getAttak();
        printBrifing(this, fighter);
    }

}
