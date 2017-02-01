import java.util.LinkedList;

public class FailedLoginPattern implements IPattern {

    @Override
    public LinkedList<Alert> run(EventLog log, LinkedList<String> usernames) {
        LinkedList<Alert> raiseAlerts = new LinkedList<Alert>();

        for (String uname : usernames) {
            int count = 0;
            int logTimes=0;
            int maxIn5Min=0;


            for (AbsEvent event: log.getLog()) {
                AbsEvent event1 = log.getLog().get(0);
                AbsEvent event2 = event;
                long diff = event1.getTimestamp().getTime() -
                        event2.getTimestamp().getTime();

                if (event.isByUser(uname)) {
                    if ((event.getType() == AbsEvent.LOGIN) &&
                            (!((Login) event).wasSuccessful())) {

                        logTimes=logTimes+1;
                        if(maxIn5Min==0){
                            maxIn5Min=1;
                            event1=event;
                        }
                        if(maxIn5Min>0 && maxIn5Min<3){
                            if(diff / 60000.0 <= 5.0){
                                logTimes = logTimes + 1;
                                maxIn5Min=maxIn5Min+1;
                            }
                        }
                        else maxIn5Min=maxIn5Min;
                    }
                }
            }

            if(maxIn5Min>=3)
                count=logTimes;
            else count=0;

            if (count > 0) {
                int severity = (Integer) Math.max(10, (count / 1));
                raiseAlerts.add(new Alert(uname, severity, AbsEvent.LOGIN));
            }

        }

        return raiseAlerts;
    }



}
