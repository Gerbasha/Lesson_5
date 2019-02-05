package fighters;


import abilitys.RideTheDragon;
import abilitys.UseRidedDragon;
import fighters.base.Fighter;
import fighters.base.Warrior;

public class DragonRider extends Warrior implements Fighter {
    private Dragon pet;

    public DragonRider() {
        getAbilities().add(new RideTheDragon());
        getAbilities().add(new UseRidedDragon());
    }

    @Override
    public void receiveDamage(float damage) {
        if (pet != null && pet.getHelth() > 0) {
            System.out.println("Riders Dragon receive damage");
            pet.setThisTurnReceivedDamage(getCurrentHelth());
            pet.setCurrentHelth(pet.getCurrentHelth() - damage * pet.getDeffence());
            pet.setThisTurnReceivedDamage(getThisTurnReceivedDamage()-getCurrentHelth());
            this.setThisTurnReceivedDamage(pet.getThisTurnReceivedDamage());
        } else {
            setThisTurnReceivedDamage(getCurrentHelth());
            setCurrentHelth(getCurrentHelth() - (damage - damage * getDeffence()));
            setThisTurnReceivedDamage(getThisTurnReceivedDamage()-getCurrentHelth());
        }
    }

    public void attack(Warrior fighter) {
        super.attack(fighter);
        if (pet != null && pet.getCurrentHelth() > 0) {
            pet.attack(fighter);
            printBrifing(pet, fighter);
        }
    }

    public Dragon getPet() {
        return pet;
    }

    public void setPet(Dragon pet) {
        if (this.pet == null)
            this.pet = pet;
    }
}