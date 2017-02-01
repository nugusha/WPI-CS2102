public class Athlete {

    BiathlonResult biathlonResult;
    CyclingResult cyclingResult;

    Athlete(BiathlonResult BR, CyclingResult CR){
        this.biathlonResult= BR;
        this.cyclingResult= CR;
    }

    //sums the points across the Cycling and Biathlon results
    public double totalScore(){
        return(this.biathlonResult.pointsEarned() + this.cyclingResult.pointsEarned());
    }

    //takes another Athlete as input and returns a boolean indicating whether the
    // athlete has a lower total score than the given (input) Athlete
    public boolean hasBeaten(Athlete other) {
        return(this.totalScore() < other.totalScore());
    }

    //take another Athlete as input, and return whichever of the two athletes has the lower score on the cycling event alone
    public Athlete betterCyclist1(Athlete other){
        if (this.cyclingResult.pointsEarned() < other.cyclingResult.pointsEarned())
            return this;
        return other;
    }

    //take another Athlete as input, and return whichever of the two athletes has the lower score on the cycling event alone
    public Athlete betterCyclist2(Athlete other){
        if (this.cyclistScore() < other.cyclistScore())
            return this;
        return other;
    }

    //returns the athletes score in the cycling event
    public double cyclistScore(){
        double ret= this.cyclingResult.time;

        if (this.cyclingResult.position == 1) ret -= 10;
        if (this.cyclingResult.position == 2) ret -= 7;
        if (this.cyclingResult.position == 3) ret -= 3;

        return ret;
    }



}
