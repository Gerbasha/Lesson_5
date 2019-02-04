package fighters.base;

public interface ElementalFighter {
    // коонстанты стихий необходимо перенсти сюда


    /**
     *
     * @return return element mask
     */
    int receiveElements();
    void changeAtackModyfier(float mult);

    float receiveCurrentAttack();
}
