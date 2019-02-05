package fighters;

import abilitys.ElementsMagic;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.base.ElementalFighter;
import fighters.base.Fighter;
import fighters.base.Warrior;

public class Dragon extends Warrior implements ElementalFighter, Fighter, OnPreRoundPhaseAction {

    int elements;
    float atackModifier;
    private float currentAttack;

    public Dragon() {
        getAbilities().add(new ElementsMagic());
    }

    public void attack(Warrior fighter) {
        currentAttack = getAttak() + atackModifier;
        fighter.receiveDamage(currentAttack);
        currentAttack = getAttak();
        printBrifing(this, fighter);
    }

    public int receiveElements() {
        return elements;
    }

    @Override
    public void changeAtackModyfier(float mult) {
        atackModifier = mult;
    }

    public void setElements(int elements) {
        this.elements = elements;
    }

}

