
import java.util.LinkedList;

public class Competition {

    LinkedList<Athlete> Athletes = new LinkedList<Athlete>();
    int numrounds;

    Competition(LinkedList<Athlete> Athletes, int numrounds){
        this.Athletes= Athletes;
        this.numrounds=numrounds;
    }

    LinkedList <Athlete> BiathlonDNF(){
        LinkedList<Athlete> athleteList= new LinkedList<Athlete>();

        for(Athlete w: Athletes) {
            if (w.biathlonResult.numRounds() < this.numrounds)
                athleteList.add(w);
        }
        return athleteList;
    }

    double scoreForAthlete(String name){
        double score= 0;
        for(Athlete w: Athletes){
            if(w.name.equals(name))
                score= w.totalScore();
        }
        return score;
    }

    int countCyclingImproved(Competition comp){
        int numAthletes=0;

        for(Athlete w: Athletes){
            numAthletes= numAthletes+ w.improved(comp);
        }
        return numAthletes;
    }
    
    /*
     * for the countCyclingImproved we implemented the helper method named improved 
     * which we added in athlete class
     * 
     * for scoreForAthlete we used totalScore as a helper method
     * 
     * we already created helpers and we are happy with it
     */
}
