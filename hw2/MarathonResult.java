public class MarathonResult extends AbsEvent implements IEvent {
    int position; // 1 for first, 2 for second, etc

    MarathonResult(double time, int position){
        super(time);
        this.position= position;
    }

    public double pointsEarned(){
        return this.time;
    }
}
