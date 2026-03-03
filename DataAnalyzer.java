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

    public static double find_average(ArrayList<Double> data) {
        // Given an ArrayList<Double> of data, returns the average value.
        double out = 0;
        for (Double d : data) {
            out += d;
        }
        return out/data.size();
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

        ArrayList<Double> internet_percent = FileOperator.getDoubleList("data\\internetpercent.txt");
        System.out.println("Average internet percent: "+find_average(internet_percent));

    }
}
