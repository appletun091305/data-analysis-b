import java.util.ArrayList;
public class DataAnalyzer {
    public ArrayList<Country> getCountryInternet() {
        ArrayList<Country> list = new ArrayList<>();
        list.add(new Country("USA",     92.5, 3.9));
        list.add(new Country("Brazil",  74.3, 11.93));
        list.add(new Country("India",   43.0, 5.33));
        list.add(new Country("Germany", 89.7, 3.38));
        list.add(new Country("Nigeria", 36.1, 8.39));
        list.add(new Country("Japan",   93.2, 2.4));
        return list;
    }
       // ── Different team members write these methods ──────────────────

    public double findMin(ArrayList<Country> countries) {
        double min = countries.get(0).getUnemploymentRate();
        for (Country c : countries) {
            if (c.getUnemploymentRate() < min) {
                min = c.getUnemploymentRate();
            }
        }
        return min;
    }
    public double findMax(ArrayList<Country> countries) {
        double max = countries.get(0).getUnemploymentRate();
        for (Country c : countries) {
            if (c.getUnemploymentRate() > max) {
                max = c.getUnemploymentRate();
            }
        }
        return max;
    }
    public double findSum(ArrayList<Country> countries) {
    double sum = 0.0;
    for (Country c : countries) {
        sum += c.getUnemploymentRate();
    }
    return sum;
    }

    public double findAve(ArrayList<Country> countries) {
        return findSum(countries) / countries.size();
    }

    public String findMinCountry(ArrayList<Country> countries) {
        Country minC = countries.get(0);
        for (Country c : countries) {
            if (c.getUnemploymentRate() < minC.getUnemploymentRate()) {
                minC = c;
            }
        }
        return minC.getName();
    }

    public String findMaxCountry(ArrayList<Country> countries) {
        Country maxC = countries.get(0);
        for (Country c : countries) {
            if (c.getUnemploymentRate() > maxC.getUnemploymentRate()) {
                maxC = c;
            }
        }
        return maxC.getName();
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