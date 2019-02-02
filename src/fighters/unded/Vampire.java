package fighters.unded;

import abilitys.FighterClassAbilitys;
import abilitys.VampiricPover;
import fighters.base.Fighter;
import fighters.base.Warrior;
import utilites.Helper;

import java.util.ArrayList;

public class Vampire extends Warrior implements Fighter {
    FighterClassAbilitys ability;
    private String name;
    private float attak;
    float deffence;
    private float helth;
    float currentHelth;
    float atackModifier;

    public Vampire() {
        setName("generate");
        setHelth();
        setCurrentHelth(helth);
        setAttak();
        setDeffence();
        setAbilities(new VampiricPover());
    }

    public void setName(String name) {
        if (name != "generate")
            this.name = name;
        else this.name = Helper.generateName();
    }

    public void setAttak() {
        this.attak = Math.round(Math.abs(Helper.getRandomHelper().nextGaussian() * 10) + 10);
    }

    public void setHelth() {
        this.helth = Math.round(Math.abs(Helper.getRandomHelper().nextGaussian() * 50) + 100);
    }

    public void setDeffence() {
        this.deffence = (float) (Math.abs(Helper.getRandomHelper().nextGaussian())) % 1;
    }

    public String getName() {
        return name;
    }

    public float getHelth() {
        return helth;
    }

    public float getCurrentHelth() {
        return currentHelth;
    }

    public ArrayList<FighterClassAbilitys> getAbilities() {
        return super.getAbilities();
    }

    public void setCurrentHelth(float currentHelth) {
        this.currentHelth = currentHelth;
    }

    public void setAbilities(FighterClassAbilitys abilities) {
        this.ability = abilities;
    }

    public void receiveDamage(float damage) {
        this.currentHelth -= damage * deffence;
    }

    public void attack(Fighter fighter) {
        fighter.receiveDamage(attak + atackModifier);
    }

    public float getAttak() {
        return attak;
    }

    public float getDeffence() {
        return deffence;
    }

    public void restore() {    }

    public void setAttak(float attak) {
        this.attak = attak;
    }

    public void setDeffence(float deffence) {
        this.deffence = deffence;
    }

    public void setHelth(float helth) {
        this.helth = helth;
    }

    public float getAtackModifier() {
        return atackModifier;
    }

    public void setAtackModifier(float atackModifier) {
        this.atackModifier = atackModifier;
    }
}
