package utilites;

import battle.Round;
import fighters.Cheeter;
import fighters.Dragon;
import fighters.DragonRider;
import fighters.base.Fighter;
import fighters.base.Warrior;
import unitLabs.Barracs;

import java.util.Random;

public class Helper {
    private static String[] firstName =
            {"Ва", "Фе", "Се", "Пе", "Ван", "Ка", "Сен", "Зол"};
    private static String[] middleName =
            {"Кир", "Нат", "Нег", "Зуб", "Драк", "Зай", "Окс", "Кус"};
    private static String[] lastName =
            {"Неп", "Соп", "Кир", "Сам", "Дох", "Зел", "Хол", "Ив"};
    private static Random randomHelper;

    Helper() {

    }

    public static Random getRandomHelper() {

        if (randomHelper != null) return randomHelper;
        else {
            randomHelper = new Random();
            return randomHelper;
        }
    }

    public static String generateName() {

        return firstName[Math.abs(getRandomHelper().nextInt() % 8)] +
                middleName[Math.abs(getRandomHelper().nextInt() % 8)] +
                lastName[Math.abs(getRandomHelper().nextInt() % 8)];
    }

    public static void printSummary(Warrior[][] table) {//todo not null
        Warrior f1 = null;
        Warrior f2 = null;
        for (int i = 0; i < table.length - 1; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (j == table[i].length - 1) {
                    f1 = table[i][j];
                    System.out.println(f1.getClass().getSimpleName() + " " +
                            f1.getName());
                } else {
                    f1 = table[i][j];
                    j++;
                    f2 = table[i][j];
                    System.out.print(f1.getClass().getSimpleName() + " " +
                            f1.getName() + " X " + f2.getClass().getSimpleName() + " " + f2.getName());
                    if (j < table[i].length - 2) System.out.print(" || ");
                    System.out.print("");
                }
            }
            System.out.println();
            for (int k = 1; k <= table.length / 2 + i; k++) {
                System.out.print("            ");
            }
        }
    }


    public static void tossUpFigters(Fighter[] horde) {
        for (int i = 0; i < horde.length; i++) {
            horde[i] = Barracs.getNewFighter();
        }
    }

    public static void printSummary(Warrior[] horde) {
        System.out.println("This fighters are ready for tournament:");
        for (Warrior f : horde) {
            System.out.println(f.getClass().getSimpleName() + " " + f.getName() + "[" + f.getHelth() + "] " + " a:" + f.getAttak() + " d:" + f.getDeffence());


        }
    }

    public static void prepairRound(Warrior[][] tableOfRounds, Warrior[] horde, int round) {
        if (tableOfRounds != null) {

            tableOfRounds[round - 1] = new Warrior[horde.length];
            for (int i = 0; i < horde.length; i++) {
                tableOfRounds[round - 1][i] = horde[i];
            }
        }

    }

    public static Round getNextFightersPair(Warrior[] horde, int i) {
        Round couple = new Round();

        Warrior first = horde[i];
        Warrior second = horde[i + 1];
        if (second instanceof Cheeter) {
            couple.serFirstFighter(second);
            couple.setSecondFighter(first);
        } else if (second instanceof DragonRider && first instanceof Dragon) {
            couple.serFirstFighter(second);
            couple.setSecondFighter(first);
        } else {
            couple.serFirstFighter(first);

            couple.setSecondFighter(second);
        }


        return couple;
    }
}
