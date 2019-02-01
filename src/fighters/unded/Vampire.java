package fighters.unded;

import abilitys.FighterClassAbility;
import abilitys.VampiricPover;
import fighters.base.Fighter;
import utilites.Helper;

public class Vampire implements Fighter {
    FighterClassAbility ability;
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
        setAbility(new VampiricPover());
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
        return attak;
    }

    @Override
    public float getDeffence() {
        return deffence;
    }

    @Override
    public void restoreHealth() {

    }

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
