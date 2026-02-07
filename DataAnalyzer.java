import java.io.*;
import java.util.*;
public class DataAnalyzer {
    private ArrayList<String> incomeData;
    public DataAnalyzer() {
        incomeData = new ArrayList<>();
    }
    public ArrayList<String> getIncomeData() {
        ArrayList<String> lowIncomeList = new ArrayList<>();
        for (String income : incomeData) {
            if (income.equalsIgnoreCase("Low Income")) {
                lowIncomeList.add(income);
            }
        }
        return lowIncomeList;
    }
    public HashMap<String, Integer> getCategoryCounts() {
        HashMap<String, Integer> counts = new HashMap<>();
        for (String income : incomeData) {
            // Normalize the data to handle case variations
            String normalized = normalizeCategory(income);
            counts.put(normalized, counts.getOrDefault(normalized, 0) + 1);
        }
        return counts;
    }
}