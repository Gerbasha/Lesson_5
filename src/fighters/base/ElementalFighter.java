package fighters.base;

public interface ElementalFighter {

    /**
     *
     * @return return element mask
     */
    int receiveElements();
    void changeAtackModyfier(float mult);

    float receiveCurrentAttack();
}
