package fighters.knights;


import abilitys.LifeDrain;

public class DarkKnight extends Knight {

    public DarkKnight() {
        getAbilities().add(new LifeDrain());
    }

}
