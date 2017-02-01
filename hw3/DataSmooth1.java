import java.util.LinkedList;

class DataSmooth1 {
  DataSmooth1(){}
  
 /* public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
    return null;
  }*/




  //dataSmooth: consumes a list of PHRs and produces a list of the smoothed heartRate values.
  public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
    LinkedList<Double> smoothData=new LinkedList<>();

    smoothData.add((double)(phrs.get(0).heartRate));

    for (int i=1; i+1<phrs.size();i++){
      double sum=phrs.get(i-1).heartRate+phrs.get(i).heartRate+phrs.get(i+1).heartRate;
      smoothData.add(sum/3.0);
    }

    smoothData.add((double)(phrs.get(phrs.size()-1).heartRate));


    return smoothData;
  }
}