package battle;


import abilitys.GodsHand;
import abilitys.markers.OnPostRoundPhaseAction;
import abilitys.markers.OnPreRoundPhaseAction;
import fighters.base.Fighter;
import fighters.base.Warrior;

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
        postRaundPhase();

        return winner;
    }

    private void postRaundPhase() {

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

        if (firstFighter.getAbilities().contains(new OnPreRoundPhaseAction())) {
            firstFighter.getAbilities().useAbility(firstFighter, secondFighter);
        }
        if (secondFighter instanceof OnPreRoundPhaseAction) {
            secondFighter.getAbilities().useAbility(secondFighter, firstFighter);
        }
    }

    void startRound() {
        boolean isFinished = true;
        int rounds = 1;
        if (winner != null) isFinished = false;

        while (isFinished) {
          preTurnPhase();
          turnPhase();
          postRaundPhase();

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

        if (firstFighter.getAbilities() instanceof OnPostRoundPhaseAction) {
            firstFighter.getAbilities().useAbility(firstFighter, secondFighter);
        }
        if (secondFighter instanceof OnPostRoundPhaseAction) {
            secondFighter.getAbilities().useAbility(secondFighter, firstFighter);
        }
    }
    void turnPhase(){
        firstFighter.attack(secondFighter);

        secondFighter.attack(firstFighter);
    }
}