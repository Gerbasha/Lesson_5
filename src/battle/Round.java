package battle;


import abilitys.markers.FighterClassAbilitys;
import abilitys.markers.GodsHand;
import abilitys.markers.OnPostRoundPhaseAction;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.DragonRider;
import fighters.base.Fighter;
import fighters.base.Warrior;

import java.util.ArrayList;

public class Round {
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


    public Warrior getFirstFighter() {
        return firstFighter;
    }

    public Warrior getSecondFighter() {
        return secondFighter;
    }

    Warrior getWinner() {
        return winner;
    }

    void preTurnPhase() {

        ArrayList<FighterClassAbilitys> abilitysToUse = firstFighter.getAbilities();
        for (FighterClassAbilitys ability : abilitysToUse)
            if (ability instanceof OnPreRoundPhaseAction)
                ability.useAbilitys(firstFighter, secondFighter);
        if (firstFighter instanceof DragonRider)
            if (((DragonRider) firstFighter).getPet() != null) {
                DragonRider petMaster = ((DragonRider) firstFighter);
                petMaster.useDragon("pre", secondFighter);

            }

        abilitysToUse = secondFighter.getAbilities();

        for (FighterClassAbilitys ability : abilitysToUse)
            if (ability instanceof OnPreRoundPhaseAction)
                ability.useAbilitys(secondFighter, firstFighter);
        if (secondFighter instanceof DragonRider)
            if (((DragonRider) secondFighter).getPet() != null) {
                DragonRider petMaster = ((DragonRider) secondFighter);
                petMaster.useDragon("pre", firstFighter);

            }

    }

    void startRound() {
        boolean isFinished = true;
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

        ArrayList<FighterClassAbilitys> abilitysToUse = firstFighter.getAbilities();
        for (FighterClassAbilitys ability : abilitysToUse)
            if (ability instanceof OnPostRoundPhaseAction)
                ability.useAbilitys(firstFighter, secondFighter);
        if (firstFighter instanceof DragonRider)
            if (((DragonRider) firstFighter).getPet() != null) {
                DragonRider petMaster = ((DragonRider) firstFighter);
                petMaster.useDragon("post", secondFighter);

            }

        abilitysToUse = secondFighter.getAbilities();

        for (FighterClassAbilitys ability : abilitysToUse)
            if (ability instanceof OnPostRoundPhaseAction)
                ability.useAbilitys(secondFighter, firstFighter);
        if (secondFighter instanceof DragonRider)
            if (((DragonRider) secondFighter).getPet() != null) {
                DragonRider petMaster = ((DragonRider) secondFighter);
                petMaster.useDragon("post", firstFighter);

            }

    }

    void turnPhase() {
        firstFighter.attack(secondFighter);

        secondFighter.attack(firstFighter);
    }

}