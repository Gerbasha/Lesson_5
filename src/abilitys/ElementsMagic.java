package abilitys;

import fighters.Dragon;
import fighters.base.Warrior;

public class ElementsMagic implements FighterClassAbilitys {

    public void useAbilitys(Warrior user, Warrior acceptor) {
        System.out.println("used elemental magic");
        Dragon dragon = (Dragon) user;
        float damage;
        int multiplyer = 0;
        int element = 0b1000;
        if (acceptor instanceof Dragon) {
            int resistBonus = ((Dragon) acceptor).getElements();
            for (int i = 0; i < 4; i++) {
                multiplyer += ((dragon.getElements() & element) == element) ?
                        (1 - (((resistBonus & element) == element) ? 1 : 0)) : 0;
                element >>= 1;
            }

        } else {
            for (int i = 0; i < 4; i++) {
                multiplyer += ((dragon.getElements() & element) == element) ? 1 : 0;
                element >>= 1;
            }
            damage = dragon.getAttak() * multiplyer;
            acceptor.receiveDamage(damage);
        }

    }
}
