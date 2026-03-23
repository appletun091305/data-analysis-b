// Country.java
public class Country {
    private String name;
    private String income;
    private double internetUsage;

    public Country(String name, double internetUsage) {
        this.name = name;
        this.income = income;
        this.internetUsage = internetUsage;
    }

    public String getName() { return name; }
    public String getIncome() { return income; }
    public double getInternetUsage() { return internetUsage; }
    public String toString() {
        return "{\"name\":\"" + name + "\",\"income\":\"" + income + "\",\"value\":" + internetUsage + "}";
    }
}