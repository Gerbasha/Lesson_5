package fighters.base;

public interface ActionPostFight {
    void  doActionPostFight();
    default void doActionPostFight(float dealDamage, Fighter fighter){

    }

}
