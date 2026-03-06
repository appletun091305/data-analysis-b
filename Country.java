public class Country {

    //Instance variables
    private String name;
    private double internet;
    private long population;
    private double unemployment;

    //Constructor - no parameters
    public Country() {
        this.name = "";
        this.internet = 0.0;
        this.population = 0;
        this.unemployment = 0.0;
    }

    //Constructor - with parameters
    public Country(String name, double internet) {
        this.name = name;
        this.internet = internet;
    }

    //Getter and setter methods
    public void setName(String name){
        this.name = name;
    }

    public void setInternet(double internet){
        this.internet = internet;
    }

    public String getName() { 
        return name; 
    }

    public double getInternet() { 
        return internet; 
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getPopulation() { 
        return population; 
    }

    public void setUnemployment(double unemployment) {
        this.unemployment = unemployment;
    }

    public double getUnemployment() { 
        return unemployment; 
    }

    // toString method for JSON
    public String toString() {
        return "{\"name\":\"" + name + "\",\"value\":" + internet + "}";
    }
}