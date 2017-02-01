abstract class AbsEvent implements IEvent {
    double time; //time in seconds at which the athlete crossed the finish line

    AbsEvent(double time){
        this.time= time;
    }
}
