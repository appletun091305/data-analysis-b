import java.util.ArrayList;

public class DataAnalyzer {

    public ArrayList<Country> getCountryPopulation() {
        ArrayList<String> names = FileOperator.getStringList("countries.txt");
        ArrayList<Integer> pops = FileOperator.getIntList("populations.txt");

        ArrayList<Country> list = new ArrayList<>();
        int limit = Math.min(names.size(), pops.size());
        for (int i = 0; i < limit; i++) {
            list.add(new Country(names.get(i).trim(), pops.get(i)));
        }
        return list;
    }

    // ── Stat helpers ──────────────────────────────────────────────────────────

    public long findMin(ArrayList<Country> countries) {
        long min = countries.get(0).getPopulation();
        for (Country c : countries)
            if (c.getPopulation() < min) min = c.getPopulation();
        return min;
    }

    public long findMax(ArrayList<Country> countries) {
        long max = countries.get(0).getPopulation();
        for (Country c : countries)
            if (c.getPopulation() > max) max = c.getPopulation();
        return max;
    }

    public long findSum(ArrayList<Country> countries) {
        long sum = 0;
        for (Country c : countries) sum += c.getPopulation();
        return sum;
    }

    public double findAve(ArrayList<Country> countries) {
        return (double) findSum(countries) / countries.size();
    }

    public String findMinCountry(ArrayList<Country> countries) {
        Country minC = countries.get(0);
        for (Country c : countries)
            if (c.getPopulation() < minC.getPopulation()) minC = c;
        return minC.getName();
    }

    public String findMaxCountry(ArrayList<Country> countries) {
        Country maxC = countries.get(0);
        for (Country c : countries)
            if (c.getPopulation() > maxC.getPopulation()) maxC = c;
        return maxC.getName();
    }

    // ── JSON ──────────────────────────────────────────────────────────────────

    public String statsToJson(ArrayList<Country> countries) {
        long   min        = findMin(countries);
        long   max        = findMax(countries);
        double avg        = findAve(countries);
        long   sum        = findSum(countries);
        String minCountry = findMinCountry(countries);
        String maxCountry = findMaxCountry(countries);

        return String.format(
            "{\"count\":%d,\"min\":%d,\"max\":%d,\"avg\":%.0f,\"sum\":%d," +
            "\"range\":%d,\"minCountry\":\"%s\",\"maxCountry\":\"%s\"}",
            countries.size(), min, max, avg, sum, (max - min), minCountry, maxCountry
        );
    }
}