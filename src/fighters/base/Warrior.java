package fighters.base;


import abilitys.FighterClassAbility;
import abilitys.Shield;
import utilites.Helper;

public abstract class Warrior implements Fighter {
    private String name;
    private float attak;
    private float deffence;
    public float helth;
    private float currentHelth;
    FighterClassAbility ability;
    float shild;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getCurrentHelth() {
        return currentHelth;
    }

    @Override
    public void receiveDamage(float damage) {
       if (ability instanceof Shield)if (Helper.getRandomHelper().nextGaussian() <shild)
            currentHelth -= damage * deffence;else System.out.println("Shield mirror the attak");
    }

    @Override
    public void attack(Fighter fighter) {
        fighter.receiveDamage(this.getAttak());
        System.out.println(this.getName() + "[" + this.getCurrentHelth() + "] " + " deal to " +
                fighter.getName() + "[" + fighter.getCurrentHelth() + "]" +
                " " + getAttak() + " damage");

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
        this.currentHelth = this.helth;
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


    public FighterClassAbility getFighterClassBonus() {
        return ability;
    }


    public void setFighterClassAbility(FighterClassAbility fighterClassAbility) {
        this.ability = fighterClassAbility;
    }

    public void setHelth() {
        this.helth = Math.round(Math.abs(Helper.getRandomHelper().nextGaussian() * 50) + 30);
    }

    public void setCurrentHelth(float helth) {
        {
            this.currentHelth = helth;
        }
    }

    @Override
    public float getHelth() {
        return helth;
    }

    public void setHelth(float helth) {
        this.helth = helth;
    }

    @Override
    public FighterClassAbility getAbility() {
        return ability;
    }

    @Override
    public void setAbility(FighterClassAbility ability) {
        this.ability = ability;
    }

    public float getShild() {
        return shild;
    }

    public void setShild() {
        this.shild = (float) ((Math.abs(Helper.getRandomHelper().nextGaussian())) % 1)/2;
    }
    boolean isAlive(){
      return currentHelth>0;
    }
}
