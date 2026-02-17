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

  public static int binarySearch(ArrayList<Integer> numbers, int targetNumber){
    int minIndex = 0;
    int maxIndex = numbers.size()-1;
    while(minIndex < maxIndex){
      int middleIndex = (int) Math.floor((minIndex + maxIndex)/2);
      if (numbers.get(middleIndex).equals(targetNumber)){
        return middleIndex;
      } else {
        if (targetNumber > numbers.get(middleIndex)){
          minIndex = middleIndex + 1;
        } else {
          maxIndex = middleIndex - 1;
        }
      }
    }
    return -1;
  } 

  public static void main(String[] args) { 
    // DataAnalyzer analyzer = new DataAnalyzer();
    // int result = analyzer.internetfinder();
    // System.out.println("Number of countries with internet usage between 0% and 10%: " + result);

    ArrayList<Integer> a = FileOperator.getIntList("numbers.txt");

    // Calculate time
    long startTime = System.nanoTime(); 
    int result = binarySearch(a, 9); 
    long endTime = System.nanoTime(); 
    
    // Display time in nanoseconds and milliseconds 
    long duration = endTime - startTime; 
    System.out.println("Time taken: " + duration + " nanoseconds"); 
    System.out.println("Time taken: " + (duration / 1000000.0) + " milliseconds");

  }
}