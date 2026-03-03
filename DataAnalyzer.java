import java.util.ArrayList;
public class DataAnalyzer {

    public static ArrayList<String> find_high_income(ArrayList<String> countries, ArrayList<String> incomes) {
        // Given the list of countries and incomes, filters for "High Income" countries.
        ArrayList<String> out = new ArrayList<>();
        for (int i=0;i<Math.min(countries.size(),incomes.size());i++) {
            if (incomes.get(i).equals("High Income")) {
                out.add(countries.get(i));
            }
        }
        return out;
    }

    public ArrayList<Country> getCountryUnemployment() {
        ArrayList<Country> list = new ArrayList<>();
        list.add(new Country("China",     4.9));
        list.add(new Country("Korea",  7.3));
        list.add(new Country("Belgium",   29.4));
        list.add(new Country("Vietnam", 1.0));
        list.add(new Country("Morocco", 4.5));
        list.add(new Country("Argentina",   2.2));
        return list;
    }

    public double findMin(ArrayList<Country> data) {
        // Given an ArrayList<Country> of data, returns the minumum value.
        Country out = data.get(0);
        for (Country c : data) {
            if (c.getUnemployment()<out.getUnemployment()) {
                out = c;
            }
        }
        return out.getUnemployment();
    }

    public double findMax(ArrayList<Country> data) {
        // Given an ArrayList<Country> of data, returns the maximum value.
        Country out = data.get(0);
        for (Country c : data) {
            if (c.getUnemployment()>out.getUnemployment()) {
                out = c;
            }
        }
        return out.getUnemployment();
    }

    public double findSum(ArrayList<Country> data) {
        // Given an ArrayList<Country> of data, returns the sum.
        double out = 0;
        for (Country c : data) {
            out += c.getUnemployment();
        }
        return out;
    }

    public double findAve(ArrayList<Country> data) {
        // Given an ArrayList<Country> of data, returns the average value.
        double out = 0;
        for (Country c : data) {
            out += c.getUnemployment();
        }
        return out/data.size();
    }

    public String findMinCountry(ArrayList<Country> data) {
        // Given an ArrayList<Country> of data, returns the minumum country.
        Country out = data.get(0);
        for (Country c : data) {
            if (c.getUnemployment()<out.getUnemployment()) {
                out = c;
            }
        }
        return out.getName();
    }

    public String findMaxCountry(ArrayList<Country> data) {
        // Given an ArrayList<Country> of data, returns the maximum country.
        Country out = data.get(0);
        for (Country c : data) {
            if (c.getUnemployment()>out.getUnemployment()) {
                out = c;
            }
        }
        return out.getName();
    }

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

    public static void main(String[] args) {
        ArrayList<String> countries = FileOperator.getStringList("data\\countries.txt");
        ArrayList<String> incomes = FileOperator.getStringList("data\\incomes.txt");
        System.out.println("High income: ");
        ArrayList<String> high_incomes = find_high_income(countries, incomes);
        for (String c : high_incomes) {
            System.out.print(c+", ");
        }
        System.out.println();

        //ArrayList<Double> internet_percent = FileOperator.getDoubleList("data\\internetpercent.txt");
        //System.out.println("Average internet percent: "+findAve(internet_percent));

    }
}
