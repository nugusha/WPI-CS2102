//Nugzar Chkhaidze nchkhaidze
//Alex Tavares amtavares

import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    public Examples () {}
/*
    @Test
    public void simpleCheck() {
	assertEquals(4, 4);
    }


    @Test
    public void simpleDoublesCheck() {
	assertEquals(4.0, 4.0, .01);
    }
*/

    BiathlonRound quickRound = new BiathlonRound(5,30);
    BiathlonRound roundTwo= new BiathlonRound(4, 100);
    BiathlonRound roundThree= new BiathlonRound(3, 120);
    BiathlonResult goodResult = new BiathlonResult(quickRound, roundTwo, roundThree);
    BiathlonResult alrightResult = new BiathlonResult(roundTwo, quickRound, roundThree);
    BiathlonResult badResult = new BiathlonResult(roundTwo, roundThree, quickRound);
    BiathlonResult anotherResult = new BiathlonResult(roundTwo, quickRound, roundThree);

    @Test
    public void testQuickBest() {
        assertEquals(quickRound, goodResult.bestRound());
    }

    @Test
    public void testBest() {
        assertEquals(quickRound, alrightResult.bestRound());
    }

    @Test
    public void testBestAgainBest() {
        assertEquals(quickRound, badResult.bestRound());
    }

    @Test
    public void testRound1(){
        assertEquals(30.0, goodResult.pointsInRound1(),.01);
    }

    @Test
    public void testRound2(){
        assertEquals(30.0, alrightResult.pointsInRound2(), .01);
    }

    @Test
    public void testRound3(){
        assertEquals(30.0, badResult.pointsInRound3(), .01);
    }

    @Test
    public void testPointsEarned(){
        assertEquals(430.0, goodResult.pointsEarned(), .01);
    }


    CyclingResult CR1= new CyclingResult(120,1);
    CyclingResult CR2= new CyclingResult(130,2);
    CyclingResult CR3= new CyclingResult(140,3);
    CyclingResult CR7= new CyclingResult(180,6);

    @Test
    public void testCR1PointsEarned(){
        assertEquals(110, CR1.pointsEarned(), .01);
    }

    @Test
    public void testCR2PointsEarned(){
        assertEquals(123, CR2.pointsEarned(), .01);
    }

    @Test
    public void testCR3PointsEarned(){
        assertEquals(137, CR3.pointsEarned(), .01);
    }

    @Test
    public void testCR7PointsEarned(){
        assertEquals(180, CR7.pointsEarned(), .01);
    }


    Athlete A1= new Athlete(goodResult, CR1);
    Athlete A2= new Athlete(alrightResult, CR2);
    Athlete A3= new Athlete(badResult, CR3);
    Athlete A7= new Athlete(anotherResult,CR7);

    @Test
    public void testTotalScore(){
        assertEquals(540, A1.totalScore(), .01);
    }

    @Test
    public void testHasBeaten1(){
        assertTrue(A1.hasBeaten(A2));
    }

    @Test
    public void testHasBeaten2(){
        assertFalse(A3.hasBeaten(A1));
    }

    @Test
    public void testBetterCyclist11(){
        assertEquals(A1, A1.betterCyclist1(A2));
    }
    @Test
    public void testBetterCyclist12(){
        assertEquals(A1, A3.betterCyclist1(A1));
    }

    @Test
    public void testBetterCyclist21(){
        assertEquals(A2, A2.betterCyclist1(A3));
    }
    @Test
    public void testBetterCyclist22(){
        assertEquals(A2, A3.betterCyclist1(A2));
    }

    @Test
    public void testCyclistScore1(){
        assertEquals(110, A1.cyclistScore(), .01);
    }

    @Test
    public void testCyclistScore2(){
        assertEquals(123, A2.cyclistScore(), .01);
    }

    @Test
    public void testCyclistScore3(){
        assertEquals(137, A3.cyclistScore(), .01);
    }

    @Test
    public void testCyclistScore4(){
        assertEquals(180, A7.cyclistScore(), .01);
    }

}
