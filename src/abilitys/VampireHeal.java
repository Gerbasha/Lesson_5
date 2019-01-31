package abilitys;

import andrew.honework.com.lesson_5.fighters.base.Fighter;

public class VampireHeal implements FighterClassAbility {
    @Override
    public boolean useAbility(Fighter user, Fighter acceptor) {
        if( user.getCurrentHelth()<user.getHelth()){
            if (((user.getCurrentHelth() + user.getAttak() - acceptor.getDeffence() / 2) > user.getHelth())) {
                System.out.println("Used darkheal");
                user.setCurrentHelth(user.getHelth());
            } else {
                System.out.println("Used darkheal"+ (user.getAttak() - acceptor.getDeffence()) / 2);
                user.setCurrentHelth((user.getAttak() - acceptor.getDeffence()) / 2);
            }
        }
        return false;
    }
}
