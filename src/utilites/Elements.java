package utilites;

/**
 * Created by Андрей on 23.01.2019.
 */
public enum Elements {
    WATER(1),
    FIRE(2),
    EARTH(4),
    AIR(8);
    public int element;

    Elements(int s) {

        this.element = s;
    }

    public int sign() {
        return element;
    }
}
