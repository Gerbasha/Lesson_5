package fighters;


import abilitys.FighterClassAbilitys;
import abilitys.RideTheDragon;
import abilitys.markers.OnPostRoundPhaseAction;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.base.Fighter;
import fighters.base.Warrior;
import utilites.Helper;

import java.util.ArrayList;

public class DragonRider extends Warrior implements Fighter {
    Dragon pet;
    FighterClassAbilitys ability;
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

        this.setAbilities(new RideTheDragon());
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

    public void attack(Warrior fighter) {
        if (fighter instanceof Dragon)
            this.ability.useAbilitys(this, (Dragon) fighter);
        if (pet != null && pet.getCurrentHelth() > 0) {
            pet.attack(fighter);
        }

        float curentDamage = getAttak();
        fighter.receiveDamage(curentDamage);
        printBrifing(this,fighter);
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
    public void restore() {
        this.currentHelth = this.helth;
    }

    public Dragon getPet() {
        return pet;
    }

    public void setPet(Dragon pet) {
        if (pet == null)
            this.pet = pet;
    }

    public ArrayList<FighterClassAbilitys> getAbilities() {
        return super.getAbilities();
    }

    public void setAbilities(FighterClassAbilitys abilities) {
       super.setAbilities(new ArrayList<>());
       super.getAbilities().add(abilities);
    }

    public void useDragon(String phase,Warrior warrior){
        if (pet.getCurrentHelth() > 0){
            ArrayList<FighterClassAbilitys> abilitysToUse = pet.getAbilities();
            for (FighterClassAbilitys ability : abilitysToUse)

                if (phase =="pre" & (ability instanceof OnPreRoundPhaseAction))
                    ability.useAbilitys(pet, warrior);
            if (phase =="post" & (ability instanceof OnPostRoundPhaseAction))
                ability.useAbilitys(pet, warrior);

        }
    }
}
