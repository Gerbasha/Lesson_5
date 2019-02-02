package abilitys;


import fighters.base.Warrior;

import java.util.ArrayList;

public class VoidAbilitys extends ArrayList<FighterClassAbilitys> implements FighterClassAbilitys {
    private ArrayList<FighterClassAbilitys> trueAbilitys;

    public VoidAbilitys(Warrior fighter) {
        this.trueAbilitys = fighter.getAbilities();
    }

    VoidAbilitys() {
    }

    @Override
    public void useAbilitys(Warrior user, Warrior acceptor) {

    }
    public ArrayList<FighterClassAbilitys> restoreTrueAbilitys(){return trueAbilitys;}
}
