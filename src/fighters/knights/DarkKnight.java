package fighters.knights;


import abilitys.heal.LifeDrain;

public class DarkKnight extends Knight {

    public DarkKnight() {
        getAbilities().add(new LifeDrain());
    }

}
