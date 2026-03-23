// DataAnalyzer.java
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataAnalyzer {
    ArrayList<String>countries;
    ArrayList<String>incomes;
    ArrayList<Double>internetUsage;
    ArrayList<Double> population;

    public DataAnalyzer(){
        countries = FileOperator.getStringList("Countries.txt");
        incomes = FileOperator.getStringList("Incomes.txt");
        internetUsage = FileOperator.getDoubleList("Internet.txt");
        population = FileOperator.getDoubleList("Populations.txt");
    }

    public ArrayList<Country> findHighIncomeCountries(){
        ArrayList<Country> result = new ArrayList<>();
        System.out.println("\nHigh Income Countries");


        for(int i = 0; i < countries.size(); i++){
            String inc=incomes.get(i).trim();
            double val=0;
            if(inc.contains("High")){
                val=90;
            } else if(inc.contains("Upper")){
                val=75;
            }else if(inc.contains("Lower")){
                val=50;
            }else if(inc.contains("Low")){
                val=25;
            }

              result.add(new Country(countries.get(i),inc,val));
        }
        return result;
    }

    public ArrayList<String> findLowInternetCountries (){
        ArrayList<String> result = new ArrayList<>();
        System.out.println("/nLow Internet USage Countries");
        for (int i=0; i < internetUsage.size() && i<20;i++){
            result.add(countries.get(i) + ": " + internetUsage.get(i));
            
        }
        return result;
    }
    public static void main(String[] args) {
        DataAnalyzer analyzer = new DataAnalyzer();
        analyzer.findHighIncomeCountries();
        analyzer.findLowInternetCountries();
    }
    // public ArrayList<Country> getCountryInternet() {
    //     ArrayList<Country> list = new ArrayList<>();
    //     list.add(new Country("USA",     92.5));
    //     list.add(new Country("Brazil",  74.3));
    //     list.add(new Country("India",   43.0));
    //     list.add(new Country("Germany", 89.7));
    //     list.add(new Country("Nigeria", 36.1));
    //     list.add(new Country("Japan",   93.2));
    //     return list;
    // }
       // ── Different team members write these methods ──────────────────

    public double findMin(ArrayList<Country> countries) {
        return 0.0;
    }
    public double findMax(ArrayList<Country> countries) {
        return 0.0;
    }    
    public double findSum(ArrayList<Country> countries) {
        return 0.0;
    }
    public double findAve(ArrayList<Country> countries) {
        return 0.0;
    }
     public String findMinCountry(ArrayList<Country> countries) {
        return "MinC";
    }
     public String findMaxCountry(ArrayList<Country> countries) {
        return "MaxC";
    }
    // ────────────────────────────────────────────────────────────────

    public String statsToJson(ArrayList<Country> countries) {
        double min        = findMin(countries);
        double max        = findMax(countries);
        double avg        = findAve(countries);
        double sum        = findSum(countries);
        String minCountry = findMinCountry(countries);
        String maxCountry = findMaxCountry(countries);

        return String.format(
                "{\"count\":%d,\"min\":%.1f,\"max\":%.1f,\"avg\":%.1f,\"sum\":%.1f,\"range\":%.1f,\"minCountry\":\"%s\",\"maxCountry\":\"%s\"}",
                countries.size(), min, max, avg, sum, (max - min), minCountry, maxCountry
        );
    }
    
}