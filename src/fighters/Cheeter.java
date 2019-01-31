package fighters;

import abilitys.FighterClassAbility;
import abilitys.ReduceAbilitys;
import fighters.base.Fighter;

public class Cheeter implements Fighter {
    FighterClassAbility ability;
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

        this.ability = new ReduceAbilitys();
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

    @Override
    public void setCurrentHelth(float heal) {
        this.currentHelth = heal;
    }

    @Override
    public void setAbility(FighterClassAbility ability) {
        this.ability = ability;
    }

    @Override
    public void receiveDamage(float damage) {
        currentHelth -= damage * deffence;
    }

    @Override
    public void attack(Fighter fighter) {
        ability.useAbility(this,fighter);
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

    public FighterClassAbility getVoidAbility() {
        return (user, acceptor) -> false;
    }

}
