public class Country {
    private String name;
    private double internet;

    public Country(String name, double internet) {
        this.name = name;
        this.internet = internet;
    }

    public String getName() { 
        return name; 
        }
    public double getInternet() { 
        return internet; 
        }
    public String toString() {
        return "{\"name\":\"" + name + "\",\"value\":" + internet + "}";
    }
}