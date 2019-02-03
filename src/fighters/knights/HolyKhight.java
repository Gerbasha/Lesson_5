package fighters.knights;


import abilitys.Heal;

public class HolyKhight extends Knight {

    public HolyKhight() {
        getAbilities().add(new Heal());
    }

}

