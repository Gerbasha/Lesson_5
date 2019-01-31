package abilitys;


import fighters.base.Fighter;

public class Heal implements FighterClassAbility {
    @Override
    public boolean useAbility(Fighter user, Fighter acceptor) {
        if (user.getCurrentHelth()<user.getHelth())
            System.out.println("used heal"+(user.getHelth()-user.getCurrentHelth())/2);
            user.setCurrentHelth((user.getHelth()-user.getCurrentHelth())/2);
        return false;
    }
}
