package fighters;

import abilitys.ElementsMagic;
import abilitys.FighterClassAbilitys;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.base.ElementalFighter;
import fighters.base.Fighter;
import fighters.base.Warrior;

public class Dragon extends Warrior implements ElementalFighter, Fighter, OnPreRoundPhaseAction {

    int elements;
    float atackModifier;


    public Dragon() {
        getAbilities().add(new ElementsMagic());
    }

    public void attack(Warrior fighter) {
        fighter.receiveDamage(getAttak() + atackModifier);
        printBrifing(this, fighter);
    }

    public int getElements() {
        return elements;
    }

    @Override
    public void increaseMultyplayAtack(float mult) {
        atackModifier = mult;
    }

    public void setElements(int elements) {
        this.elements = elements;
    }

    public void setAbilities(FighterClassAbilitys abilities) {

    }
}

