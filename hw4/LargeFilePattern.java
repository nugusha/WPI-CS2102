import java.util.LinkedList;

public class LargeFilePattern implements IPattern {

    @Override
    public LinkedList<Alert> run(EventLog log, LinkedList<String> usernames){
        LinkedList<Alert> raiseAlerts= new LinkedList<>();

        for(String uname: usernames){
            int count=0;

            for(AbsEvent event: log.getLog()){

                if(event.isByUser(uname)) {
                    if ((event.getType() == AbsEvent.FILE_SAVED) &&
                            (((FileSaved) event).getSize() > 1000000)) {
                        count = count + 1;
                    }
                }
            }

            if(count>1){
                int severity = (Integer)Math.max(10, (count / 1));
                raiseAlerts.add(new Alert(uname, severity, AbsEvent.FILE_SAVED));
            }
        }

        return raiseAlerts;
    }


}


