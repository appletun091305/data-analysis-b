import java.util.ArrayList;

public class DataAnalyzer {
  public int internetfinder() {
    ArrayList<String> countries = FileOperator.getStringList("countries.txt");
    ArrayList<Double> percents = FileOperator.getDoubleList("internetpercent.txt");
    int good = 0;

    for (int i = 0; i < countries.size() && i < percents.size(); i++) {
      double percent = percents.get(i);
            if (percent >= 0 && percent < 10) {
                System.out.println(countries.get(i) + " - " + percent + "%");
                good++;
            }
        }
        return good;
    }    
  public static void main(String[] args) { 
    DataAnalyzer analyzer = new DataAnalyzer();
    int result = analyzer.internetfinder();
    System.out.println("Number of countries with internet usage between 0% and 10%: " + result);
  }
}