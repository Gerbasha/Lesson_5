package fighters;


import abilitys.FighterClassAbilitys;
import abilitys.RideTheDragon;
import abilitys.markers.OnPostRoundPhaseAction;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.base.Fighter;
import fighters.base.Warrior;

import java.util.ArrayList;

public class DragonRider extends Warrior implements Fighter {
    Dragon pet;

    public DragonRider() {
        getAbilities().add(new RideTheDragon());
    }

    @Override
    public void receiveDamage(float damage) {
        if (pet != null && pet.getHelth() > 0) {
            System.out.println("Riders Dragon receive damage");
            pet.setCurrentHelth(pet.getCurrentHelth() - damage * pet.getDeffence());
        } else setCurrentHelth(getCurrentHelth() - damage * getDeffence());
    }

    public void attack(Warrior fighter) {
        super.attack(fighter);
        if (pet != null && pet.getCurrentHelth() > 0) {
            pet.attack(fighter);
            printBrifing(pet, fighter);
        }
        printBrifing(this, fighter);
    }

    public Dragon getPet() {
        return pet;
    }

    public void setPet(Dragon pet) {
        if (pet == null)
            this.pet = pet;
    }

    public void useDragon(String phase, Warrior warrior) {
        if (pet.getCurrentHelth() > 0) {
            ArrayList<FighterClassAbilitys> abilitysToUse = pet.getAbilities();
            for (FighterClassAbilitys ability : abilitysToUse) {

                if (phase == "pre" & (ability instanceof OnPreRoundPhaseAction))
                    ability.useAbilitys(pet, warrior);
                if (phase == "post" & (ability instanceof OnPostRoundPhaseAction))
                    ability.useAbilitys(pet, warrior);
            }
        }
    }
}