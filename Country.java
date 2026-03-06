// Country.java
public class Country {
    private String name;
    private double unemploymentRate;

    public Country(String name, double unemploymentRate) {
        this.name = name;
        this.unemploymentRate = unemploymentRate;
    }

    public String getName() { return name; }
    public double getUnemploymentRate() { return unemploymentRate; }
    public String toString() {
        return "{\"name\":\"" + name + "\",\"value\":" + unemploymentRate + "}";
    }
}