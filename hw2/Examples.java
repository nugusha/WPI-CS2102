
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Examples {

	public Examples () {}
	
	
	
	    BiathlonRound quickRound = new BiathlonRound(5,30);
	    BiathlonRound roundTwo= new BiathlonRound(4, 100);
	    BiathlonRound roundThree= new BiathlonRound(3, 120);

/*
    BiathlonResult goodResult = new BiathlonResult(quickRound, roundTwo, roundThree);
    BiathlonResult alrightResult = new BiathlonResult(roundTwo, quickRound, roundThree);
    BiathlonResult badResult = new BiathlonResult(roundTwo, roundThree, quickRound);
    BiathlonResult anotherResult = new BiathlonResult(roundTwo, quickRound, roundThree);
*/
	    
	    
		LinkedList<BiathlonRound> B1=new LinkedList<BiathlonRound>();
		LinkedList<BiathlonRound> B2=new LinkedList<BiathlonRound>();
		LinkedList<BiathlonRound> B3=new LinkedList<BiathlonRound>();
		LinkedList<BiathlonRound> B4=new LinkedList<BiathlonRound>();
		LinkedList<BiathlonRound> B5=new LinkedList<BiathlonRound>();
		LinkedList<BiathlonRound> B6=new LinkedList<BiathlonRound>();
		LinkedList<BiathlonRound> B7=new LinkedList<BiathlonRound>();
		LinkedList<BiathlonRound> B_empty=new LinkedList<BiathlonRound>();
		

	public void add1(){
		B1.add(quickRound);
		B1.add(roundTwo);
		B1.add(roundThree);

		B2.add(roundTwo);
		B2.add(quickRound);		
		B2.add(roundThree);

		B3.add(roundTwo);		
		B3.add(roundThree);
		B3.add(quickRound);
		

		B5.add(roundThree);
		B5.add(roundTwo);
		B6.add(roundTwo);
		B6.add(roundThree);
		
		B7.add(roundThree);
	}

		BiathlonResult goodResult = new BiathlonResult(B1);
		BiathlonResult alrightResult = new BiathlonResult(B2);
		BiathlonResult badResult = new BiathlonResult(B3);
		BiathlonResult BR_empty = new BiathlonResult(B4);
		BiathlonResult BR5 = new BiathlonResult(B5);
		BiathlonResult BR6 = new BiathlonResult(B6);
		BiathlonResult BR7 = new BiathlonResult(B7);
		


	    CyclingResult CR1= new CyclingResult(120,1);
	    CyclingResult CR2= new CyclingResult(130,2);
	    CyclingResult CR3= new CyclingResult(140,3);
	    CyclingResult CR7= new CyclingResult(180,6);
	

	    Athlete A1= new Athlete("George",goodResult, CR1);
	    Athlete A2= new Athlete("Alex",alrightResult, CR2);
	    Athlete A3= new Athlete("Nick",badResult, CR3);
	    Athlete A7= new Athlete("Luka",alrightResult,CR7);
	    
	    Athlete A10= new Athlete("Nick",BR6, CR1);
	    Athlete A20= new Athlete("Luka",BR6,CR7);

	    LinkedList<Athlete> Athletes=new LinkedList<Athlete>();
	    LinkedList<Athlete> Athletes2=new LinkedList<Athlete>();
	    LinkedList<Athlete> Athletes_A10_A20=new LinkedList<Athlete>();
	    LinkedList<Athlete> AthletesEmpty=new LinkedList<Athlete>();
	    
	public void add2(){
	    Athletes.add(A1);
	    Athletes.add(A2);
	    Athletes.add(A3);
	    Athletes.add(A7);

	    Athletes_A10_A20.add(A10);
	    Athletes_A10_A20.add(A20);
	    
	    Athletes2.add(A1);
	    Athletes2.add(A10);
	    Athletes2.add(A20);
	}

//    add1();
   // add2();

		Competition C1= new Competition (Athletes,5);
		Competition C2= new Competition (Athletes,3);
		Competition C3= new Competition (Athletes2,3);
		Competition C10_20= new Competition (Athletes_A10_A20,3);

		/*
		@Test  // checks number of rounds in a competition
		public void test1(){
			assertEquals(5,C1.numrounds);
		}
		*/

		@Test  
		public void points_in_BR(){
			add1();
			add2();
			// checks points earned in biathlon result
			assertEquals(goodResult.pointsEarned(),430.00,0.1);
			// checks points earned in empty biathlon result
			assertEquals(BR_empty.pointsEarned(),0,0.1);
		}
		
		@Test
		public void best_round_in_list(){
			add1();
			add2();
			
			// checks best round in BiathlonResult with 3 rounds
			// which consist of same rounds with different permutations
			   assertEquals(goodResult.bestRound(),quickRound);
			   assertEquals(alrightResult.bestRound(),quickRound);
			   assertEquals(badResult.bestRound(),quickRound);
			   
			// checks best round in BiathlonResult with 2 rounds
			   assertEquals(BR5.bestRound(),roundTwo);
			   assertEquals(BR6.bestRound(),roundTwo);

		    // checks best round in BiathlonResult with only 1 round
			   assertEquals(BR7.bestRound(),roundThree);
		}
		

		@Test
		public void B_DNF(){
			add1();
			add2();
		// no athlete finishes	
			assertEquals(C1.BiathlonDNF(),Athletes);
		// all athletes finish	
			assertEquals(C2.BiathlonDNF(),AthletesEmpty);
	    // 2 of 3 athletes finish
			assertEquals(C3.BiathlonDNF(),Athletes_A10_A20);
		}
		
		
		@Test
		public void ScoreForAthlete(){
			add1();
			add2();
		// Checks scores for each of the athletes in C1 and C3	
			assertEquals(C1.scoreForAthlete("George"),540.0,0.1);
			assertEquals(C1.scoreForAthlete("Alex"),553.0,0.1);
			assertEquals(C1.scoreForAthlete("Nick"),567.0,0.1);
			assertEquals(C3.scoreForAthlete("Luka"),580.0,0.1);
			assertEquals(C3.scoreForAthlete("Nick"),510.0,0.1);
		}
		
		
		@Test
		public void test_improved(){
			add1();
			add2();
			// checks competitions with same athletes with different order
			assertEquals(C1.countCyclingImproved(C2),0);
			assertEquals(C2.countCyclingImproved(C1),0);
			// check competitions where 1 person improves
			assertEquals(C10_20.countCyclingImproved(C1),1);
			// checks competitions where 1 person regresses
			assertEquals(C1.countCyclingImproved(C10_20),0);
		}
}
