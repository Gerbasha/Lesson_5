package fighters;

import abilitys.FighterClassAbilitys;
import abilitys.ReduceAbilitys;
import abilitys.VoidAbilitys;
import fighters.base.Fighter;
import fighters.base.Warrior;

import java.util.ArrayList;

public class Cheeter extends Warrior implements Fighter {

    public Cheeter() {
        setName("Cheater");
        getAbilities().add(new ReduceAbilitys());
    }

    public ArrayList<FighterClassAbilitys> getVoidAbilitys(Warrior fighter) {
        return new VoidAbilitys(fighter);
    }

}
