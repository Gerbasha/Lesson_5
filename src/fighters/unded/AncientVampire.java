package fighters.unded;

import abilitys.ReceiveElement;
import fighters.base.ElementalFighter;

public class AncientVampire extends Vampire implements ElementalFighter {
    int element;

    public AncientVampire() {
        getAbilities().add(new ReceiveElement());
    }

    @Override
    public int getElements() {
        return element;
    }

    @Override
    public void increaseMultyplayAtack(float mult) {
        this.atackModifier = mult;
    }

    public void setElement(int element) {
        this.element = element;
    }

}
