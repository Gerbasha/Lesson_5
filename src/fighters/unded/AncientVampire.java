package fighters.unded;

import abilitys.FighterClassAbility;
import abilitys.ReceiveElement;
import fighters.base.ElementalFighter;
import utilites.Helper;

public class AncientVampire extends Vampire implements ElementalFighter {
    int element;
    FighterClassAbility ability;
    private String name;
    private float attak;
    float deffence;
    private float helth;
    float currentHelth;

    public AncientVampire() {
        setName("generate");
        setHelth();
        setCurrentHelth(helth);
        setAttak();
        setDeffence();
        setAbility(new ReceiveElement());
    }

    @Override
    public int getElements() {
        return element;
    }

    @Override
    public void increaseMultyplayAtack(float mult) {
        this.atackModifier = mult;
    }

//    @Override
//    public void doActionPostFight() {
//
//    }
//
//    @Override
//    public void doActionPostFight(float dealDamage, Fighter fighter) {
//
//    }

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

    public void setCurrentHelth(float currentHelth) {
        this.currentHelth = currentHelth;
    }

}
