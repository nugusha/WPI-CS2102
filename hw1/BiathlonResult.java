public class BiathlonResult implements IEvent{
    BiathlonRound round1;
    BiathlonRound round2;
    BiathlonRound round3;

    BiathlonResult(BiathlonRound round1, BiathlonRound round2, BiathlonRound round3){
        this.round1= round1;
        this.round2=round2;
        this.round3= round3;
    }

    //returns a double representating an athlete’s score on that event
    public double pointsEarned(){
        return(this.pointsInRound1()+
                this.pointsInRound2()+
                this.pointsInRound3());
    }

    //returns whichever of the three BiathlonRounds that earned the best (lowest) score.
    // In case of a tie, return the earliest round
    BiathlonRound bestRound(){
        double minimumPoints=Math.min(this.pointsInRound1(),Math.min(pointsInRound2(), pointsInRound3()));
        if (minimumPoints == this.pointsInRound1())
            return this.round1;
        if (minimumPoints == this.pointsInRound2())
            return this.round2;
        return this.round3;
    }

    //returns athlete's points in round 1
    double pointsInRound1(){
        return(this.round1.time + (60 * (5- this.round1.targetsHit)));
    }

    //returns athlete's points in round 2
    double pointsInRound2(){
        return(this.round2.time + (60 * (5- this.round2.targetsHit)));
    }

    //returns athlete's points in round 3
    double pointsInRound3(){
        return(this.round3.time + (60 * (5- this.round3.targetsHit)));
    }
}
