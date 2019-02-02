package fighters;

import abilitys.FighterClassAbilitys;
import abilitys.ReduceAbilitys;
import abilitys.VoidAbilitys;
import fighters.base.Fighter;
import fighters.base.Warrior;

import java.util.ArrayList;


public class Cheeter extends Warrior implements Fighter {
    private String name;
    private float attak;
    private float deffence;
    private float helth;
    private float currentHelth;

    public Cheeter() {
        this.name = "Cheater";
        this.helth = 100;
        this.currentHelth = helth;
        this.attak = 30;
        this.deffence = 0.5f;

        this.getAbilities() = new ArrayList<>();
        this.getAbilities().add(new ReduceAbilitys());
    }

    public String getName() {
        return name;
    }

    public float getHelth() {
        return helth;
    }

    public float getCurrentHelth() {
        return currentHelth;
    }

    public ArrayList<FighterClassAbilitys> getAbilities() {
        return super.getAbilities();
    }

    public void setCurrentHelth(float heal) {
        this.currentHelth = heal;
    }


    public void setAbilities(ArrayList<FighterClassAbilitys> abilities) {
        super.setAbilities(abilities);
    }

    @Override
    public void receiveDamage(float damage) {
        currentHelth -= damage * deffence;
    }


    public void attack(Warrior fighter) {
        fighter.receiveDamage(this.getAttak());

        printBrifing(this,fighter);

    }

    public float getAttak() {
        return attak;
    }

    public float getDeffence() {
        return deffence;
    }

    @Override
    public void restore() {
        this.currentHelth = this.helth;
    }

    public ArrayList<FighterClassAbilitys> getVoidAbilitys(Warrior fighter) {
        return new VoidAbilitys(fighter);
    }

}
