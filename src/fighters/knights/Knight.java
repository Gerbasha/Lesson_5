package fighters.knights;


import abilitys.Shield;
import fighters.base.Fighter;
import fighters.base.Warrior;
import utilites.Helper;

public class Knight extends Warrior implements Fighter {
    float shild;
    boolean shielded;

    public Knight() {
        setShild();
        getAbilities().add(new Shield());
    }

    public float getShild() {
        return shild;
    }

    public void setShild() {
        this.shild = (float) ((Math.abs(Helper.getRandomHelper().nextGaussian())) % 1) / 2;
    }

    @Override
    public void receiveDamage(float damage) {
        if (!isShielded())
            setCurrentHelth(getCurrentHelth() - (damage - damage * getDeffence()));
        else System.out.println("Shield of " + getName() + " completely reduce the attack");
    }

    public void setShielded(boolean shielded) {
        this.shielded = shielded;
    }

    public boolean isShielded() {
        return shielded;
    }
}
