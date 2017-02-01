import java.util.LinkedList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {
  // customize here, or create multiple monitors with different parameter lists
  SecurityMonitor SM = 
    new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern(),new FailedLoginPattern(),new LargeFilePattern())));
    SecurityMonitor SM2 =
            new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList()));
  // use this fixed set of usernames -- it is what we have in all the logs
  LinkedList<String> usernames = new LinkedList<String>(Arrays.asList("root","kathi", "simmon", "jordan"));
  Alert alert1=new Alert("aname", 5,3);
  Alert alert2=new Alert("aname", 5,3);

  public Examples() {}

    @Test
    public void checkloginLogAlerts(){
        // populate the queue based on a specific log
        SM.runLogFile("./src/webrequestlog.txt", usernames);
        assertEquals(1,SM.numAlerts());
        // reset the queue between test cases
        SM.clearQueue();
    }

    @Test
    public void checkloginLogAlerts2() {
        SM.runLogFile("./src/loginLog.txt", usernames);
        assertEquals(1, SM.numAlerts());
        SM.clearQueue();
    }

    /*
    @Test
    public void checkloginLogAlerts3() {
        SM2.runLogFile("./src/largeLog1.txt", usernames);
        assertEquals(3, SM2.numAlerts());
        SM2.clearQueue();
    }*/

    @Test
    public void checkloginLogAlerts4() {
        SM.runLogFile("./src/saveLog.txt", usernames);
        assertEquals(1, SM.numAlerts());
        SM.clearQueue();
    }

    /*
    @Test
    public void checkloginLogAlerts5() {
        SM2.runLogFile("./src/eventlog1.txt", usernames);
        assertEquals(4, SM2.numAlerts());
        SM2.clearQueue();
    }*/




    @Test
    public void equalsTest(){
        assertEquals(true,alert1.equals(alert2));
    }

    @Test
    public void compareToTest(){
        assertEquals(0,alert1.compareTo(alert2));
    }



    @Test
    public void checkEqualsTo() {
        Alert alert1 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
        Alert alert2 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
        assertTrue(alert1.equals(alert2));
    }

    @Test
    public void checkEqualsToFalse() {
        Alert alert1 = new Alert("test", 7, AbsEvent.FILE_SAVED);
        Alert alert2 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
        assertFalse(alert1.equals(alert2));
    }

    @Test
    public void checkEqualsToFalse2() {
        Alert alert1 = new Alert("test1", 8, AbsEvent.FILE_SAVED);
        Alert alert2 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
        assertFalse(alert1.equals(alert2));
    }

    @Test
    public void checkEqualsToFalse3() {
        Alert alert1 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
        Alert alert2 = new Alert("test1", 7, AbsEvent.LOGIN);
        assertFalse(alert1.equals(alert2));
    }

    @Test
    public void checkCompareToZero() {
        Alert alert1 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
        Alert alert2 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
        assertEquals(0, alert1.compareTo(alert2));
    }

    @Test
    public void checkCompareToNeg() {
        Alert alert1 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
        Alert alert2 = new Alert("test1", 5, AbsEvent.FILE_SAVED);
        assertEquals(-1, alert1.compareTo(alert2));
    }

    @Test
    public void checkCompareToPos() {
        Alert alert1 = new Alert("test1", 5, AbsEvent.FILE_SAVED);
        Alert alert2 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
        assertEquals(1, alert1.compareTo(alert2));
    }

}