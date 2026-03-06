import java.util.ArrayList;

public class DataAnalyzer {
  // Check if counties have internet usage between 0% and 10%
  public ArrayList<Country> badinternetfinder() {
    // Read data from files
    ArrayList<String> countries = FileOperator.getStringList("countries.txt");
    ArrayList<Double> percents = FileOperator.getDoubleList("internetpercent.txt");
    
    int bad = 0;

    // Create list of Country objects
    ArrayList<Country> countryList = new ArrayList<>();

    // Loop through the two lists and check their internet percentages, then create Country objects and add them to the list if they are between 0% and 10%
    for (int i = 0; i < countries.size() && i < percents.size(); i++) {
      double percent = percents.get(i);
            if (percent >= 0 && percent < 10) {
                countryList.add(new Country(countries.get(i), percent));
                // System.out.println(countries.get(i) + " - " + percent + "%");
                bad++;
            }
        }
        System.out.println("Number of countries with internet usage between 0% and 10%: " + bad);
        return countryList;
    } 

  // Binary search - assumes list is sorted
  public static int binarySearch(ArrayList<Integer> numbers, int targetNumber){
    int minIndex = 0;
    int maxIndex = numbers.size()-1;
    while(minIndex <= maxIndex){
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

  //Linear search - does not assume list is sorted
  public static int linearSearch(ArrayList<Integer> numbers, int targetNumber){
    int index = 1;
    while (index < numbers.size()-1){
      if (numbers.get(index) == targetNumber){
        return index;
      }
      index++;
    }
    return -1;
  }

  //Reverse list search - does not assume list is sorted, but starts from the end of the list
  public static int reverseList(ArrayList<Integer> numbers, int targetNumber){
    for (int i = numbers.size() - 1; i >= 0; i--){
      if (numbers.get(i) == targetNumber){
        return i;
      }
    }
    return -1;
  }

  // Get the list of countries and their internet usage as Country objects
  public ArrayList<Country> getInternetUsage() {
        //Read data from files
        ArrayList<String> countries = FileOperator.getStringList("countries.txt");
        ArrayList<Double> percents = FileOperator.getDoubleList("internetpercent.txt");

        // Create list of Country objects
        ArrayList<Country> countryList = new ArrayList<>();
        
        // Loop through the two lists and find their internet percentages, then create Country objects and add them to the list
        for (int i = 0; i < countries.size() && i < percents.size(); i++) {
            double percent = percents.get(i);
            if (percent >= 0 && percent <= 100) {
              String cleanName = countries.get(i).trim().toUpperCase();
              countryList.add(new Country(cleanName, percent));
                
            }
        }
        return countryList;
  }
  
  // Remove outliers from the list of Country objects (countries with internet usage less than 0% or greater than 100%)
  public ArrayList<Country> removeOutliers(ArrayList<Country> countries) {
    ArrayList<Country> cleaned = new ArrayList<>(countries);
    for (int i = cleaned.size() - 1; i >= 0; i--) {
        if (cleaned.get(i).getInternet() < 0 || cleaned.get(i).getInternet() > 100) {
            cleaned.remove(i);
        }
    }
    return cleaned;
  }
       
    // ── Different team members write these methods ──────────────────

    // Find minimum internet percent
    public double findMin(ArrayList<Country> countries) {
        double min = countries.get(0).getInternet();

        for (Country c : countries) {
          if (c.getInternet() < min) {
            min = c.getInternet();
          }
        }
        return min;
    }

    // Find maximum internet percent
    public double findMax(ArrayList<Country> countries) {
        double max = countries.get(0).getInternet();
        for (Country c : countries) {
          if (c.getInternet() > max){
            max = c.getInternet();
          }
        }
        return max;
    }   

  // Find sum of internet percents
    public double findSum(ArrayList<Country> countries) {
        double sum = 0;
        for (Country c : countries){
          sum += c.getInternet();
        }
        return sum;
    }

    // Find average internet percent
    public double findAve(ArrayList<Country> countries) {
        double sum = 0;
        for (Country c : countries){
          sum += c.getInternet();
        }
        double avg = sum / countries.size();
        return avg;
    }

    // Find country with minimum internet percent
     public String findMinCountry(ArrayList<Country> countries) {
        Country min = countries.get(0);
        for (Country c : countries) {
            if (c.getInternet() < min.getInternet()){
              min = c;
            } 
        }
        return min.getName();
    }

    // Find country with maximum internet percent
     public String findMaxCountry(ArrayList<Country> countries) {
        Country max = countries.get(0);
        for (Country c : countries) {
          if (c.getInternet() > max.getInternet()){
            max = c;
          }
        }
        return max.getName();
    }

    // ────────────────────────────────────────────────────────────────

    // Convert stats to JSON string
    public String statsToJson(ArrayList<Country> countries) {
        double min = findMin(countries);
        double max = findMax(countries);
        double avg = findAve(countries);
        double sum = findSum(countries);
        String minCountry = findMinCountry(countries);
        String maxCountry = findMaxCountry(countries);

        return String.format(
                "{\"count\":%d,\"min\":%.1f,\"max\":%.1f,\"avg\":%.1f,\"sum\":%.1f,\"range\":%.1f,\"minCountry\":\"%s\",\"maxCountry\":\"%s\"}",
                countries.size(), min, max, avg, sum, (max - min), minCountry, maxCountry
        );
    }

  public static void main(String[] args) { 
    // DataAnalyzer analyzer = new DataAnalyzer();
    // int result = analyzer.goodinternetfinder();
    // System.out.println("Number of countries with internet usage between 0% and 10%: " + result);

    ArrayList<Integer> a = FileOperator.getIntList("numbers.txt");

    // Calculate time
    long startTime = System.nanoTime(); 
    int resultB = binarySearch(a, 9); 
    long endTime = System.nanoTime(); 
    
    // Display time in nanoseconds and milliseconds 
    long duration = endTime - startTime; 
    System.out.println("Time taken: " + duration + " nanoseconds"); 
    System.out.println("Time taken: " + (duration / 1000000.0) + " milliseconds");

    // Check search results
    int resultL = linearSearch(a, 9);
    int resultR = reverseList(a, 9);
    System.out.println("Binary Search Result: " + resultB);
    System.out.println("Linear Search Result: " + resultL);
    System.out.println("Reverse List Search Result: " + resultR);

  }
}