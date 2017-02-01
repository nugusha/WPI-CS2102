import java.util.LinkedList;

public class TestClassNames {

    public static void main(String[] args) {

        // dummy variables for assignment
        double x;
        boolean y;
        Athlete a;
        BiathlonRound b;

        // test making BiathlonRounds
        BiathlonRound biathlonRound1 = new BiathlonRound(1, 0.5);
        BiathlonRound biathlonRound2 = new BiathlonRound(3, 5.0);
        BiathlonRound biathlonRound3 = new BiathlonRound(2, 1.2);
        LinkedList<BiathlonRound> roundList= new LinkedList<BiathlonRound>();
        roundList.add(biathlonRound1);
        roundList.add(biathlonRound2);
        roundList.add(biathlonRound3);

        // test making each of the Result classes
        BiathlonResult biathlonResult = new BiathlonResult(roundList);
        CyclingResult cyclingResult = new CyclingResult(2.2, 6);

        // test making two athlete
        Athlete athlete1 = new Athlete("Steve", biathlonResult, cyclingResult);
        Athlete athlete2 = new Athlete("Ben", biathlonResult, cyclingResult);

        // test pointsEarned method
        x = cyclingResult.pointsEarned();
        x = biathlonResult.pointsEarned();

        // test bestRound method
        b = biathlonResult.bestRound();

        //test totalScore method
        x = athlete1.totalScore();

        //test hasBeaten method
        y = athlete2.hasBeaten(athlete1);

        // test betterCyclist methods
        a = athlete1.betterCyclist1(athlete2);
        a = athlete1.betterCyclist2(athlete2);

        System.out.println("Congrats! Your program compiled and ran!");

    }
}
