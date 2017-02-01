import java.util.LinkedList;

class Earthquake2 {
    Earthquake2() {
    }

    // checks whether a datum is a date
    boolean isDate(double anum) {
        return (int) anum > 10000000;
    }

    // extracts the month from an 8-digit date
    int extractMonth(double dateNum) {
        return ((int) dateNum % 10000) / 100;
    }

  /*public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,int month) {
    return null;
  }*/

    /*public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
        return null;
    }*/



    //dailyMaxForMonth: consumes a list of sensor data (doubles) and a month (represented by a number between 1 and 12)
    // and produces a list of reports (maxHzReport) indicating the highest frequency reading for each day in that month.
    public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
        LinkedList<MaxHzReport> report=new LinkedList<MaxHzReport>();

        for (int i = 0; i < data.size(); i++) {

            if (data.get(i) > 10000000) {

                if ((int) (data.get(i) % 10000) / 100 == month) {
                    double dates = data.get(i);
                    double max = data.get(i + 1);


                    for (int k=i+1; k < data.size(); k++) {


                        if (data.get(k) <= 500) {
                            if (data.get(k) > max)
                                max = data.get(k);
                        }
                        if (data.get(k) > 10000000)
                            break;

                    }

                    report.add(new MaxHzReport(dates,max));
                }
            }
        }

        return report;
    }


}