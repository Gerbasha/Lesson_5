package fighters.base;


import abilitys.FighterClassAbilitys;
import abilitys.Shield;
import abilitys.VoidAbilitys;
import utilites.Helper;

import java.util.ArrayList;

public abstract class Warrior implements Fighter {
    private String name;
    private float attak;
    private float deffence;
    public float helth;
    private float currentHelth;
    ArrayList<FighterClassAbilitys> abilities;
    float shild;

    public String getName() {
        return name;
    }


    public float getCurrentHelth() {
        return currentHelth;
    }

    @Override
    public void receiveDamage(float damage) {
        Shield shield = new Shield();
        if (abilities.contains(shield)) if (Helper.getRandomHelper().nextGaussian() < shild)
            currentHelth -= damage * deffence;
        else System.out.println("Shield mirror the attak");
    }

    public void attack(Fighter fighter) {

        fighter.receiveDamage(this.getAttak());
        System.out.println(this.getName() + "[" + this.getCurrentHelth() + "] " + " deal to " +
                ((Warrior) fighter).getName() + "[" + ((Warrior) fighter).getCurrentHelth() + "]" +
                " " + getAttak() + " damage");

    }

    // @Override
    public float getAttak() {
        return attak;
    }

    //  @Override
    public float getDeffence() {
        return deffence;
    }

    @Override
    public void restore() {
        currentHelth = helth;
        if (abilities instanceof VoidAbilitys) {
            this.abilities = ((VoidAbilitys) abilities).restoreTrueAbilitys();
        }
    }

    public void setName(String name) {
        if (name != "generate")
            this.name = name;
        else this.name = Helper.generateName();
    }

    public void setAttak() {
        this.attak = Math.round(Math.abs(Helper.getRandomHelper().nextGaussian() * 5) + 5);
    }

    public void setAttak(float attak) {
        this.attak = attak;
    }

    public void setDeffence() {
        this.deffence = (float) (Math.abs(Helper.getRandomHelper().nextGaussian())) % 1;
    }

    public void setDeffence(float deffence) {
        this.deffence = deffence;
    }


    public ArrayList<FighterClassAbilitys> getAbilities() {
        return abilities;
    }


    public void setFighterClassAbility(FighterClassAbilitys fighterClassAbility) {
        this.abilities.add(fighterClassAbility);
    }

    public void setHelth() {
        this.helth = Math.round(Math.abs(Helper.getRandomHelper().nextGaussian() * 50) + 30);
    }

    public void setCurrentHelth(float helth) {
        {
            this.currentHelth = helth;
        }
    }

    public float getHelth() {
        return helth;
    }

    public void setHelth(float helth) {
        this.helth = helth;
    }

    //    public FighterClassAbilitys getAbilities() {
//        return abilities;
//    }
//
    public void setAbilities(ArrayList<FighterClassAbilitys> abilities) {
        this.abilities = abilities;
    }

    public float getShild() {
        return shild;
    }

    public void setShild() {
        this.shild = (float) ((Math.abs(Helper.getRandomHelper().nextGaussian())) % 1) / 2;
    }

    boolean isAlive() {
        return currentHelth > 0;
    }

    public static void printBrifing(Warrior fighter1, Warrior fighter2) {
        System.out.println(fighter1.getName() + "[" + fighter1.getCurrentHelth() + "] " + " deal to " +
                fighter2.getName() + "[" + fighter2.getCurrentHelth() + "]" +
                " " + fighter1.getAttak() + " damage");
    }
}
