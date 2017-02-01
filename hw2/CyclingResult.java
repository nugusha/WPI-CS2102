
public class CyclingResult extends AbsEvent implements IEvent {
    int position; // 1 for first, 2 for second, etc

    CyclingResult(double time, int position){
        super(time);
        this.position= position;
    }

    //returns a double representating an athlete’s score on that event
    public double pointsEarned(){
        double ret= this.time;

        if (this.position == 1) ret -= 10;
        if (this.position == 2) ret -= 7;
        if (this.position == 3) ret -= 3;

        return ret;
    }

}
