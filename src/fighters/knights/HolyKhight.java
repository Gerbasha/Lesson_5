package fighters.knights;


import abilitys.heal.Heal;

public class HolyKhight extends Knight {

    public HolyKhight() {
        getAbilities().add(new Heal());
    }

}

