import java.util.LinkedList;

class BMI2 {
  BMI2(){}
  
  /*public BMISummary bmiReport(LinkedList<PHR> phrs) {
    return null;
  }*/


  //bmiReport:  consumes a list of personal health records (defined above) and produces
  // a report containing a list of names (not the entire records) of patients in each BMI classification category.
  public BMISummary bmiReport(LinkedList<PHR> phrs){
    LinkedList<String> underweight= new LinkedList<>();
    LinkedList<String> healthy= new LinkedList<>();
    LinkedList<String> overweight= new LinkedList<>();
    LinkedList<String> obese= new LinkedList<>();

    for(PHR w: phrs){
      if(w.personBMI()>=30)
        obese.add(w.name);
      if(w.personBMI()>=25 && w.personBMI()<30)
        overweight.add(w.name);
      if(w.personBMI()>=18.5 && w.personBMI()<25)
        healthy.add(w.name);
      if(w.personBMI()<18.5)
        underweight.add(w.name);

    }
    return makeReport(underweight, healthy, overweight, obese);
  }


  //makeReport: consumes four lists and creates a new BMISummary.
  public BMISummary makeReport(LinkedList<String> uw,LinkedList<String> h,LinkedList<String> ow,LinkedList<String> o){
    BMISummary report= new BMISummary(uw, h, ow, o);
    return report;
  }
}