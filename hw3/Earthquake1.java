import java.util.LinkedList;

class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }
 
 /* public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                                  int month) {
   return null;
  }*/



 //dailyMaxForMonth: consumes a list of sensor data (doubles) and a month (represented by a number between 1 and 12)
 // and produces a list of reports (maxHzReport) indicating the highest frequency reading for each day in that month.
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month){
    LinkedList<MaxHzReport> answer=new LinkedList<>();

    double cur_data=0;
    double cur_max=0;

    for(int i=0;i<data.size();i++){

      if(data.get(i)>500){
        cur_data=data.get(i);

        if(((int)(cur_data)/100)%100==month){
          MaxHzReport new_report= new MaxHzReport(cur_data,0);
          answer.add(new_report);
        }
        else{
          cur_data=0;
        }
      }

      else{

          if(cur_data>0){
            double max=answer.get(answer.size()-1).maxReading;

            if(max<data.get(i)){
              MaxHzReport changed_report= new MaxHzReport(cur_data,(double)(data.get(i)));

              answer.set(answer.size()-1,changed_report);
            }
          }
      }
    }

    return answer;
  }
}

