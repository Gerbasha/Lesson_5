package unitLabs;

import andrew.honework.com.lesson_5.classAbilitys.Shield;
import andrew.honework.com.lesson_5.fighters.knights.DarkKnight;
import andrew.honework.com.lesson_5.fighters.knights.HolyKhight;
import andrew.honework.com.lesson_5.fighters.knights.Knight;
import andrew.honework.com.lesson_5.fighters.base.Warrior;

import java.util.Random;

public class Academy {
    static Warrior learned;
    Warrior resurected;
    private static Random fate;

    public Academy() {
        fate = new Random();
    }


    Warrior ressurectThisWarrior(Warrior warrior) {

       if (warrior instanceof HolyKhight){
            this.resurected = new HolyKhight();
        } else  if (warrior instanceof DarkKnight){
            this.resurected = new DarkKnight();
        } else  this.resurected = new Knight();

        resurected.setName(warrior.getName());
        resurected.setAttak(warrior.getAttak());
        resurected.setDeffence(warrior.getDeffence());
        resurected.setFighterClassAbility(warrior.getFighterClassBonus());

        return resurected;
    }

    static Warrior createNewWarrior(String warrior) {
        switch (warrior) {
            case "knight": {
                learned = new Knight();
                setWarriorParameters();

                break;
            }
            case "darkknight": {
                learned = new DarkKnight();
                setWarriorParameters();

                break;
            }
            case "holyknight": {
                learned = new HolyKhight();
                setWarriorParameters();

                break;
            }
        }
        return learned;
    }

    static void setWarriorParameters(){
        learned.setName("generate");
        learned.setHelth();
        learned.setCurrentHelth(learned.helth);
        learned.setAttak();
        learned.setDeffence();
        learned.setShild();
        learned.setAbility(new Shield());
    }
}
