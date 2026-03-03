public class Country {
    private String name;
    private double unemployment;

    public Country(String n, double u) {
        name = n;
        unemployment = u;
    }

    public String getName() { return name; }
    public double getUnemployment() { return unemployment; }

    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\",\"value\":" + unemployment + "}";
    }
}
