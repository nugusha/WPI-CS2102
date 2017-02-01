import java.util.PriorityQueue;
import java.util.LinkedList;

class SecurityMonitor {
  LinkedList<IPattern> patterns;
  private PriorityQueue<Alert> alertQ = new PriorityQueue<Alert>();
  SystemLog parser = new SystemLog();
  
  SecurityMonitor(LinkedList<IPattern> patts) {
    this.patterns = patts;
  }
  
  // takes filename for logfiles and usernames to track within the log
  void runLogFile(String logFile, LinkedList<String> onUsernames) {
    // read the logfile and create the EventLog from it
    EventLog theLog = parser.parseLog(logFile);
    System.out.println("Monitoring " + patterns.size() + " pattern(s)");
    SuspiciousWebPattern a = new SuspiciousWebPattern();
    LargeFilePattern b= new LargeFilePattern();
    FailedLoginPattern c= new FailedLoginPattern();

    alertQ.addAll(a.run(theLog,onUsernames));
    alertQ.addAll(b.run(theLog,onUsernames));
    alertQ.addAll(c.run(theLog,onUsernames));
  }
  
  // return the top alert on the priority queue
  Alert topAlert() {
    return alertQ.peek();
  }
  
  // return the number of alerts in the queue
  int numAlerts() {
    return alertQ.size();
  }
  
  // remove the first alert from the queue, returning it to the user
  Alert handleAlert() {
    return alertQ.poll();
  }
  
  // clears everything out of the queue (to reset between tests)
  void clearQueue() {
    alertQ.clear();
  }
  
}
    
  