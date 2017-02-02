public class LowerRateException extends Exception{
    Double oldRate;
    Double newRate;

    LowerRateException(Double oldRate, Double newRate){
        this.oldRate=oldRate;
        this.newRate=newRate;
    }

}
