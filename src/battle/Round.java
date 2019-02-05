package battle;


import abilitys.markers.FighterClassAbilitys;
import abilitys.markers.GodsHand;
import abilitys.markers.OnPostRoundPhaseAction;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.base.Fighter;
import fighters.base.Warrior;

import java.util.ArrayList;

public class Round {
    private boolean isFinished;
    private Warrior firstFighter;
    private Warrior secondFighter;
    private Warrior winner;

    public void serFirstFighter(Warrior fighter) {
        this.firstFighter = fighter;
    }

    public void setSecondFighter(Warrior fighter) {
        this.secondFighter = fighter;
    }

    Fighter fight(GodsHand hand) {

        preTurnPhase();
        startRound();
        postTurnPhase();

        return winner;
    }

    Warrior getWinner() {
        return winner;
    }

//    instanceof DragonRider - должен перехать в интерфейс

    void preTurnPhase() {
        if (isFinished) {
            ArrayList<FighterClassAbilitys> abilitysToUse = firstFighter.getAbilities();
            prePhaseFighterIdenrification(abilitysToUse, firstFighter, secondFighter);

            abilitysToUse = secondFighter.getAbilities();
            prePhaseFighterIdenrification(abilitysToUse, secondFighter, firstFighter);
        }
    }

    private void prePhaseFighterIdenrification(ArrayList<FighterClassAbilitys> abilitysToUse, Warrior firstFighter, Warrior secondFighter) {
        for (FighterClassAbilitys ability : abilitysToUse)
            if (ability instanceof OnPreRoundPhaseAction) // нет необходимости разделять FighterClassAbilitys с ActionPhase
                ability.useAbilitys(firstFighter, secondFighter);
    }

    void startRound() {
        isFinished = true;
        int rounds = 1;
        if (winner != null) isFinished = false;

        while (isFinished) {
            preTurnPhase();
            turnPhase();
            postTurnPhase();
//            if (firstFighter.getCurrentHelth() <= 0 | secondFighter.getCurrentHelth() <= 0) {
//                if (firstFighter.getCurrentHelth() <= 0)
//                    hand.pray(firstFighter);
//                if (secondFighter.getCurrentHelth() <= 0)
//                    hand.pray(secondFighter);
            if (firstFighter.getCurrentHelth() <= 0 | secondFighter.getCurrentHelth() <= 0) {
                isFinished = false;
            }
            if (rounds++ > 10) isFinished = false;
        }
        if (winner == null) {
            System.out.println(firstFighter.getCurrentHelth() > secondFighter.getCurrentHelth() ?
                    firstFighter.getClass().getSimpleName() + " " + firstFighter.getName() + " winn" :
                    secondFighter.getClass().getSimpleName() + " " + secondFighter.getName() + " winn");
            winner = (firstFighter.getCurrentHelth() > 0) ? firstFighter : secondFighter;
        } else System.out.println(winner.getClass().getSimpleName() + " " + secondFighter.getName() + " winn");

        winner.restore();
    }

    void postTurnPhase() {

        if (isFinished) {
            ArrayList<FighterClassAbilitys> abilitysToUse = firstFighter.getAbilities();
            postPhaseFighterIdentification(abilitysToUse, firstFighter, secondFighter);

            abilitysToUse = secondFighter.getAbilities();

            postPhaseFighterIdentification(abilitysToUse, secondFighter, firstFighter);
        }
    }

    private void postPhaseFighterIdentification(ArrayList<FighterClassAbilitys> abilitysToUse, Warrior firstFighter, Warrior secondFighter) {
        for (FighterClassAbilitys ability : abilitysToUse)
            if (ability instanceof OnPostRoundPhaseAction)
                ability.useAbilitys(firstFighter, secondFighter);
    }

    void turnPhase() {
        if (isFinished) {
            firstFighter.attack(secondFighter);
            secondFighter.attack(firstFighter);
        }
    }
}