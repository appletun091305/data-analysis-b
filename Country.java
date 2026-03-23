// Country.java
public class Country {
    private String name;
    private String income;
    private double value;

    public Country(String name, String income, double value) {
        this.name = name;
        this.income = income;
        this.value = value;
    }

    public String getName() { return name; }
    public String getIncome() { return income; }
    public double getValue() { return value; }
    public String toString() {
        return "{\"name\":\"" + name + "\",\"income\":\"" + income + "\",\"value\":" + value + "}";
    }
}