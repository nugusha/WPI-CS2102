public class InvalidRateException extends Exception{
    Double rate;

    InvalidRateException(Double rate){
        this.rate=rate;
    }

}
