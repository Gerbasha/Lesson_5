package fighters;

import andrew.honework.com.lesson_5.Elements;
import andrew.honework.com.lesson_5.fighters.base.ActionPostFight;
import andrew.honework.com.lesson_5.fighters.base.ElementalFighter;
import andrew.honework.com.lesson_5.fighters.base.Fighter;
import andrew.honework.com.lesson_5.fighters.base.Warrior;

public class Elemental extends Warrior implements ElementalFighter, ActionPostFight {
  int element;
    public Elemental(Elements elements) {
        element= elements.element;
    }

    @Override
    public int getElements() {
        return element;
    }

    @Override
    public void doActionPostFight() {

    }

    @Override
    public void doActionPostFight(float dealDamage, Fighter fighter) {

    }
}
