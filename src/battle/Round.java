package battle;


import abilitys.GodsHand;
import fighters.Dragon;
import fighters.DragonRider;
import fighters.base.ActionPreFight;
import fighters.base.Fighter;

public class Round {
    private Fighter firstFighter;
    private Fighter secondFighter;
    private Fighter winner;

    public void serFirstFighter(Fighter fighter) {
        this.firstFighter = fighter;
    }

    public void setSecondFighter(Fighter fighter) {
        this.secondFighter = fighter;
    }

    Fighter fight(GodsHand hand) {


        preRoundPhase();
        roundPhase();
        postRaundPhase();

        return winner;
    }

    private void postRaundPhase() {

    }

    public Fighter getFirstFighter() {
        return firstFighter;
    }

    public Fighter getSecondFighter() {
        return secondFighter;
    }

    Fighter getWinner() {
        return winner;
    }

    private void preRoundPhase() {
        if (firstFighter instanceof ActionPreFight) {
            ((ActionPreFight) firstFighter).doActionBeforeFight();
        }
        if (secondFighter instanceof ActionPreFight) {
            ((ActionPreFight) secondFighter).doActionBeforeFight();
        }
    }

     void roundPhase() {
        boolean isFinished = false;
        int rounds = 1;
        do {
            firstFighter.attack(secondFighter);
            if (firstFighter instanceof DragonRider && secondFighter instanceof Dragon) {
                winner = firstFighter;
                isFinished = false;
            } else
                secondFighter.attack(firstFighter);
            if (rounds++ > 10) isFinished = false;
//            if (firstFighter.getCurrentHelth() <= 0 | secondFighter.getCurrentHelth() <= 0) {
//                if (firstFighter.getCurrentHelth() <= 0)
//                    hand.pray(firstFighter);
//                if (secondFighter.getCurrentHelth() <= 0)
//                    hand.pray(secondFighter);
                if (firstFighter.getCurrentHelth() <= 0 | secondFighter.getCurrentHelth() <= 0) {
                    isFinished = false;
                }


                if (winner == null) {
                    System.out.println(firstFighter.getCurrentHelth() > secondFighter.getCurrentHelth() ?
                            firstFighter.getClass().getSimpleName() + " " + firstFighter.getName() + " winn" :
                            secondFighter.getClass().getSimpleName() + " " + secondFighter.getName() + " winn");
                    winner = (firstFighter.getCurrentHelth() > 0) ? firstFighter : secondFighter;
                } else System.out.println(winner.getClass().getSimpleName() + " " + secondFighter.getName() + " winn");

                winner.restoreHealth();


        } while (isFinished);
    }
}