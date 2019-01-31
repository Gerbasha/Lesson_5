package fighters.base;

import abilitys.FighterClassAbility;

/**
 * Created by Андрей on 26.01.2019.
 */
public interface Fighter {


    String getName();

    float getHelth();

    float getCurrentHelth();

    FighterClassAbility getAbility();

    void setCurrentHelth(float heal);

    void setAbility(FighterClassAbility ability);


    void receiveDamage(float damage);

    void attack(Fighter fighter);

    float getAttak();

    float getDeffence();

    void restoreHealth();

}