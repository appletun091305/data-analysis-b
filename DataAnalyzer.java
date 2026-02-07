import java.io.*;
import java.util.*;
public class DataAnalyzer {
    private ArrayList<String> incomeData;
    public DataAnalyzer() {
        incomeData = new ArrayList<>();
    }
    public ArrayList<String> findLowIncome() {
        ArrayList<String> lowIncomeList = new ArrayList<>();
        for (String income : incomeData) {
            if (income.equalsIgnoreCase("Low Income")) {
                lowIncomeList.add(income);
            }
        }
        return lowIncomeList;
    }
    public static void main(String[] args) {
        DataAnalyzer analyzer = new DataAnalyzer();
        analyzer.loadData("incomes.txt");
        ArrayList<String> lowIncome = analyzer.findLowIncome();
        System.out.println("Low Income Data: " + lowIncome);
    }
}