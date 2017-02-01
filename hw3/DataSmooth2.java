import java.util.LinkedList;

class DataSmooth2 {
  DataSmooth2(){}
  
  /*public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
    return null;
  }*/


  //dataSmooth: consumes a list of PHRs and produces a list of the smoothed heartRate values.
  public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
    LinkedList<Double> smoothData=new LinkedList<>();


    for(int i=0;i<phrs.size();i++){

      smoothData.add((double) (phrs.get(i).heartRate));
    }

    for(int i=1;i+1<phrs.size();i++) {

      double sum=phrs.get(i-1).heartRate+phrs.get(i).heartRate+phrs.get(i+1).heartRate;

      smoothData.set(i,sum/3.0);
    }

    return smoothData;
  }


}