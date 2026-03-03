import java.util.ArrayList;
public class test {
    public static void main(String[] args) {
        ArrayList<Integer> weather = new ArrayList<>();
        weather.add(1);
        weather.add(7);
        weather.add(6);
        weather.add(2);
        for (int i=0;i<=weather.size()-1;++i) {
            System.out.println(weather.get(i));
        }
    }
}