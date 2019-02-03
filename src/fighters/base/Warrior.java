package fighters.base;


import abilitys.FighterClassAbilitys;
import abilitys.VoidAbilitys;
import utilites.Helper;

import java.util.ArrayList;

public abstract class Warrior implements Fighter {
    private String name;
    private float attak;
    private float deffence;
    private float helth;
    private float currentHelth;
    ArrayList<FighterClassAbilitys> abilities;

    public Warrior() {
        setName("generate");
        setHelth();
        setCurrentHelth(helth);
        setAttak();
        setDeffence();
        this.abilities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public float getCurrentHelth() {
        return currentHelth;
    }

    @Override
    public void receiveDamage(float damage) {
        currentHelth -= damage * deffence;
    }

    public void attack(Warrior fighter) {

        fighter.receiveDamage(this.getAttak());
        printBrifing(this, fighter);

    }

    public float getAttak() {
        return attak;
    }

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

    public void setAbilities(ArrayList<FighterClassAbilitys> abilities) {
        this.abilities = abilities;
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
