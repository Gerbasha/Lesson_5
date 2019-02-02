package fighters;

import abilitys.ElementsMagic;
import abilitys.FighterClassAbilitys;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.base.ElementalFighter;
import fighters.base.Fighter;
import fighters.base.Warrior;
import utilites.Helper;

import java.util.ArrayList;

public class Dragon extends Warrior implements ElementalFighter, Fighter, OnPreRoundPhaseAction {
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

    public void attack(Warrior fighter) {
        fighter.receiveDamage(this.getAttak()+atackModifier);
        printBrifing(this,fighter);

    }



    public ArrayList<FighterClassAbilitys> getAbilities() {
        return super.getAbilities();
    }

    public void setAbility(ElementsMagic ability) {
        super.getAbilities().add(ability);
    }

    @Override
    public void receiveDamage(float damage) {
        currentHelth -= damage * deffence;

    }

    @Override
    public void restore() {
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

    @Override
    public void increaseMultyplayAtack(float mult) {
        atackModifier = mult;
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

    public void setAbilities(FighterClassAbilitys abilities) {

    }

    public void setHelth() {
        this.helth = Math.round(Math.abs(Helper.getRandomHelper().nextGaussian() * 50) + 100);
    }

}

