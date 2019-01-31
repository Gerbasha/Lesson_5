package fighters.unded;

import abilitys.FighterClassAbility;
import fighters.base.Fighter;

public class Vampire implements Fighter {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public float getHelth() {
        return 0;
    }

    @Override
    public float getCurrentHelth() {
        return 0;
    }

    @Override
    public FighterClassAbility getAbility() {
        return null;
    }

    @Override
    public void setCurrentHelth(float heal) {

    }

    @Override
    public void setAbility(FighterClassAbility ability) {

    }

    @Override
    public void receiveDamage(float damage) {

    }

    @Override
    public void attack(Fighter fighter) {

    }

    @Override
    public float getAttak() {
        return 0;
    }

    @Override
    public float getDeffence() {
        return 0;
    }

    @Override
    public void restoreHealth() {

    }
}
