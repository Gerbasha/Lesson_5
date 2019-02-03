package fighters;


import abilitys.ElementaHeal;
import abilitys.ElementalStrike;
import fighters.base.ElementalFighter;
import fighters.base.Fighter;
import fighters.base.Warrior;
import utilites.Elements;

import static unitLabs.Barracs.createElementTalant;

public class Elemental extends Warrior implements Fighter, ElementalFighter {
    int element;
    float atackModifier;
    private float currentAttack;

    public Elemental() {
        element = createElementTalant();
        getAbilities().add(new ElementalStrike());
        getAbilities().add(new ElementaHeal());
    }

    public Elemental(Elements elements) {
        element = elements.element;
    }

    @Override
    public int receiveElements() {
        return element;
    }

    @Override
    public void changeAtackModyfier(float mult) {
        atackModifier = mult;
    }

    @Override
    public float receiveCurrentAttack() {
        return currentAttack;
    }


    public void setElement(int element) {
        this.element = element;
    }


    public void attack(Warrior fighter) {
        currentAttack = getAttak() + atackModifier;
        fighter.receiveDamage(currentAttack);
        currentAttack = getAttak();
        printBrifing(this, fighter);
    }

    public float getAtackModifier() {
        return atackModifier;
    }

}
