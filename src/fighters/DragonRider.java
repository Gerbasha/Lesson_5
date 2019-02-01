package fighters;


import abilitys.FighterClassAbility;
import abilitys.RideTheDragon;
import fighters.base.Fighter;
import utilites.Helper;

public class DragonRider implements Fighter {
    Dragon pet;
    FighterClassAbility ability;
    private String name;
    private float attak;
    private float deffence;
    private float helth;
    private float currentHelth;

    public DragonRider() {
        this.name = Helper.generateName();
        this.helth = 75;
        this.currentHelth = helth;
        this.attak = 15;
        this.deffence = 0.2f;

        this.ability = new RideTheDragon();
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
    public void setCurrentHelth(float heal) {
        this.currentHelth = heal;
    }

    @Override
    public void receiveDamage(float damage) {
        if (pet!=null&&pet.getHelth()>0){
            System.out.println("Riders Dragon receive damage");
            pet.currentHelth -= damage * deffence;
        }
        else currentHelth -= damage * deffence;
    }

    @Override
    public void attack(Fighter fighter) {
        if (fighter instanceof Dragon)
            this.ability.useAbility(this, (Dragon) fighter);
        if (pet != null && pet.getCurrentHelth() > 0) {
            pet.ability.useAbility(pet, fighter);
            pet.attack(fighter);
        }

        float curentDamage = getAttak();
        fighter.receiveDamage(curentDamage);
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

    public Dragon getPet() {
        return pet;
    }

    public void setPet(Dragon pet) {
        if (pet == null)
            this.pet = pet;
    }

    public FighterClassAbility getAbility() {
        return ability;
    }

    public void setAbility(FighterClassAbility ability) {
        this.ability = ability;
    }
}
