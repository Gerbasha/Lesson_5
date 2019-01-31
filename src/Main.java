import battle.Battlefield;

public class Main {
    public static void main(String[] args) {
        Battlefield arena = new Battlefield();
        arena.prepairFigters();
        arena.startBattle();
        arena.getSummary();


//        int talant = 0;
//        Random fate = new Random();
//        for (; ; ) {
//            talant = (int) (Math.abs(fate.nextGaussian() * 10))%4;
//            System.out.println(talant);
//        }

    }
}
