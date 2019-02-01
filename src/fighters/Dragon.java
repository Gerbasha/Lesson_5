package fighters;

import abilitys.ElementsMagic;
import abilitys.FighterClassAbility;
import fighters.base.ElementalFighter;
import fighters.base.Fighter;
import utilites.Helper;

public class Dragon implements ElementalFighter, Fighter {
    FighterClassAbility ability;
    private String name;
    int elements;
    private float attak;
    float deffence;
    public float helth;
    float currentHelth;
    float atackModifier;


    public Dragon() {
        setName("generate");
        setHelth();
        setCurrentHelth(helth);
        setAttak();
        setDeffence();
        setAbility(new ElementsMagic());
    }


    @Override
    public void attack(Fighter fighter) {
        this.ability.useAbility(this, fighter);
        fighter.receiveDamage(this.getAttak());
        System.out.println(this.getName() + "[" + this.getCurrentHelth() + "] " + " deal to " +
                fighter.getName() + "[" + fighter.getCurrentHelth() + "]" +
                " " + getAttak() + " damage");

    }


    @Override
    public FighterClassAbility getAbility() {
        return ability;
    }

    public void setAbility(ElementsMagic ability) {
        this.ability = ability;
    }

    @Override
    public void receiveDamage(float damage) {
        currentHelth -= damage * deffence;

    }

    @Override
    public void restoreHealth() {
        this.currentHelth = this.helth;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != "generate")
            this.name = name;
        else this.name = Helper.generateName();
    }

    public int getElements() {
        return elements;
    }

    public void setElements(int elements) {
        this.elements = elements;
    }

    public float getAttak() {
        return attak;
    }

    public void setAttak(float attak) {
        this.attak = attak;
    }

    public void setAttak() {
        this.attak = Math.round(Math.abs(Helper.getRandomHelper().nextGaussian() * 10) + 10);
    }

    public float getDeffence() {
        return deffence;
    }

    public void setDeffence(float deffence) {
        this.deffence = deffence;
    }

    public void setDeffence() {
        this.deffence = (float) (Math.abs(Helper.getRandomHelper().nextGaussian())) % 1;
    }

    public float getHelth() {
        return helth;
    }

    public void setHelth(float helth) {
        this.helth = helth;
    }

    public float getCurrentHelth() {
        return currentHelth;
    }

    public void setCurrentHelth(float currentHelth) {
        this.currentHelth = currentHelth;
    }

    @Override
    public void setAbility(FighterClassAbility ability) {

    }

    public void setHelth() {
        this.helth = Math.round(Math.abs(Helper.getRandomHelper().nextGaussian() * 50) + 100);
    }

}

