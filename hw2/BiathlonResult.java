import java.util.LinkedList;


public class BiathlonResult implements IEvent {
    LinkedList<BiathlonRound> rounds= new LinkedList<>();

    BiathlonResult(LinkedList<BiathlonRound> rounds){
        this.rounds= rounds;
    }

    //returns a double representating an athlete’s score on that event
    public double pointsEarned(){
        double points= 0;

        for(BiathlonRound w: rounds){
            points= points + w.pointsInRound();
        }
        return points;
    }

    public void addList(BiathlonRound round){
        rounds.add(round);
    }

    //returns whichever of the three BiathlonRounds that earned the best (lowest) score.
    // In case of a tie, return the earliest round
    BiathlonRound bestRound(){
        BiathlonRound best= rounds.get(0);

        
        
        for(BiathlonRound w: rounds){
            if(w.pointsInRound()< best.pointsInRound())
                best= w;
        }
        return best;
    }

    int numRounds(){
        int num=rounds.size();
        return num;
    }


}
