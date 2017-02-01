public class Alert implements Comparable{
    String uname;  //username of person with suspicious behavior
    int severity; //an integer from 1 to 10
    int type; //integer from 1 to 6

    Alert(String uname, int severity, int type){
        this.uname=uname;
        this.severity=severity;
        this.type=type;
    }

    // indicates which of this object or the given object should be considered "smaller"
    // it should return 0 if the two alerts are equaly severe
    // -1 if the alert is more severe than the given alert
    // 1 if the alert is less severe than the given alert
    public int compareTo(Object otherObj){
        Alert other= (Alert) otherObj;

        if(this.severity == other.severity)
            return 0;
        if(this.severity > other.severity)
            return -1;
        if(this.severity < other.severity)
            return 1;
        else return 0;
    }

    public boolean equals(Object otherObj){
        Alert other= (Alert) otherObj;

        if(this.uname == other.uname){
            if(this.severity == other.severity){
                if(this.type == other.type)
                    return true;
            }
        }
        return false;
    }


}
