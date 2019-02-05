package fighters.unded;

import abilitys.ReceiveElement;
import fighters.base.ElementalFighter;

public class AncientVampire extends Vampire implements ElementalFighter {
    int element;

    public AncientVampire() {
        getAbilities().add(new ReceiveElement());
    }

    @Override
    public int receiveElements() {
        return element;
    }

    @Override
    public void changeAtackModyfier(float mult) {
        this.atackModifier+= mult;
    }

    public void setElement(int element) {
        this.element = element;
    }


}
