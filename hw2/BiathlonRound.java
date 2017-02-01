public class BiathlonRound {
    int targetsHit; //integer from 0-5
    double time; //time (in seconds) of the athlete’s run around the track in that round

    BiathlonRound(int targetsHit, double time){
        this.targetsHit= targetsHit;
        this.time= time;
    }

    public double pointsInRound(){
        return(this.time + (60 * (5- this.targetsHit)));
    }
}
