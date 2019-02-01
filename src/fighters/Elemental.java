package fighters;


import abilitys.ElementalStrike;
import abilitys.FighterClassAbility;
import fighters.base.ActionPostFight;
import fighters.base.ElementalFighter;
import fighters.base.Fighter;
import utilites.Elements;
import utilites.Helper;

import static unitLabs.Barracs.createElementTalant;

public class Elemental implements Fighter,ElementalFighter, ActionPostFight {
    int element;
    FighterClassAbility ability;
    private String name;
    private float attak;
    float deffence;
    private float helth;
    float currentHelth;
    float atackModifier;

    public Elemental() {
        setName("generate");
        setHelth();
        setCurrentHelth(helth);
        setAttak();
        setDeffence();
        element = createElementTalant();
        setAbility(new ElementalStrike());

    }

    public Elemental(Elements elements) {
        element = elements.element;
    }

    @Override
    public int getElements() {
        return element;
    }

    @Override
    public void increaseMultyplayAtack(float mult) {

    }

    @Override
    public void doActionPostFight() {

    }

    @Override
    public void doActionPostFight(float dealDamage, Fighter fighter) {

    }

    private void setName(String name) {
        if (name != "generate")
            this.name = name;
        else this.name = Helper.generateName();
    }


    private void setAttak() {
        this.attak = Math.round(Math.abs(Helper.getRandomHelper().nextGaussian() * 10) + 10);
    }

    private void setHelth() {
        this.helth = Math.round(Math.abs(Helper.getRandomHelper().nextGaussian() * 50) + 100);

    }
    private void setDeffence() {
        this.deffence = (float) (Math.abs(Helper.getRandomHelper().nextGaussian())) % 1;
    }


    public void setElement(int element) {
        this.element = element;
    }

    public void setAbility(FighterClassAbility ability) {
        this.ability = ability;
    }

    @Override
    public void receiveDamage(float damage) {

    }

    @Override
    public void attack(Fighter fighter) {

    }

    @Override
    public float getAttak() {
        return attak;
    }

    @Override
    public float getDeffence() {
        return deffence;
    }

    @Override
    public void restoreHealth() {
        this.currentHelth = helth;
    }


    public void setAttak(float attak) {
        this.attak = attak;
    }

    public void setDeffence(float deffence) {
        this.deffence = deffence;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getHelth() {
        return helth;
    }

    @Override
    public float getCurrentHelth() {
        return currentHelth;
    }

    @Override
    public FighterClassAbility getAbility() {
        return ability;
    }

    public void setCurrentHelth(float currentHelth) {
        this.currentHelth = currentHelth;
    }

    public int getElement() {
        return element;
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
