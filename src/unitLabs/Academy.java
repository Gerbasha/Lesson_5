package unitLabs;


import fighters.base.Warrior;
import fighters.knights.DarkKnight;
import fighters.knights.HolyKhight;
import fighters.knights.Knight;

import java.util.Random;

public class Academy {
    static Warrior learned;
    Warrior resurected;
    private static Random fate;

    public Academy() {
        fate = new Random();
    }


//    Warrior ressurectThisWarrior(Warrior warrior) {
//
//       if (warrior instanceof HolyKhight){
//            resurected = new HolyKhight();
//        } else  if (warrior instanceof DarkKnight){
//            resurected = new DarkKnight();
//        } else  resurected = new Knight();
//
//        resurected.setName(warrior.getName());
//        resurected.setAttak(warrior.getAttak());
//        resurected.setDeffence(warrior.getDeffence());
//        resurected.setFighterClassAbility(warrior.getAbilities());
//
//        return resurected;
//    }

    static Warrior createNewWarrior(String warrior) {
        switch (warrior) {
            case "knight": {
                learned = new Knight();
                break;
            }
            case "darkknight": {
                learned = new DarkKnight();
                break;
            }
            case "holyknight": {
                learned = new HolyKhight();
                break;
            }
        }
        return learned;
    }
}
