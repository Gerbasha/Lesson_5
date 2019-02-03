package fighters;


import abilitys.ElementalStrike;
import fighters.base.ElementalFighter;
import fighters.base.Fighter;
import fighters.base.Warrior;
import utilites.Elements;

import static unitLabs.Barracs.createElementTalant;

public class Elemental extends Warrior implements Fighter,ElementalFighter{
    int element;
    float atackModifier;

    public Elemental() {
        element = createElementTalant();
        getAbilities().add(new ElementalStrike());
    }

    public Elemental(Elements elements) {
        element = elements.element;
    }

    @Override
    public int getElements() {
        return element;
    }

    @Override
    public void increaseMultyplayAtack(float mult) {

    }

    public void setElement(int element) {
        this.element = element;
    }

    public void attack(Fighter fighter) {
        fighter.receiveDamage(getAttak()+atackModifier);
    }

    public int getElement() {
        return element;
    }

    public float getAtackModifier() {
        return atackModifier;
    }

    public void setAtackModifier(float atackModifier) {
        this.atackModifier = atackModifier;
    }
}
