// Country.java
public class Country {
    private String name;
    private double internetUsage;
    private double unemploymentRate;

    public Country(String name, double internetUsage, double unemploymentRate) {
        this.name = name;
        this.internetUsage = internetUsage;
        this.unemploymentRate = unemploymentRate;
    }

    public String getName() { return name; }
    public double getInternetUsage() { return internetUsage; }
    public double getUnemploymentRate() { return unemploymentRate; }
    public String toString() {
        return "{\"name\":\"" + name + "\",\"value\":" + unemploymentRate + "}";
    }
}