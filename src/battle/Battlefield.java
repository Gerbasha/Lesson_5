package battle;

import fighters.base.Warrior;
import unitLabs.DragonLair;
import utilites.Helper;

import static utilites.Helper.*;

public class Battlefield {
    Warrior[] horde;
    Warrior[][] tableOfRounds;
    Helper utilWorker;
    boolean isRoundFinished;
    boolean isTournamentFinished;
    Round pair;
    Warrior chempion;
   // Dragon punisher=new DragonLair().getBorned();

    public void startBattle() {

        isTournamentFinished = false;
        isRoundFinished = false;
        int stageCount = getStageCount(horde.length);
        tableOfRounds = new Warrior[stageCount + 1][];
        Warrior[] nextTournamentStage = new Warrior[horde.length / 2];
        int winners = 0;
        int round = 1;
        prepairRound(tableOfRounds, horde, round);
        // разписываем на два метода.
        // меняем на  do while
        while (!isTournamentFinished) {
            System.out.println("round " + round + " started");
            for (int i = 0; i < tableOfRounds[round - 1].length; i += 2) {
                pair = getNextFightersPair(tableOfRounds[round - 1], i);

                pair.startRound();

                if (round < stageCount - 1) nextTournamentStage[winners++] = pair.getWinner();
                else {
                    chempion = pair.getWinner();

                }
            }

            if (round == stageCount - 1) isTournamentFinished = true;
            else {
                round++;
                winners = 0;
                prepairRound(tableOfRounds, nextTournamentStage, round);
                printSummary(tableOfRounds[round - 1]);
                nextTournamentStage = new Warrior[tableOfRounds[round - 1].length / 2];
            }
        }
        tableOfRounds[round] = new Warrior[tableOfRounds[round - 1].length / 2];
        tableOfRounds[round][0] = chempion;
    }

    private int getStageCount(int length) {
        int count;
        if (length == 1)
            return 1;
        else
            count = getStageCount(length / 2) + 1;
        return count;
    }

    public void getSummary() {
        printSummary(tableOfRounds);

    }

    public void prepairFigters() {
        DragonLair hole = new DragonLair();

        horde = new Warrior[8];

        tableOfRounds = new Warrior[5][];
        tossUpFigters(horde);
        printSummary(horde);

    }

//    void punish(Fighter fighter){
//        punisher.attack(fighter);
//    }
}
