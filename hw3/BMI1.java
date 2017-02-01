import java.util.LinkedList;

class BMI1 {
  BMI1(){}
  
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
    BMISummary report= new BMISummary(underweight, healthy, overweight, obese);

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
    return report;
  }



}