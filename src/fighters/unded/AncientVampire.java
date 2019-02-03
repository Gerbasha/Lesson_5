package fighters.unded;

import abilitys.FighterClassAbilitys;
import abilitys.ReceiveElement;
import fighters.base.ElementalFighter;
import utilites.Helper;

import java.util.ArrayList;

public class AncientVampire extends Vampire implements ElementalFighter {
    int element;
    FighterClassAbilitys ability;
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
        setAbilities(new ReceiveElement());
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

    public void setElement(int element) {
        this.element = element;
    }

    public void setAbilities(FighterClassAbilitys abilities) {
        super.setAbilities(new ArrayList<>());
        super.getAbilities().add(abilities);
    }

    public void setCurrentHelth(float currentHelth) {
        this.currentHelth = currentHelth;
    }

}
